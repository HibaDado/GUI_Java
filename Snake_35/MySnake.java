package Snake_35;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MySnake extends JFrame {
    int xS = 40, yS = 40; //for snake
    int xA = 100, yA = 100; //for Apple
    int flagDir = 1;
    int score = 0;
    ArrayList <XY> list = new ArrayList<XY>();
    Timer timer;
    public MySnake(String title) throws HeadlessException{
        super(title);

        list.add(new XY(40, 40));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(450,100);
        this.setSize(600,600);
        this.setResizable(false);
        this.setUndecorated(true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT && flagDir != 2){
                    flagDir = 1;
                } else if(e.getKeyCode() == KeyEvent.VK_LEFT && flagDir != 1){
                    flagDir = 2;
                } else if(e.getKeyCode() == KeyEvent.VK_UP && flagDir != 4){
                    flagDir = 3;
                } else if(e.getKeyCode() == KeyEvent.VK_DOWN && flagDir != 3){
                    flagDir = 4;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });



        timer = new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flagDir == 1){//لما امشي على اليمين x بتزداد لكن y ثابتة
                    xS = 20;
                    yS = 0;
                } else if(flagDir == 2) {//لما ارجع لورا(امشي على اليسار) x بتنقص لكن y ثابتة
                    xS = -20;
                    yS = 0;
                } else if(flagDir == 3) {//لما امشي لفوق x ثابتة لكن y بتقل
                    yS = -20;
                    xS = 0;
                } else if(flagDir == 4) {//لما امشي على لتحت x ثابتة لكن y بتزيد
                    yS = 20;
                    xS = 0;
                }
                repaint();
            }
        });
        timer.start();
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawRect(20,20,getWidth() - 40,getHeight() - 40);

        int xF = list.get(0).getX();
        int yF = list.get(0).getY();

        if(!(xF > 20 && xF < getWidth() - 40 && yF > 20 && yF < getHeight() - 40)){
            timer.stop();
            JOptionPane.showMessageDialog(this, "You Lose with Score : " + score);
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            int xi = list.get(i).getX();
            int yi = list.get(i).getY();
            if(xF == xi && yF == yi){
                timer.stop();
                JOptionPane.showMessageDialog(this, "You Lose with Score : " + score);
                return;
            }
        }

        if(list.get(0).getX() == xA && list.get(0).getY() == yA){
            score += 10;
            xA = (int)(2 + Math.random() * 26) * 20;//*20 عشان حكيت بدي الموقع من مضاعفات ال20
            yA = (int)(2 + Math.random() * 26) * 20; //ال1 عشان اتجنب الاطراف واختار رقم 26 عشان 600\20 = 30 لكن بده نتجنب مشكلة الحواف

            int xN = 0, yN = 0; //N: new
            if (flagDir == 1){
                xN = list.get(list.size() - 1).getX() - 20;
                yN = list.get(list.size() - 1).getY();
            } else if (flagDir == 2) {
                xN = list.get(list.size() - 1).getX() + 20;
                yN = list.get(list.size() - 1).getY();
            } else if (flagDir == 3) {
                yN = list.get(list.size() - 1).getY() + 20;
                xN = list.get(list.size() - 1).getX();
            } else if (flagDir == 4) {
                yN = list.get(list.size() - 1).getY() - 20;
                xN = list.get(list.size() - 1).getX();
            }

            list.add(new XY(xN, yN));
        }
        g.drawString("score : " + score,getWidth() -90, 50);

        g.setColor(Color.RED);
        g.fillOval(xA,yA,20,20);
        //g.setColor(Color.BLACK);
        for (int i = list.size() - 1; i >= 0 ; i--) {
            if(i == 0) {
                list.get(i).setX(list.get(i).getX() + xS);
                list.get(i).setY(list.get(i).getY() + yS);
            } else{
                list.get(i).setX(list.get(i-1).getX());
                list.get(i).setY(list.get(i-1).getY());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if(i == 0){
                g.setColor(Color.BLUE);
            } else{
                g.setColor(Color.BLACK);
            }
            g.fillOval(list.get(i).getX(), list.get(i).getY(),20,20);
        }
    }

    public static void main(String[] args) {
        new MySnake("My Snake");
    }
}

