import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Objects {
    ArrayList<Object> o = new ArrayList<>();
    Room r = new Room();
    Text t = new Text();
    String name;
    String colour;
    int width;
    int height;
    int x;
    int y;
    Color c;

    public Objects() {
    }

    /**
     * adds object
     * inputs:
     *  name
     *  colour
     *  width
     *  height
     *  x coordinate
     *  y coordinate
     * @throws InputMismatchException if invalid integer
     */
    public void addObject() {
        Scanner sc = new Scanner(System.in);
        System.out.print("#object name\n#");
        try {
            name = sc.nextLine();
            name = name.toUpperCase();
            dupeChecker(name);
            System.out.print("#object colour:\n#");
            colour = sc.nextLine();
            colour = colour.toLowerCase();
            checkColour();
            System.out.println("#colour set to " + colour);
            System.out.print("#object width\n#");
            width = sc.nextInt();
            System.out.print("#object height\n#");
            height = sc.nextInt();
            System.out.print("#object x\n#");
            x = sc.nextInt();
            System.out.print("#object y\n#");
            y = sc.nextInt();
            checkBounds(x, y, width, height);
            o.add(new Object(name, colour, c, width * 16, height * 16, x * 16, y * 16));
            System.out.println("#object added");
            checkCollision(name);
        } catch (InputMismatchException e) {
            System.out.println("#invalid input, returning to menu");
        }
    }

    /**
     * Finds existing object via name
     * removes it
     */
    public void removeObject() {
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.print("#object name\n#");
        n = sc.nextLine();
        n = n.toUpperCase();
        System.out.println(n);
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).name.equals(n)) {
                o.remove(i);
                System.out.print("#object removed\n");
                break;
            } else {
                System.out.println("#object not found\n");
            }
        }
    }

    /**
     * Finds existing object via name
     * allows to move an already exising object
     * @throws InputMismatchException if collision detected or is outside of grid
     */
    public void moveObject() {
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.print("#object name\n#");
        n = sc.nextLine();
        n = n.toUpperCase();
        System.out.println(n);
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).name.equals(n)) {
                System.out.println("#" + o.get(i).name + " found");
                int newX;
                int newY;
                try {
                    System.out.print("#new x\n#");
                    newX = sc.nextInt();
                    System.out.print("#new y\n#");
                    newY = sc.nextInt();
                    checkBounds(newX, newY, o.get(i).width, o.get(i).height);
                    o.get(i).x = newX * 16;
                    o.get(i).y = newY * 16;
                    System.out.println("#object moved moved to\n#x = " + newX + "\n#new y = " + newY);
                    checkCollision(o.get(i).name);
                } catch (InputMismatchException e) {
                    System.out.println("#invalid input, object was not moved");
                }
            } else {
                System.out.println("#object not found");
            }
        }
    }

    /**
     * changes an already existing object's size
     * object is found via object name
     *
     * @throws InputMismatchException if not within bounds or colliding with other objects
     */
    public void resizeObject() {
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.print("#object name\n#");
        n = sc.nextLine();
        n = n.toUpperCase();
        System.out.println(n);
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).name.equals(n)) {
                System.out.println("#" + o.get(i).name + " found");
                int newWidth;
                int newHeight;
                try {
                    System.out.print("#new width\n#");
                    newWidth = sc.nextInt();
                    System.out.print("#new height\n#");
                    newHeight = sc.nextInt();
                    checkBounds(o.get(i).x, o.get(i).y, newWidth, newHeight);
                    o.get(i).width = newWidth * 16;
                    o.get(i).height = newHeight * 16;
                    System.out.println("#object moved moved to\n#new width = " + newWidth + "\n#new height = " + newHeight);
                    checkCollision(o.get(i).name);
                } catch (InputMismatchException e) {
                    System.out.println("#invalid input, object was not moved");
                }
            } else {
                System.out.println("#object not found");
            }
        }
    }

    //checks whether the object is within the grid (INCOMPLETE)
    public void checkBounds(int X, int Y, int WIDTH, int HEIGHT) {
        if ((X < 1 || X + WIDTH - r.SQUARE_SIZE > r.MAX_COL/* * r.SQUARE_SIZE*/ + 1) || (Y < 1 || Y + HEIGHT - r.SQUARE_SIZE > r.MAX_ROW/* * r.SQUARE_SIZE*/ + 1)) {
            //System.out.println(r.MAX_COL/* * r.SQUARE_SIZE*/);
            //System.out.println(r.MAX_ROW/* * r.SQUARE_SIZE*/);
            System.out.println("#out of bounds");
            throw new InputMismatchException();
        }
    }

    //checks for duplicate names
    public void dupeChecker(String nme) {
        for (int i = 0; i < o.size(); i++) {
            if (nme.equals(o.get(i).name)) {
                System.out.println("#no duplicate names");
                throw new InputMismatchException();
            }
        }
    }

    /**
     * Every time an object is created or updated,
     * the method checks for any colliding objects
     * if they are, the updated object is removed
     *
     * @param n name of updated object
     * @throws InputMismatchException if collision is detected
     */
    public void checkCollision(String n) {
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).name.equals(n)) {
                for (int j = 0; j < o.size(); j++) {
                    if (!o.get(i).name.equals(o.get(j).name)) {
                        if (((o.get(i).x >= o.get(j).x && o.get(i).x <= o.get(j).x + o.get(j).width - 16) &&
                                (o.get(i).y >= o.get(i).y && o.get(i).y <= o.get(i).y + o.get(i).height - 16)) ||
                                ((o.get(i).x + o.get(i).width - 16 >= o.get(j).x && o.get(i).x + o.get(i).width - 16 <= o.get(j).x + o.get(j).width - 16) &&
                                        (o.get(i).y + o.get(i).height - 16 >= o.get(i).y && o.get(i).y + o.get(i).height - 16 <= o.get(i).y + o.get(i).height - 16))) {
                            System.out.println("#object collision\n#object removed");
                            o.remove(i);
                            throw new InputMismatchException();
                        }
                    }
                }
            }
        }
    }

    public void checkColour() {
        switch (colour) {
            case "red":
                c = Color.RED;
                break;
            case "orange":
                c = Color.ORANGE;
                break;
            case "yellow":
                c = Color.yellow;
                break;
            case "green":
                c = Color.green;
                break;
            case "blue":
                c = Color.cyan;
                break;
            case "pink":
                c = Color.pink;
                break;
            case "white":
                c = Color.WHITE;
                break;
            default:
                System.out.println("#not in selection or invalid colour\n#will be set to white");
                colour = "white";
                c = Color.WHITE;
                break;
        }
    }

    /**
     * Menu for all functions besides grid size
     */
    public void update() {
        //System.out.println(r.MAX_COL + ", " + r.MAX_ROW);
        Scanner sc = new Scanner(System.in);
        System.out.print("#what do you want to do?\n#");
        String action = sc.nextLine();
        switch (action.toLowerCase()) {
            case "add":
                addObject();
                break;
            case "remove":
                if (o.isEmpty()) {
                    System.out.println("#nothing to remove");
                } else {
                    removeObject();
                }
                break;
            case "move":
                if (o.isEmpty()) {
                    System.out.println("#nothing to move");
                } else {
                    moveObject();
                }
                break;
            case "resize":
                if (o.isEmpty()) {
                    System.out.println("#nothing to resize");
                } else {
                    resizeObject();
                }
                break;
            case "list":
                if (o.isEmpty()) {
                    System.out.println("#nothing to list");
                } else {
                    System.out.println(o);
                }
                break;
            case "help":
                t.instructions();
                break;
            case "clear":
                o.clear();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("#invalid action\n#type help for instructions");
                break;

        }
    }

    public void draw(Graphics g2) {
        for (int i = 0; i < o.size(); i++) {
            g2.setColor(o.get(i).c);
            g2.fillRect(o.get(i).x, o.get(i).y, o.get(i).width, o.get(i).height);
        }
        for (int i = 0; i < o.size(); i++) {
            g2.setColor(Color.BLACK);
            g2.drawString(o.get(i).name, o.get(i).x + 1, o.get(i).y + (o.get(i).height / 2));
        }
    }
}