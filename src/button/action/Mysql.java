package button.action;

import java.io.File;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import datatool.Connect;
import datatool.Sql;
import function.Getpic;
import setting.Cardata;
import setting.Equipment;
import setting.Stringctl;

public class Mysql extends Thread{
	private String value ;
	public Mysql(String value) {
		this.value = value ;
	}
	public void run (){
		action();
	}
	public void gogo (){
		action();
	}
	private void action(){
		Connect mysql = new Connect();
		mysql.Connect("MYSQL");
		System.out.println("MYSQL Connect : "+mysql.isConnect());
		Sql instruction = new Sql(mysql.getConnect());
		String is_exist="";
		try {
			instruction.setSQL("select name from carname");
			while(instruction.getResultSet().next()){
				is_exist = is_exist + instruction.getResultSet().getString(1) + "\n";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Equipment equip = new Equipment(value,instruction);
		equip.start();
		Cardata sql = new Cardata(value,is_exist);
		try {
			instruction.setSQL(sql.getCarname_Insql());
			instruction.setSQL(sql.getCarname_Upsql());
			instruction.setSQL(sql.getAllcar_Insql());
			instruction.setSQL(sql.getAllcar_Upsql());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql = null;
		try {
			equip.join();
		} catch (InterruptedException e) {
			
		}
		new File("PIC").mkdir();
		Getpic Getpic = new Getpic(value);
		try {
			Getpic.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		instruction = null;
		mysql.close();
	}
}
