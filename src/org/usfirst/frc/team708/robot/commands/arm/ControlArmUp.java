package org.usfirst.frc.team708.robot.commands.arm;

import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.OI;
import org.usfirst.frc.team708.robot.Robot;
import org.usfirst.frc.team708.robot.RobotMap;
//import org.team708.robot.subsystems.*;
//import org.usfirst.frc.team708.robot.subsystems.Loader;


import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;



/**
 *@author James Alex Thomas Mikhael
 */
public class ControlArmUp extends Command {

	private boolean hasBall;

    public ControlArmUp() {
    	requires(Robot.arm);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.moveMotor(Constants.ARM_FORWARD);
    	
//    	if (Robot.loader.HasBall() == true){
//        	Robot.loader.stop();
//        	cancel();
//    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

//    	if (Robot.loader.HasBall() == true){
//    		Robot.intake.stop();
//        	Robot.loader.stop();
//    		cancel();
//    	} else {
//    	Robot.loader.manualMove(0.5);
 //   	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;		//Replace with intake "has" boolean later	-Viet
    }

    // Called once after isFinished returns true
    protected void end() {
     Robot.arm.stop();

    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}