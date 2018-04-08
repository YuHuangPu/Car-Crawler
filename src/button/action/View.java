package button.action;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;

public class View extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			View dialog = new View();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public View() {
		
	}

	public View(String value) {
		setUndecorated(true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setBounds(screenSize.width/2+265/2, screenHeight/2-331/2, 265, 331);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 265, 331);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea(value);
		textArea.setFont(new Font("·L³n¥¿¶ÂÅé", Font.BOLD, 13));
		textArea.setBackground(Color.BLACK);
		scrollPane.setViewportView(textArea);
		textArea.setForeground(Color.GREEN);
	}

	public void Start() {
		setVisible(true);
	}
	public void Close(){
		dispose();
	}

}
