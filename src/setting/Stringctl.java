package setting;

import java.util.HashMap;

public class Stringctl {
	private String [][] column_name = new String [] [] {
		 {"�~��","�~�P","�ڦ�","����"}
		,{"�ʤO����","��������","�Ʈ�q","�̤j���O","�̤j��O","���F�X�O","���Y��","�t���`�X��X"}
		,{"�X�ʫ���","�ܳt�t��"}
		,{"�e���a�Q","����a�Q","�٨�����","���L�ؽX"}
		,{"��������","������","�y���","����","���e","����","����","�b�Z","�зǦ���c�e�q","��y�ɭ˦���c�e�q"}
		,{"�o�c�e�q","���Ϫo��","���t�o��","�����o��","�P�ӵ|","�U�ƶO"}
		,{"�~�[","����","�v��","�K�Q","�w��"}
		,{"�Ϥ�","REMARK1","REMARK2","REMARK3","REMARK4","REMARK5"}};
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
