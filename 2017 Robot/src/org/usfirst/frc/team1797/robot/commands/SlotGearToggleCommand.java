package org.usfirst.frc.team1797.robot.commands;

import org.usfirst.frc.team1797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SlotGearToggleCommand extends Command {

	public SlotGearToggleCommand() {
		requires(Robot.slotgear);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.slotgear.toggleHolder();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.slotgear.isDone();
	}

	// Called once after isFinished returns true
	protected void end() {
		interrupted();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.slotgear.holderOff();
	}
}
