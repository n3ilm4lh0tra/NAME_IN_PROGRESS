import java.util.ArrayList;
import java.util.Scanner;
public class Objects(){
    ArrayList<Object> o = new ArrayList<>();
    public Objects(){}
    public void addObject(){
        Scanner sc = new Scanner(System.in);
        System.out.print("object name:\n#");
        String name = sc.nextLine();
        System.out.print("object width:\n#");
        int width = sc.nextInt();
    }
}