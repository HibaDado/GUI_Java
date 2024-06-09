import java.awt.EventQueue;
import java.io.*;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblInvalid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setTitle("My App");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "LoginForm", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(42, 92, 79, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(42, 138, 79, 28);
		contentPane.add(lblNewLabel_2);

		txtUsername = new JTextField();
		txtUsername.setBounds(151, 92, 125, 28);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(151, 141, 125, 28);
		contentPane.add(txtPassword);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Scanner adminSc = new Scanner(new File("C:\\Users\\lenovo\\eclipse-workspace\\FirstRealProject\\files\\admins.txt"));

					while (adminSc.hasNextLine() ) {
						String user = adminSc.nextLine();
						String pass = adminSc.nextLine();

						if (txtUsername.getText().equals(user) && new String(txtPassword.getPassword()).equals(pass)) {
							lblInvalid.setText("");
							//JOptionPane.showMessageDialog(LoginForm.this, "Login Done"); 
							//adminSc.close();
							//new MainPage().setVisible(true);
							StaticObjects.mp = new MainPage(); //لانها ستتيك بستدعيها باسم الكلاس
							
							StaticObjects.mp.setVisible(true);
							
							LoginForm.this.setVisible(false);
							break;
						} else {
							lblInvalid.setText("Invalid User !");

						}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(110, 196, 110, 28);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\login.png"));
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(93, 10, 158, 56);
		contentPane.add(lblNewLabel);

		lblInvalid = new JLabel("");
		lblInvalid.setForeground(new Color(255, 0, 0));
		lblInvalid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInvalid.setBounds(95, 234, 135, 36);
		contentPane.add(lblInvalid);
	}
}
