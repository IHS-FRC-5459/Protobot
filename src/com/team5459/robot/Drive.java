/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team5459.robot;

import org.strongback.command.Command;
import org.strongback.drive.TankDrive;
import org.strongback.components.ui.FlightStick;
/**
 *
 * @author filip
 */
public class Drive extends Command{
    private final TankDrive drive;
    private final double rightStick;
    private final double leftStick;

    public Drive() {
        this.drive = null;
        this.leftStick = 0;
        this.rightStick = 0;
    }
    
    
    public Drive(TankDrive drive, double rightStick, double leftStick) {
        this.drive = drive;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
    }
    
    
    
   @Override
    public boolean execute(){
    	drive.tank(leftStick, rightStick);
    	return false;
    	//this drives the robot
    }
    
    @Override
    public void interrupted() {
    	drive.tank(0, 0);
        //if interrupted the drive stops
    }
    
    @Override
    public void end(){
    	drive.tank(0, 0);
        //if interrupted the drive stops
    }
}
    

