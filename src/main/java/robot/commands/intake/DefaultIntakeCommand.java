package robot.commands.intake;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.commands.TSafeCommand;

import edu.wpi.first.wpilibj.*;
import robot.Robot;

/**
 *
 */
public class DefaultIntakeCommand extends TSafeCommand {

	private static final String COMMAND_NAME = 
			DefaultIntakeCommand.class.getSimpleName();

	public DefaultIntakeCommand() {

		super(TConst.NO_COMMAND_TIMEOUT, Robot.oi);

		// Use requires() here to declare subsystem dependencies
        requires(Robot.intakeSubsystem);
        
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
        
        

    	if (Robot.oi.intakeFwd()) {
            Robot.intakeSubsystem.intakeFwd();
        
        }else if (Robot.oi.intakeBkd()){
            Robot.intakeSubsystem.intakeBkd();

		}else {
            Robot.intakeSubsystem.intakeStop();
        }

        // Intake Pos 1
        if(Robot.oi.wristUp()) {
            // Check if Claw is at Mid
            if (intakePos==3){
                Robot.intakeSubsystem.wristUp();
                Timer.delay(.4);
                Robot.intakeSubsystem.stopWrist();
                intakePos = 1;
            // Check if Claw is not at Pos 1
            }else if(intakePos!=1){
                Robot.intakeSubsystem.wristUp();
                Timer.delay(.8);
                Robot.intakeSubsystem.stopWrist(); 
                intakePos=1;    
            }

        // Intake Pos 2
		}else if (Robot.oi.wristDown()) {
            // Check if Claw is at Mid
            if (intakePos==3){
                Robot.intakeSubsystem.wristDown();
                Timer.delay(-.4);
                Robot.intakeSubsystem.stopWrist();
                intakePos = 2;

            // Check if Claw is not at Pos 2
            }else if(intakePos!=2){
                Robot.intakeSubsystem.wristDown();
                Timer.delay(.8);
                Robot.intakeSubsystem.stopWrist();
                intakePos = 2; 
            }
        
        // Claw Pos 3
        }else if (Robot.oi.wristMid()) {
            if (intakePos!=3){
            Robot.intakeSubsystem.wristDown();
            Timer.delay(.4);
            Robot.intakeSubsystem.stopWrist();
            intakePos = 3;
            }

        }else{
            Robot.intakeSubsystem.stopWrist();
        }
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

}