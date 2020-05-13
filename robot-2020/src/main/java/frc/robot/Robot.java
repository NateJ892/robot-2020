/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;

public class Robot extends TimedRobot 
{
 
 private XboxController ckController;
 private DriveTrain ckDrive = new DriveTrain ();
 private Shooter ckShooter = new Shooter ();
 private Lift ckLift = new Lift();
 private UsbCamera shooterCamera;

  @Override
  public void robotInit() 
  {
    ckController = new XboxController(0);

    CameraServer.getInstance().startAutomaticCapture();
    shooterCamera.setResolution(160, 120);
    shooterCamera.setFPS(15);
  }

  @Override
  public void teleopPeriodic() 
  {
    ckDrive.teleDriveCartesian(-ckController.getY(GenericHID.Hand.kRight),ckController.getX(GenericHID.Hand.kRight), ckController.getX(GenericHID.Hand.kLeft));

    if (ckController.getTriggerAxis(Hand.kLeft)>0.5) ckShooter.shoot();
    if (ckController.getStartButtonReleased() == true) ckLift.LiftUp();
  }
}
