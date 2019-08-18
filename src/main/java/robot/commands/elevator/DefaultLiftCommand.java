package robot.commands.elevator;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.commands.TSafeCommand;

import edu.wpi.first.wpilibj.*;
import robot.Robot;

/**
 *
 */
public class DefaultLiftCommand extends TSafeCommand {

	private static final String COMMAND_NAME = 
			DefaultLiftCommand.class.getSimpleName();

	public DefaultLiftCommand() {

		super(TConst.NO_COMMAND_TIMEOUT, Robot.oi);

		// Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
        
	}

	@Override
	protected String getCommandName() { return COMMAND_NAME; }

	@Override
	protected String getParmDesc() { 
		return super.getParmDesc(); 
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Print the command parameters if this is the current
		// called command (it was not sub-classed)
		if (getCommandName().equals(COMMAND_NAME)) {
			logMessage(getParmDesc() + " starting");
		}
	}
            int intakePos = 1;
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
        
        

    	if (Robot.oi.elevatorUp()) {
            Robot.elevatorSubsystem.elevatorUp();
        
        }else if (Robot.oi.elevatorDown()){
            Robot.elevatorSubsystem.elevatorDown();

		}else {
            Robot.elevatorSubsystem.stopElevator();
        }
        /** 
        // Claw Pos 1
        if(Robot.oi.clawUp()) {
            // Check if Claw is at Mid
            if (intakePos==3){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.4);
                Robot.wristSubsystem.clawStop();
                intakePos = 1;
            // Check if Claw is not at Pos 1
            }else if(intakePos!=1){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.8);
                Robot.wristSubsystem.clawStop(); 
                intakePos=1;    
            }

        // Claw Pos 2
		}else if (Robot.oi.clawDown()) {
            // Check if Claw is at Mid
            if (intakePos==3){
                Robot.wristSubsystem.clawDown();
                Timer.delay(-.4);
                Robot.wristSubsystem.clawStop();
                intakePos = 2;

            // Check if Claw is not at Pos 2
            }else if(intakePos!=2){
                Robot.wristSubsystem.clawDown();
                Timer.delay(.8);
                Robot.wristSubsystem.clawStop();
                intakePos = 2; 
            }
        
        // Claw Pos 3
        }else if (Robot.oi.clawMid()) {
            if (intakePos!=3){
            Robot.wristSubsystem.clawDown();
            Timer.delay(.4);
            Robot.wristSubsystem.clawStop();
            intakePos = 3;
            }

        }else{
            Robot.wristSubsystem.clawStop();
        }
		**/
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

}