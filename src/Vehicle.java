import java.awt.Graphics;

public class Vehicle {
    // set x,y,speed,width,height and position values
    int x;
    int y;
    int speed;
    int width;
    int height;
    int position=0;

    // Set Road and Signals
    String road;
    String signal="";

    // Set Turn
    boolean current=false;
    boolean turn1=false;
    boolean turn2=false;
    boolean turn3=false;
    int in=0;
    int in1=0;
    int in3;
    boolean check=false;

    // set the previous vehicle location
    String previous;

    // set vehicle function class
    public Vehicle(int x,int y) {

        this.x=x;
        this.y=y;
        this.in3=0;
        if(x>=0 & x<=305 & y==104 || y==135 & x>=0 & x<=310) {
            this.road="r1";
            this.signal="s1";


        }
        else if(y>=0 & y<=55 & x==354 || x==385 & y>=0 & y<=60) {
            this.road="r2";
            this.signal="s2";



        }
        else if(y<=370 & y>=165 & x==385 ||x==354 & y<=365 & y>=150) {
            this.road="r3";
            this.signal="s3";


        }
        else if(x>=395 & x<=820 & y==135 || x>=395 & x<=820 & y==104) {
            this.road="r4";
            this.signal="s4";


        }
        else if(y<=580 & y>=445 & x==185 || x==155 & y<=580 & y>=445) {
            this.road="r5";
            this.signal="s5";

        }
        else if(y<=580 & y>=445 & x==385 || y<=580 & y>=445 & x==355 ) {
            this.road="r6";
            this.signal="s6";


        }
        else if(y<=580 & y>=445 & x==685 || y<=580 & y>=445 & x==655) {
            this.road="r7";
            this.signal="s7";


        }
        else if(x>=0 & x<=820 & y==404 || x>=0 & x<=820 & y==432 ) {
            this.road="main";
            this.signal="main";


        }

    }}
