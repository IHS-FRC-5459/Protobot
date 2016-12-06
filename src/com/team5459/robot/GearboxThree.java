
package com.team5459.robot;

import org.strongback.components.Motor;
import org.strongback.components.Solenoid;
/**
 * This is for the gearbox class for a three CIM shifting gearbox
 * @author filip
 */
public class GearboxThree {
    private final Motor top;
    private final Motor front;
    private final Motor back;
    private final boolean isReversed;

    public GearboxThree() {
        this.top = null;
        this.back = null;
        this.front = null;
        this.isReversed = false;
    }

    
    public GearboxThree(Motor top, Motor front, Motor back, boolean isReversed) {
        this.top = top;
        this.front = front;
        this.back = back;
        this.isReversed = isReversed;
    }
    
    public void setSpeed(double speed){
        if (isReversed) {
            top.setSpeed(speed);
            front.setSpeed(-speed);
            back.setSpeed(-speed);
        }else{
            top.setSpeed(-speed);
            front.setSpeed(speed);
            back.setSpeed(speed);
        }
    }
    
    
}
