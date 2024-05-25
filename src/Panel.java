import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Panel extends JPanel implements Runnable {
    Room room = new Room();
    public int WIDTH = (room.MAX_COL * room.getSQUARE_SIZE()) + 100;
    public int HEIGHT = (room.MAX_ROW * room.getSQUARE_SIZE()) + 100;
    final int FPS = 60;
    Thread thread;

    Objects o = new Objects();
    Text t = new Text();

    public Panel() {
        //room.setRoomSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }

    public void launch() {
        t.intro();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (thread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print("#what do you want to do?\n#");
        String action = sc.nextLine();
        switch (action.toLowerCase()) {
            case "add":
                o.addObject();
                break;
            case "remove":
                if (o.o.isEmpty()) {
                    System.out.println("#nothing to move");
                } else {
                    o.removeObject();
                }
                break;
            case "move":
                if (o.o.isEmpty()) {
                    System.out.println("#nothing to move");
                } else {
                    o.moveObject();
                }
                break;
            case "resize":
                if (o.o.isEmpty()) {
                    System.out.println("#nothing to move");
                } else {
                    o.resizeObject();
                }
                break;
            case "list":
                if (o.o.isEmpty()) {
                    System.out.println("#nothing to move");
                } else {
                    System.out.println(o.o);
                }
                break;
            case "help":
                t.instructions();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("#invalid action\n#type help for instructions");
                break;

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        g2.drawString("0", 0, 16);
        room.draw(g2);
        for (int i = 0; i < o.o.size(); i++) {
            g2.setColor(o.o.get(i).c);
            g2.fillRect(o.o.get(i).x, o.o.get(i).y, o.o.get(i).width, o.o.get(i).height);
        }
        for (int i = 0; i < o.o.size(); i++) {
            g2.setColor(Color.BLACK);
            g2.drawString(o.o.get(i).name, o.o.get(i).x + 1, o.o.get(i).y + (o.o.get(i).height / 2));
        }
    }
}
