package yahoo;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Scanner;
public class StepI extends Thread {

	public static void main(String[] args) {
		long st = new Date ().getTime() ;
		new StepI().Step("/new-cars/make/peugeot","2016");
		long ans = (new Date ().getTime() - st)/1000;
		System.out.println(ans);
	}
	private void ssss(){
		String s = "nklasdjflksdjaflsjlfkjsflsdklf;jasf";
		System.out.println(s.indexOf("las"));
	}
	public StepI(){}
	public StepI (String url ,String year){
		this.url = url ;
		this.year = year ;
	}
	private String url = "";
	private String year = "";
	public void run (){
		Step(url,year);
	}
	public void Step(String u,String year ){
		URL url = null;
		URLConnection conn = null ;
		InputStreamReader ISR = null;
		BufferedReader BR = null;
		String URLsource = null;
		try{
			url = new URL("https://tw.autos.yahoo.com"+u);
			conn = url.openConnection();
			ISR = new InputStreamReader(conn.getInputStream(),"UTF-8");
			BR = new BufferedReader(ISR);
			while((URLsource = BR.readLine() )!= null){
				URLsource = URLsource.trim();
				if(URLsource.startsWith("<a href=\"/") && URLsource.endsWith("\">") && URLsource.indexOf(year) > 0 &&URLsource.indexOf(u.split("/")[u.split("/").length-1])>0){
					//System.out.println(URLsource.substring(URLsource.indexOf("/new-cars/model/"),URLsource.indexOf("\" class=\"")));//<a href="/new-cars/model/audi-q3-2016"......
					String URL = URLsource.substring(URLsource.indexOf("/new-cars/model/"),URLsource.indexOf("\" class=\""));
					System.out.println("Reading\t" + URL);
					new StepII().Step(URL);
					System.out.println("Sucessful");
				}
				
			}
		}catch (MalformedURLException e1) {
			System.out.println("Exception(I) : URL ! " + e1.toString());
			new ERRORLOG("Exception(I) : URL ! " + e1.toString());
		}catch (IOException e) {
			System.out.println("Exception(I) : Conn ! " + e.toString());
			new ERRORLOG("Exception(I) : Conn ! " + e.toString());
		}catch (Exception e) {
			System.out.println("Otherwise(I) : "+e.toString());
			new ERRORLOG("Otherwise(I) : "+e.toString());
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
