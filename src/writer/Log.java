package writer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import setting.Pathctl;

public class Log {
	private String logs ;
	private static BufferedWriter BW = null;
	private static String type = "";
	private static Date startdate;
	//
	// pathctl p = new pathctl() ;
	//
	public Log (){
		//
		//p.FILESYSTEM();
		//
	} 
	/*public static void main(String[] args) {
		log l = new log();
		l.error("error test");
		l.normal("normal test");
	}*/ // use TEST
	public void error (String log){
		logs = log ;
		writer("ERROR");
	}
	public void normal (String log){
		logs = log ;
		if(this.logs.indexOf("DEMO END")>0){
			String i = "["+String.valueOf((double)( (new Date()).getTime()- startdate.getTime())/1000 )+"s]";
			while(i.length()<9){
				i = i+"-";
			}
			logs = logs.replace("[%%%%%%%%%s]",i);
		}
		writer("NORMAL");
	}
	public void function (String log){
		logs = log ;
		writer("FUNCTION");
	}
	private void writer(String type){
		try{
			if(BW ==null || this.type!= type){
				close();
				this.type = type;
				BW = new BufferedWriter(new FileWriter(Pathctl.getFile("LOG")+"/"+type+".txt",true));
			}
			String logs =  new SimpleDateFormat ("[yyyy/MM/dd hh:mm:ss]").format(new Date()) 
					+":"+ this.logs;
			BW.write(logs);
			BW.newLine();
			if(this.logs.indexOf("DEMO START")>0){
				startdate = new Date() ;
				this.logs = "*----START----*";
				writer("ERROR");
				writer("FUNCTION");
			}
			else if(this.logs.indexOf("DEMO END")>0){
				this.logs = "*-----END-----*\n";
				writer("ERROR");
				writer("FUNCTION");
			}
		}catch (IOException e) {
			System.out.println("LogWriter error0 !!"+type);
		}
	}
	public void close(){
		try {
			if(BW != null)
				BW.close();
		} catch (IOException e) {
			System.out.println("LogWriter error1 !!");
		}
	}
}
