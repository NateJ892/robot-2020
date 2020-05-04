package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DigitalInput;

public class FerrisWheel
{
    private DigitalInput screwSensor, ballSensor;
    private CANSparkMax ferrisMotor;    //NOT SPARK MAX, THINK IT'S TALON
    private static volatile boolean wheelTaskFinished = false;


    public FerrisWheel ()
    {
        screwSensor = new DigitalInput(RMap.screwSens);
        ballSensor = new DigitalInput (RMap.ballSens);
        ferrisMotor = new CANSparkMax (RMap.CANFerrisWheelMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
    }
    
    public void cycleWheel()    //We have 8 CPU cores to work with so why not use asyncronous programming
    {
        
    }

    public void ballStatus ()
    {
        // Set the ferrisMotor to a speed of 0.5 (subject to change)
        // check previous screw sensor status
        // check current screw sensor status
        // If the previous was false and the current is true, that means the sensor encountered a screw.
        // Switch the position variable.
        // Check if there's a ball there.
    }
}