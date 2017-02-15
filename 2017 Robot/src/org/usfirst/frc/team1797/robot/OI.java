package org.usfirst.frc.team1797.robot;

import org.usfirst.frc.team1797.robot.commands.DrivetrainAccelTest;
import org.usfirst.frc.team1797.robot.commands.DrivetrainShiftGearCommand;
import org.usfirst.frc.team1797.robot.commands.DrivetrainStation1Command;
import org.usfirst.frc.team1797.robot.commands.DrivetrainStation2Command;
import org.usfirst.frc.team1797.robot.commands.DrivetrainStation3Command;
import org.usfirst.frc.team1797.util.XBox360;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public XBox360 driverController;
	public XBox360 operatorController;

	public OI() {
		driverController = new XBox360(0);
		operatorController = new XBox360(1);

		// Driver
		driverController.getLeftStick().whenPressed(new DrivetrainShiftGearCommand());
		driverController.getXButton().whenPressed(new DrivetrainStation1Command());
		driverController.getYButton().whenPressed(new DrivetrainStation2Command());
		driverController.getBButton().whenPressed(new DrivetrainStation3Command());

		// Testing
		driverController.getAButton().whileHeld(new DrivetrainAccelTest());
	}

}
