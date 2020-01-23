import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Simulator extends JFrame implements Runnable,ActionListener {
    private Vehicle vehicle[]=new Vehicle[69];
    private Road cc[]=new Road[5];
    int city=0;
    private City c=new City();
    private trafficLight s;
    private JPanel contentPane;
    private boolean running=false;
    boolean open =false;
    int index=0;
    int i=0;
    private JLabel label=new JLabel("");
    JButton btnRun = new JButton("Run\r\n");
    JButton btnStop = new JButton("Stop");
    private int total=0;
    int count=0;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Simulator frame = new Simulator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
