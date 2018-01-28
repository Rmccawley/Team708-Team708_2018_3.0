package org.usfirst.frc.team708.robot.subsystems;


import org.usfirst.frc.team708.robot.AutoConstants;
import org.usfirst.frc.team708.robot.Constants;
import org.usfirst.frc.team708.robot.subsystems.Drivetrain;
import org.usfirst.frc.team708.robot.util.Math708;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *	@author Viet Tran
 */
public class VisionProcessor extends Subsystem {
	
	public static Drivetrain 		drivetrain;
	
	private boolean isCentered;

//	Required Network Table Data 	
	private boolean hasTarget;	//Get from Network Table
	private double tv;
	private double displacementX;	//Get from Network Table

//	Accessing the Limelight's Network Table	
	NetworkTableInstance 	limeLightInstance 	= NetworkTableInstance.getDefault();
	NetworkTable			limeLightTable		= limeLightInstance.getTable("/limelight");
	
//	Sweep function variables
//	private double gyroAngle = 0.0;
    	
	private double rotate			= 0.0;
	public double getRotate			= 0.0;
	
//	Method for getting different data from a Network Table	
	public double getNTInfo(String tableInfo, Double convertInfo) {
		NetworkTableEntry limeLightInfo = limeLightTable.getEntry(tableInfo);		
		convertInfo = limeLightInfo.getDouble(0);	
		return convertInfo;
	}
	
//	Method for setting different data into a Network Table    
	public void setNTInfo(String tableInfo, Double setValue) {
		NetworkTableEntry limeLightInfo = limeLightTable.getEntry(tableInfo);		
		limeLightInfo.setNumber(setValue);
	}
	
	public VisionProcessor() {
		super("Vision Processor");
	}


//	Method for centering with the cubes
	public double displacementX() {
		NetworkTableEntry limeLightInfo = limeLightTable.getEntry("tx");		
		displacementX = limeLightInfo.getDouble(0);	
		return displacementX;
	}
	public boolean hasTarget() {
		NetworkTableEntry limeLightInfo = limeLightTable.getEntry("tv");		
		tv = limeLightInfo.getDouble(0);	
		if (tv == 1.0) {
			hasTarget = true;
		}
		else {
			hasTarget = false;
		}
		return hasTarget;
	}
	public boolean isCentered() {
	
		getNTInfo("tx", displacementX);
	
		if (Math.abs(displacementX) <= AutoConstants.X_THRESHOLD) {
			isCentered = true;
		}
		else {
			isCentered = false;
		}
		return isCentered;
	}
	public double getRotate() {	
		if (hasTarget = true) {
			
			if (isCentered = true) {
				rotate = 0.0;
			}
			else if (isCentered = false && displacementX > 0) {
				rotate = .5;
			}
			else if (isCentered = false && displacementX < 0) {
				rotate = -.5;
			}
		}
		
//		else {	//The robot does not see any targets and is now sweeping
//			drivetrain.resetGyro();
//			gyroAngle = drivetrain.getAngle();
//			if (gyroAngle == AutoConstants.SWEEP_ANGLE_START) {
//				rotate = drivetrain.rotateByGyro(AutoConstants.SWEEP_ANGLE_LEFT, AutoConstants.X_THRESHOLD);
//			}
//			else if (gyroAngle == AutoConstants.SWEEP_ANGLE_LEFT) {
//				rotate = drivetrain.rotateByGyro(AutoConstants.SWEEP_ANGLE_RIGHT, AutoConstants.X_THRESHOLD);
//			}
//			else if (gyroAngle == AutoConstants.SWEEP_ANGLE_RIGHT) {
//				rotate = drivetrain.rotateByGyro(AutoConstants.SWEEP_ANGLE_STOP, AutoConstants.X_THRESHOLD);
//			}
//		}		
		return rotate;
	}

//	Method for moving towards a target	-NOT USED IN 2018
	//Returns how to move to get to target distance (targetAmount = target ratio)
	
/**	public double getMove() {
		double move;
		
		if (hasTarget) 
		{
			double difference = targetY - currentY;			
			move = Math708.getSignClippedPercentError(currentY, targetY, 0.4, 0.6); 
			//Check if target is at correct level within threshold
			if (difference <= thresholdY) {
				move = 0.0;
				isAtY = true;
			} else {
				isAtY = false;
			}
			
		} else {
 			move = 0.0;
		}
		
		return move;
	}
	
	/**
	 * Returns if the robot sees a container
	 * @return
	 */
	public boolean hadTarget() {
		return hasTarget;
	}
	
	public boolean wasCentered() {
		return isCentered;
	}
	public double currentX () {
		return displacementX;
	}

	public void sendToDashboard() {		//Might have to rewrite public variables for the smart dashboard...
										//Future me problem		-Viet
		
//		SmartDashboard.putBoolean("string name", boolean);
		SmartDashboard.putBoolean("Is Centered", wasCentered());

//		SmartDashboard.putNumber("string name", number);
//		SmartDashboard.putNumber("Displacement X", currentX());
//		SmartDashboard.putNumber("Has Target", targetFound());


	}

    public void initDefaultCommand() {
		if (Constants.DEBUG) {
		}    	
    }
    
}

