package org.usfirst.frc.team708.robot.commands.pneumatics;

//import java.awt.Robot;

import org.usfirst.frc.team708.robot.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team708.robot.commands.pneumatics.*;
import org.usfirst.frc.team708.robot.subsystems.PneumaticsCube;
import org.usfirst.frc.team708.robot.Robot;

public class PneumaticsClose extends Command {


    public PneumaticsClose() {
    	
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.pneumaticsCube.toggleIntake();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return(true);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems are scheduled to run
    protected void interrupted() {
    	end();
    }
}
