import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{
    public int WIDTH = 1100;
    public int HEIGHT = 800;
    final int FPS = 60;
    Thread thread;

    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }
    @Override
    public void run() {
    }
    private void update(){}
    public void paintComponent(Graphics g){}


}
