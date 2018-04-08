package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;

import javax.swing.JLabel;

public class test extends Thread {
	public static void main (String [] args){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        System.out.println(screenWidth +"X"+screenHeight );
	}
}
