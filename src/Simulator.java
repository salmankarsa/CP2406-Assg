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
    public Simulator() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1058, 629);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(c);


        addSignal(-10,0);
        btnStop.setFont(new Font("Serif", Font.BOLD, 15));
        btnStop.setBounds(40, 217, 89, 23);
        btnStop.addActionListener(this);
        contentPane.add(btnStop);


        btnRun.setFont(new Font("Serif", Font.BOLD, 15));
        btnRun.setBounds(40, 154, 89, 23);
        btnRun.addActionListener(this);

        contentPane.add(btnRun);


        JButton btnOpen = new JButton("Open\r\n");

        btnOpen.setFont(new Font("Serif", Font.BOLD, 15));
        btnOpen.setBounds(40, 271, 89, 23);
        btnOpen.setVisible(false);
        contentPane.add(btnOpen);

        JButton btnEdit = new JButton("Edit");

        btnEdit.setFont(new Font("Serif", Font.BOLD, 15));
        btnEdit.setBounds(40, 217, 89, 23);
        btnEdit.setVisible(false);
        contentPane.add(btnEdit);

        JButton btnNewButton_2 = new JButton("Create");

        btnNewButton_2.setFont(new Font("Serif", Font.BOLD, 15));
        btnNewButton_2.setBounds(40, 154, 89, 23);
        contentPane.add(btnNewButton_2);

        JLabel lblMenu = new JLabel("Menu");
        lblMenu.setBounds(56, 11, 99, 35);
        lblMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        lblMenu.setForeground(Color.WHITE);
        contentPane.add(lblMenu);

        JButton btnNewButton = new JButton("City\r\n");

        btnNewButton.setBounds(10, 81, 84, 23);
        btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Sim");

        btnNewButton_1.setBounds(104, 81, 75, 23);
        btnNewButton_1.setFont(new Font("Cambria", Font.BOLD, 20));
        contentPane.add(btnNewButton_1);

        JLabel lblMode = new JLabel("Mode:Sim");
        lblMode.setForeground(Color.WHITE);
        lblMode.setFont(new Font("Cambria", Font.BOLD, 20));
        lblMode.setBounds(10, 388, 119, 23);
        contentPane.add(lblMode);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setForeground(Color.WHITE);
        lblStatus.setFont(new Font("Cambria", Font.BOLD, 20));
        lblStatus.setBounds(10, 432, 119, 23);
        contentPane.add(lblStatus);

        JLabel lblCityDefault = new JLabel("City: Default");
        lblCityDefault.setForeground(Color.WHITE);
        lblCityDefault.setFont(new Font("Cambria", Font.BOLD, 16));
        lblCityDefault.setBounds(31, 466, 108, 23);
        contentPane.add(lblCityDefault);

        JLabel lblVehicles = new JLabel("Vehicles:");
        lblVehicles.setForeground(Color.WHITE);
        lblVehicles.setFont(new Font("Cambria", Font.BOLD, 16));
        lblVehicles.setBounds(31, 500, 99, 23);
        contentPane.add(lblVehicles);

        label.setText(String.valueOf(total));
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Cambria", Font.BOLD, 16));
        label.setBounds(104, 500, 67, 23);
        contentPane.add(label);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                btnRun.setVisible(true);
                btnStop.setVisible(true);

                btnOpen.setVisible(false);
                btnEdit.setVisible(false);
                btnNewButton_2.setVisible(false);
                lblMode.setText("Mode: Sim");
                lblCityDefault.setVisible(true);
                lblVehicles.setVisible(true);
                label.setVisible(true);
                c.setVisible(true);

            }
        });
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                btnRun.setVisible(false);
                btnStop.setVisible(false);

                btnOpen.setVisible(true);
                btnEdit.setVisible(true);
                btnNewButton_2.setVisible(true);
                lblStatus.setVisible(false);
                lblMode.setText("Mode: City");
                lblCityDefault.setVisible(false);
                lblVehicles.setVisible(false);
                label.setVisible(false);
            }
        });
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(city<5) {
                    c.setVisible(true);
                    btnOpen.setVisible(false);
                    btnEdit.setVisible(false);
                    btnNewButton_2.setVisible(false);
                    JOptionPane j=new JOptionPane();
                    String name=j.showInputDialog("Enter city name");
                    int roads=Integer.parseInt(j.showInputDialog("Enter no of Roads "));

                    btnRun.setVisible(false);
                    btnStop.setVisible(false);

                    btnOpen.setVisible(true);
                    btnEdit.setVisible(true);
                    btnNewButton_2.setVisible(true);
                    lblStatus.setVisible(false);
                    lblMode.setText("Mode: City");
                    lblCityDefault.setVisible(false);
                    lblVehicles.setVisible(false);
                    label.setVisible(false);
                    Road create=new Road(name,roads);
                    cc[city]=create;
                    j.showMessageDialog(contentPane, "You have succesfully created "+name+".");
                    c.setVisible(false);
                    contentPane.add(cc[city]);
                    for(int i=0;i<city;i++) {
                        cc[i].setVisible(false);
                    }
                    addSignal(cc[city].roads,city);
                    cc[city].setVisible(true);
                    city++;

                }
                else {
                    JOptionPane.showMessageDialog(contentPane, "You can't create cities more then 5");
                }


            }
        });btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOpen.setVisible(false);
                btnEdit.setVisible(false);
                btnRun.setVisible(false);
                btnStop.setVisible(false);
                btnNewButton_2.setVisible(false);
                JOptionPane j=new JOptionPane();
                if(city!=0) {
                    String name=j.showInputDialog("Enter city name");
                    int i=0;
                    while(i!=city) {
                        if(cc[i].name.equalsIgnoreCase(name)) {
                            int roads=Integer.parseInt(j.showInputDialog("Enter number of roads "));
                            cc[i].roads=roads;
                            JOptionPane.showMessageDialog(contentPane, cc[i].name+" Succesfully edited!");
                            for(int m=0;m<city;m++) {
                                cc[m].setVisible(false);
                            }
                            cc[i].s.clear();
                            addSignal(roads,i);
                            cc[i].setVisible(true);
                        }
                        i++;
                    }

                }
                else {
                    JOptionPane.showMessageDialog(contentPane, "No Cities Found!");

                }
                btnOpen.setVisible(true);
                btnEdit.setVisible(true);
                btnNewButton_2.setVisible(true);
            }

        });
        btnOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(city>0) {
                    String name=JOptionPane.showInputDialog("Enter city name");
                    for(int i=0;i<city;i++) {

                        if(cc[i].name.equalsIgnoreCase(name)) {

                            open=true;
                            index=cc[i].roads;
                            i=i;
                            cc[i].setVisible(true);
                            btnRun.setVisible(true);
                            btnStop.setVisible(true);

                            btnOpen.setVisible(false);
                            btnEdit.setVisible(false);
                            btnNewButton_2.setVisible(false);
                            lblMode.setText("Mode: Sim");
                            lblCityDefault.setText("City:"+cc[i].name);
                            lblCityDefault.setVisible(true);
                            lblVehicles.setVisible(true);
                            label.setVisible(true);
                            total=0;

                        }
                    }

                }
                else {
                    JOptionPane.showMessageDialog(contentPane, "No Cities Found!");
                }
            }
        });

    }public void check() {
        for(int j=0;j<total;j++) {

            if(vehicle[j].check==true) {
                for(int k=j;k<total;k++) {
                    vehicle[k]=vehicle[k+1];
                }
                total--;

            }

        }
    }
    public void addSignal(int index,int i) {
        if(index>0 & index<=2) {
        }
        else if(index>2 & index<=4) {
            cc[i].addSignal(new trafficLight(true,false,false,310, 117,true));
            cc[i].addSignal(new trafficLight(true,false,false,372, 60,false));
            cc[i].addSignal(new trafficLight(true,false,false,372, 150,false));
            cc[i].addSignal(new trafficLight(true,false,false,395, 117,true));
        }
        else if(index>4 & index<=6) {
            cc[i].addSignal(new trafficLight(true,false,false,310, 117,true));
            cc[i].addSignal(new trafficLight(true,false,false,372, 60,false));
            cc[i].addSignal(new trafficLight(true,false,false,372, 150,false));
            cc[i].addSignal(new trafficLight(true,false,false,395, 117,true));
            cc[i].addSignal(new trafficLight(true,false,false,372, 445,false));
        }
        else if(index>6 &  index<=8) {
            s=new trafficLight(true,false,false,310, 117,true);
            cc[i].addSignal(s);
            s=new trafficLight(true,false,false,372, 60,false);
            cc[i].addSignal(s);

            s=new trafficLight(true,false,false,372, 150,false);
            cc[i].addSignal(s);
            s=new trafficLight(true,false,false,395, 117,true);
            cc[i].addSignal(s);

            s=new trafficLight(true,false,false,170, 445,false);
            cc[i].addSignal(s);
            s=new trafficLight(true,false,false,372, 445,false);
            cc[i].addSignal(s);
            s=new trafficLight(true,false,false,672, 445,false);
            cc[i].addSignal(s);
        }
        else {
            c.addSignal(new trafficLight(true,false,false,310, 117,true));
            c.addSignal(new trafficLight(true,false,false,372, 60,false));

            c.addSignal(new trafficLight(true,false,false,372, 150,false));
            c.addSignal(new trafficLight(true,false,false,395, 117,true));

            c.addSignal(new trafficLight(true,false,false,170, 445,false));
            c.addSignal(new trafficLight(true,false,false,372, 445,false));
            c.addSignal(new trafficLight(true,false,false,672, 445,false));}
    }
    public void addVehicle(int index,int i) {
        if(index>0 & index<=2) {
            vehicle[total]=new Bus(804, 135);
            vehicle[total].turn3();
            cc[i].addVehicle(vehicle[total]);
            total++;
        }
        else if(index>2 & index<=4) {
            int a=(int) (Math.random() * 3);
            if(a==0) {
                vehicle[total]=new Bus(804, 135);
                vehicle[total].turn3();
                cc[i].addVehicle(vehicle[total]);
                total++;}

            else if(a==1) {
                vehicle[total]=new Car(354, 0);
                vehicle[total].turn1();
                cc[i].addVehicle(vehicle[total]);
                total++;}
        }
        else if(index>4 & index<=6) {
            int a=(int) (Math.random() * 5);
            if(a==0) {
                vehicle[total]=new Bus(804, 135);
                vehicle[total].turn3();
                cc[i].addVehicle(vehicle[total]);
                total++;}

            else if(a==1) {
                vehicle[total]=new Car(354, 0);
                vehicle[total].turn1();
                cc[i].addVehicle(vehicle[total]);
                total++;}

            else if(a==2) {
                vehicle[total]=new Motorcycle(385, 580);
                vehicle[total].turn2();
                cc[i].addVehicle(vehicle[total]);
                total++;}
            else if(a==3) {

                vehicle[total]=new Car(0, 404);

                cc[i].addVehicle(vehicle[total]);
                total++;}
        }
        else if(index>6 &  index<=8) {
            int a=(int) (Math.random() * 5);
            if(a==0) {
                vehicle[total]=new Bus(804, 135);
                vehicle[total].turn3();
                cc[i].addVehicle(vehicle[total]);
                total++;}

            else if(a==1) {
                vehicle[total]=new Car(354, 0);
                vehicle[total].turn1();
                cc[i].addVehicle(vehicle[total]);
                total++;}

            else if(a==2) {
                vehicle[total]=new Motorcycle(385, 580);
                vehicle[total].turn2();
                cc[i].addVehicle(vehicle[total]);
                total++;}
            else if(a==3) {

                vehicle[total]=new Car(0, 404);

                cc[i].addVehicle(vehicle[total]);
                total++;}
            else if(a==4) {
                vehicle[total]=new Motorcycle(185, 580);
                vehicle[total].turn2();
                c.addVehicle(vehicle[total]);
                total++;}
            else if(a==5) {

                vehicle[total]=new Motorcycle(685, 580);
                vehicle[total].turn2();
                c.addVehicle(vehicle[total]);
                total++;}
        }


        else {
            int a=(int) (Math.random() * 5);
            if(a==0) {

                vehicle[total]=new Motorcycle(185, 580);
                vehicle[total].turn2();
                c.addVehicle(vehicle[total]);
                total++;}

            else if(a==1) {
                vehicle[total]=new Car(385, 580);
                vehicle[total].turn2();
                c.addVehicle(vehicle[total]);
                total++;}

            else if(a==2) {
                vehicle[total]=new Motorcycle(685, 580);
                vehicle[total].turn2();
                c.addVehicle(vehicle[total]);
                total++;}
            else if(a==3) {

                vehicle[total]=new Car(354, 0);
                vehicle[total].turn1();
                c.addVehicle(vehicle[total]);
                total++;}

            else if(a==4) {

                vehicle[total]=new Bus(810, 135);
                vehicle[total].turn3=true;
                c.addVehicle(vehicle[total]);

                total++;}

            else {

                vehicle[total]=new Bus(0, 404);
                c.addVehicle(vehicle[total]);
                total++;	}

        }
    }public void run() {
        while(running==true & open==false) {
            c.step();
            c.repaint();
            check();
            label.setText(String.valueOf(total));
            if(count==10 & total!=29) {
                addVehicle(-10,0);
                count=0;

            }

            count++;


            try {
                Thread.sleep(500);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        while(running==true & open==true) {

            cc[i].step();
            cc[i].repaint();
            check();
            label.setText(String.valueOf(total));
            if(count==10 & total!=29) {
                addVehicle(index,i);
                count=0;

            }

            count++;


            try {
                Thread.sleep(500);
            }
            catch(Exception e) {
                e.printStackTrace();
            }}
    }

