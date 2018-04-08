package setting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataSearch {
	private final String name;
	public static void main(String[] args) {
	}
	public DataSearch (String name){this.name = name;}
	public String bt(){return search();}
	private String search(){
		BufferedReader BR = null;
		int t = 0;
		try {
			BR = new BufferedReader(new FileReader(Pathctl.getFile("DATAS")+"/Data.txt"));
			String LINE ;
			while((LINE = BR.readLine())!=null){
				if(LINE.indexOf(name)>0){
					t=1;
					break;
				}
				
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			
		} finally{
			try {
				if(BR!=null)
				BR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return t==1?"true":"false";
	}
}
