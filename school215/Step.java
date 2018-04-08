package yahoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Step {

	public static void main(String[] args) {
		new Step().Step("https://tw.autos.yahoo.com/car-research/");
	}
	private void Step(String u){
		URL url = null;
		URLConnection conn = null ;
		InputStreamReader ISR = null;
		BufferedReader BR = null;
		String URLsource = null;
		try{
			
			url = new URL(u);
			conn = url.openConnection();
			ISR = new InputStreamReader(conn.getInputStream(),"UTF-8");
			BR = new BufferedReader(ISR);
			int i =0;
			while((URLsource = BR.readLine() )!= null){
				URLsource = URLsource.trim();
				if(URLsource.startsWith("<div class=\"Pt-10 Bd-b\"><a class=\"Fz-m\" href=\"") ){
					StepI star = new StepI(); 
					star.Step(URLsource.substring(URLsource.indexOf("<div class=\"Pt-10 Bd-b\"><a class=\"Fz-m\" href=\"")+46)
							.substring(0,URLsource.substring(URLsource.indexOf("<div class=\"Pt-10 Bd-b\"><a class=\"Fz-m\" href=\"")+46).indexOf("\">")),"2015");
					/*if(i%5==0){
						star.sleep((i/5)*3000);
					}
					i++;*/
				}
				
			}
		}catch (MalformedURLException e1) {
			System.out.println("Exception(0) : URL ! " + e1.toString());
			new ERRORLOG("Exception(0) : URL ! " + e1.toString());
		}catch (IOException e) {
			System.out.println("Exception(0) : Conn ! " + e.toString());
			new ERRORLOG("Exception(0) : Conn ! " + e.toString());
		}catch (Exception e) {
			System.out.println("Otherwise(0) : "+e.toString());
			new ERRORLOG("Otherwise(0) : "+e.toString());
		}finally{
			try {
				if(ISR != null)
					ISR.close();
				if(BR != null)
					BR.close();
				if(conn != null)
					conn = null ;
			} catch (Exception e) {
				System.out.println("Exception : Close ! ");
				new ERRORLOG("Exception : Close ! ");
			}
		}
	}
}
