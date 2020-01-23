import java.awt.Color;
import java.awt.Graphics;

public class Motorcycle extends Vehicle{

    // set vehicle width,height, and speed
    public Motorcycle(int x, int y) {
        super(x, y);
        width=15;
        height=10;
        speed=20;
    }

    // Give color to the motorcycle
    public void paintMe(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }


}
