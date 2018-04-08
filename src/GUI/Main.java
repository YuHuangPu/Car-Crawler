package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import button.action.Start;
import button.listener.ActionListen;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private final HashMap<String , Component> Comps = new HashMap<String , Component>();
	private final ActionListen ActionListener = new ActionListen(Comps);
	private JComboBox cbYearList;
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.gc();
			}
		});
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setTitle("AutoDownload");
		frame.getContentPane().setFont(new Font("Consolas", Font.PLAIN, 12));
		frame.setBounds(100, 100, 270, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		Comps.put("Frame",frame);
		cbYearList = new JComboBox();
		cbYearList.setBackground(Color.BLACK);
		cbYearList.setForeground(Color.GREEN);
		cbYearList.setFont(new Font("Consolas", Font.PLAIN, 12));
		cbYearList.setBounds(10, 10, 130, 21);
		frame.getContentPane().add(cbYearList);
		cbYearList.setModel(new DefaultComboBoxModel(new String[] {"2018", "2017", "2016", "2015", "2014", "2013", "\u8ACB\u4E0D\u8981\u9078\u6211..."}));
		Comps.put("cbYearList",cbYearList);
		JPanel plMake = new JPanel();
		plMake.setBackground(Color.BLACK);
		plMake.setBounds(10, 35, 241, 23);
		frame.getContentPane().add(plMake);
		plMake.setLayout(null);
		
		JLabel lblMake = new JLabel("-----");
		lblMake.setForeground(Color.GREEN);
		lblMake.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblMake.setBounds(0, 0, 112, 23);
		plMake.add(lblMake);
		Comps.put("lblMake",lblMake);
		
		JLabel lblMakecount = new JLabel("-----");
		lblMakecount.setForeground(Color.GREEN);
		lblMakecount.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblMakecount.setBounds(120, 0, 68, 23);
		plMake.add(lblMakecount);
		Comps.put("lblMakecount",lblMakecount);
		
		JPanel plCol = new JPanel();
		plCol.setBackground(Color.BLACK);
		plCol.setBounds(10, 68, 241, 23);
		frame.getContentPane().add(plCol);
		plCol.setLayout(null);
		
		JLabel lblCol = new JLabel("-----");
		lblCol.setForeground(Color.GREEN);
		lblCol.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblCol.setBounds(0, 0, 112, 23);
		plCol.add(lblCol);
		Comps.put("lblCol",lblCol);
		
		JLabel lblColcount = new JLabel("-----");
		lblColcount.setForeground(Color.GREEN);
		lblColcount.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblColcount.setBounds(120, 0, 68, 23);
		plCol.add(lblColcount);
		Comps.put("lblColcount",lblColcount);
		
		JLabel lblColcounts = new JLabel("-----");
		lblColcounts.setForeground(Color.GREEN);
		lblColcounts.setHorizontalAlignment(SwingConstants.RIGHT);
		lblColcounts.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblColcounts.setBounds(178, 0, 53, 23);
		plCol.add(lblColcounts);
		Comps.put("lblColcounts",lblColcounts);
		
		JPanel plType = new JPanel();
		plType.setBackground(Color.BLACK);
		plType.setBounds(10, 101, 241, 23);
		frame.getContentPane().add(plType);
		plType.setLayout(null);
		
		JLabel lblType = new JLabel("-----");
		lblType.setForeground(Color.GREEN);
		lblType.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblType.setBounds(0, 0, 112, 23);
		plType.add(lblType);
		Comps.put("lblType",lblType);
		
		JLabel lblTypecount = new JLabel("-----");
		lblTypecount.setBounds(120, 0, 70, 23);
		plType.add(lblTypecount);
		lblTypecount.setForeground(Color.GREEN);
		lblTypecount.setFont(new Font("Consolas", Font.PLAIN, 12));
		Comps.put("lblTypecount",lblTypecount);
		
		JLabel lblTypecounts = new JLabel("-----");
		lblTypecounts.setForeground(Color.GREEN);
		lblTypecounts.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTypecounts.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblTypecounts.setBounds(178, 0, 53, 23);
		plType.add(lblTypecounts);
		Comps.put("lblTypecounts",lblTypecounts);
		
		JLabel lblSuccess = new JLabel("-----");
		lblSuccess.setBounds(10, 132, 101, 23);
		frame.getContentPane().add(lblSuccess);
		lblSuccess.setForeground(Color.GREEN);
		lblSuccess.setFont(new Font("Consolas", Font.PLAIN, 12));
		Comps.put("lblSuccess",lblSuccess);
		
		JLabel lblFail = new JLabel("-----");
		lblFail.setBounds(10, 255, 42, 23);
		frame.getContentPane().add(lblFail);
		lblFail.setForeground(Color.GREEN);
		lblFail.setFont(new Font("Consolas", Font.PLAIN, 12));
		Comps.put("lblFail",lblFail);
		
		final JButton btnStart = new JButton("START");
		btnStart.setForeground(Color.GREEN);
		btnStart.setBackground(Color.BLACK);
		btnStart.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnStart.addActionListener(ActionListener);
		Comps.put("btnStart",btnStart);
		
		JLabel lblSys = new JLabel("--------------------------");
		lblSys.setForeground(Color.GREEN);
		lblSys.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblSys.setBounds(62, 134, 189, 21);
		frame.getContentPane().add(lblSys);
		Comps.put("lblSys",lblSys);
		btnStart.setBounds(10, 165, 81, 80);
		frame.getContentPane().add(btnStart);
		
		JComboBox cbFailList = new JComboBox();
		cbFailList.setForeground(Color.GREEN);
		cbFailList.setBackground(Color.BLACK);
		cbFailList.setBounds(62, 254, 189, 21);
		frame.getContentPane().add(cbFailList);
		cbFailList.setFont(new Font("Consolas", Font.PLAIN, 12));
		Comps.put("cbFailList",cbFailList);
		
		JLabel lblNewLabel = new JLabel("By Yu.Huang");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblNewLabel.setBounds(150, 10, 101, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnView = new JButton("VIEW");
		btnView.setEnabled(false);
		btnView.setBackground(Color.BLACK);
		btnView.setForeground(Color.GREEN);
		btnView.addActionListener(ActionListener);
		btnView.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnView.setBounds(90, 165, 81, 80);
		frame.getContentPane().add(btnView);
		Comps.put("btnView",btnView);
		
		JButton btnLocal = new JButton("LOCAL");
		btnLocal.setEnabled(false);
		btnLocal.addActionListener(ActionListener);
		btnLocal.setForeground(Color.GREEN);
		btnLocal.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnLocal.setBackground(Color.BLACK);
		btnLocal.setBounds(170, 165, 81, 27);
		frame.getContentPane().add(btnLocal);
		Comps.put("btnLocal",btnLocal);
		
		JButton btnMysql = new JButton("MYSQL");
		btnMysql.setEnabled(false);
		btnMysql.addActionListener(ActionListener);
		btnMysql.setForeground(Color.GREEN);
		btnMysql.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnMysql.setBackground(Color.BLACK);
		btnMysql.setBounds(170, 191, 81, 27);
		Comps.put("btnMysql",btnMysql);
		frame.getContentPane().add(btnMysql);
		
		
		JButton btnOracle = new JButton("ORACLE");
		btnOracle.setEnabled(false);
		btnOracle.setForeground(Color.GREEN);
		btnOracle.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnOracle.setBackground(Color.BLACK);
		btnOracle.setBounds(170, 217, 81, 28);
		frame.getContentPane().add(btnOracle);
		
		JCheckBox Random = new JCheckBox("");
		Random.setBackground(Color.BLACK);
		Random.setBounds(10, 295, 20, 20);
		frame.getContentPane().add(Random);
		Comps.put("Random",Random);
		
		JButton btnPic = new JButton("PIC");
		btnPic.addActionListener(ActionListener);
		btnPic.setBounds(36, 292, 55, 23);
		frame.getContentPane().add(btnPic);
	}
}
