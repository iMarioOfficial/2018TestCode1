
  package org.usfirst.frc.team5589.robot.commands;
 

import org.usfirst.frc.team5589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class Autonomous_Command  extends Command{
	
	public Autonomous_Command()
	{
		requires(Robot.DriveTrain);
	}
	
	
	protected void initialise()
	{
		
	}
	
	@Override
	protected void execute()
	{	  
		
		Robot.DriveTrain.Autonomous();
		
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