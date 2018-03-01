package org.usfirst.frc.team5589.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmAndClaw_Subsystem extends Subsystem{
	
    
	// create claw and arm motor objects
	Spark m_Arm = new Spark(4);
	Spark m_Claw = new Spark(5);
	
	protected void initDefaultCommand() {
		
		
	}
	
	//bring up arm according to Y value of right controller stick
	
	public void RaiseArm(XboxController Driver)
	{
		m_Arm.set(Driver.getY(Hand.kRight));
		
	}
	
	
	//Open Claw
	
	public void OpenClaw()
	{
		m_Claw.set(0.25);
	}

}