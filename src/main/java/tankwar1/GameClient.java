package tankwar1;

import javax.swing.*;
import java.awt.*;

public class GameClient extends JComponent {
    private GameClient(){
        this.setPreferredSize(new Dimension(800 , 600));//設定一個視窗800X600
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(new ImageIcon("assets/images/tankD.gif").getImage(),
             400 , 100 , null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("坦克大戰");//視窗的名字
        frame.setIconImage(new ImageIcon("assets/images/icon.png").getImage());
        GameClient client = new GameClient();
        frame.add(client);//把視窗加入frame
        frame.pack();//使開啟視窗時不會縮小
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//關閉視窗時同時關閉程式
        frame.setVisible(true);//視窗可見化

    }
}
