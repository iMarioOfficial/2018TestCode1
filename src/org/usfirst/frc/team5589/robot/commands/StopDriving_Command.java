package org.usfirst.frc.team5589.robot.commands;

import org.usfirst.frc.team5589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class StopDriving_Command  extends Command{
	
	public StopDriving_Command()
	{
		requires(Robot.DriveTrain);
	}
	
	
	protected void initialise()
	{
		
	}
	
	@Override
	protected void execute()
	{	  
		
		Robot.DriveTrain.Stop();
		
	}
	
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	protected void end()
	{
		
	}


}
