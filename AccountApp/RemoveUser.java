import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class RemoveUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable userTable;
	private JScrollPane scrollPane;
	
	private DefaultTableModel tableModel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveUser frame = new RemoveUser();
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
	public RemoveUser() {
		if(StaticObjects.mp == null) {
			RemoveUser.this.setVisible(false);
			new LoginForm().setVisible(true);
			return;
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 628, 249);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel(new String [] 
				{"Emp Name", "Address", "Phone", "Email", "Salary", "Gender"} ,0);
		
		userTable = new JTable(tableModel);
		scrollPane.setViewportView(userTable);
		
		readUserFile();
		
		JButton btnNewButton = new JButton("Remove User ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.removeRow(userTable.getSelectedRow());
				try {
					PrintWriter pw = new PrintWriter(new File("C:\\Users\\lenovo\\eclipse-workspace\\FirstRealProject\\files\\users.txt"));
					for (int i = 0; i < userTable.getRowCount(); i++) {
						pw.println(userTable.getValueAt(i, 0));
						pw.println(userTable.getValueAt(i, 1));
						pw.println(userTable.getValueAt(i, 2));
						pw.println(userTable.getValueAt(i, 3));
						pw.println(userTable.getValueAt(i, 4));
						pw.println(userTable.getValueAt(i, 5));
					}
					pw.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\delete.png"));
		btnNewButton.setBounds(279, 260, 171, 57);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveUser.this.setVisible(false);
				StaticObjects.mp.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\back.png"));
		btnNewButton_1.setBounds(156, 259, 113, 57);
		contentPane.add(btnNewButton_1);
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
}
