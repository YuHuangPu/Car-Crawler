package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ora.json.JSONObject;

public class test2 {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://autos.yahoo.com.tw/new-cars/trim/audi-q7-2018-40-tfsi-quattro%E4%BA%94%E4%BA%BA%E5%BA%A7/spec#car-trim-nav").get();
//		Elements elems = doc.select("div.bread a:eq(2)");
		Map<String, String> MAP = new HashMap<String, String>();
		
		MAP.put("品牌", doc.select("div.bread a").get(2).attr("title"));
		
		String yearAndstyle = doc.select("div.bread a").get(3).text() +" " + doc.select("div.bread a").get(4).text();
		MAP.put("年分", yearAndstyle.substring(0,4));
		MAP.put("款式", yearAndstyle.substring(5));
		
		Elements main = doc.select("div.trim-main");
		MAP.put("價錢", main.select("h3.price span font").text().substring(2));

		Elements subMain = main.select("div.trim-spec-detail div.spec-wrapper:eq(0) ul li span:eq(1)");
		main = main.select("div.trim-spec-detail div.spec-wrapper:eq(0) ul li span:eq(0)");
		for(int i = 0 ; i < main.size() ; i++){
			MAP.put(main.get(i).text(), subMain.get(i).text());
		}
		
		main = doc.select("div.trim-main div.trim-spec-detail div.spec-wrapper.spec-right label");
		subMain = doc.select("div.trim-main div.trim-spec-detail div.spec-wrapper.spec-right ul");
		for(int i = 0 ; i < main.size() ; i++){
			String str = subMain.get(i).select("li").eachText().toString();
			MAP.put(main.get(i).text(), str.substring(1, str.length()-1));
		}
		
		main = doc.select("div.trim-main div.nav-wrapper img.gabtn");
		String picListStr =  main.eachAttr("src").toString();
		MAP.put("圖片", picListStr.substring(1, picListStr.length()-1));
		
		System.out.println(MAP);
//		System.out.println(elems.select("div.year-title"));
//		System.out.println(elems.size());
//		System.out.println(elems.eachAttr("href"));
//		System.out.println(elems.eachAttr("title"));
		
	}

}
