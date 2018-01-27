package org.usfirst.frc.team5589.robot.subsystems;

import org.usfirst.frc.team5589.robot.RobotMap;
import org.usfirst.frc.team5589.robot.commands.ArcadeDrive_Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain_Subsystem extends Subsystem{
	
	@SuppressWarnings("deprecation")
	private RobotDrive MainDrive = new RobotDrive(RobotMap.Drive_Left, RobotMap.Drive_Right);

	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive_Command());
		
	}
	
	@SuppressWarnings("deprecation")
	public void JoystickDrive(Joystick Driver)
	{
		MainDrive.arcadeDrive(Driver);
	}
	
	@SuppressWarnings("deprecation")
	public void Spin()
	{
		MainDrive.drive(0.5, 1);
	}

	@SuppressWarnings("deprecation")
	public void Stop()
	{
		MainDrive.arcadeDrive(0, 0);
	}
}
