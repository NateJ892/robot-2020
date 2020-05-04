package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Lift
{
    private CANSparkMax m_backLift, m_frontLift;
    private SpeedControllerGroup m_Lift;

    public Lift ()
    {
        m_frontLift = new CANSparkMax(RMap.CANLiftMotorFront, CANSparkMaxLowLevel.MotorType.kBrushless);
        m_backLift = new CANSparkMax (RMap.CANLiftMotorBack, CANSparkMaxLowLevel.MotorType.kBrushless);

        m_frontLift.setIdleMode(IdleMode.kBrake);
        m_backLift.setIdleMode(IdleMode.kBrake);

        m_frontLift.setSoftLimit(SoftLimitDirection.kReverse, 5);
        m_backLift.setSoftLimit(SoftLimitDirection.kReverse, 5);

        m_Lift = new SpeedControllerGroup(m_frontLift, m_backLift);
    }

    public void LiftUp() 
    {
        m_Lift.set(RMap.liftSpeed);
	}
}
