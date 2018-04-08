package function;

import java.io.BufferedReader;

import setting.Stringctl;
import writer.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ora.json.JSONArray;
import ora.json.JSONObject;

public class AnalysisSource extends Thread{
	//private final Log L = new Log();
	private String messlog = "0" ;
	private String ERRORLOG = "";
	private HashMap<String, String> MAP ;
	public AnalysisSource (){}
	public AnalysisSource (Document BR){
//		this.BR = BR ;
	}
//	private BufferedReader BR ;
	private Document DOC;
	private List<String> url ;
	private List<String> name ;
	private String [] year ;
	private String YEAR = null;
	private String [][] value ;

	public List<String> getTable_Column_name(){
		return name;
	}
	public String [][] getTable_value(){
		return value;
	}
	public String [] getYear(){
		return year;
	}
	
	public void transport(String type,Document DOC){
		AnalysisSource AS = null;
		switch(type){
			case "INDEX":
				INDEX(DOC);
			break;
			case "SECOND":
				SECOND(DOC);
			break;
			case "SECONDyear":
				SECOND(DOC);
			break;
			case "THIRD":
				THIRD(DOC);
			break;
			case "LAST":
				/*AS = new AnalysisSource("LAST",BR);
				AS.start();*/
				this.DOC = DOC ;
				LAST();
			break;
		}
		try {
			if(AS != null)
				AS.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//L.normal("*AnalysisSource\t--> "+( messlog.equals("0")?"Successful":"Fail"));
	}
	private void INDEX(Document doc) {
		String LINE ,tag="",tag2="", NAME = "SEARCH";
		int con=0;
		try {
			Elements elems = doc.select("div.research-main div.research-wrapper div.list a.gabtn");
//			System.out.println(elems.eachAttr("href"));
//			System.out.println(elems.eachAttr("title"));
			url = elems.eachAttr("href");
			name= elems.eachAttr("title");
		} catch (Exception e) {
			System.out.println("*AnalysisSource INDEX("+NAME+")\t-->"+e.toString());
			messlog = "1";
			ERRORLOG = "*AnalysisSource INDEX("+NAME+")\t-->"+e.toString() ;
		}finally{
			//L.function("*AnalysisSource INDEX("+NAME+")\t--> "+(messlog.equals("0")?"Successful":"Fail"));
		}
	}
	private void SECOND(Document doc) {
		String LINE ,tag="",tag2="",tag3="", NAME = "";
		int con=0;
		String html = "";
		try {
//			while((LINE = dOC2.readLine())!=null){
//				html+= LINE;
//				LINE = LINE.trim();
//				boolean YEARtag = YEAR != null 
//						?LINE.startsWith("<a href=\"/new-cars/model/")&&LINE.indexOf("</a>")>0&&LINE.indexOf(YEAR)>0
//						:LINE.startsWith("<a href=\"/new-cars/model/")&&LINE.indexOf("</a>")>0;
//				if(YEARtag){
//					//if(LINE.indexOf(YEAR)>0){
//					con++;
//					String year = LINE.substring("<a href=\"".length(),LINE.indexOf("\">")).split("-")[LINE.substring("<a href=\"".length(),LINE.indexOf("\">")).split("-").length-1];
//					tag3 = tag3.split("\n")[tag3.split("\n").length-1].equals(year) ?tag3:tag3 + year + "\n";
//					//System.out.println(LINE.substring("<a href=\"".length(),LINE.indexOf("\">")));
//					tag = tag + LINE.substring("<a href=\"".length(),LINE.indexOf("\">")) + "\n";
//					//}
//				}
//				if(LINE.startsWith("<title>")){
//					NAME = LINE.substring("<title>".length(),LINE.indexOf("車系"));
//				}
//				YEARtag = YEAR != null 
//						?LINE.startsWith("<img width=\"224\" height=\"128\" alt=\"")&&LINE.indexOf(YEAR)>0
//						:LINE.startsWith("<img width=\"224\" height=\"128\" alt=\"");
//				if(YEARtag){
//					tag2 = tag2 + LINE.substring("<img width=\"224\" height=\"128\" alt=\"".length(),LINE.indexOf("\" src=\"")).trim()+"\n";
//				}
				
//			}
//			System.out.println(html);
//			year = tag3.split("\n");
			Elements elems = doc.select("div.make-main div.year");
			JSONObject cars = new JSONObject();
			Iterator<Element> itrs = elems.iterator();
			while(itrs.hasNext()){
				Element year = itrs.next();
				Elements carElems = year.select("a.gabtn");
				cars.put(year.select("div.year-title").text(), 
						new JSONObject()
							.put("href", carElems.eachAttr("href"))
							.put("title", carElems.eachAttr("title")));
			}
			
			
			con = elems.size();
			if(cars.has(YEAR)){
				url = jsonArrayToList(cars.getJSONObject(YEAR).getJSONArray("href"));
				this.name = jsonArrayToList(cars.getJSONObject(YEAR).getJSONArray("title"));
			}else{
				url = new ArrayList<String>();
				this.name = new ArrayList<String>();
			}
		} catch (Exception e) {
			System.out.println("*AnalysisSource SECOND("+NAME+")\t-->"+e.toString());
			ERRORLOG = "*AnalysisSource SECOND("+NAME+")\t-->"+e.toString();
			messlog = "1";
		}finally{
			//L.function("*AnalysisSource SECOND("+NAME+")\t--> "+(messlog.equals("0")?"Successful":"Fail"));
		}
	}
	private List<String> jsonArrayToList(JSONArray jsonarray){
		List<String> result = new ArrayList<String>();
		Iterator<Object> itrs = jsonarray.iterator();
		while(itrs.hasNext()){
			result.add((String)itrs.next());
		}
		return result;
	}
	private void THIRD(Document doc){
		String LINE ,tag="",tag2="", NAME="ERROR";
		int flag = 0,flag2 = 0,con=0;
		try {
//			while((LINE = dOC.readLine())!=null){
//				LINE = LINE.trim();
//				if(LINE.startsWith("<div class=\"Va-t P-16 centercol\">")){flag=1;}
//				else if(LINE.startsWith("<a href=\"/new-cars/trim/") && flag==1){
//					flag = 0;flag2++;
//					tag = tag + LINE.substring(9,LINE.indexOf("\" style=\"display:block;\"")) + "\n";
//					con++;
//				}
//				else if(LINE.startsWith("<title>")&& flag2 == 0 ){
//					NAME = LINE.substring("<title>".length(),LINE.indexOf("車款"));
//				}
//				if(LINE.startsWith("<div class=\"Fw-b title\">")){
//					tag2 = tag2 + LINE.substring("<div class=\"Fw-b title\">".length(),LINE.indexOf("</div>")) + "\n";
//					//System.out.println(LINE.substring("<div class=\"Fw-b title\">".length(),LINE.indexOf("</div>")));
//				}
//			}
//				url = tag.split("\n");
//				this.name = tag2.split("\n");
//			
//			dOC.close();
			Elements elems = doc.select("div.main-model div.model-wrapper a.gabtn");
			con = elems.size();
			Iterator<String> urlItrs = elems.eachAttr("href").iterator();
			List<String> newUrl = new ArrayList<String>();
			while(urlItrs.hasNext()){
				newUrl.add(urlItrs.next() + "/spec#car-trim-nav");
			}
			url = newUrl;
			this.name = elems.eachAttr("title");
			
		} catch (Exception e) {
			System.out.println("*AnalysisSource THIRD\t("+NAME+")\t-->"+e.toString());
			ERRORLOG = ("*AnalysisSource THIRD\t("+NAME+")\t-->"+e.toString());
			messlog = "1";
		}finally{
			//L.function("*AnalysisSource THIRD\t("+NAME+")\t--> "+(messlog.equals("0")?"Successful":"Fail"));
		}
	}
	public List<String> getUrl(){
		return url ;
	}
	
	//LAST
	public void run (){ LAST();}
	private void LAST(){

		HashMap<String, String> MAP = new Stringctl().getDATAMAP() ;
		String LINE , tagmap="", PICS="",name = "",tagname = "";
		int flag = 0,pics=0 ;
		try {
//			while((LINE = BR.readLine())!=null){
//				LINE = LINE.trim();
//				if( LINE.indexOf("選購配備") >0) {//控制鈕
//					flag++;
//				}
//				else if( LINE.startsWith("<li class=\"Carousel-Item")){pics++;
//					PICS = PICS + LINE.substring(LINE.indexOf("http://"),LINE.indexOf(".jpg")+4) + ", ";
//					if(pics == 10 )
//						MAP.put("圖片",PICS.substring(0,PICS.length()-2));
//				}
//				else if (flag == 0 && LINE.startsWith("<span class=\"price-num\">$ <strong>")){
//					String money = LINE.substring("<span class=\"price-num\">$ <strong>".length(),LINE.length()-"</strong></span> 萬".length());
//					MAP.put("價錢",money);
//				}
//				else if( LINE.startsWith("<td class=\"Py-10 Bd-b Fz-m Whs-nw\">")){
//					String colname = LINE.substring(("<td class=\"Py-10 Bd-b Fz-m Whs-nw\">").length(),LINE.length()-5);
//					if(flag == 0 )tagmap = colname ;
//					else if (flag ==1){
//						String value = (MAP.get(tagmap)==null? "": MAP.get(tagmap)) + colname + ", ";
//						MAP.put(tagmap,value);
//					}
//				}
//				else if(flag == 0 && LINE.startsWith("<td class=\"Py-10 Bd-b Fz-m Wob-ba\">")){
//					String value = LINE.substring(("<td class=\"Py-10 Bd-b Fz-m Wob-ba\">").length(),LINE.length()-5);
//					MAP.put(tagmap, value);
//				}
//				else if(flag == 1 &&LINE.startsWith("<span class=\"Fw-b\">")){
//					String colname = LINE.substring("<span class=\"Fw-b\">".length(),LINE.length()-"</span>".length());
//					tagmap = colname;
//				}else if(LINE.startsWith("<a href=\"/new-cars/make/")){
//					LINE = LINE.substring(LINE.indexOf("\">")+2,LINE.indexOf("</a>"));
//					
//					tagname = LINE ;
//				}else if(LINE.startsWith("<div class=\"title\">")){
//					LINE = (LINE.replace("<div class=\"title\">","").replace("</div>", "").trim());
//					MAP.put("品牌",tagname);
//					MAP.put("年分",LINE.split(" ")[0]);
//					MAP.put("款式",LINE.substring(5).replace(tagname,"").trim());
//				}	
//			}
//			BR.close();
			MAP.put("品牌", this.DOC.select("div.bread a").get(2).attr("title"));
			
			String yearAndstyle = this.DOC.select("div.bread a").get(3).text() +" " + this.DOC.select("div.bread a").get(4).text();
			MAP.put("年分", yearAndstyle.substring(0,4));
			MAP.put("款式", yearAndstyle.substring(5));
			
			Elements main = this.DOC.select("div.trim-main");
			MAP.put("價錢", main.select("h3.price span font").text().substring(2));

			Elements subMain = main.select("div.trim-spec-detail div.spec-wrapper:eq(0) ul li span:eq(1)");
			main = main.select("div.trim-spec-detail div.spec-wrapper:eq(0) ul li span:eq(0)");
			for(int i = 0 ; i < main.size() ; i++){
				MAP.put(main.get(i).text(), subMain.get(i).text());
			}
			
			main = this.DOC.select("div.trim-main div.trim-spec-detail div.spec-wrapper.spec-right label");
			subMain = this.DOC.select("div.trim-main div.trim-spec-detail div.spec-wrapper.spec-right ul");
			for(int i = 0 ; i < main.size() ; i++){
				String str = subMain.get(i).select("li").eachText().toString();
				MAP.put(main.get(i).text(), str.substring(1, str.length()-1));
			}
			
			main = this.DOC.select("div.trim-main div.nav-wrapper img.gabtn");
			String picListStr =  main.eachAttr("src").toString();
			MAP.put("圖片", picListStr.substring(1, picListStr.length()-1));
			
			this.MAP = MAP ;
			String [][] value = new String[MAP.size()][2];
			String [][] column_name = new Stringctl().getColumn_name();
			int i =0;
			Z :
			for(String s [] : column_name)
				for(String a : s){
					if(a.indexOf("REMARK")>=0)break Z;
					value[i][0] = a;value[i][1] = (MAP.get(a)==null?"null":MAP.get(a));
					i++;
					//System.out.println(i-1+" "+value[i-1][0]+"\t"+value[i-1][1]);
				}
			this.value=value;
		} catch (Exception e) {
			System.out.println("*AnalysisSource LAST\t("+name+")\t-->"+e.toString());
			ERRORLOG = ("*AnalysisSource LAST\t("+name+")\t-->"+e.toString()) ;
			messlog = "1";
		} finally{
			//L.function("*AnalysisSource LAST\t("+name+")\t--> "+(messlog.equals("0")?"Successful":"Fail"));
		}
	}
	public HashMap<String,String> getMAP(){
		return MAP;
	}
	//LAST
	public void setYear(String year) {
		this.YEAR =year ; 
	}
}
