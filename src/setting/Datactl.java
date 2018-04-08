package setting;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;;
public class Datactl extends Thread{
	private String[][] data ;
	private String name ; 
	public static void main(String[] args) {
		
	}
	public Datactl (String name ,String[][] data){this.data = data;this.name = name ;}
	public void run (){ data();}
	private void data(){
		int XXX = 0;
		String TIME = (new SimpleDateFormat("yyyyMMdd").format(new Date()));
		File F = new File(Pathctl.getFile("DATAS") + "/" + data[0][1]);
		F.mkdirs();
		BufferedWriter BW = null ;
		
		try {
			BW = new BufferedWriter(new FileWriter(F+"/Data"+TIME.substring(2)+".txt",true));
			for(int i =0;i<data.length-1;i++){
			BW.write(data[i][1]+"\t");
			}BW.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			XXX=1;
			e.printStackTrace();
		} finally{try {
			if(BW!=null)
			BW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		if(XXX==0){
			try {
				File F2 = new File(Pathctl.getFile("PIC") + "/" + data[0][1]);
				F2.mkdirs();
				BW = new BufferedWriter(new FileWriter(F2+"/Data"+TIME+".txt",true));
				BW.write("["+name+"]\t");
				for(String path : data[data.length-1][1].split("\n")){
				BW.write(path+"\t");
				}BW.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{try {
				if(BW!=null)
				BW.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(XXX==0){
			try {
				BW = new BufferedWriter(new FileWriter(Pathctl.getFile("DATAS")+"/Data.txt",true));
				BW.write(TIME + " : ["+name+"]\t");
				BW.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try {
					if(BW!=null)
						BW.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		}
		}
		
	}
}
