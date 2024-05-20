import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Objects {
    ArrayList<Object> o = new ArrayList<>();
    Room r = new Room();
    String name;
    String colour;
    int width;
    int height;
    int x;
    int y;
    Color c;

    public Objects() {
    }

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
        } catch (InputMismatchException e) {
            System.out.println("#invalid input, returning to menu");
        }
    }

    public void removeObject() {
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.print("#object name\n#");
        n = sc.nextLine();
        n = n.toUpperCase();
        System.out.println(n);
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).name.toLowerCase().equals(n)) {
                o.remove(i);
                System.out.print("#object removed\n");
                break;
            } else {
                System.out.println("#object not found\n");
            }
        }
    }

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
                    o.get(i).x = newX*16;
                    o.get(i).y = newY*16;
                    System.out.println("#object moved moved to\n#x = " + newX + "\n#new y = " + newY);
                } catch (InputMismatchException e) {
                    System.out.println("#invalid input, object was not moved");
                }
            } else {
                System.out.println("#object not found");
            }
        }
    }
    public void resizeObject(){
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
                    System.out.print("#new x\n#");
                    newWidth = sc.nextInt();
                    System.out.print("#new y\n#");
                    newHeight = sc.nextInt();
                    checkBounds(o.get(i).x, o.get(i).y, newWidth, newHeight);
                    o.get(i).x = newWidth*16;
                    o.get(i).y = newHeight*16;
                    System.out.println("#object moved moved to\n#new width = " + newWidth + "\n#new height = " + newHeight);
                } catch (InputMismatchException e) {
                    System.out.println("#invalid input, object was not moved");
                }
            } else {
                System.out.println("#object not found");
            }
        }
    }
    public void checkBounds(int X, int Y, int WIDTH, int HEIGHT){
        if(X < 1||X+WIDTH>r.getMAX_COL()+1||Y < 1||Y+HEIGHT>r.getMAX_ROW()+1) {
            System.out.println("#out of bounds");
            throw new InputMismatchException();
        }
    }
    public void dupeChecker(String nme){
        for (int i = 0; i < o.size(); i++) {
            if(nme.equals(o.get(i).name)){
                System.out.println("#no duplicate names");
                throw new InputMismatchException();
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
}