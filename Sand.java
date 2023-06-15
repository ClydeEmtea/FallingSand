import java.awt.*;

public class Sand implements Constants {
    private int x;
    private int y;
    private Color color;

    public Sand(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = colors[random.nextInt(colors.length)];
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, Constants.SIZE, Constants.SIZE);
    }

    public void move() {
        boolean grainBelow = false;
        boolean belowRightFree = true;
        boolean belowLeftFree = true;

        // Check if there is a grain below
        for (Sand grain : App.getGrains()) {
            if (grain.getX() == this.x && grain.getY() == this.y + Constants.SIZE) {
                grainBelow = true;
                break;
            }
        }

        // Check if below right position is free
        for (Sand grain : App.getGrains()) {
            if (grain.getX() == this.x + Constants.SIZE && grain.getY() == this.y + Constants.SIZE) {
                belowRightFree = false;
                break;
            }
        }

        // Check if below left position is free
        for (Sand grain : App.getGrains()) {
            if (grain.getX() == this.x - Constants.SIZE && grain.getY() == this.y + Constants.SIZE) {
                belowLeftFree = false;
                break;
            }
        }

        // Move to the right if grain below and below right position is free
        if (grainBelow && belowRightFree && belowLeftFree) {
            int randomChoice = random.nextInt(2);  // Randomly choose 0 or 1
            if (randomChoice == 0 && this.y != Constants.HEIGHT * Constants.SIZE - Constants.SIZE && this.x != Constants.WIDTH * Constants.SIZE - Constants.SIZE) {
                this.y += Constants.SIZE;
                this.x += Constants.SIZE;
            } else if (randomChoice == 1 && this.y != Constants.HEIGHT * Constants.SIZE - Constants.SIZE && this.x != 0) {
                this.y += Constants.SIZE;
                this.x -= Constants.SIZE;
            }
        } else if (grainBelow && belowRightFree) {
            if (this.y != Constants.HEIGHT * Constants.SIZE - Constants.SIZE && this.x != Constants.WIDTH * Constants.SIZE - Constants.SIZE) {
                this.y += Constants.SIZE;
                this.x += Constants.SIZE;
            }
        } else if (grainBelow && belowLeftFree) {
            if (this.y != Constants.HEIGHT * Constants.SIZE - Constants.SIZE && this.x != 0) {
                this.y += Constants.SIZE;
                this.x -= Constants.SIZE;
            }
        } else if (!grainBelow) {  // Only move down if there is no grain below
            if (this.y != Constants.HEIGHT * Constants.SIZE - Constants.SIZE) {
                this.y += Constants.SIZE;
            }
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
