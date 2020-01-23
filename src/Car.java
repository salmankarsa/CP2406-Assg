import java.awt.Color;
import java.awt.Graphics;

public class Car extends Vehicle{

    // set vehicle width,height, and speed
    public Car(int x, int y) {
        super(x, y);
        width=30;
        height=10;
        speed=15;
    }

    //Give color to the car
    public void paintMe(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
    public void setRate(int r) {
        this.speed=r;
    }


}
