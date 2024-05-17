import java.awt.*;
import java.util.ArrayList;
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

    public void addObject() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("#object name:\n#");
            name = sc.nextLine();
            System.out.print("#object colour:\n#");
            colour = sc.nextLine();
            colour.toLowerCase();
            checkColour();
            System.out.println("colour set to "+colour);
            System.out.print("#object width:\n#");
            width = sc.nextInt();
            System.out.print("#object height:\n#");
            height = sc.nextInt();
            System.out.print("#object x:\n#");
            x = sc.nextInt();
            System.out.print("#object y:\n#");
            y = sc.nextInt();
            o.add(index, new Object(name, c, width*16, height*16, x*16, y*16));
            index++;
            System.out.println("#object added");
        }catch (Exception e) {
            System.out.println("incorrect input");
        }
    }
    public void checkColour(){
        switch(colour){
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
                c = Color.blue;
                break;
            case "pink":
                c = Color.pink;
                break;
            default:
                System.out.println("not in selection or invalid colour");
                colour = null;
                break;
        }
    }
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(x*16, y*16, width*16, height*16);
    }
}