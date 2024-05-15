import java.awt.*;

public class Room {
    final int MAX_COL = 50;
    final int MAX_ROW = 60;
    public static final int SQUARE_SIZE = 16;
    public static final int HALF_SQUARE_SIZE = SQUARE_SIZE / 2;

    public void draw(Graphics g2) {
        for (int i = 0; i < MAX_COL; i++) {
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Times New Roman", Font.BOLD, 12));
            g2.drawString(String.valueOf(i + 1), 16 * (i + 1) + 2, 12);
            for (int j = 0; j < MAX_ROW; j++) {
                g2.drawString(String.valueOf(j + 1), 0, 16 * (j + 2));
            }
        }

        int c = 0;
        for (int row = 1; row < MAX_ROW + 1; row++) {

            for (int col = 1; col < MAX_COL + 1; col++) {
                if (c == 0) {
                    g2.setColor(Color.GRAY);
                    c = 1;
                } else {
                    g2.setColor(Color.darkGray);
                    c = 0;
                }
                g2.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
            if (c == 0) {
                c = 1;
            } else {
                c = 0;
            }
        }
    }
}