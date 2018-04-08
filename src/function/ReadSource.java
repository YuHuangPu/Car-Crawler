package function;

import java.io.*;
import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import setting.Pathctl;
import writer.Log;
public class ReadSource {
	private URL url = null;
//	private URLConnection conn = null ;
//	private InputStreamReader ISR = null;
//	private BufferedReader BR = null;
	private String messlog = "0";
	Document doc;
	public Document getDoc(){
		return doc;
	}
	//private Log L = new Log();
	
	//
	//Pathctl p = new Pathctl();
	//
	public static void main(String[] args) {
		
		ReadSource RS = new ReadSource();
		RS.seturl("/new-cars/");

	}
	public ReadSource (){
		//p.FILESYSTEM();
		}
	public boolean seturl(String url){
		
		try {
//			url=url.replace(url.split("/")[url.split("/").length-1],URLEncoder.encode(url.split("/")[url.split("/").length-1],"UTF-8"));
			this.url = new URL(url);
			
		} catch (Exception e) {
			System.out.println("seturl*ReadSource\t-->"+e.toString());
			messlog = "1";
			return false;
		}
		return read()&&true;
	}
	private boolean read(){
		try {
//			conn = url.openConnection();
//			ISR = new InputStreamReader(conn.getInputStream(),"UTF-8");
//			BR = new BufferedReader(ISR);
			try {
				doc = Jsoup.connect(url.toString()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			String LINE ;
//			while((LINE = BR.readLine())!=null){
//				System.out.println(LINE);
////				SourceCode_trim = SourceCode_trim + LINE.trim() + "\n"; 
//				
//			}
		} catch (Exception e){
			System.out.println("read*ReadSource\t-->"+e.toString());
			messlog = "1";
			return false;
		} finally{
			try {
				//if(ISR != null)
				//	ISR.close();
				//if(BR != null)
				//	BR.close();
//				if(conn != null)
//					conn = null ;
				System.gc();
			} catch (Exception e) {
			System.out.println("*EReadSource\t-->"+e.toString());
				messlog = "1";
			}
			
		}return true;
		//L.normal("*ReadSource\t--> "+(messlog.equals("0")?"Successful":"Fail"));
	}
//	public BufferedReader getCode_BR(){
//		return BR;
//	}
//	public boolean Close_BR(){
//		boolean B = false ;
//		try {
//			if(BR!=null)
//				BR.close();
//			B=true ; 
//		} catch (IOException e) {
//		}
//		return B;
//	}
}
