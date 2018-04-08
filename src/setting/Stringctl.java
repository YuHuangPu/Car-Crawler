package setting;

import java.util.HashMap;

public class Stringctl {
	private String [][] column_name = new String [] [] {
		 {"年分","品牌","款式","價錢"}
		,{"動力型式","引擎型式","排氣量","最大馬力","最大扭力","馬達出力","壓縮比","系統總合輸出"}
		,{"驅動型式","變速系統"}
		,{"前輪懸吊","後輪懸吊","煞車型式","輪胎尺碼"}
		,{"車身型式","車門數","座位數","車長","車寬","車高","車重","軸距","標準行李箱容量","後座傾倒行李箱容量"}
		,{"油箱容量","市區油耗","高速油耗","平均油耗","牌照稅","燃料費"}
		,{"外觀","內裝","影音","便利","安全"}
		,{"圖片","REMARK1","REMARK2","REMARK3","REMARK4","REMARK5"}};
	private HashMap <String,String>DATAMAP = new HashMap<String,String>();
	/*public void setColumn_name(String[][] column_name) {
		this.column_name = column_name;
	}*/
	public String[][] getColumn_name() {
		return column_name;
	}
	public HashMap<String, String> getDATAMAP() {
		setDATAMAP();
		return DATAMAP;
	}
	private void setDATAMAP() {
		Z:
		for(String [] s1:column_name){
			for(String  name:s1){
				if(name.indexOf("REMARK")>=0)break Z;
				DATAMAP.put(name,null);
			}
		}
	}
}
