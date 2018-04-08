package yahoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class StepIII extends Thread {

	public static void main(String[] args) {
		new StepIII().Step("/new-cars/trim/kia-morning-2015-1-.-2%E6%99%82%E5%B0%9A%E7%89%88");
		
	}
	HashMap <String,String> MapI = null;
	public String Step(String u){
		
		try {
			u=u.replace(u.split("/")[u.split("/").length-1],URLEncoder.encode(u.split("/")[u.split("/").length-1],"UTF-8"));
		} catch (Exception e2) {
			System.out.println("trans error(III)"+e2.toString());
			new ERRORLOG("trans error(III)"+e2.toString());
		}
		MapI = new HashMap<String,String>();
		URL url = null;
		URLConnection conn = null ;
		InputStreamReader ISR = null;
		BufferedReader BR = null;
		String URLsource = null;
		String pic = "";
		createHap();
		int j = 0;
		try{
			url = new URL("https://tw.autos.yahoo.com"+u);
			conn = url.openConnection();
			ISR = new InputStreamReader(conn.getInputStream(),"UTF-8");
			BR = new BufferedReader(ISR);
			String key = "";
			while((URLsource = BR.readLine() )!= null){
				URLsource = URLsource.trim();
				String s = "";
				//name
				if(URLsource.startsWith("<meta property=\"og:title\" content=\"")){
				//	System.out.println(URLsource.substring(URLsource.indexOf("<div class=\"title\">")+19,URLsource.indexOf("</div>")));
					s = URLsource.substring(URLsource.indexOf("<div class=\"title\">")+36,URLsource.indexOf("介紹 - 汽車資料庫 - Yahoo奇摩汽車機車\"/>"));
					try{
						Double.valueOf(s.split(" ")[1]);
						MapI.put(title1[0][1],s.split(" ")[1]);
						MapI.put(title1[0][0],s.split(" ")[0]);
						MapI.put(title1[0][2],s.replace(s.split(" ")[0],"").replace(s.split(" ")[1],"").trim());
					}catch(Exception e){
						MapI.put(title1[0][1],s.split(" ")[2]);
						MapI.put(title1[0][0],s.split(" ")[0]+" "+s.split(" ")[1]);
						MapI.put(title1[0][2],s.replace(s.split(" ")[2],"").replace(s.split(" ")[0]+" "+s.split(" ")[1],"").trim());
						
					}
				}
				//money
				if(URLsource.startsWith("<span class=\"price-num\">$ <strong>")&&!URLsource.startsWith("<span class=\"price-num\">$ <strong></strong>")){
				//	System.out.println(URLsource.substring(URLsource.indexOf("<strong>")+8,URLsource.indexOf("</strong>")));
					s = URLsource.substring(URLsource.indexOf("<strong>")+8,URLsource.indexOf("</strong>"));
					MapI.put(title1[0][3],s);
				}
				//pic url
				if(URLsource.startsWith("<li class=\"Carousel-Item")){
				//	System.out.println(URLsource.substring(URLsource.indexOf("https://"),URLsource.indexOf(".jpg")+4));
					pic = pic + URLsource.substring(URLsource.indexOf("https://"),URLsource.indexOf(".jpg")+4) + "\n";
					picn++;
				}
				if(URLsource.trim().startsWith("<span class=\"Fw-b\">")){
					//System.out.println(URLsource.trim().substring(19,URLsource.trim().length()-7));
					j++;
				}
				//title
				if(URLsource.trim().startsWith("<td class=\"Py-10 Bd-b Fz-m Whs-nw\">")){
					//System.out.print("\t"+URLsource.trim().substring(35,URLsource.trim().length()-5)+" : ");
					key = URLsource.trim().substring(35,URLsource.trim().length()-5);
				}
				if(URLsource.trim().startsWith("<td class=\"Py-10 Bd-b Fz-m Ta-end\"></td>")){
				//	System.out.println();
					value[j] = value[j]+key+", ";
				}
				//value
				if(URLsource.trim().startsWith("<td class=\"Py-10 Bd-b Fz-m Wob-ba\">")){
				//	System.out.println(URLsource.trim().substring(35,URLsource.trim().length()-5));
					s = URLsource.trim().substring(35,URLsource.trim().length()-5);
					MapI.put(key,s);
				}
			}
		}catch (MalformedURLException e1) {
			System.out.println("Exception(III) : URL ! " + e1.toString());
			new ERRORLOG("Exception(III) : URL ! " + e1.toString());
		}catch (IOException e) {
			System.out.println("Exception(III) : Conn ! " + e.toString());
			new ERRORLOG("Exception(III) : Conn ! " + e.toString());
		}catch (Exception e) {
			System.out.println("Otherwise(III) : "+e.toString());
			new ERRORLOG("Otherwise(III) : "+e.toString());
		}finally{
			try {
				if(ISR != null)
					ISR.close();
				if(BR != null)
					BR.close();
			} catch (Exception e) {
				System.out.println("Exception : Close ! ");
				new ERRORLOG("Exception : Close ! ");
			}
		}
		value[11] = value[11]+pic;
		///
		int i =0;
		for(String sI[] : title1){
			String s = "";
			//System.out.println(title[i]);
			for(String sII : sI){
				//System.out.println("\t"+sII + "\t" + MapI.get(sII));
				s = s + sII + "\t" + MapI.get(sII)+"\n";
			}
			value[i] = value[i]+s;
			i++;
		}int J =0;
		for(i=6;i<=10;i++,J++){
			try{
			value[i] =titleI[J]+"\t"+ value[i].substring(0,value[i].length()-2);
			}catch(Exception e){
				value[i] = titleI[J] +"\t"+ null;
			}
		}
		///
		for(int I=0;I<6;I++){
			//System.out.print("*-- "+(I)+" --*\n"+ title[I] + "\n" + value [I] );
			DATAVALUE = DATAVALUE  + value [I];
			DATATITLE = DATATITLE + title[I] + "\n";
			if(I==5){
				//System.out.println("*-- "+(I+1)+" --*\n"+ title[I+1] );
				DATATITLE = DATATITLE+ title[I+1] ;
				for(I = 6;I<11;I++){
					//System.out.println(value[I]);
					DATAVALUE = DATAVALUE+value[I]+"\n";
					if(I==10){
						//System.out.print("*-- "+(7)+" --*\n"+title[7]+"\n"+value[I+1]);
						DATAVALUE = DATAVALUE+value[I+1];
						DATATITLE = DATATITLE + title[7]+"\n" ;
					}
				}
			}
		}
		System.out.print(".");
		StepVI stepVI = new StepVI(DATATITLE,DATAVALUE,picn);
		stepVI.start();
		return null;
	}
	int picn = 0 ;
	String DATAVALUE = "",DATATITLE="";
	String [][] title1 = null;
	String [] titleI = null;
	String [] value = new String []{"","","","","","","","","","","",""}  ;
	String [] title = null ;
	private void createHap(){
		title = new String [] {"基本","動力","傳動","底盤","車體","其他","配備","圖片"};
		titleI = new String [] {"外觀配備","內裝配備","影音配備","便利配備","安全配備"};
		title1 = new String [] [] {
				 {"品牌","年分","款式","價錢"}
				,{"動力型式","引擎型式","排氣量","最大馬力","最大扭力","馬達出力","壓縮比","系統總合輸出"}
				,{"驅動型式","變速系統"}
				,{"前輪懸吊","後輪懸吊","煞車型式","輪胎尺碼"}
				,{"車身型式","車門數","座位數","車長","車寬","車高","車重","軸距","標準行李箱容量","後座傾倒行李箱容量"}
				,{"油箱容量","市區油耗","高速油耗","平均油耗","牌照稅","燃料費"}};
		for(String sI[] : title1){
			for(String sII : sI){
				MapI.put(sII,null);
			}
		}
		
	}
	
		
	
}
