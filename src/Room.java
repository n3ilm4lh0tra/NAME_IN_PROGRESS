import java.awt.*;
import java.util.Scanner;

public class Room {
    public int MAX_COL = 500;
    public int MAX_ROW = 500;
    private final int SQUARE_SIZE = 16;
    private final int HALF_SQUARE_SIZE = SQUARE_SIZE / 2;

    /*public void setRoomSize(int width, int height) {
        Scanner sc = new Scanner(System.in);
        System.out.print("#enter grid width\n#");
        MAX_COL = sc.nextInt();
        System.out.print("#enter grid height\n#");
        MAX_ROW = sc.nextInt();
        width = (MAX_COL * getSQUARE_SIZE()) + 100;
        height = (MAX_ROW * getSQUARE_SIZE()) + 100;
    }*/

    public int getMAX_COL() {
        return MAX_COL;
    }

    public void setMAX_COL(int MAX_COL) {
        this.MAX_COL = MAX_COL;
    }

    public int getMAX_ROW() {
        return MAX_ROW;
    }

    public void setMAX_ROW(int MAX_ROW) {
        this.MAX_ROW = MAX_ROW;
    }

    public int getSQUARE_SIZE() {
        return SQUARE_SIZE;
    }

    public void draw(Graphics g2) {
        for (int i = 0; i < MAX_COL; i++) {
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Times New Roman", Font.BOLD, 8));
            g2.drawString(String.valueOf(i + 1), 16 * (i + 1), 12);
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
                    c = 0;
                }
                g2.drawRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
            if (c == 0) {
                c = 1;
            } else {
                c = 0;
            }
        }
    }
}