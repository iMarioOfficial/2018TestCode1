package org.usfirst.frc.team5589.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmAndClaw_Subsystem extends Subsystem{
	
    
	// create claw and arm motor objects
	Talon m_Arm = new Talon(4);
	Talon m_Claw = new Talon(5);
	
	protected void initDefaultCommand() {

		
	}
	
	//bring up arm according to Y value of right controller stick
	
	public void RaiseArm(XboxController Driver)
	{
		double rstickValue = Driver.getY(Hand.kRight);
		m_Arm.setSafetyEnabled(false);
		m_Arm.set(-rstickValue);
		
		
		
	}
	
	
	//Open Claw
	
	public void OpenClaw(XboxController Driver)
	{
		m_Claw.setSafetyEnabled(false);
		double rstickXValue = Driver.getTriggerAxis(Hand.kLeft);
		m_Claw.set(rstickXValue);
	
		
	}

}