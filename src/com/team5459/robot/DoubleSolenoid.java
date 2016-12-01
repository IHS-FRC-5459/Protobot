/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team5459.robot;
import org.strongback.components.Solenoid;
/**
 * This may be irrelevant 
 * @author filip
 */
public class DoubleSolenoid {
    private final Solenoid forward;
    private final Solenoid backward;
    private boolean isForwardExtended;
    public DoubleSolenoid(Solenoid forward, Solenoid backward) {
        this.forward = forward;
        this.backward = backward;
    }
    
    public void extendForward(){
        if (!isForwardExtended) {
            backward.retract();
            if(backward.isStopped()){
                forward.extend();
            }
        }
    }
    
    public void retractForward(){
        if (isForwardExtended) { 
            forward.retract();
            if(forward.isStopped()){
                backward.extend();
            }
        }
    }
    
    public void init(){
        backward.retract();
        if(backward.isStopped()){
            forward.extend();
        }
    }

    public boolean isForwardExtended() {
        return isForwardExtended;
    }
    
    
    
    public boolean isMoving(){
        if (forward.isExtending() || forward.isRetracting() || backward.isExtending() || backward.isRetracting()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isStopped() {
        if(forward.isStopped() || backward.isStopped()){
            return true;
        }else{
            return false;
        }
        
    }
}
