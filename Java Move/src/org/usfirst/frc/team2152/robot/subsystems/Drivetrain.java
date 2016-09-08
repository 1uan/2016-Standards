package org.usfirst.frc.team2152.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2152.robot.RobotMap;
import org.usfirst.frc.team2152.robot.commands.DriveTrainJoystick;

/**
 *
 */
public class Drivetrain extends Subsystem {
	public  static final double    DEFAULT_SPEED    = 0.5;
	
	//=== Speed Controllers
	private CANTalon frontRight;
	private CANTalon frontLeft;
	private CANTalon rearLeft;
	private CANTalon rearRight;
	
	//=== Drive Train
	private RobotDrive drive;

	// Initialize your subsystem here
	public Drivetrain() {

		//=== Create ESC objects for each of the motors
		frontRight = new CANTalon(RobotMap.motorFrontRightId);
		frontRight.setSafetyEnabled(false);
		frontLeft  = new CANTalon(RobotMap.motorFrontLeftId);
		frontLeft.setSafetyEnabled(false);
		rearLeft   = new CANTalon(RobotMap.motorRearLeftId);
		rearLeft.setSafetyEnabled(false);
		rearRight  = new CANTalon(RobotMap.motorRearRightId);
		rearRight.setSafetyEnabled(false);

		//=== Create drive train object for 4 motors ===
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		drive.setSafetyEnabled(false);   
	}

	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveTrainJoystick());		
	}

	//=== For this drive train forward requires a negative speed
	public static double forward(double speed) {
			return (-1 * speed);
	}

	//=== For this drive train reverse requires a positve speed
	public static double reverse(double speed) {
		return speed;
	}
}

