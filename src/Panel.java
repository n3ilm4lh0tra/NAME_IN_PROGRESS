import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Panel extends JPanel implements Runnable {
    public int WIDTH = 1200;
    public int HEIGHT = 1200;
    final int FPS = 60;
    Thread thread;
    Room room = new Room();
    boolean objectAdded = false;
    Objects o = new Objects();

    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }
    public void temp(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if(x == 5){
            o.addObject();
            objectAdded = true;
        }else if(x == 8){
            System.out.println(o.o);
        }
    }

    public void launch() {
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
                temp();
                repaint();
                delta--;
            }
        }
    }
    private void update() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        g2.drawString("0", 0, 16);
        room.draw(g2);
        if(objectAdded){
            o.draw(g2);
            objectAdded = false;
        }
    }
}
