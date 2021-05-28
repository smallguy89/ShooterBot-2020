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

public class Turret extends SubsystemBase {
  /**
   * Creates a new Turret.
   */
  WPI_TalonSRX topWheel = new WPI_TalonSRX(0-9);
  WPI_TalonSRX bottomWheel = new WPI_TalonSRX(0-9);
  public Turret() {
    topWheel.configFactoryDefault();
    bottomWheel.configFactoryDefault();
  }
  public void spinTopWheel(double speed) {
    topWheel.set(ControlMode.PercentOutput, speed);
  }
  public void spinBottomWheel(double speed){
    bottomWheel.set(ControlMode.PercentOutput, speed);
  }
  public void stopWheel(){
    topWheel.set(ControlMode.PercentOutput, 0);
    bottomWheel.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
