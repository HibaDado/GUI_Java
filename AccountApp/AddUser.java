import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtSalary;
	private JComboBox combGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
				//	frame.setVisible(true); //security
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddUser() {
		if(StaticObjects.mp == null) {
			AddUser.this.setVisible(false);
			new LoginForm().setVisible(true);
			return;
		}
		
	
		setTitle("Add New User");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New User");
		lblNewLabel.setBounds(89, 23, 136, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\add_account.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(49, 101, 63, 13);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setBounds(122, 95, 161, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(49, 149, 63, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(49, 201, 63, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_3.setBounds(49, 255, 63, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Salary");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_4.setBounds(49, 307, 63, 13);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Gender");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_5.setBounds(49, 351, 63, 13);
		contentPane.add(lblNewLabel_1_5);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(122, 140, 161, 19);
		contentPane.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(122, 192, 161, 19);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(122, 246, 161, 19);
		contentPane.add(txtEmail);
	
		
		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(122, 298, 161, 19);
		contentPane.add(txtSalary);
		
		combGender = new JComboBox();
		combGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		combGender.setBounds(122, 349, 161, 17);
		contentPane.add(combGender);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				PrintWriter pw = new PrintWriter(new File("C:\\Users\\lenovo\\eclipse-workspace\\FirstRealProject\\files\\users.txt"));
				String name = txtName.getText();
				String address = txtAddress.getText();
				String phone = txtPhone.getText();
				String email = txtEmail.getText();
				String salary = txtSalary.getText();
				String gender = combGender.getSelectedItem() + "";
				
				pw.append(name + "\n");
				pw.append(address + "\n");
				pw.append(phone + "\n");
				pw.append(email + "\n");
				pw.append(salary + "\n");
				pw.append(gender + "\n");
				
				pw.close();
				JOptionPane.showMessageDialog(AddUser.this, "Done");
				AddUser.this.setVisible(false);
				StaticObjects.mp.setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(AddUser.this, "Cann't add new user !");

					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\add.png"));
		btnNewButton.setBounds(132, 376, 63, 52);
		contentPane.add(btnNewButton);
	}
}
