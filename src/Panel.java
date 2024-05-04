import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public int WIDTH = 1100;
    public int HEIGHT = 800;

    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }
}
