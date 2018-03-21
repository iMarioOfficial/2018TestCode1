package org.usfirst.frc.team5589.robot.subsystems;

import org.usfirst.frc.team5589.robot.commands.JoystickDrive_Command;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
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
 
	   @SuppressWarnings("deprecation")
	   RobotDrive MainDrive = new RobotDrive(m_left, m_right);

	 
	//   Ultrasonic ultra = new Ultrasonic(1,1); // creates the ultra object andassigns ultra to be an ultrasonic sensor which uses DigitalOutput 1 for 
       // the echo pulse and DigitalInput 1 for the trigger pulse
	
	  AnalogGyro gyro = new AnalogGyro(1);
	 
	
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
		else if(Driver.getTriggerAxis(Hand.kRight) != 0)
		{
			YAxis = Driver.getTriggerAxis(Hand.kRight);
		}
		
		
		MainDrive.arcadeDrive(- Driver.getX(Hand.kLeft), YAxis);
		
	}

	public void SpinTest()
	{
		Timer testTime = new Timer();
		
		while(testTime.get() < 0.5)
		{
		m_left.set(0.15);
		m_right.set(-0.15);
		}
		
		m_left.set(0);
		m_right.set(0);
	}

	public void Spin(char side, double speed)
	{
		  double Kp = 0.03;
		 double OGangle = gyro.getAngle(); // get current heading
	
		if(side == 'L')
		{
			MainDrive.drive(speed, OGangle - 15 * Kp);
		
			
		}
		else
		{
		MainDrive.drive(speed, OGangle + 15 * Kp);
			
		}
		
		
		
			
	}
	/*
	public double getDistance()
	{
		ultra.setAutomaticMode(true); // turns on automatic mode
		
		double range = ultra.getRangeInches(); // reads the range on the ultrasonic sensor
		return range;
	}
	
	public char getFieldPosition()
	{
		char fieldPos = 'N';
		
		Spin('L', 0.15);
		double leftDist = getDistance();
		
		Spin('R', 0.30);
		double rightDist = getDistance();
		
		if(leftDist > rightDist )
		{
			fieldPos = 'R';
		}
		if(leftDist == rightDist)
		{
			fieldPos = 'M';
		}
		
		if(leftDist < rightDist)
		{
			fieldPos = 'M';
		}
		
		
			return fieldPos;
	}
	
	public void Autonomous()
	{
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
			//Put left auto code here
			//switch statement which field position and drive at angle accordingly
			  
		  } else {
			//Put right auto code here
			 //switch statement which field position and drive at angle accordingly
		  }
                }
	}
*/
	
	public void Stop()
	{	
		m_left.set(0);
		m_right.set(0);

	}
}
