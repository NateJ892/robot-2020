package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Shooter
{
    CANSparkMax m_WheelMotorLeft, m_WheelMotorRight;

    public Shooter()
    {
        m_WheelMotorLeft = new CANSparkMax (RMap.CANShooterMotorLeft, CANSparkMaxLowLevel.MotorType.kBrushless);
        m_WheelMotorRight = new CANSparkMax (RMap.CANShooterMotorRight, CANSparkMaxLowLevel.MotorType.kBrushless);
    }
       
    public void shoot ()
    {
        m_WheelMotorLeft.set(0.99);
        m_WheelMotorRight.set(-0.99);
    }
}
