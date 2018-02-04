package org.usfirst.frc.team5589.robot.subsystems;

import org.usfirst.frc.team5589.robot.commands.JoystickDrive_Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
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
	
	public void JoystickDrive(Joystick Driver)
	{
		m_left.setInverted(true);
	
		MainDrive.arcadeDrive(Driver.getX(), Driver.getY());
	}
	
	public void Spin()
	{

	    Timer time = new Timer();  
		time.start();  //start timer
		
		while(time.get() < 1) {   //spin for less than 1 second
	    
		m_left.set(0);  //set right side at 0
		m_right.set(0.2);  //set left at 1/5 speed so that it spins moderately fast, on the spot
		
		}
		MainDrive.stopMotor();  
		time.stop();
		
	}


	public void Stop()
	{
		MainDrive.stopMotor();  

	}
}
