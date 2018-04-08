package replaceDatabase;

import function.ReadSource;
import function.AnalysisSource;
import java.io.IOException;
import java.util.HashMap;

import setting.Datactl;
import setting.DataSearch;
import setting.Pathctl;
import setting.Stringctl;
import writer.Log;

public class Mainfunc {
	private final Pathctl p = new Pathctl();
	private final Log L = new Log();
	private String [][] value;
	private String [][] STATUS;
	private final ReadSource RS = new  ReadSource();
	private AnalysisSource AS  = new AnalysisSource ();
	private HashMap<String, HashMap<String,String>> PAGE = new HashMap<String, HashMap<String,String>>();
	public static void main(String[] args) {
//		Mainfunc DEMO = new Mainfunc();
//		DEMO.START();
//		DEMO.CLOSE();
	}
//	private void TEST() {
//
//		///car-research/
//		//RS.seturl("/car-research/");
//		//AS.transport("INDEX",RS.getCode_BR());
//		RS.seturl("/new-cars/make/aston-martin");
//		AS.transport("SECOND",RS.getCode_BR());
//		for(String s :AS.getUrl()){
//			RS.seturl(s);
//			AS.transport("THIRD",RS.getCode_BR());
//			for(String ss :AS.getUrl()){
//				RS.seturl(ss);
//				AS.transport("LAST",RS.getCode_BR());
//			}
//		}
//		/*RS.seturl("/new-cars/model/audi-q7-2016");
//		AS.transport("THIRD",RS.getCode_BR());
//		for(String s :AS.getUrl()){
//			RS.seturl(s);
//			AS.transport("LAST",RS.getCode_BR());
//		}*/
//		//RS.seturl("/new-cars/make/aston-martin");
//		//AS.transport("SECOND",RS.getCode_BR());
//		//RS.seturl("/new-cars/make/audi");
//		//AS.transport("SECOND",RS.getCode_BR());
//		//RS.seturl("/new-cars/model/land-rover-discovery-2016");
//		//AS.transport("THIRD",RS.getCode_BR());
//		//RS.seturl("/new-cars/trim/land-rover-discovery-2016-3-.-0-scv6-hse");
//		//AS.transport("LAST",RS.getCode_BR());
//		
//	}
//	public Mainfunc(){
//		p.FILESYSTEM();
//		start();
//	}
//	public String [] getYear(String make){
//		return setYear(make);
//	}
//	private String [] setYear(String make){
//		value=null;
//		RS.seturl(PAGE.get("INDEX").get(make));
//		AS.transport("SECOND",RS.getCode_BR());
//		HashMap <String,String> iV = new HashMap <String,String>();
//		for(int i = 0 ; i<AS.getUrl().length;i++){
//			//System.out.println(AS.getTable_Column_name()[i] + "\t" + AS.getUrl()[i]);
//			iV.put(AS.getTable_Column_name()[i],AS.getUrl()[i]);
//		}
//		PAGE.put("SECOND",iV);
//		return AS.getYear();
//	}
//	public String [][] getSECONDtable_Column_name(String make,String year){
//		return setSECONDtable_Column_name(make,year);
//	}
//	public String [][] getTHIRDtable_Column_name(String collection){
//		return setTHIRDtable_Column_name(collection) ; 
//	}
//	public String downloadDataStatus(String ymct){
//		return downloadData(ymct);
//	}
//	public void cleanValue(){
//		value = null;
//	}
//	private String downloadData(String ymct){
//		String status = PAGE.get("LAST").get(ymct);
//		if(value==null){
//			RS.seturl(PAGE.get("LAST").get(ymct));
//			AnalysisSource as = new AnalysisSource(RS.getCode_BR());
//			as.start();
//			try {
//				as.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			value = as.getTable_value() ;
//		}
//		Datactl writer = new Datactl(ymct,value);
//		writer.start();
//		return status;
//	}
//	public String [][] getTHIRD_STATUS(){
//		return replaceTHIRD_STATUS();
//	}
//	private String [][] replaceTHIRD_STATUS(){
//		for(int i = 0 ;i<STATUS.length;i++){
//			DataSearch D = new DataSearch(STATUS[i][0]);
//			STATUS[i][1] = D.bt();
//		}
//		return STATUS;
//	}
//	private String [][] setTHIRDtable_Column_name(String collection){
//		value=null;
//		//System.out.println("\t"+PAGE.get("SECOND").get(collection));
//		RS.seturl(PAGE.get("SECOND").get(collection));
//		AS.transport("THIRD",RS.getCode_BR());
//		String [][] column_name = new String[AS.getTable_Column_name().length-1][2];
//		String [][] STATUS = new String[AS.getTable_Column_name().length-1][2];
//		for(int i =0;i<column_name.length;i++){
//				column_name[i][0] = AS.getTable_Column_name()[i+1];
//				STATUS[i][0] =(AS.getTable_Column_name()[0] + " "+column_name[i][0]).trim(); 
//				DataSearch D = new DataSearch((AS.getTable_Column_name()[0] + " "+column_name[i][0]).trim());
//				column_name[i][1] = D.bt() ; 
//				STATUS[i][1] = column_name[i][1];
//		}
//		this.STATUS = STATUS ;
//		HashMap <String,String> iV = new HashMap <String,String>();
//		for(int i = 0 ; i<AS.getUrl().length;i++){
//			//System.out.println((AS.getTable_Column_name()[0] + " "+column_name[i][0]).trim() + "\t" + AS.getUrl()[i]);
//			iV.put((AS.getTable_Column_name()[0] + " "+column_name[i][0]).trim(),AS.getUrl()[i]);
//			
//		}
//		PAGE.put("LAST",iV);
//		return column_name;
//	}
//	private String [][] setSECONDtable_Column_name(String make,String year){
//		value=null;
//		HashMap <String,String> yearMap = new HashMap <String,String>();
//		for(String s : AS.getTable_Column_name()){
//			yearMap.put(s.substring(0,4),(yearMap.get(s.substring(0,4))==null?"":yearMap.get(s.substring(0,4)))+s+"\n");
//		}
//		String [][] column_name = new String[yearMap.get(year).split("\n").length][1];
//		for(int i =0;i<column_name.length;i++){
//			column_name[i][0] = yearMap.get(year).split("\n")[i].substring(4).replace(make.trim(),"").trim();
//		}
//		return column_name;
//	}
//	public String [][] getLASEtable_Column_name(String type){
//		return setLASEtable_Column_name(type);
//	}
//	public String[][] gettest(){return AS.getTable_value();}
//	private String [][] setLASEtable_Column_name(String type){
//		//System.out.println(type + "\t" + PAGE.get("LAST").get(type));
//		RS.seturl(PAGE.get("LAST").get(type));
//		AS.transport("LAST",RS.getCode_BR());
//		value = AS.getTable_value();
//		return value ; 
//	}
//	public String [][] getINDEXtable_Column_name(){
//		return setINDEXtable();
//	}
//	private String [][] setINDEXtable(){
//		value=null;
//		HashMap <String,String>iV = new HashMap<String,String>();
//		RS.seturl("/car-research/");
//		AS.transport("INDEX",RS.getCode_BR());
//		for(int i = 0 ; i<AS.getUrl().length;i++){
//			iV.put(AS.getTable_Column_name()[i],AS.getUrl()[i]);
//		}
//		PAGE.put("INDEX",iV);
//		String [][] column_name = new String[AS.getTable_Column_name().length][1];
//		
//		for(int i =0;i<column_name.length;i++){
//			column_name[i][0] = AS.getTable_Column_name()[i];
//		}
//		return column_name;
//	}
//	public void CLOSE (){
//		 close();
//	}
//	public void START (){
//		 start();
//	}
//	private void close(){
//		//AS.yield();
//		L.normal("* -----------------------------  DEMO END  use:[%%%%%%%%%s]---------------- *\n");
//		L.close();}
//	private void start(){
//		L.normal("* ----------------------------- DEMO START ----------------------------- *");
//		
//	}
	
}
