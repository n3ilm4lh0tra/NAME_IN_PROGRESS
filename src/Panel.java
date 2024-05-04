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
    public void launch(){
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(thread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
    private void update(){}
    public void paintComponent(Graphics g){}


}
