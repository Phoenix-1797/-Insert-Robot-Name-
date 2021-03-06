package org.usfirst.frc.team1797.robot.subsystems;

import org.usfirst.frc.team1797.robot.RobotMap;
import org.usfirst.frc.team1797.robot.commands.FloorGearDefaultCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FloorGear extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private VictorSP intake;
	private DoubleSolenoid liftPiston, blockPiston;
	
	private long lastActuationLifter, lastActuationBlocker;
	
	private DoubleSolenoid.Value lastActionLifter, lastActionBlocker;

	public FloorGear() {
		intake = RobotMap.FLOORGEAR_INTAKE;
		liftPiston = RobotMap.FLOORGEAR_LIFTER;
		blockPiston = RobotMap.FLOORGEAR_BLOCKER;

		lastActuationLifter = Long.MAX_VALUE;
		lastActuationBlocker = Long.MAX_VALUE;
	}

	//Intake
	public void intake() {
		intake.set(1);
	}

	public void outtake() {
		intake.set(-1);
	}

	public void intakeOff() {
		intake.set(0);
	}

	//Claw
	public void lifterUp() {
		liftPiston.set(DoubleSolenoid.Value.kForward);
		lastActionLifter = DoubleSolenoid.Value.kForward;
		lastActuationLifter = System.currentTimeMillis();
	}

	public void lifterDown() {
		liftPiston.set(DoubleSolenoid.Value.kReverse);
		lastActionLifter = DoubleSolenoid.Value.kReverse;
		lastActuationLifter = System.currentTimeMillis();
	}

	public void stopLifter() {
		liftPiston.set(DoubleSolenoid.Value.kOff);
		lastActuationLifter = Long.MAX_VALUE;
	}

	public boolean lifterIsDone() {
		return System.currentTimeMillis() - lastActuationLifter > 1000;
	}

	public boolean isLifting() {
		return lastActionLifter == DoubleSolenoid.Value.kForward;
	}
	
	// Blocker
	public void blockerDown() {
		blockPiston.set(DoubleSolenoid.Value.kForward);
		lastActionBlocker = DoubleSolenoid.Value.kForward;
		lastActuationBlocker = System.currentTimeMillis();
	}

	public void blockerUp() {
		blockPiston.set(DoubleSolenoid.Value.kReverse);
		lastActionBlocker = DoubleSolenoid.Value.kReverse;
		lastActuationBlocker = System.currentTimeMillis();
	}

	public void stopBlocker() {
		blockPiston.set(DoubleSolenoid.Value.kOff);
		lastActuationBlocker = Long.MAX_VALUE;
	}

	public boolean blockerIsDone() {
		return System.currentTimeMillis() - lastActuationBlocker > 1000;
	}

	public boolean isBlocking() {
		return lastActionBlocker == DoubleSolenoid.Value.kForward;
	}

	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(new FloorGearDefaultCommand());
	}
}
