package setting;

import button.action.Mysql;
import datatool.Sql;

public class Equipment extends Thread{
	private String value ="";
	private Sql instruction = null;
	private String equipment = "";
	public Equipment(String value, Sql instruction) {
		this.value = value;
		this.instruction = instruction ;
	}

	public void run (){
		String RealName  = "" ;
		Integer ty [] = {34,35,36,37,38,
				3,6,7,8,13,14,15,16,25,31};
		String [] type = {"OUTSIDE","INSIDE","VIDEO","EASY","SAFETY",
				"MONEY","CC","POWER","TORQUE","GEARBOX","FRONT","BEHIND","BRAKES","AXIAL","GAS"};
		String plus = "";
		Z :
		for(String V : value.split("\n")){
			String value[]  = new String [type.length+1] ; 
			value[0] = V.substring(2).split("', '")[0] +" "
					+ V.substring(2).split("', '")[1] + " "
					+ V.substring(2).split("', '")[2];
			if(!plus.equals(value[0])){plus = value[0] ;}
			else {continue Z;}
			for(int i = 1; i < type.length+1 ;i++){
				value[i] = V.split("', '")[ty[i-1]];
				RealName = RealName + "'" + value[0] + "', ";
				if(i<6)for(String va : value[i].split(", ")){
					equipment = equipment +("('"+ value[0] + "', '" + va + "', '"+type[i-1]+"'), ");
				}
				else{
					equipment = equipment +("('"+ value[0] + "', '" + value[i] + "', '"+type[i-1]+"'), ");
				}
				
				
			}
		}
		RealName = RealName.substring(0,RealName.length()-2);
		equipment = equipment.substring(0,equipment.length()-2);
		try {
			instruction.setSQL("delete from carequipment where name in ("+RealName+")");
			instruction.setSQL("insert into carequipment value "+equipment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
