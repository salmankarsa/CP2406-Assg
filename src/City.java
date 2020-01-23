import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class City extends JPanel {
    final int laneHeight=300;
    final int bound1=50;
    final int bound2=650;

    ArrayList<Vehicle> v=new ArrayList<Vehicle>();
    ArrayList<trafficLight> s=new ArrayList<trafficLight>();



    public City() {
        Color brown = new Color (244,164,96); // Color Brown
        setBackground(brown);
        setForeground(brown);
        setBounds(187, 0, 855, 590);
        setLayout(null);
        setVisible(true);
    }
    public void addSignal(trafficLight trafficLight) {
        s.add(trafficLight);
    }
    public void addVehicle(Vehicle vehicle) {
        v.add(vehicle);
    }

    //To make the vehicle move
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

                    if(count==0) {
                        s.get(count).randomLightStatus(false, false, true);

                    }
                    else {
                        s.get(count-1).randomLightStatus(true, false, false);
                        s.get(count).randomLightStatus(false, false, true);
                    }
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
