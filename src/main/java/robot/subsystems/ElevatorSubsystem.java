package robot.subsystems;

import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import com.torontocodingcollective.subsystem.TSubsystem;

import robot.RobotMap;
import robot.commands.elevator.DefaultLiftCommand;



/**
 * Subsystem for arm mechanism.
 * 64 encoder counts per revolution, approx. 10 counts / degree
 * 60 revolutions = 1 full 360 degree arm turn, 1 revolution = 6 degrees
 */

public class ElevatorSubsystem extends TSubsystem {

    TCanSpeedController leftElevator = new TCanSpeedController(
    		RobotMap.LEFT_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE,RobotMap.LEFT_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.LEFT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_TYPE,RobotMap.LEFT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.LEFT_ELEVATOR_CAN_MOTOR_ISINVERTED);
    TCanSpeedController rightElevator = new TCanSpeedController(
    		RobotMap.RIGHT_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE,RobotMap.RIGHT_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.RIGHT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_TYPE,RobotMap.RIGHT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_ADDRESS, RobotMap.RIGHT_ELEVATOR_CAN_MOTOR_ISINVERTED);
    
    @Override
    public void init() {
    };

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultLiftCommand());
    }	
    
    public void elevatorUp() {
    	leftElevator.set(1);
        rightElevator.set(1);
    }

    public void elevatorDown() {
    	leftElevator.set(-1);
        rightElevator.set(-1);
    }

    public void elevatorUpSlow() {
    	leftElevator.set(0.5);
        rightElevator.set(0.5);
    }

    public void elevatorDownSlow() {
    	leftElevator.set(-0.5);
        rightElevator.set(-0.5);
    }
    
    public void stopElevator() {
    	leftElevator.set(0);
        rightElevator.set(0);
    }


    // Periodically update the dashboard and any PIDs or sensors
    @Override
    public void updatePeriodic() {

    	// Monitor for limits
    	// This is done in case a command starts the motor and 
    	// does not update the motor speed at the end of the command
    	
    	}
    
    }