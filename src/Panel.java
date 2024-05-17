import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Panel extends JPanel implements Runnable {
    Room room = new Room();
    public int WIDTH = room.getMAX_COL() + 100;
    public int HEIGHT = room.getMAX_ROW() + 100;
    final int FPS = 60;
    Thread thread;

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
       for(int i = 0; i<o.o.size(); i++){
           g2.setColor(o.o.get(i).c);
           g2.fillRect(o.o.get(i).x, o.o.get(i).y, o.o.get(i).width, o.o.get(i).height);
       }
    }
}
