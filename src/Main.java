import javax.swing.*;

public class Main {
    /*
    * .jar file in /out/artifacts/NAME_IN_PROGRESS_jar/
    */
    public static void main(String[] args) {
        Panel p = new Panel();
        p.setGridSize();
        JFrame window = new JFrame("NAME_IN_PROGRESS");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        window.add(p);
        window.pack();
        p.launch();

        JScrollPane sp = new JScrollPane(p);
        sp.getVerticalScrollBar().setUnitIncrement(16);
        sp.getViewport().putClientProperty("EnableWindowBlit", Boolean.TRUE);
        sp.getViewport().setScrollMode(JViewport.BACKINGSTORE_SCROLL_MODE);
        window.add(sp);

        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }
}