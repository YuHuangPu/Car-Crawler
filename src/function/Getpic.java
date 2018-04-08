package function;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import datatool.Connect;
import datatool.Sql;

public class Getpic extends Thread{
	private String RealName ;
	private  String name ;
	private Integer count[]; 
	private String newName = "";
	private String  [] http ;
	private Getpic (Integer count[],String RealName,String http[]){this.count = count;this.RealName = RealName;this.http=http;}
	public Getpic (String name){this.name = name ;trans();}
	public void run(){count[0]++;getPIC();count[0]--;}
	
	private void trans(){
		for(String s : name.split("\n")){
			newName =newName+"'"+ (s.split("', '")[0].substring(2)+" "+s.split("', '")[1]+" "+s.split("', '")[2])+"', ";
		}
		newName = ("("+newName.substring(0,newName.length()-2)+")");
		Connect C = new Connect();
		C.Connect("MYSQL");
		Sql CMD = new Sql(C.getConnect());
		try{
			CMD.setSQL("select concat(年分,' ',品牌,' ',款式),圖片 from allcar where concat(年分,' ',品牌,' ',款式) in "+newName);
			Integer [] count = {0};
			while(CMD.getResultSet().next()){
				new File("PIC/"+CMD.getResultSet().getString(1).replace("/", "[_]")).mkdirs();
				new Getpic(count,CMD.getResultSet().getString(1).replace("/", "[_]"),CMD.getResultSet().getString(2).split(", ")).start();
				if(count[0]>10){
					System.out.println("Reader SLEEP "+count[0]);
					while(count[0]>2){
						sleep(500);System.out.print(".");
					}System.out.println();
				
				}
			}
			
		}catch(Exception e){
			System.out.println(e.toString());
		}finally{System.out.println("PIC GET FINISH");
			C.close();
			CMD.sqlClose();
			
		}
	}
	private void getPIC(){
		DataInputStream dis = null;
		FileOutputStream fos = null;
		int i =0;
		try{
			for(String imageUrl : http){
				URL url = new URL(imageUrl);
				dis = new DataInputStream(url.openStream());
				String newImageName="PIC/"+RealName+"/"+i+".jpg";
				fos = new FileOutputStream(new File(newImageName));
				i++;
				byte[] buffer = new byte[1024];
				int length;
				while((length = dis.read(buffer))>0){
					fos.write(buffer,0,length);
				}
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}finally{
			try {
				if(dis!=null){
				dis.close();
				dis =null;
				}
				if(fos!=null){
				fos.close();
				fos = null;
				}
			System.out.println(RealName + " FINISH !");
			} catch (IOException e) {System.out.println(e.toString());
			}
		}
	}
}
