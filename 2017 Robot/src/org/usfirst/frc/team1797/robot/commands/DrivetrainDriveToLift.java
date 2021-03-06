package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivetrainDriveToLift extends Command {

	public DrivetrainDriveToLift(){
		requires(Robot.drivetrain);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drivetrain.setR(88.5);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drivetrain.rDrive();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.drivetrain.rDriveIsDone();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drivetrain.resetDriveMotors();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
