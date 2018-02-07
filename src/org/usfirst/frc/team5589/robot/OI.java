/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5589.robot;

import org.usfirst.frc.team5589.robot.commands.Spin_Command;
import org.usfirst.frc.team5589.robot.commands.StopDriving_Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick DriverStick = new Joystick(0);
	JoystickButton SpinButton = new JoystickButton(DriverStick, 2);
	JoystickButton StopButton = new JoystickButton(DriverStick, 1);
	
	public OI()
	{
		SpinButton.whenPressed(new Spin_Command());
		StopButton.whileHeld(new StopDriving_Command());
	}
		
		public Joystick getDriverJoystick()
		{
			return DriverStick;
			
		}
		
	
	
}
