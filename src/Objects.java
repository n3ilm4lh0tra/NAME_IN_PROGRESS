import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Objects {
    ArrayList<Object> o = new ArrayList<>();
    int index = 0;
    String name;
    String colour;
    int width;
    int height;
    int x;
    int y;
    Color c;

    public Objects() {
    }

    public void setNameAndColour() {
        Scanner sc = new Scanner(System.in);

    }

    public void addObject() {
        Scanner sc = new Scanner(System.in);
        System.out.print("#object name\n#");
        try {
            name = sc.nextLine();
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
            o.add(index, new Object(name, colour, c, width * 16, height * 16, x * 16, y * 16));
            System.out.println(o.get(index));
            index++;
            System.out.println("#object added");
        } catch (InputMismatchException e) {
            System.out.println("#invalid input, add again");
        }
    }

    public void removeObject() {
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.print("#object name\n#");
        n = sc.nextLine();
        n = n.toLowerCase();
        System.out.println(n);
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).name.toLowerCase().equals(n)) {
                o.remove(i);
                System.out.print("#object removed");
            } else {
                System.out.println("#object not found");
            }
        }
    }

    public void moveObject() {
        Scanner sc = new Scanner(System.in);
        String n;
        System.out.print("#object name\n#");
        n = sc.nextLine();
        n = n.toLowerCase();
        System.out.println(n);
        for (int i = 0; i < o.size(); i++) {
            if (o.get(i).name.toLowerCase().equals(n)) {
                System.out.println("#" + o.get(i).name + " found");
                int newX;
                int newY;
                try {
                    System.out.print("#new x\n#");
                    newX = sc.nextInt();
                    System.out.print("#new y\n#");
                    newY = sc.nextInt();
                    o.get(i).x = newX;
                    o.get(i).y = newY;
                    System.out.print("#object moved moved to\n#x = " + o.get(i).x + "\n#new y = " + o.get(i).y);
                } catch (InputMismatchException e) {
                    System.out.print("#invalid input, object was not moved");
                }
            } else {
                System.out.println("#object not found");
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