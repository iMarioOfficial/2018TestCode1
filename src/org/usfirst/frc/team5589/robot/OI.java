/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5589.robot;

import org.usfirst.frc.team5589.robot.commands.OpenClaw_Command;
import org.usfirst.frc.team5589.robot.commands.RaiseArm_Command;
import org.usfirst.frc.team5589.robot.commands.StopDriving_Command;
import org.usfirst.frc.team5589.robot.commands.TestAutonomous_Command;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	XboxController DriverController = new XboxController(0);
	
	JoystickButton StopButton = new JoystickButton(DriverController, 2);

	JoystickButton ToggleArmButton = new JoystickButton(DriverController, 6);

	JoystickButton ClawButton = new JoystickButton(DriverController, 5);

	JoystickButton testDistance = new JoystickButton(DriverController, 7);
	
	
	public OI()
	{

			StopButton.whileHeld(new StopDriving_Command());

			ToggleArmButton.toggleWhenActive(new RaiseArm_Command());
			
			ClawButton.toggleWhenActive(new OpenClaw_Command());
			
			testDistance.toggleWhenPressed(new TestAutonomous_Command());

	}
		
		public XboxController getDriverJoystick()
		{
		
		return DriverController;	
		
		}
		
}
		
