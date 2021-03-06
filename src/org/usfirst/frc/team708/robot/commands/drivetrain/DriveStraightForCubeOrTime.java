package org.usfirst.frc.team708.robot.commands.drivetrain;

import org.usfirst.frc.team708.robot.Robot;
import org.usfirst.frc.team708.robot.util.Math708;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightForCubeOrTime extends Command {

	private double moveSpeed;
	private double runTime;
	
    public DriveStraightForCubeOrTime(double moveSpeed, double runTime) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        
        this.moveSpeed = moveSpeed;
        this.runTime = runTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.haloDrive(moveSpeed, 0.0, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (this.timeSinceInitialized() >= runTime);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
