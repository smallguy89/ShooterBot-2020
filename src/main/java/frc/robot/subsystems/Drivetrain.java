/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  
  WPI_TalonSRX leftFront = new WPI_TalonSRX(0-9);
  WPI_TalonSRX leftBack = new WPI_TalonSRX(0-9);
  WPI_TalonSRX rightFront = new WPI_TalonSRX(0-9);
  WPI_TalonSRX rightBack = new WPI_TalonSRX(0-9);
  SpeedControllerGroup leftDrive = new SpeedControllerGroup(leftBack, leftFront);
  SpeedControllerGroup rightDrive = new SpeedControllerGroup(rightBack, rightFront);
  DifferentialDrive diffDrive = new DifferentialDrive(leftDrive, rightDrive);
  public Drivetrain() {
    leftBack.configFactoryDefault();
    leftFront.configFactoryDefault();
    rightBack.configFactoryDefault();
    rightFront.configFactoryDefault();
  }
  public void curvatureDrive(double speed, double rotation, Boolean isQuickTurn){
    diffDrive.curvatureDrive(speed, rotation, isQuickTurn);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
