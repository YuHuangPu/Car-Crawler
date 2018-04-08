package button.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import datatool.Connect;
import datatool.Sql;

public class PIC extends Thread{
	public void run(){
		File F = new File("PIC");
		Connect C = new Connect();
		C.Connect("Mysql");
		String RealName = null;
		for(String name : F.list()){
			RealName = name;
			File pic = new File("PIC/"+RealName );
			try {
				PreparedStatement pstmt = C.getConnect().prepareStatement(  
						"insert into carfile values('"+RealName.replace("[_]","/")+"',?,?,?,?,?,?,?,?,?,?)");
				for(int i = 0 ; i<10;i++){
					File picF = new File(pic+"/"+String.valueOf(i)+".jpg");
					pstmt.setBinaryStream ((i+1)
							, new FileInputStream(picF)
							, (int)(picF.length())
							);
				}
				pstmt.executeUpdate();  
		        pstmt.clearParameters();  
		        pstmt.close();
		        System.out.print(".");
			} catch (Exception e) {
				System.out.println(e);
			} 
			
		}
		System.out.println();
		C.close();
	}
}
