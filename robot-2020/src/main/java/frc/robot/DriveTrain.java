package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.XboxController;

/*      Learn all you need to know about the mecanum drive class here!
        This explains cartesian drive, and how forward, strafe, 
        and rotation is incorporated into three dimensional vectors.
        https://first.wpi.edu/FRC/roborio/beta/docs/java/edu/wpi/first/wpilibj/drive/MecanumDrive.html
*/

public class DriveTrain {

    // Creation of CANSparkMax objects
    CANSparkMax leftFrontMotor, rightFrontMotor, leftBackMotor, rightBackMotor;
    // MecanumDrive
    MecanumDrive ckDrive;
    // gyro
    ADXRS450_Gyro ckGyro;
    Double speedF = 0.0; // forward speed
    Double speedR = 0.0; // rotation speed
    Double speedS = 0.0; // strafe speed

    XboxController ckController; // xbox controller object

    public DriveTrain() 
    {

      // Attaching motor types and objects to the objects
        leftFrontMotor = new CANSparkMax (RMap.CANLeftFrontMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightFrontMotor = new CANSparkMax (RMap.CANRightFrontMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftBackMotor = new CANSparkMax (RMap.CANLeftBackMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightBackMotor = new CANSparkMax (RMap.CANRightBackMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        
        // setting idle modes to "brake"
        leftFrontMotor.setIdleMode(IdleMode.kBrake);
        leftBackMotor.setIdleMode(IdleMode.kBrake);
        rightFrontMotor.setIdleMode(IdleMode.kBrake);
        rightBackMotor.setIdleMode(IdleMode.kBrake);

        // creating the MecanumDrive train
        ckDrive = new MecanumDrive (leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor);

        // Creating the gyro
        ckGyro = new ADXRS450_Gyro();
        
        SmartDashboard.putData("Drive Train", ckDrive);

    }


    public void teleDriveCartesian(double forward, double rotation, double strafe)
    {

        speedF = applyDappen (applyDeadBand(forward), speedF);
        speedR = applyDappen(applyDeadBand(rotation), speedR);
        speedS = applyDappen (applyDeadBand(strafe), speedS);

        // ckDrive.driveCartesian(ySpeed, xSpeed, zRotation);
        ckDrive.driveCartesian(speedS, speedF, speedR, 0);

    }

    public void resetGyro ()
    {
        ckGyro.reset();
    }

    public void driveStraight(double forward)
    {
        double turnAmount = ckGyro.getAngle() * RMap.gyroStraightKp;
        ckDrive.driveCartesian(0, forward, turnAmount);
    }

    private double applyDeadBand(double value) 
    {
        if (Math.abs(value) > RMap.driveTrainDeadzone) 
        {
          if (value > 0.0) 
          {
            if (value >= RMap.driveTrainMax) 
            {
              //Your at max speed, keep it there
              return RMap.driveTrainMax;
            }
            else return (value - RMap.driveTrainDeadzone) / (RMap.driveTrainMax - RMap.driveTrainDeadzone); // scale the speed up
        
          } else {
            if (value < -RMap.driveTrainMax) {
              //Your at minimum speed, keep it there
              return -RMap.driveTrainMax;
            }
            else return (value + RMap.driveTrainDeadzone) / (RMap.driveTrainMax - RMap.driveTrainDeadzone); // scale the speed down
            
          }
        } else {
          return 0.0;
        }
    
      }




      public double applyDappen(double proposedValue, double currentSpeed) 
      {
        // Apply Dapening
        if (currentSpeed >= 0.0) 
        {
          // Going Forward
          if (proposedValue > currentSpeed) 
          {
            // Accelerating Forward
            proposedValue = Math.min(proposedValue, currentSpeed + RMap.maxSpeedIncrease);
          } else proposedValue = Math.max(proposedValue, currentSpeed - RMap.maxSpeedDecrease); // Decelerating Forward
          
        } else {
          // Going Backwards
          if (proposedValue < currentSpeed) {
            // Accelerating Backwards
            proposedValue = Math.max(proposedValue, currentSpeed - RMap.maxSpeedIncrease);
          } else proposedValue = Math.min(proposedValue, currentSpeed + RMap.maxSpeedDecrease); // Decelerating Backward
          
        }
    
        return proposedValue;
      }
    
    
}