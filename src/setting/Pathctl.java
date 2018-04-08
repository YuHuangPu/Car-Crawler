package setting;

import java.io.*;
import java.util.HashMap;

import writer.Log;

public class Pathctl {
	/*private final File F1 = new File("DATA");
	private final File DATABASE = new File("DATA/DATABASE");;
	private final File LOG = new File("DATA/LOG");
	private final File PIC = new File("DATA/DATABASE/PIC");
	private final File DATAS = new File("DATA/DATABASE/DATAS");*/
	private static HashMap <String,File> F = new HashMap <String,File>() ;
	private String FILE_NAME [] = {"DATA","DATABASE","LOG","PIC","DATAS"};
	private String FILE_PATH [] = {"DATA","DATA/DATABASE","DATA/LOG","DATA/DATABASE/PIC","DATA/DATABASE/DATAS"};
	private Log L = new Log();
	private void FileAdd(){
		for(int i =0;i<FILE_NAME.length;i++){
			F.put(FILE_NAME[i],new File(FILE_PATH[i]));
		}
		FileCreate() ;
	}
	private void FileCreate(){
		String logs []= {"",""};
		for(String F : FILE_NAME){
			if(!this.F.get(F).exists()){
				this.F.get(F).mkdirs();
				logs[0] = logs[0] + F + ", ";
			}
			
		}
		if(logs[0]!="")
		L.normal("*Mkdir "+logs[0].substring(0,logs[0].length()-2)+"--> Successful");
	}
	public Pathctl(){}
	public void FILESYSTEM(){FileAdd();}
	public static File getFile (String FILE_NAME){
		return F.get(FILE_NAME);
	}
}
