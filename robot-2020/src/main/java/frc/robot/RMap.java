/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RMap 
{

// Drive Train
static int CANLeftFrontMotor = 12;
static int CANRightFrontMotor = 13;
static int CANLeftBackMotor = 14;
static int CANRightBackMotor = 10;

// Other Subsystem Motors
static int CANFerrisWheelMotor = 4;
static int CANShooterMotorLeft = 2;
static int CANShooterMotorRight = 1;
static int CANLiftMotorBack = 11;
static int CANLiftMotorFront = 9;

// Final Variables
static final double driveTrainDeadzone = 0.04;
static final double driveTrainMax = 0.8;
static final double gyroStraightKp = 0.065;
static final double maxSpeedIncrease = 0.03;
static final double maxSpeedDecrease = 0.08;
static final double liftSpeed = 0.4;

static boolean liftExtend = false;

// DIO (Digital Input Output)
static int screwSens = 0;
static int ballSens = 1;

}
