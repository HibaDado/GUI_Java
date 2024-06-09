import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class AddPayments extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtItem;
	private JTextField txtCost;
	private JTextField txtDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPayments frame = new AddPayments();
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
	public AddPayments() {
		if(StaticObjects.mp == null) {
			AddPayments.this.setVisible(false);
			new LoginForm().setVisible(true);
			return;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 388);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payments");
		lblNewLabel.setBounds(82, 10, 116, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lenovo\\Downloads\\pay.png"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item");
		lblNewLabel_1.setBounds(32, 101, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cost");
		lblNewLabel_2.setBounds(32, 153, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(32, 204, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		txtItem = new JTextField();
		txtItem.setBounds(140, 98, 96, 19);
		contentPane.add(txtItem);
		txtItem.setColumns(10);
		
		txtCost = new JTextField();
		txtCost.setBounds(140, 150, 96, 19);
		contentPane.add(txtCost);
		txtCost.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setBounds(140, 201, 96, 19);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		JComboBox comType = new JComboBox();
		comType.setModel(new DefaultComboBoxModel(new String[] {"Pay", "Cash"}));
		comType.setBounds(140, 244, 96, 21);
		contentPane.add(comType);
		
		JLabel lblNewLabel_4 = new JLabel("Type");
		lblNewLabel_4.setBounds(32, 248, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter pw = new PrintWriter(new File("C:\\Users\\lenovo\\eclipse-workspace\\FirstRealProject\\files\\Payments.txt"));
					String item = txtItem.getText();
					String cost = txtCost.getText();
					String date = txtDate.getText();
					String type = comType.getSelectedItem() + "";
					
					pw.append(item + "\n");
					pw.append(cost + "\n");
					pw.append(date + "\n");
					pw.append(type + "\n");
					
					pw.close();
					JOptionPane.showMessageDialog(AddPayments.this, "Done");
					AddPayments.this.setVisible(false);
					StaticObjects.mp.setVisible(true);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(AddPayments.this, "Cann't add !");

						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(92, 298, 85, 21);
		contentPane.add(btnNewButton);
	}
}
