import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Reports extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable userTable;
	private DefaultTableModel tableModel;
	private DefaultTableModel tablePayModel;
	private JTable payTable;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reports() {
		if(StaticObjects.mp == null) {
			Reports.this.setVisible(false);
			new LoginForm().setVisible(true);
			return;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 10, 617, 396);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("User Report", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 612, 369);
		panel.add(scrollPane);
		
		tableModel = new DefaultTableModel(new String [] 
				{"Emp Name", "Address", "Phone", "Email", "Salary", "Gender"} ,0);
		
		userTable = new JTable(tableModel);
		readUserFile();
		scrollPane.setViewportView(userTable);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Payments Report", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 612, 359);
		panel_1.add(scrollPane_1);
		
		tablePayModel = new DefaultTableModel(new String [] 
				{"Item", "Cost", "Date", "Type"} ,0);
		
		payTable = new JTable(tablePayModel);
		readPayFile();     
		scrollPane_1.setViewportView(payTable);
	}
	
	public void readUserFile() {
		try {
			Scanner sc = new Scanner (new File("C:\\Users\\lenovo\\eclipse-workspace\\FirstRealProject\\files\\users.txt"));
			while(sc.hasNextLine()) {
				tableModel.addRow(new String [] {sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()});
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readPayFile() {
		try {
			Scanner sc = new Scanner (new File("C:\\Users\\lenovo\\eclipse-workspace\\FirstRealProject\\files\\Payments.txt"));
			while(sc.hasNextLine()) {
				tablePayModel.addRow(new String [] {sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()});
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

