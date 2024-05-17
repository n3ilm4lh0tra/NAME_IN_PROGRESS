public class Object {
    String name;
    String colour;
    int width;
    int height;
    int x;
    int y;

    public Object(String name, int width, int height, int x, int y) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Object{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                "}\n";
    }
}