import java.util.ArrayList;
import java.util.Scanner;
public class Objects(){
    ArrayList<Object> o = new ArrayList<>();
    int index = 0;
    public Objects(){}
    public void addObject(){
        Scanner sc = new Scanner(System.in);
        System.out.print("object name:\n#");
        String name = sc.nextLine();
        System.out.print("object width:\n#");
        int width = sc.nextInt();
        System.out.print("object height:\n#");
        int height = sc.nextInt();
        System.out.print("object x:\n#");
        int x = sc.nextInt();
        System.out.print("object y:\n#");
        int y = sc.nextInt();
        o.add(i, new Object(name, width, height, x, y));
        i++;
        System.out.println("object added");
    }
}