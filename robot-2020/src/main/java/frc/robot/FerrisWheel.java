package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DigitalInput;

public class FerrisWheel
{

    DigitalInput screwSensor, ballSensor;
    CANSparkMax ferrisMotor;

    boolean screwThere = false;
    boolean previousScrewThere = false;
    boolean [] ballStatus = {false, false, false, false, false};
    int position;
    int prevPosition;

    public FerrisWheel ()
    {

        screwSensor = new DigitalInput(RMap.screwSens);
        ballSensor = new DigitalInput (RMap.ballSens);

        ferrisMotor = new CANSparkMax (RMap.CANFerrisWheelMotor, CANSparkMaxLowLevel.MotorType.kBrushless);

    }

    public void setBallPosition (int pos)
    {
        this.position = pos;
    }
    
    public int getBallPosition()
    {
        return position;
    }

    public void switchBallPosition()
    {
        switch (this.position) {
        case 0: this.position = 1;
        case 1: this.position = 2;
        case 2: this.position = 3;
        case 3: this.position = 4;
        case 4: this.position = 0;
        }
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