import javax.swing.*;

public class Main extends JFrame {

    Main() {
        this.setResizable(false); // zruší schopnost měnit velikost okna
        this.add(new App());
        this.setTitle("Falling Sand"); // pojmenování okna
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zavírání okna
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null); // nastaví okno doprostřed obrazovky
    }

    public static void main(String[] args) {

        new Main();
    }
}