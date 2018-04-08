package yahoo;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StepVI extends Thread{
	private String DATATILE = null;
	private String DATAVALUE = null;
	private int picn =0;
	public StepVI (String DATATILE,String DATAVALUE,int picn){
		this.DATATILE = DATATILE;
		this.DATAVALUE = DATAVALUE;
		this.picn = picn;
	}
	public StepVI (){}
	public static void main(String[] args) {
		new StepIII().Step("/new-cars/model/m-benz-m-class-2015");
	}
	public void run (){
		step(DATATILE,DATAVALUE,picn);
	}
	public void step(String DATATILE,String DATAVALUE,int picn){
		System.out.println(DATAVALUE);
		try {
			//System.out.println(URLDecoder.decode(URLEncoder.encode(DATAVALUE,"UTF-8"),"UTF-8"));
		} catch (Exception e1) {
		}
		String picdata = "";
		for(int i =0;i <picn;i++){
			picdata = picdata + DATAVALUE.split("\n")[DATAVALUE.split("\n").length-picn+i].split("--/")[2] + "\n";
		}
		File F = new File("DATA");
		F.mkdirs();
		String value_trans = "";
		String title_trans = "";
		String value = "";
		try{
		for(int i =0 ; i <DATAVALUE.split("\n").length-picn;i++){
			String [] SII = DATAVALUE.split("\n")[i].split("\t");
				value = value + SII[1] + "\t";
				try{
					title_trans = title_trans + (URLEncoder.encode(SII[0],"UTF-8")) + "\t";
					value_trans = value_trans + (URLEncoder.encode(SII[1],"UTF-8")) + "\t";
				}catch (Exception e) {
					System.out.println("trans error");
					new ERRORLOG("trans error");
				}
		}}catch(Exception e){
			System.out.println("ERROR : "+DATAVALUE.split("\n")[2].split("款式\t")[1]);
			new ERRORLOG("ERROR : "+DATAVALUE.split("\n")[2].split("款式\t")[1]);
		}
		
		try {
			value_trans = value_trans +URLEncoder.encode("DATA/pics/"+DATAVALUE.split("\n")[0].split("品牌\t")[1]+"/"+DATAVALUE.split("\n")[2].split("款式\t")[1]+"/","UTF-8") ;
		} catch (UnsupportedEncodingException e) {
			System.out.println("trans error");
			new ERRORLOG("trans error");
		}
		value = value + "DATA/pics/"+DATAVALUE.split("\n")[0].split("品牌\t")[1]+"/"+DATAVALUE.split("\n")[2].split("款式\t")[1]+"/" ;
		//getData(value,value_trans);
		//getPic(picdata,DATAVALUE.split("\n")[2].split("款式\t")[1],DATAVALUE.split("\n")[0].split("品牌\t")[1]);
	}
	private void getData(String value , String trans_value){
		BufferedWriter BW = null;
		File FI = new File("DATA/datas");
		FI.mkdirs();
		try {
			BW = new BufferedWriter(new FileWriter(FI+"/datas.xls",true));
			BW.write(value);
			BW.newLine();
		} catch (IOException e) {
			System.out.println("Writer Error (VI)!!");
		} finally{
			try {
				BW.close();
			} catch (IOException e) {
				System.out.println("BW CLOSE !?");
				new ERRORLOG("BW CLOSE !?");
			}
		}
		try {
			BW = new BufferedWriter(new FileWriter(FI+"/datas_trans.xls",true));
			BW.write(trans_value);
			BW.newLine();
		} catch (IOException e) {
			System.out.println("Writer Error (VI)!!");
		} finally{
			try {
				BW.close();
			} catch (IOException e) {
				System.out.println("BW CLOSE !?");
				new ERRORLOG("BW CLOSE !?");
			}
		}
	}
	private void getPic(String picdata,String picname,String dir){
		File Fx = new File("DATA/pics");
		Fx.mkdirs();
		Fx = new File(Fx+"/"+DATAVALUE.split("\n")[0].split("品牌\t")[1]);
		Fx.mkdirs();
		Fx = new File(Fx+"/"+DATAVALUE.split("\n")[2].split("款式\t")[1]);
		Fx.mkdirs();
	    URL url;
	    DataInputStream dis = null;
	    FileOutputStream fos = null;
	    int i = 0;
	    for(String imageUrl : picdata.split("\n"))
		try {
			url = new URL(imageUrl);
			dis = new DataInputStream(url.openStream());
			String newImageName="DATA/pics/"+dir+"/"+picname+"/"+(i+1)+".jpg";
	    	fos = new FileOutputStream(new File(newImageName));
		    byte[] buffer = new byte[1024];
		    int length;
		    while((length = dis.read(buffer))>0){
		    	fos.write(buffer,0,length);
		    }
	    
		}catch (MalformedURLException e) {
			System.out.println("PIC URL ERROR !!");
			new ERRORLOG("PIC URL ERROR !!");
		}catch (IOException e) {
			System.out.println("PIC IO ERROR !!");
			new ERRORLOG("PIC IO ERROR !!");
		}catch(Exception e ){
			System.out.println("ERROR : [ "+picname+" ]");		
			new ERRORLOG("ERROR : [ "+picname+" ]");
		}finally{
			i++;
			try {
				dis.close();
				fos.close();
			}catch (IOException e){
				System.out.println("PIC CLOSE !!");
				new ERRORLOG("PIC CLOSE !!" + " [ "+picname+" ]");
			}catch(Exception e ){
				System.out.println("ERROR : [ "+picname+" ]");	
				new ERRORLOG("ERROR : [ "+picname+" ]");
			}
		}
	}
}
