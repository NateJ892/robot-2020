/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID;

public class Robot extends TimedRobot 
{
 
 XboxController ckController;
 DriveTrain ckDrive = new DriveTrain ();
 Shooter ckShooter = new Shooter ();
 Lift ckLift = new Lift();

  @Override
  public void robotInit() 
  {
      ckController = new XboxController(0);   
  }

  @Override
  public void teleopPeriodic() 
  {
    ckDrive.teleDriveCartesian(-ckController.getY(GenericHID.Hand.kRight),ckController.getX(GenericHID.Hand.kRight), ckController.getX(GenericHID.Hand.kLeft));

    if (ckController.getTriggerAxis(Hand.kLeft)>0.5) ckShooter.shoot();
    if (ckController.getStartButtonReleased() == true) ckLift.LiftUp();
  }
}
