package org.usfirst.frc.team5589.robot.subsystems;


import org.usfirst.frc.team5589.robot.commands.JoystickDrive_Command;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
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
	
	public boolean done = false;
	   Spark m_frontLeft = new Spark(0);
	   Spark m_rearLeft = new Spark(1);
	   SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
	   

	   Spark m_frontRight = new Spark(2);
	   Spark m_rearRight = new Spark(3);
	   SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
 
	   @SuppressWarnings("deprecation")
	   RobotDrive MainDrive = new RobotDrive(m_left, m_right);
	   

	 
	  AnalogInput ultrasonic = new AnalogInput(0); 
	  
	
	  AnalogGyro gyro = new AnalogGyro(1);
	  double OGangle = gyro.getAngle(); // get current heading
	  double Kp = 0.03;
	 
	
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive_Command());
		
	}
	
	@SuppressWarnings("deprecation")
	public void JoystickDrive(XboxController Driver)
	{
		MainDrive.setSafetyEnabled(false);
		m_left.setInverted(true);
	
		MainDrive.arcadeDrive(-(Driver.getX(Hand.kLeft)), -(Driver.getY(Hand.kLeft)));		
		
	}

	public void DistanceTest()
	{
		
		while(getDistance() > 36)
		{
			m_left.set(0);
			m_right.set(0);
		}
		while(getDistance() <= 36)
		{
			m_left.set(-0.15);
			m_right.set(-0.15);
		}
	
	
		
	}
	
	

	@SuppressWarnings("deprecation")
	public void Spin(char side, double speed)
	{
		  
		if(side == 'L')
		{
			MainDrive.drive(speed, OGangle - 25 * Kp);
		
			
		}
		else
		{
			//timer so it spins for 1/3 sec
		MainDrive.drive(speed, OGangle + 50 * Kp);
		//now get angle and drive straight	
		}
		
		
		
			
	}
	
	public double getDistance()
	{
		
		double  rawrange = ultrasonic.getVoltage() * 36.6;
        double range = rawrange + 12;
		
        return range;
	}
	
	//public char getFieldPosition()
//	{
		/*
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
		
		*/
			//return fieldPos;
		//	return 'R';
//	}
	
	public void Autonomous()
	{
		/*
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
		  if(gameData.charAt(0) == 'L')
		  {
			m_left.set(-0.25);
			m_right.set(-0.30);
			}
			else if (gameData.charAt(0) == 'R')
			{
			m_left.set(-0.30);
			m_right.set(-0.25);
			}
			/*
			case 'R': MainDrive.arcadeDrive(0.05, -0.64);
				//MainDrive.drive(0.8, OGangle - 25 * Kp);
				break;
			case 'M':	MainDrive.arcadeDrive(0.05, -0.64);
				//MainDrive.drive(0.8, OGangle - 45 * Kp);
				break;
			case 'L':  MainDrive.arcadeDrive(0.05,0.0);
				//MainDrive.drive(0.8, OGangle  * Kp);
			}
			  
		  } else {
			  switch(getFieldPosition())
				{
				case 'R':  MainDrive.arcadeDrive(0.05,0.0);
					// MainDrive.drive(0.8, OGangle  * Kp);
					break;
				case 'M':    MainDrive.arcadeDrive(0.05, 0.64);
							//MainDrive.drive(0.8, OGangle + 45 * Kp);
					break;
				case 'L': MainDrive.arcadeDrive(0.05, 0.64);
					//MainDrive.drive(0.8, OGangle + 25 * Kp);
				}
		  }
         */       
		//
		
		//drive forward
		
		Timer.delay(2);
		Timer timer = new Timer();
		timer.start();
		while(timer.get() < 8) {
                m_left.set(-0.30);
                m_right.set(-0.25);
		}
		timer.stop();
		m_left.set(0.0);
		m_right.set(0.0);
		done = true;
             
                //drive forward
            //  MainDrive.arcadeDrive(0.15,0.0);
                
                //rotate right
           //     MainDrive.arcadeDrive(0.05, 0.64);
                
                //rotate left
        //        MainDrive.arcadeDrive(0.05, -0.64);
	}

	
	public void Stop()
	{	
		m_left.set(0);
		m_right.set(0);

	}
}
