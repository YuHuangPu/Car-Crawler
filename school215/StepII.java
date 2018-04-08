package yahoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class StepII {

	public static void main(String[] args) {
		new StepII().Step("/new-cars/model/aston-martin-rapide-2015");
	}
	public void Step(String u){
		try {
			u=u.replace(u.split("/")[u.split("/").length-1],URLEncoder.encode(u.split("/")[u.split("/").length-1],"UTF-8"));
		} catch (Exception e2) {
			System.out.println("trans error(III)"+e2.toString());
		}
		System.out.print("\tSecend Reading ");
		URL url = null;
		URLConnection conn = null ;
		InputStreamReader ISR = null;
		BufferedReader BR = null;
		String URLsource = null;
		String URL = null;
		try{
			url = new URL("https://tw.autos.yahoo.com"+u);
			conn = url.openConnection();
			ISR = new InputStreamReader(conn.getInputStream(),"UTF-8");
			BR = new BufferedReader(ISR);
			String ua = "";
			while((URLsource = BR.readLine() )!= null){
				URLsource = URLsource.trim();
				if(URLsource.startsWith("<a href=\"/new-cars/trim/") && URLsource.endsWith("\">")){
					System.out.println(URLsource.substring(URLsource.indexOf("/new-cars/trim/"),URLsource.indexOf("\" style=\"display:block")));//<a href="/new-cars/model/audi-q3-2016"......	
					URL = URLsource.substring(URLsource.indexOf("/new-cars/trim/"),URLsource.indexOf("\" style=\"display:block"));
					if(!URL.equals(ua)){
						//new StepIII().Step(URL);
						ua = URL;
					}
				}
				
				
			}
			
		}catch (MalformedURLException e1) {
			System.out.println("Exception(II) : URL ! " + e1.toString());
			new ERRORLOG("Exception(II) : URL ! " + e1.toString());
		}catch (IOException e) {
			System.out.println("Exception(II) : Conn ! " + e.toString());
			new ERRORLOG("Exception(II) : Conn ! " + e.toString());
		}catch (Exception e) {
			System.out.println("Otherwise(II) : "+e.toString());
			new ERRORLOG("Otherwise(II) : "+e.toString());
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
