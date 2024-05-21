import java.awt.*;

public class Object {
    String name;
    String colour;
    Color c;
    int width;
    int height;
    int x;
    int y;

    public Object(String name, String colour, Color c, int width, int height, int x, int y) {
        this.name = name;
        this.colour = colour;
        this.c = c;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "#" + name +
                "\n  #colour " + colour +
                "\n  #x" + x +
                "\n  #y" + y +
                "\n  #width" + width +
                "\n  #height" + height + "\n\n";
    }
}