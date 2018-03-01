package org.usfirst.frc.team5589.robot.subsystems;

import org.usfirst.frc.team5589.robot.commands.JoystickDrive_Command;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain_Subsystem extends Subsystem{
	
	   Spark m_frontLeft = new Spark(0);
	   Spark m_rearLeft = new Spark(1);
	   SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

	   Spark m_frontRight = new Spark(2);
	   Spark m_rearRight = new Spark(3);
	   SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
 
	   ////
	   DifferentialDrive MainDrive = new DifferentialDrive(m_left, m_right);
	 
	
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive_Command());
		
	}
	
	public void JoystickDrive(XboxController Driver)
	{
		m_left.setInverted(true);
	
		double YAxis = 0;
		
		if(Driver.getTriggerAxis(Hand.kLeft) != 0)
		{
			YAxis = -Driver.getTriggerAxis(Hand.kLeft);
		}
		
		if(Driver.getTriggerAxis(Hand.kRight) != 0)
		{
			YAxis = Driver.getTriggerAxis(Hand.kRight);
		}
		
		MainDrive.arcadeDrive(Driver.getX(Hand.kLeft), YAxis);//y);
	}
	
	


	public void Stop()
	{
		MainDrive.stopMotor();  

	}
}
