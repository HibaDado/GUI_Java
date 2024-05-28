package advanced_32;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private int sp1=0, sp2=120, sp3=240;
	private int x = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("stop");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x = 0;
			}
		});
		btnNewButton.setBounds(47, 353, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("speedDown");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x-=5;
			}
		});
		btnNewButton_1.setBounds(226, 353, 114, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("speedup");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x+=5;
			}
		});
		btnNewButton_2.setBounds(435, 353, 85, 21);
		contentPane.add(btnNewButton_2);
		Timer t = new Timer(150, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sp1+=x;
				sp2+=x;
				sp3+=x;
				repaint();
			}
		});
		t.start();
	}
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawOval(this.getWidth()/2-80, this.getHeight()/2-80,150 , 150);
		g.fillArc(this.getWidth()/2-80, this.getHeight()/2-80, 150, 150, sp1, 30);
		g.fillArc(this.getWidth()/2-80, this.getHeight()/2-80, 150, 150, sp2, 30);
		g.fillArc(this.getWidth()/2-80, this.getHeight()/2-80, 150, 150, sp3, 30);

		}
	

}
