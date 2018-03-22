package org.usfirst.frc.team5589.robot.commands;

import org.usfirst.frc.team5589.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;



public class TestAutonomous_Command  extends Command{
	
	public TestAutonomous_Command()
	{
		requires(Robot.DriveTrain);
	}
	
	
	protected void initialise()
	{
		
	}
	
	@Override
	protected void execute()
	{	  
		
		Robot.DriveTrain.DistanceTest();
		
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
