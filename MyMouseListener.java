import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseListener, MouseMotionListener {

    private final App app;

    public MyMouseListener(App app) {
        this.app = app;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        App.getGrains().add(new Sand((e.getX() / Constants.SIZE) * Constants.SIZE, (e.getY() / Constants.SIZE) * Constants.SIZE));
        app.addMouseMotionListener(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        app.removeMouseMotionListener(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        App.getGrains().add(new Sand((e.getX() / Constants.SIZE) * Constants.SIZE, (e.getY() / Constants.SIZE) * Constants.SIZE));
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
