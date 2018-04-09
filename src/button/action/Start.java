package button.action;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

import button.listener.ActionListen;
import function.AnalysisSource;
import function.ReadSource;

public class Start extends Thread{
	private ReadSource RS = new  ReadSource();
	private AnalysisSource AS  = new AnalysisSource ();
	private long startdate = new Date().getTime();
	private String value ="";
	private final String year ;
	private boolean isRunning = true;
	private HashMap<String, Component> Comps;
	public Start(String year, HashMap<String ,Component> Comps){this.Comps = Comps;this.year = year ;}
	private void newr(){
		((JComboBox)Comps.get("cbFailList")).removeAllItems();
		((JLabel)Comps.get("lblMake")).setText("-----");
		((JLabel)Comps.get("lblCol")).setText("-----");
		((JLabel)Comps.get("lblType")).setText("-----");
		((JLabel)Comps.get("lblSys")).setText("-----");
		((JLabel)Comps.get("lblMakecount")).setText("-----");
		((JLabel)Comps.get("lblColcount")).setText("-----");
		((JLabel)Comps.get("lblTypecount")).setText("-----");
		((JLabel)Comps.get("lblColcounts")).setText("-----");
		((JLabel)Comps.get("lblTypecounts")).setText("-----");
		((JLabel)Comps.get("lblSuccess")).setText("-----");
		((JLabel)Comps.get("lblFail")).setText("-----");
		((JLabel)Comps.get("lblSys")).setHorizontalAlignment(SwingConstants.LEADING);
	}
	public void run (){
		boolean getRandom = ((JCheckBox)Comps.get("Random")).isSelected();
		newr();
			//try{
			int Successcount = 0 ;
			int Failcount = 0 ;
			int Makecount = 0;
			int Colcounts = 0;
			int Typecounts = 0;
			RS.seturl("https://autos.yahoo.com.tw/new-cars/research");
			AS.transport("INDEX",RS.getDoc());
			List<String> Makeurl = AS.getUrl();
			List<String> Makename = AS.getTable_Column_name();
			int ran = ((int) (Math.random()*40));
			Z:
			for(int i = 0 ; i<Makeurl.size() ; i++){if(!isRunning)break Z;
//				if(i!= ran&& getRandom)continue;
				if(i!= 2)continue;// Test
				((JLabel)Comps.get("lblMake")).setText(Makename.get(i));
				((JLabel)Comps.get("lblSys")).setText(Makename.get(i));
				((JLabel)Comps.get("lblSys")).setForeground(Color.GREEN);
				((JLabel)Comps.get("lblMakecount")).setText(String.valueOf(i+1) + " / "+(Makeurl.size()));
				int Colcount = 0;
				if(RS.seturl(Makeurl.get(i))){
					if(year.length()==4)AS.setYear(year);
					
					AS.transport("SECONDyear",RS.getDoc());
					List<String> Colurl = AS.getUrl();
					List<String> Colname = AS.getTable_Column_name();
					if((Colurl.size()-1)!=0){
						Z2:
						for(int j = 0 ; j<Colurl.size() ; j++){if(!isRunning)break Z;
						if(j!= 15)continue Z2; // Test
						//if(getRandom&&Math.random()>0.13)continue;
							((JLabel)Comps.get("lblSys")).setForeground(Color.green);
							((JLabel)Comps.get("lblCol")).setText(Colname.get(j).replace(year,"").replace(Makename.get(i),"").trim());
							((JLabel)Comps.get("lblSys")).setText(Makename.get(i)+" "+Colname.get(j).replace(year,"").replace(Makename.get(i),"").trim());
							((JLabel)Comps.get("lblColcount")).setText(String.valueOf(++Colcount) + " / "+(Colurl.size()));
							((JLabel)Comps.get("lblColcounts")).setText(String.valueOf(++Colcounts));
							if(RS.seturl(Colurl.get(j))){
								AS.transport("THIRD",RS.getDoc());
								List<String> Typeurl = AS.getUrl();
								List<String> Typename = AS.getTable_Column_name();
								int Typecount = 0;
								Z3:
								for(int k = 0 ; k<Typeurl.size() ; k++){if(!isRunning)break Z;
								//if(getRandom&&Math.random()>0.1)continue;
									((JLabel)Comps.get("lblType")).setText(Typename.get(k));
									((JLabel)Comps.get("lblSys")).setText(Makename.get(i)+" "+Colname.get(j).replace(year,"").replace(Makename.get(i),"").trim()+" "+Typename.get(k));
									((JLabel)Comps.get("lblSys")).setForeground(Color.red);
									((JLabel)Comps.get("lblTypecount")).setText(String.valueOf(++Typecount) + " / "+(Typeurl.size()));
									((JLabel)Comps.get("lblTypecounts")).setText(String.valueOf(++Typecounts));
									if(RS.seturl(Typeurl.get(k))){
										AS.transport("LAST",RS.getDoc());
										String lue [][]= AS.getTable_value();
										String tag = "";
										for(String va[] : lue){
											tag = tag+ "'" +(va[1].endsWith(", ")?va[1].substring(0,va[1].length()-2):va[1]) + "', " ;
										}this.value =this.value +"("+tag.substring(0,tag.length()-2)+")"+"\n";
										((JLabel)Comps.get("lblSuccess")).setText("S "+String.valueOf(++Successcount));
										((JLabel)Comps.get("lblSys")).setForeground(Color.green);
										//if(Successcount==15)break Z;
									}else{
										((JLabel)Comps.get("lblFail")).setText(String.valueOf(++Failcount));
										((JComboBox)Comps.get("cbFailList")).addItem(Typename.get(k) +" URL : "+ Typeurl.get(k));;
									}
								}
							}else{
								((JLabel)Comps.get("lblFail")).setText(String.valueOf(++Failcount));
								((JComboBox)Comps.get("cbFailList")).addItem(Colname.get(j) +" URL : "+ Colurl.get(i));;
							}
						}
					}
				}else{
					((JLabel)Comps.get("lblFail")).setText(String.valueOf(++Failcount));
					((JComboBox)Comps.get("cbFailList")).addItem(Makename.get(i) +" URL : "+ Makeurl.get(i));;
				}
				
			}
			/*}catch(Exception e){
				System.out.println("STOP");
			}*/
//			System.out.println(RS);
			RS = null;
			AS = null;
			//while(true){
			//	LBLs.get("lblMake").setText(String.valueOf(Makecount++));
			//}
			((JLabel)Comps.get("lblSys")).setText(String.valueOf("Total : "+(new Date().getTime()-startdate)/1000.0)+" s ");
			((JLabel)Comps.get("lblSys")).setHorizontalAlignment(SwingConstants.RIGHT);
			((JLabel)Comps.get("lblSuccess")).setText("Success "+String.valueOf(Successcount));
			if(isRunning != false)((JButton)Comps.get("btnStart")).doClick();
			if(!this.value.equals("")){
				((JButton)Comps.get("btnView")).setEnabled(true);
				((JButton)Comps.get("btnView")).doClick();
				((JButton)Comps.get("btnLocal")).setEnabled(true);
				((JButton)Comps.get("btnMysql")).setEnabled(true);
			}
	}
	public void stopRun (){
		isRunning = false;
	}
	public String getvalue (){
		return value;
	}
}
