/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */



public class Robot extends TimedRobot {
 
 XboxController ckController;
 DriveTrain ckDrive = new DriveTrain ();
 
  @Override
  public void robotInit() {

      ckController = new XboxController(0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

 
  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {



  }  
  

  @Override
  public void teleopPeriodic() {
    ckDrive.teleDriveCartesian(-ckController.getY(GenericHID.Hand.kRight),ckController.getX(GenericHID.Hand.kRight), ckController.getX(GenericHID.Hand.kLeft));
  }

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
