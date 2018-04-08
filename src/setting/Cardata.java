package setting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cardata{
	private String value ;
	private String is_exist;
	private String allcar_insql = "";
	private String allcar_upsql = "";
	private String carname_insql = "";
	private String carname_upsql = "";
	private String cargrade_insql ="";
	public Cardata(String value,String is_exist){
		this.value = value ; 
		this.is_exist = is_exist;
		go ();
	}
	private void go (){
		String [] upvalue = new String [38];
		//
		String [][] column_name = new Stringctl().getColumn_name();
		String col_name_sql = "";
		Z:
		for(String v [] : column_name)
			for(String V : v){
				if(V.startsWith("REMARK"))break Z;
				col_name_sql = col_name_sql + V + ", ";
			}
		String [] colName = col_name_sql.split(", ");
		//
		String plus = "";
		Z:
		for(String value : this.value.split("\n")){
			String colValue []  = value.substring(2,value.length()-2).split("', '");
			//2016 Aston Martin Rapide S 6.0 V12
			if(!plus.equals(colValue[2])){plus = colValue[2] ;}
			else {
				continue Z ;
				//plus = colValue[2] + "+";
				//value = value.replace(colValue[2],plus);
			}
			String RealName = (colValue[0]+" "+colValue[1]+" "+colValue[2]);
			
			//
			//value set
			if((is_exist==null?"":is_exist).indexOf(RealName)<0){
				allcar_insql = allcar_insql + value +", ";
				carname_insql = carname_insql +"('" +RealName +"', '"+(new SimpleDateFormat("hh:mm:ss").format(new Date())+"'), ");
			}
			else{
				for(int i = 3,j=0; i<40 ;i++,j++){
					upvalue[j] = (upvalue[j]==null?colName[i]+" = case concat(年分,' ',品牌,' ',款式) ":upvalue[j]) + "when '"+ RealName + "' then '" +colValue[i]+"'"; 
				}
				upvalue[37] = (upvalue[37]==null?"":upvalue[37]) +"'"+ RealName +"', ";
			}
		}
		//allcar
		for(int i = 0; i<37 ;i++){
			allcar_upsql = allcar_upsql+ (upvalue[i]==null?"":(upvalue[i] + "END, "));
		}
		//
		//sql set
		if(!allcar_insql.equals("")){
			allcar_insql = ("insert allcar value"
				+ allcar_insql.substring(0,allcar_insql.length()-2)
				);
			carname_insql = ("insert into carname(name,lst_update) value "
					+carname_insql.substring(0,carname_insql.length()-2));
		}
		if(!allcar_upsql.equals("")){
			allcar_upsql=("update allcar set "
					+ allcar_upsql.substring(0,allcar_upsql.length()-2)
					+ " where concat(年分,' ',品牌,' ',款式) in ("+upvalue[37].substring(0,upvalue[37].length()-2)+")");
			carname_upsql = ("update carname set lst_update = '"
					+(new SimpleDateFormat("hh:mm:ss").format(new Date()))+"' "
					+("where name in ("+upvalue[37].substring(0,upvalue[37].length()-2)+")"));
		}
		
	}
	public String getAllcar_Insql(){
		return allcar_insql ;
	}
	public String getAllcar_Upsql(){
		return allcar_upsql ;
	}
	public String getCarname_Upsql(){
		return carname_upsql ;
	}
	public String getCarname_Insql(){
		return carname_insql ;
	}
	public void clear(){
		allcar_insql = null;
		allcar_upsql = null;
		carname_insql = null;
		carname_upsql = null;
	}
}

