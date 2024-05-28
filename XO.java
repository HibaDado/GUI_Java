package advaned_XO;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class XO extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int [] [] arr = new int [3] [3];
	private int flag = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XO frame = new XO();
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
	public XO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 360);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getX() > 0 && e.getX() < 120) {
						if(e.getY() > 0 && e.getY() < 120) {
							if(arr [0] [0] != 0) {
								JOptionPane.showMessageDialog(XO.this, "invaled");
							} else {
							if(flag == 0) {
								arr [0] [0] = 1;
							} else {
								arr [0] [0] = 2;
							}
							}
						} else if(e.getY() > 120 && e.getY() < 240) {
							if(arr [1] [0] != 0) {
								JOptionPane.showMessageDialog(XO.this, "invaled");
							} else {
							if(flag == 0) {
								arr [1] [0] = 1;
							} else {
								arr [1] [0] = 2;
							}}
							
						} else if(e.getY() > 240 && e.getY() < 360) {
							if(arr [2] [0] != 0) {
								JOptionPane.showMessageDialog(XO.this, "invaled");
							} else {
							if(flag == 0) {
								arr [2] [0] = 1;
							} else {
								arr [2] [0] = 2;
							}							
						}}
						
				} else if(e.getX() > 120 && e.getX() < 240){
						  if(e.getY() > 0 && e.getY() < 120) {
							  if(arr [0] [1] != 0) {
									JOptionPane.showMessageDialog(XO.this, "invaled");
								} else {
								if(flag == 0) {
									arr [0] [1] = 1;
								} else {
									arr [0] [1] = 12;

								}}
						} else if(e.getY() > 120 && e.getY() < 240) {
							if(arr [1] [1] != 0) {
								JOptionPane.showMessageDialog(XO.this, "invaled");
							} else {
							if(flag == 0) {
								arr [1] [1] = 1;
							} else {
								arr [1] [1] = 2;
							}}
						} else if(e.getY() > 240 && e.getY() < 360) {
							if(arr [2] [1] != 0) {
								JOptionPane.showMessageDialog(XO.this, "invaled");
							} else {
							if(flag == 0) {
								arr [2] [1] = 1;
							} else {
								arr [2] [1] = 2;
							}
						}}
					
				} else if(e.getX() > 240 && e.getX() < 360){
						  if(e.getY() > 0 && e.getY() < 120) {
							  if(arr [0] [2] != 0) {
									JOptionPane.showMessageDialog(XO.this, "invaled");
								} else {
								if(flag == 0) {
									arr [0] [2] = 1;
								} else {
									arr [0] [2] = 2;
								}}
						} else if(e.getY() > 120 && e.getY() < 240) {
							if(arr [1] [2] != 0) {
								JOptionPane.showMessageDialog(XO.this, "invaled");
							} else {
							if(flag == 0) {
								arr [1] [2] = 1;
							} else {
								arr [1] [2] = 1;
							}}
						} else if(e.getY() > 240 && e.getY() < 360) {
							if(arr [2] [2] != 0) {
								JOptionPane.showMessageDialog(XO.this, "invaled");
							} else {
							if(flag == 0) {
								arr [2] [2] = 1;
							} else {
								arr [2] [2] = 2;
							}
						}}
					
				}
				if(flag == 0) {
					flag = 1;
				} else {
					flag = 0;
				}
				int v = win();
				if(v == 1) {
					JOptionPane.showMessageDialog(XO.this, "o is the winner");
				}else if(v == 2) {
					JOptionPane.showMessageDialog(XO.this, "x is the winner");
				}
				repaint();
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	
	public int win() {
		int countx = 0;
		int county = 0;
		for(int i = 0; i < 3; i++) {
			if(arr [0][i] == 1) {
				countx++;
			}else if(arr [0][i] == 2) {
				county++;
				}
			}
		if(countx == 3) {
			return 1;
		} else if(county == 3) {
			return 2;
			}
		
		countx = 0;
		county = 0;
		for(int i = 0; i < 3; i++) {
			if(arr [1][i] == 1) {
				countx++;
			}else if(arr [1][i] == 2) {
				county++;
				}
		}
		if(countx == 3) {
			return 1;
		} else if(county == 3) {
			return 2;
			}
		
		countx = 0;
		county = 0;
		for(int i = 0; i < 3; i++) {
			if(arr [2][i] == 1) {
				countx++;
			}else if(arr [2][i] == 2) {
				county++;
				}
		}
		if(countx == 3) {
			return 1;
		} else if(county == 3) {
			return 2;
			}
		
		countx = 0;
		county = 0;
		for(int i = 0; i < 3; i++) {
			if(arr [i][0] == 1) {
				countx++;
			}else if(arr [i][0] == 2) {
				county++;
				}
		}
		if(countx == 3) {
			return 1;
		} else if(county == 3) {
			return 2;
			}
		
		countx = 0;
		county = 0;
		for(int i = 0; i < 3; i++) {
			if(arr [i][1] == 1) {
				countx++;
			}else if(arr [i][1] == 2) {
				county++;
				}
		}
		if(countx == 3) {
			return 1;
		} else if(county == 3) {
			return 2;
			}
		
		countx = 0;
		county = 0;
		for(int i = 0; i < 3; i++) {
			if(arr [i][2] == 1) {
				countx++;
			}else if(arr [i][2] == 2) {
				county++;
				}
		}
		if(countx == 3) {
			return 1;
		} else if(county == 3) {
			return 2;
			}
		
		countx = 0;
		county = 0;
		for(int i = 0; i < 3; i++) {
			if(arr [i][i] == 1) {
				countx++;
			}else if(arr [i][i] == 2) {
				county++;
				}
		}
		if(countx == 3) {
			return 1;
		} else if(county == 3) {
			return 2;
			}
		
		countx = 0;
		county = 0;
		for(int i = 0; i < 3; i++) {
			if(arr [i][2-i] == 1) {
				countx++;
			}else if(arr [i][2-i] == 2) {
				county++;
				}
		}
		if(countx == 3) {
			return 1;
		} else if(county == 3) {
			return 2;
			} else {
				return 0;
			}

	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
		
		g2d.drawLine(120, 0, 120, this.getHeight());;		
		g2d.drawLine(240, 0, 240, this.getHeight());;
		
		g2d.drawLine(0, 120, this.getWidth(), 120);;		
		g2d.drawLine(0, 240, this.getWidth(), 240);;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(arr [i] [j] == 1) {
					g2d.drawOval(j * 120, i * 120, 120, 120);
				} else if(arr [i] [j] == 2) {
					g2d.drawLine(j * 120, i * 120, j * 120 +120, i * 120 +120);
					g2d.drawLine(j * 120 +120, i * 120, j * 120, i * 120 +120);
				}
			}
		}	
	}

}
