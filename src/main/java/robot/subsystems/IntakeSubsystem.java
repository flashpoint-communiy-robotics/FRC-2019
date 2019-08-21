package robot.subsystems;

import com.torontocodingcollective.speedcontroller.TPwmSpeedController;
import com.torontocodingcollective.subsystem.TSubsystem;

import edu.wpi.first.wpilibj.Solenoid;
import robot.RobotMap;
import robot.commands.intake.DefaultIntakeCommand;

/**
 * Subsystem for arm mechanism.
 * 64 encoder counts per revolution, approx. 10 counts / degree
 * 60 revolutions = 1 full 360 degree arm turn, 1 revolution = 6 degrees
 */

public class IntakeSubsystem extends TSubsystem {

        TPwmSpeedController intakeWrist = new TPwmSpeedController
        (RobotMap.WRIST_SPEED_CONTROLLER_TYPE, RobotMap.WRIST_SPEED_CONTROLLER_ADDRESS, RobotMap.WRIST_MOTOR_ISINVERTED);
        
        TPwmSpeedController intakeLeft  = new TPwmSpeedController
        (RobotMap.INTAKE_LEFT_SPEED_CONTROLLER_TYPE, RobotMap.INTAKE_LEFT_SPEED_CONTROLLER_ADDRESS, RobotMap.INTAKE_LEFT_MOTOR_ISINVERTED);
    
        TPwmSpeedController intakeRight = new TPwmSpeedController
        (RobotMap.INTAKE_RIGHT_SPEED_CONTROLLER_TYPE, RobotMap.INTAKE_RIGHT_SPEED_CONTROLLER_ADDRESS, RobotMap.INTAKE_RIGHT_MOTOR_ISINVERTED);

        Solenoid forkSolenoid = new Solenoid(RobotMap.HATCH_FORKS_SOLENOID);
        Solenoid slideSolenoid =new Solenoid( RobotMap.HATCH_SLIDE_SOLENOID);
    
    @Override
    public void init() {
    };

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeCommand());
    }	
    
    public void intakeFwd() {
    	intakeLeft.set(1);
        intakeRight.set(1);
    }

    public void intakeBkd() {
    	intakeLeft.set(-1);
        intakeRight.set(-1);
    }

    public void intakeStop() {
        intakeLeft.set(0);
        intakeRight.set(0);
    }

    public void wristUp() {
    	intakeWrist.set(0.5);
    }

    public void wristDown() {
    	intakeWrist.set(-0.5);
    }

    public void stopWrist() {
    	intakeWrist.set(0);
    }

    public void forksOut() {
		forkSolenoid.set(true);
	}
    
    public void forksIn() {
		forkSolenoid.set(false);
    }
    
    public void slideOut() {
		forkSolenoid.set(true);
	}
    
    public void slideIn() {
		forkSolenoid.set(false);
	}
    


    // Periodically update the dashboard and any PIDs or sensors
    @Override
    public void updatePeriodic() {

    	// Monitor for limits
    	// This is done in case a command starts the motor and 
    	// does not update the motor speed at the end of the command
    	
    	}
    
    }