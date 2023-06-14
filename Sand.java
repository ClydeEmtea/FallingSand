import java.awt.*;

public class Sand implements Constants {
    private final int x;
    private final int y;
    public Sand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(this.x, this.y, Constants.SIZE, Constants.SIZE);
    }
}
