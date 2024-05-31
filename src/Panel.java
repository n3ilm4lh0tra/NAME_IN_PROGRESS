import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Panel extends JPanel implements Runnable {
    Room room = new Room();

    final int FPS = 60;
    Thread thread;

    Objects o = new Objects();
    Text t = new Text();

    public Panel() {
    }

    /**
     * set the size of the frid in full meters
     * eventually shall be set to be more versatile
     */
    public void setGridSize() {
        Scanner sc = new Scanner(System.in);
        String[] dimensions = new String[2];
        int[] grid = new int[2];
        String[] names = {"width", "height"};
        System.out.println("#set the size in full meters\n#max is 10");
        for (int i = 0; i < dimensions.length; i++) {
            System.out.print("#" + names[i] + "\n#");
            dimensions[i] = sc.nextLine();
            switch (dimensions[i]) {
                case "1":
                    grid[i] = 100;
                    break;
                case "2":
                    grid[i] = 200;
                    break;
                case "3":
                    grid[i] = 300;
                    break;
                case "4":
                    grid[i] = 400;
                    break;
                case "5":
                    grid[i] = 500;
                    break;
                case "6":
                    grid[i] = 600;
                    break;
                case "7":
                    grid[i] = 700;
                    break;
                case "8":
                    grid[i] = 800;
                    break;
                case "9":
                    grid[i] = 900;
                    break;
                case "10":
                    grid[i] = 1000;
                    break;
                default:
                    System.out.println("#invalid\n#set to 1 meter");
                    grid[i] = 100;
            }
        }
        o.r.MAX_COL = grid[0];
        room.MAX_COL = grid[0];
        o.r.MAX_ROW = grid[1];
        room.MAX_ROW = grid[1];
        System.out.println(o.r.MAX_COL + ", " + o.r.MAX_ROW + "\n" + grid[0] + ", " + grid[1]);
        int WIDTH = (o.r.MAX_COL * o.r.SQUARE_SIZE) + 100;
        int HEIGHT = (o.r.MAX_ROW * o.r.SQUARE_SIZE) + 100;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }

    public int W = room.MAX_COL;
    public int H = room.MAX_ROW;

    /**
     * Starts the thread
     */
    public void launch() {
        //setGridSize();
        t.intro();
        thread = new Thread(this);
        thread.start();
    }

    @Override
    /**
     * Temporary update
     * Temp because it is intended to split the logic and graphic into 2 threads
     */
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
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

    /**
     * updates the logic and graphics
     * once split it shall only update the graphics 60 times a second
     */
    private void update() {
        /*System.out.println(room.MAX_COL + ", " + room.MAX_ROW);
        Scanner sc = new Scanner(System.in);
        System.out.print("#what do you want to do?\n#");
        String action = sc.nextLine();
        switch (action.toLowerCase()) {
            case "add":
                o.addObject();
                break;
            case "remove":
                if (o.o.isEmpty()) {
                    System.out.println("#nothing to remove");
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
                    System.out.println("#nothing to resize");
                } else {
                    o.resizeObject();
                }
                break;
            case "list":
                if (o.o.isEmpty()) {
                    System.out.println("#nothing to list");
                } else {
                    System.out.println(o.o);
                }
                break;
            case "help":
                t.instructions();
                break;
            case "clear":
                o.o.clear();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("#invalid action\n#type help for instructions");
                break;

        }*/
        o.update();
    }

    /**
     * creates and updates the graphics
     *
     * @param g the <code>Graphics</code> graphic component, allows one to add shapes and colour
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        g2.drawString("0", 0, 16);
        room.draw(g2);
        /*for (int i = 0; i < o.o.size(); i++) {
            g2.setColor(o.o.get(i).c);
            g2.fillRect(o.o.get(i).x, o.o.get(i).y, o.o.get(i).width, o.o.get(i).height);
        }
        for (int i = 0; i < o.o.size(); i++) {
            g2.setColor(Color.BLACK);
            g2.drawString(o.o.get(i).name, o.o.get(i).x + 1, o.o.get(i).y + (o.o.get(i).height / 2));
        }*/
        o.draw(g2);
    }
}