import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
					if(StaticObjects.mp == null) {
						new LoginForm().setVisible(true);
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		
		setTitle("Main Page");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 259);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Acounter");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\acc.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(218, 112, 214));
		lblNewLabel.setBounds(114, 10, 182, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddUser().setVisible(true);
				StaticObjects.mp.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\add_account.png"));
		btnNewButton.setBackground(new Color(216, 191, 216));
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(24, 73, 182, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RemoveUser().setVisible(true);
				StaticObjects.mp.setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\remove_account.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setForeground(new Color(128, 0, 128));
		btnNewButton_1.setBackground(new Color(216, 191, 216));
		btnNewButton_1.setBounds(228, 74, 182, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Payments");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddPayments().setVisible(true);
				StaticObjects.mp.setVisible(false);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\payment.png"));
		btnNewButton_2.setForeground(new Color(128, 0, 128));
		btnNewButton_2.setBackground(new Color(216, 191, 216));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(24, 137, 182, 53);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Show Reports");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reports().setVisible(true);
				StaticObjects.mp.setVisible(false);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\reports.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBackground(new Color(216, 191, 216));
		btnNewButton_3.setForeground(new Color(128, 0, 128));
		btnNewButton_3.setBounds(228, 137, 182, 53);
		contentPane.add(btnNewButton_3);
	}

}
