package yahoo;

import java.io.*;

public class ERRORLOG {

	public static void main(String[] args) {
		new ERRORLOG().set("START");
	}
	public ERRORLOG (String error){
		set(error);
	}
	public ERRORLOG (){
	}
	public void set (String error){
		File F = new File("DATA/ERROR");
		F.mkdirs();
		BufferedWriter BW =null;
		try{
			BW = new BufferedWriter(new FileWriter (F+"/log.txt",true));
			BW.write("[  "+error+"  ]");
			BW.newLine();
		}catch (IOException e) {
		}finally{
			try {
				if(BW!=null)
					BW.close();
			} catch (Exception e) {
			}
		}
	}
}
