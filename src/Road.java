import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

public class Road extends JPanel {
    Color brown = new Color (244,164,96); // Color Brown
    int roads=0;
    String name="";
    int laneHeight=300;
    ArrayList<Vehicle> v=new ArrayList<Vehicle>();
    ArrayList<trafficLight> s=new ArrayList<trafficLight>();
    public Road(String n, int roads) {
        setBackground(brown);
        setForeground(brown);
        setBounds(187, 0, 855, 590);
        setLayout(null);
        setVisible(true);
        this.name=n;
        this.roads=roads;
    }
    public void addVehicle(Vehicle vehicle) {
        v.add(vehicle);
    }
    public void addSignal(trafficLight trafficLight) {
        s.add(trafficLight);

    }

    // Give the color for the road in new city
    public void paint(Graphics g) {

        super.paintComponent(g);

        // Roads is set to two
        if(roads<=2) {

            g.setColor(Color.GRAY);
            g.fillRect(0, 100, 870, 50);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    g.fillRect(b, 120, 30, 5);
                }
            }
        }

        // Roads is set to four
        else if(roads<=4) {

            g.setColor(Color.GRAY);
            g.fillRect(0, 100, 870, 50);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    g.fillRect(b, 120, 30, 5);
                }
            }
            g.setColor(Color.GRAY);
            g.fillRect(350, 0, 50, 600);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getHeight();b+=40) {
                    g.fillRect(375, b, 5, 30);
                }
            }}

        // Roads is set to 6
        else if(roads<=6) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 100, 870, 50);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    g.fillRect(b, 120, 30, 5);
                }
            }
            g.setColor(Color.GRAY);
            g.fillRect(350, 0, 50, 600);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getHeight();b+=40) {
                    g.fillRect(375, b, 5, 30);
                }
            }
            g.setColor(Color.GRAY);
            g.fillRect(0, 400, 870, 50);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    g.fillRect(b, 420, 30, 5);
                }
            }
        }

        //Roads is set to ten
        else if(roads<=10) {
            g.setColor(Color.GRAY);
            g.fillRect(0, 100, 870, 50);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    g.fillRect(b, 120, 30, 5);
                }
            }
            g.setColor(Color.GRAY);
            g.fillRect(350, 0, 50, 600);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getHeight();b+=40) {
                    g.fillRect(375, b, 5, 30);
                }
            }
            g.setColor(Color.GRAY);
            g.fillRect(0, 400, 870, 50);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    g.fillRect(b, 420, 30, 5);
                }
            }
            g.setColor(Color.GRAY);
            g.fillRect(150, 400, 50, 600);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=430;b<getHeight();b+=40) {
                    g.fillRect(173, b, 5, 30);
                }
            }


            g.setColor(Color.GRAY);
            g.fillRect(650, 400, 50, 600);

            g.setColor(Color.WHITE);
            for(int a=laneHeight;a<laneHeight*4;a=a+laneHeight) {
                for(int b=430;b<getHeight();b+=40) {
                    g.fillRect(673, b, 5, 30);
                }
            }}

        for(int a=0;a<s.size();a++) {
            s.get(a).paintMe(g);
        }

        for(int a=0;a<v.size();a++) {
            v.get(a).paintMe(g);
        }
    }
    public void step() {
        for(int i=0;i<v.size();i++) {
            Vehicle vehicle=v.get(i);


            if(vehicle.turn1==true & !vehicle.road.equals("in") ) {
                vehicle.setY(vehicle.getY()+vehicle.getSpeed() );
                vehicle.setPosition(vehicle.getY()+vehicle.getSpeed());
                vehicle.setRoad(vehicle.getX(), vehicle.getY());



            }
            else if(vehicle.turn2==true & !vehicle.road.equals("in")){
                vehicle.setY(vehicle.getY()-vehicle.getSpeed());
                vehicle.setPosition(vehicle.getY()-vehicle.getSpeed());
                vehicle.setRoad(vehicle.getX(), vehicle.getY());


            }
            else if(vehicle.turn3==true & !vehicle.road.equals("in")){
                vehicle.setX(vehicle.getX()-vehicle.getSpeed());
                vehicle.setPosition(vehicle.getX()-vehicle.getSpeed());
                vehicle.setRoad(vehicle.getX(), vehicle.getY());


            }
            else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false & !vehicle.road.equals("in")) {
                vehicle.setX(vehicle.getX()+vehicle.getSpeed());
                vehicle.setPosition(vehicle.getX()+vehicle.getSpeed());
                vehicle.setRoad(vehicle.getX(), vehicle.getY());


            }
            else {
                if(vehicle.current==true) {

                    int count=0;
                    if(vehicle.signal.equals("s1")) {count=0;}
                    else if(vehicle.signal.equals("s2")) {count=1;}
                    else if(vehicle.signal.equals("s3")) {count=2;}
                    else if(vehicle.signal.equals("s4")) {count=3;}
                    else if(vehicle.signal.equals("s5")) {count=4;}
                    else if(vehicle.signal.equals("s6")) {count=5;}
                    else if(vehicle.signal.equals("s7")) {count=6;}
                    else if(vehicle.signal.equals("s8")) {count=7;}
                    if(s.size()!=0) {
                        if(count==0) {
                            s.get(count).randomLightStatus(false, false, true);

                        }
                        else {
                            if(s.size()==5 & count==5) {s.get(count-2).randomLightStatus(true, false, false);
                                s.get(count-1).randomLightStatus(false, false, true);}
                            else {
                                s.get(count-1).randomLightStatus(true, false, false);
                                s.get(count).randomLightStatus(false, false, true);
                            }

                        }}
                    if(vehicle.turn1==true) {
                        vehicle.setY(vehicle.getY()+vehicle.getSpeed() );
                        vehicle.setRoad(vehicle.getX(), vehicle.getY());
                    }
                    else if(vehicle.turn2==true){
                        vehicle.setY(vehicle.getY()-vehicle.getSpeed());

                        vehicle.setRoad(vehicle.getX(), vehicle.getY());


                    }
                    else if(vehicle.turn3==true ){
                        vehicle.setX(vehicle.getX()-vehicle.getSpeed());
                        vehicle.setRoad(vehicle.getX(), vehicle.getY());


                    }
                    else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false ) {
                        vehicle.setX(vehicle.getX()+vehicle.getSpeed());
                        vehicle.setRoad(vehicle.getX(), vehicle.getY());


                    }
                }
                else {
                    vehicle.setRoad(vehicle.getX(), vehicle.getY());
                }

            }
        }
    }
    public void randomLightStatus(int i,boolean r,boolean y,boolean g) {
        s.get(i).randomLightStatus(r, y, g);
    }
}
