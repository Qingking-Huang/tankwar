package tankwar1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class GameClient extends JComponent {

    private tank playerTank;

    private List<tank> enemyTanks;

    private List<wall> walls;

    private GameClient(){
        this.playerTank = new tank(400 , 100 ,Direction.DOWN );
        this.enemyTanks = new ArrayList<>(12);
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                this.enemyTanks.add(new tank(200 + 120 *j, 400 +40 *i ,true, Direction.UP));
            }
        }

        this.setPreferredSize(new Dimension(800 , 600));//設定一個視窗800X600
    }

    @Override
    protected void paintComponent(Graphics g) {
        playerTank.draw(g);
        for (tank tanks : enemyTanks){
            tanks.draw(g);
        }
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
                client.playerTank.keyPressed(e);
                }

            @Override
            public void keyReleased(KeyEvent e) {
                client.playerTank.keyReleased(e);
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
