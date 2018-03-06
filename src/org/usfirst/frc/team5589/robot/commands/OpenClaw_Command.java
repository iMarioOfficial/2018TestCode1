package org.usfirst.frc.team5589.robot.commands;

import org.usfirst.frc.team5589.robot.Robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;



public class OpenClaw_Command extends Command{

	
	
	protected void initialise()
	{
		
	}
	
	@Override
	protected void execute()
	{
		XboxController AButton = Robot.oi.getDriverJoystick();
		
		if(AButton.getAButton() == true)
			Robot.ArmAndClaw.OpenClaw();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end()
	{
		
	}
}
