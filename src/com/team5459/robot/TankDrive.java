/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team5459.robot;

import org.strongback.command.Command;
import org.strongback.components.ui.FlightStick;
/**
 *
 * @author filip
 */
public class TankDrive extends Command{
    private GearboxThree right;
    private GearboxThree left;
    private FlightStick rightStick;
    private FlightStick leftStick;

    public TankDrive() {
        this.right = null;
        this.left = null;
        this.leftStick = null;
        this.rightStick = null;
    }
    
    
    public TankDrive(GearboxThree right, GearboxThree left, FlightStick rightStick, FlightStick leftStick) {
        this.right = right;
        this.left = left;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
    }
    
    
    
   @Override
    public boolean execute(){
    	right.setSpeed(rightStick.getPitch().read());
        left.setSpeed(leftStick.getPitch().read());
    	return false;
    	//this drives the robot
    }
    
    @Override
    public void interrupted() {
    	right.setSpeed(0);
        left.setSpeed(0);
        //if interrupted the drive stops
    }
    
    @Override
    public void end(){
    	right.setSpeed(0);
        left.setSpeed(0);
        //if interrupted the drive stops
    }
}
    

