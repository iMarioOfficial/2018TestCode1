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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	XboxController DriverController = new XboxController(0);
	
	JoystickButton StopButton = new JoystickButton(DriverController, 2);
<<<<<<< HEAD
	JoystickButton ToggleArmButton = new JoystickButton(DriverController, 6);
=======
	JoystickButton ClawButton = new JoystickButton(DriverController, 1);\
	//make bumper button
>>>>>>> a0030ec3a2a84f67dcc5d4b0857497716ec8705d
	
	
	public OI()
	{

			StopButton.whileHeld(new StopDriving_Command());
<<<<<<< HEAD
			ToggleArmButton.toggleWhenActive(new RaiseArm_Command());
			//if above doesnt work then try below
			//ToggleArmButton.whileHeld(new RaiseArmCommand());
=======
			ClawButton.whileHeld(new OpenClaw_Command());
			
			
>>>>>>> a0030ec3a2a84f67dcc5d4b0857497716ec8705d
	}
		
		public XboxController getDriverJoystick()
		{
		
		return DriverController;	
		
		}
		
	
	
}
