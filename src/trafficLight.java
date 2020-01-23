import java.awt.Color;
import java.awt.Graphics;

public class trafficLight {
    private int x=0;
    private int y=0;
    private boolean red=false;
    private boolean yellow=false;
    private boolean turn=false;
    boolean green=false;

    public trafficLight(boolean red, boolean yellow, boolean green, int x, int y, boolean turn) {
        this.red=red;
        this.yellow=yellow;
        this.green=green;
        this.x=x;this.y=y;
        this.turn=turn;
    }
    public void randomLightStatus(boolean r, boolean y, boolean g) {
        this.red=r;
        this.yellow=y;
        this.green=g;
    }
    public void paintMe(Graphics g) {
        if(turn==false) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, 10, 40);
//			g.fillRect(372, 60, 10, 60);

            if(this.red==true) {
                g.setColor(Color.RED);
                g.fillOval(x+1, y+10, 8, 8);

            }
            else if(this.yellow==true) {
                g.setColor(Color.YELLOW);
                g.fillOval(x+1, y+10, 8, 8);
            }
            else {
                g.setColor(Color.GREEN);
                g.fillOval(x+1, y+10, 8, 8);}
        }
        else {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, 40, 10);
//				g.fillRect(372, 60, 10, 60);
            if(this.red==true) {
                g.setColor(Color.RED);
                g.fillOval(x+10, y+1, 8, 8);
            }
            else if(this.yellow==true) {
                g.setColor(Color.YELLOW);
                g.fillOval(x+10, y+1, 8, 8);
            }
            else {
                g.setColor(Color.GREEN);
                g.fillOval(this.x+10, this.y+1, 8, 8);}

        }
    }

//
}
