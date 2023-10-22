package classes;

import java.awt.MouseInfo;

public class Mouse {
    
    Coord position;

    public Mouse(){
        this.position = new Coord(Mouse.getX(), Mouse.getY());   
    }
    
    public Coord getCoord(){
        position.setPosition(getX(), getY());
        return position;
    }

    public static int getX(){
        return MouseInfo.getPointerInfo().getLocation().x;
    }
    public static int getY(){
        return MouseInfo.getPointerInfo().getLocation().y;
    }

}
