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
        this.addMouseListener(new MyMouseListener());
        start();
    }
    Timer timer;
    List<Sand> grains;

    public void start() {
        timer = new Timer(DELAY, this);
        timer.start();
        grains = new ArrayList<>();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {
        for (Sand grain : grains) {
            grain.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();

    }

    public class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {
            grains.add(new Sand((e.getX() / Constants.SIZE) * Constants.SIZE, (e.getY() / Constants.SIZE) * Constants.SIZE));
        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
}