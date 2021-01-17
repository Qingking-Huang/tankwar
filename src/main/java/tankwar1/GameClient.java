package tankwar1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameClient extends JComponent {

    private tank playertnak;


    private GameClient(){
        this.playertnak = new tank(400 , 100 ,Direction.DOWN );

        this.setPreferredSize(new Dimension(800 , 600));//設定一個視窗800X600
    }

    @Override
    protected void paintComponent(Graphics g) {
        playertnak.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("坦克大戰");//視窗的名字
        frame.setIconImage(new ImageIcon("assets/images/icon.png").getImage());
        final GameClient client = new GameClient();
        frame.add(client);//把視窗加入frame
        frame.pack();//使開啟視窗時不會縮小
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                client.playertnak.keyPressed(e);
                }

            @Override
            public void keyReleased(KeyEvent e) {
                client.playertnak.keyReleased(e);
            }

        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//關閉視窗時同時關閉程式
        frame.setVisible(true);//視窗可見化

        while (true){
            client.repaint();
            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
