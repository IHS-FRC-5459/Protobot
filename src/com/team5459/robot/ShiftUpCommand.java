/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team5459.robot;

import org.strongback.command.Command;
import org.strongback.components.Solenoid;

/**
 *
 * @author filip
 */
public class ShiftUpCommand extends Command{
    private Solenoid shift;

    public ShiftUpCommand() {
        this.shift = null;
    }
    
    public ShiftUpCommand(Solenoid shift) {
        this.shift = shift;
    }
    
    @Override
    public boolean execute(){
        shift.extend();
        return true;
    }
}
