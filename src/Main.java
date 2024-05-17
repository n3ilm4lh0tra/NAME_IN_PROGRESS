import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame("NAME_IN_PROGRESS");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        Panel p = new Panel();
        window.add(p);
        window.pack();

        JScrollPane sp = new JScrollPane(p);
        window.add(sp);

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //p.launch();
        Objects o = new Objects();
        o.addObject();

    }
}