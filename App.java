import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class App extends JPanel implements ActionListener, Constants {
    public App() {
        this.setPreferredSize(new Dimension(Constants.WIDTH * Constants.SIZE, Constants.HEIGHT * Constants.SIZE));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addMouseListener(new MyMouseListener(this));
        start();
    }
    Timer timer;
    static List<Sand> grains;

    public void start() {
        timer = new Timer(DELAY, this);
        timer.start();
        grains = new ArrayList<>();
    }

    public void moveAll() {
        for (Sand grain : grains) {
            grain.move();
        }
    }

    public static List<Sand> getGrains() {return grains;}


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        for (Sand grain : grains) {
            grain.draw(g, grain.getX(), grain.getY());
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        moveAll();
        repaint();

    }

}