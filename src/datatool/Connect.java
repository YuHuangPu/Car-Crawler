package datatool;

import java.sql.*;

public class Connect {
	private boolean isConnect = false;
    private Connection conDB = null;
	public Connect (){}
	public boolean isConnect(){
		return isConnect;
	}
	public Connection getConnect(){
		return conDB;
	}
	public void close(){
		try{
			if(conDB!=null){conDB.close();isConnect=false;}
			System.out.println("MySql Connect Close");
		}catch(Exception e){
		}
	}
	public void Connect (String Database){
		Connectport(Database);
	}
	private void Connectport(String Database){
		switch(Database.toUpperCase()){
			case "MYSQL":
				ConnectMysql();
				break;
			default:
				System.out.println("Can't Find Database : "+Database);
				break;
		}
	}
	private boolean ConnectMysql(){
		 try{
		     Class.forName("com.mysql.jdbc.Driver");
		     conDB = DriverManager.getConnection("jdbc:mysql://localhost:8888/car","root","");
		     isConnect = true ;
		     return true ;
		 }
		 catch(Exception e){
		     System.out.println("Connect Mysql Exception"+e);
		 }
		 return false ;
	}
}
