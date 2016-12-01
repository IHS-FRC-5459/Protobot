
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
    private final Solenoid shift;
    private final boolean isReversed;

    public GearboxThree(Motor top, Motor front, Motor back, Solenoid shift, boolean isReversed) {
        this.top = top;
        this.front = front;
        this.back = back;
        this.shift = shift;
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
    
    public void shiftGearsHigh(){
        shift.extend();
    }
    
    public void shiftGearsLow(){
        shift.retract();
    }
     
}
