package button.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import setting.Stringctl;

public class Local extends Thread{
	private final String value ;
	public Local (String value){this.value = value;}
	public void run (){R();}
	private void R (){
		//String name  = String.valueOf((new SimpleDateFormat("MM_dd").format(new Date())));
		new File("LOCAL").mkdirs();
		new File("LOCAL/CONF").mkdirs();
		new File("LOCAL/DATA").mkdirs();
		String [][] title = new Stringctl().getColumn_name();
		BufferedWriter BW = null;
		try {
			
			BW = new BufferedWriter(new FileWriter(new File("LOCAL/CONF/TITLE by AutoDownload.txt")));
			String VALUE = "";
			BW.write("TITLE\tTYPE");BW.newLine();
			for(String ti[] : title){
				for(String tle : ti){
					VALUE =tle +" varchar(255), " ;
					BW.write(VALUE);BW.newLine();
				}
			}BW.close();
			VALUE ="";
			BW = new BufferedWriter(new FileWriter(new File("LOCAL/NAMEs by AutoDownload.txt")));
			int j =0;
			for(String S :value.split("\n")){
				VALUE ="";
				for(int i =0;i<3;i++){
					VALUE = VALUE + S.split("', '")[i].replace("('","").trim() + " " ;
				}
				j++;BW.write(j+"¡B"+VALUE);BW.newLine();
			}BW.write("END");BW.close();
			
			BW = new BufferedWriter(new FileWriter(new File("LOCAL/DATA/DATAs by AutoDownload.txt")));
			for(String S :value.split("\n")){
				VALUE ="";
				for(String s :S.substring(2,S.length()-4).split("', '")){
					VALUE = VALUE + (s.equals("null")?"":s) + "\t" ;
				}
				BW.write(VALUE);BW.newLine();
			}BW.write("END");
			BW.close();
		} catch (IOException e) {
		}
		
	}
}
