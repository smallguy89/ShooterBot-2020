/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  WPI_TalonSRX intakeTop = new WPI_TalonSRX(0-9);
  WPI_TalonSRX intakeBottom = new WPI_TalonSRX(0-9);
  WPI_TalonSRX centerSpin = new WPI_TalonSRX(0-9);
  public Intake() {
    intakeTop.configFactoryDefault();
    intakeBottom.configFactoryDefault();
    centerSpin.configFactoryDefault();
  }
  public void spinCenter(){
    centerSpin.set(ControlMode.PercentOutput, 0.25);
  }
  public void spin(){
    intakeBottom.set(ControlMode.PercentOutput, 0.25);
    intakeTop.set(ControlMode.PercentOutput, -0.25);
    centerSpin.set(ControlMode.PercentOutput, -0.25);
  }
  public void stop(){
    intakeBottom.set(ControlMode.PercentOutput, 0);
    intakeTop.set(ControlMode.PercentOutput, 0);
    centerSpin.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
