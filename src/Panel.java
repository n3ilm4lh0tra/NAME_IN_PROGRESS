import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public int HEIGHT = 1100;
    public int WIDTH = 800;

    public Panel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }
}
