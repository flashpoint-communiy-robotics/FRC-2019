package robot;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.speedcontroller.TCanSpeedController.TCanSpeedControllerType;
import com.torontocodingcollective.speedcontroller.TPwmSpeedController.TPwmSpeedControllerType;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * <p>
 * This map is intended to define the wiring only. Robot constants should be put
 * in {@link RobotConst}
 */
public class RobotMap {

    // ******************************************
    // Speed Controllers and encoders
    // ******************************************

    // Drive
    public static final int                     LEFT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType LEFT_DRIVE_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     LEFT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType LEFT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 LEFT_DRIVE_CAN_MOTOR_ISINVERTED;

    public static final int                     RIGHT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType RIGHT_DRIVE_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     RIGHT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType RIGHT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 RIGHT_DRIVE_CAN_MOTOR_ISINVERTED;

    public static final boolean                 LEFT_DRIVE_CAN_ENCODER_ISINVERTED;
    public static final boolean                 RIGHT_DRIVE_CAN_ENCODER_ISINVERTED;

    // Elevator
    public static final int                     LEFT_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType LEFT_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     LEFT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType LEFT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_TYPE;
    public static final boolean                 LEFT_ELEVATOR_CAN_MOTOR_ISINVERTED;
    public static final boolean                 LEFT_ELEVATOR_CAN_ENCODER_ISINVERTED;

    public static final int                     RIGHT_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType RIGHT_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE;
    public static final int                     RIGHT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType RIGHT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_TYPE;
    public static final boolean                 RIGHT_ELEVATOR_CAN_MOTOR_ISINVERTED;
    public static final boolean                 RIGHT_ELEVATOR_CAN_ENCODER_ISINVERTED;

    // Intake
    public static final int                     WRIST_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType WRIST_SPEED_CONTROLLER_TYPE;
    public static final boolean                 WRIST_MOTOR_ISINVERTED;

    public static final int                     INTAKE_LEFT_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType INTAKE_LEFT_SPEED_CONTROLLER_TYPE;
    public static final boolean                 INTAKE_LEFT_MOTOR_ISINVERTED;

    public static final int                     INTAKE_RIGHT_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType INTAKE_RIGHT_SPEED_CONTROLLER_TYPE;
    public static final boolean                 INTAKE_RIGHT_MOTOR_ISINVERTED;
    

    // ******************************************
    // Gyro Ports
    // ******************************************
    public static final int                     GYRO_PORT;
    public static final boolean                 GYRO_ISINVERTED;

    // ******************************************
    // Pneumatics Ports
    // ******************************************
    public static final int                     SHIFTER_PNEUMATIC_PORT = 0;

    // Initializers if this code will be deployed to more than one
    // robot with different mappings
    static {

        switch (RobotConst.robot) {

        case RobotConst.TEST_ROBOT:
        default:
            // CAN Constants
            // Talon and Victor connected through the CAN Bus

            // Drive
            LEFT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS           = 0;
            LEFT_DRIVE_CAN_SPEED_CONTROLLER_TYPE              = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            LEFT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_ADDRESS  = 1;
            LEFT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_TYPE     = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            LEFT_DRIVE_CAN_MOTOR_ISINVERTED                   = TConst.INVERTED;
            LEFT_DRIVE_CAN_ENCODER_ISINVERTED                 = TConst.INVERTED;

            RIGHT_DRIVE_CAN_SPEED_CONTROLLER_ADDRESS          = 2;
            RIGHT_DRIVE_CAN_SPEED_CONTROLLER_TYPE             = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            RIGHT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_ADDRESS = 3;
            RIGHT_DRIVE_CAN_FOLLOWER_SPEED_CONTROLLER_TYPE    = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            RIGHT_DRIVE_CAN_MOTOR_ISINVERTED                  = TConst.NOT_INVERTED;
            RIGHT_DRIVE_CAN_ENCODER_ISINVERTED                = TConst.NOT_INVERTED;

            // Elevator
            LEFT_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS           = 4;
            LEFT_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE              = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            LEFT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_ADDRESS  = 5;
            LEFT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_TYPE     = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            LEFT_ELEVATOR_CAN_MOTOR_ISINVERTED                   = TConst.INVERTED;
            LEFT_ELEVATOR_CAN_ENCODER_ISINVERTED                 = TConst.INVERTED;

            RIGHT_ELEVATOR_CAN_SPEED_CONTROLLER_ADDRESS          = 6;
            RIGHT_ELEVATOR_CAN_SPEED_CONTROLLER_TYPE             = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            RIGHT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_ADDRESS = 7;
            RIGHT_ELEVATOR_FOLLOWER_CAN_SPEED_CONTROLLER_TYPE    = TCanSpeedControllerType.SPARK_MAX_BRUSHLESS;
            RIGHT_ELEVATOR_CAN_MOTOR_ISINVERTED                  = TConst.NOT_INVERTED;
            RIGHT_ELEVATOR_CAN_ENCODER_ISINVERTED                = TConst.NOT_INVERTED;

            // Intake

            WRIST_SPEED_CONTROLLER_ADDRESS                      = 0;
            WRIST_SPEED_CONTROLLER_TYPE                         = TPwmSpeedControllerType.VICTOR_SP;
            WRIST_MOTOR_ISINVERTED                              = TConst.NOT_INVERTED;

            INTAKE_LEFT_SPEED_CONTROLLER_ADDRESS                = 1;
            INTAKE_LEFT_SPEED_CONTROLLER_TYPE                   = TPwmSpeedControllerType.VICTOR_SP;
            INTAKE_LEFT_MOTOR_ISINVERTED                        = TConst.NOT_INVERTED;

            INTAKE_RIGHT_SPEED_CONTROLLER_ADDRESS                = 2;
            INTAKE_RIGHT_SPEED_CONTROLLER_TYPE                   = TPwmSpeedControllerType.VICTOR_SP;
            INTAKE_RIGHT_MOTOR_ISINVERTED                        = TConst.INVERTED;

            GYRO_PORT       = 0;
            GYRO_ISINVERTED = TConst.NOT_INVERTED;
        }
    }
}
