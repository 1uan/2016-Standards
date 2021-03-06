package org.usfirst.frc.team2152.robot.commands;

import org.usfirst.frc.team2152.robot.Robot;
import org.usfirst.frc.team2152.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrainJoystick extends Command{

    public DriveTrainJoystick() {
    	requires(Robot.drivetrain);
	}


	private void requires(Drivetrain drivetrain) {
	}


	// Called just before this Command runs the first time
    protected void initialize() {
    }
    
    public void execute() {
    	double left  = Robot.oi.driverJoystick.getRawAxis(1);
    	double right = Robot.oi.driverJoystick.getRawAxis(5);
    	Robot.drivetrain.tankDrive(left, right);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
