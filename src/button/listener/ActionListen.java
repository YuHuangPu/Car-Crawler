package button.listener;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

import button.action.Local;
import button.action.Mysql;
import button.action.PIC;
import button.action.Start;
import button.action.View;

public class ActionListen implements ActionListener  {
	private HashMap<String, Component> Comps ;
	private Start StartBTAC = null;
	private String Value ;
	boolean Localflag = false;
	private View J ;
	public ActionListen(HashMap<String, Component> Comps) {
		this.Comps = Comps;
	}
	public void actionPerformed(ActionEvent e) {
		startlistener(e.getActionCommand().toString());
	}
	private void startlistener(String name){
		switch(name.toUpperCase()){
		case "START":
			StartBTAC = new Start(String.valueOf(((JComboBox)Comps.get("cbYearList")).getSelectedItem()),Comps);
			StartBTAC.start();
			Localflag =true;
			((JButton)Comps.get("btnStart")).setText("STOP");
			((JButton)Comps.get("btnView")).setEnabled(false);
			((JButton)Comps.get("btnLocal")).setEnabled(false);
			((JButton)Comps.get("btnMysql")).setEnabled(false);
			break;
		case "STOP":
			if(StartBTAC!=null)StartBTAC.stopRun();
			System.gc();
			((JButton)Comps.get("btnStart")).setText("START");
			break;
		case "VIEW":
			if(StartBTAC!=null){
				Value = StartBTAC.getvalue();
				StartBTAC = null;
			}
			JDialogView();
			break;
		case "LOCAL":
			if(Localflag)new Local(Value).start();				
			else System.out.println("Already Save");
			Localflag = false ;
			break;
		case "MYSQL":
			//Value.substring(0,Value.length()-3)
			System.out.println("START   time : "+new SimpleDateFormat("hh:mm:ss").format(new Date()));
			new Mysql(Value).gogo();
			System.out.println("End   time : "+new SimpleDateFormat("hh:mm:ss").format(new Date()));
			break;
		case "PIC":
			new PIC().start();
			break;
		default:
			System.out.println(name);
			break;
		}
	}
	private void JDialogView(){
		if(J == null ){
			J = new View("Data value : \n"+Value);
			J.Start();
		}
		else{J.Close();J=null;((JButton)Comps.get("btnView")).setText("VIEW");}
		//J.Start();
	}
}
