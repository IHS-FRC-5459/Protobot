/* Created Mon Nov 28 16:30:42 EST 2016 */
package com.team5459.robot;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.junit.Test;
import org.strongback.mock.Mock;
import org.strongback.mock.MockSolenoid;
import org.fest.assertions.Delta;
import org.junit.Before;
import org.strongback.drive.TankDrive;
import org.strongback.components.ui.FlightStick;
import org.strongback.components.Motor;
import static org.fest.assertions.Assertions.assertThat;
import org.junit.Ignore;
import org.strongback.command.CommandTester;
import org.strongback.mock.MockController;


public class TestRobot {
    private Motor leftMotor;
    private Motor rightMotor;
    private TankDrive drive;
    private CommandTester tester;
    
    
    @Before
    public void beforeDrive(){
        leftMotor = Mock.stoppedTalonSRX();
        rightMotor = Mock.stoppedTalonSRX();
        drive = new TankDrive(leftMotor, rightMotor);

    }
        
    @Test
    public void shouldShiftUpWhenAlreadyShiftedUp(){
        MockSolenoid solenoid = Mock.manualSolenoid().extend();
        System.out.println("Solenoid created");
        ShiftUpCommand command = new ShiftUpCommand(solenoid);
        
        assertThat(solenoid.isExtending()).isTrue();
        assertThat(solenoid.isRetracting()).isFalse();
        System.out.println("Command created");
        assertThat(command.execute()).isTrue();
        solenoid.stop();
        assertThat(solenoid.isStopped()).isTrue(); 
        System.out.println("shouldShiftUpWhenAlreadyShiftedUp passed");
}

    @Ignore
    @Test
    public void shouldShiftUpWhenShiftedDown(){
        MockSolenoid solenoid = Mock.manualSolenoid().retract();
        System.out.println("Solenoid created");
        ShiftUpCommand command = new ShiftUpCommand(solenoid);
        System.out.println("Solenoid created");
        assertThat(command.execute()).isTrue();
        assertThat(solenoid.isExtending()).isTrue();
        assertThat(solenoid.isRetracting()).isFalse();
        solenoid.stop();
        assertThat(solenoid.isStopped()).isTrue();   
        System.out.println("shouldShiftUpWhenShiftedDown passed");
}
    @Ignore
    @Test
    public void shouldShiftDownWhenAlreadyShiftedUp(){
        MockSolenoid solenoid = Mock.manualSolenoid().extend();
        System.out.println("Solenoid created");
        ShiftDownCommand command = new ShiftDownCommand(solenoid);
        System.out.println("Command created");
        assertThat(command.execute()).isTrue();
        assertThat(solenoid.isExtending()).isTrue();
        assertThat(solenoid.isRetracting()).isFalse();
        solenoid.stop();
        assertThat(solenoid.isStopped()).isTrue();
        System.out.println("shouldShiftDownWhenAlreadyShiftedUp passed");
}

    @Ignore
    @Test
    public void shouldShiftDownWhenAlreadyShiftedDown(){
        MockSolenoid solenoid = Mock.manualSolenoid().retract();
        System.out.println("Solenoid created");
        ShiftDownCommand command = new ShiftDownCommand(solenoid);
        System.out.println("Command created");
        assertThat(solenoid.isExtending()).isTrue();
        assertThat(solenoid.isRetracting()).isFalse();
        assertThat(command.execute()).isTrue();

        solenoid.stop();
        assertThat(solenoid.isStopped()).isTrue();  
        System.out.println("shouldShiftDownWhenAlreadyShiftedDown passed");
}
    @Ignore
    @Test
    public void shouldDriveForwardAtASpeed(){
        tester = new CommandTester(new DriveCommand(drive, 0.5,0.5));
        assertThat(leftMotor.getSpeed()).isEqualTo(0.0);
        assertThat(rightMotor.getSpeed()).isEqualTo(0.0);
        System.out.println("Inital Speed passed");
        tester.step(2000);
        assertThat(leftMotor.getSpeed()).isEqualTo(0.5);
        assertThat(rightMotor.getSpeed()).isEqualTo(0.5);
        System.out.println("Final Speed passed");


    }

}
