/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSolenoid extends SubsystemBase {
  /**
   * Creates a new IntakeSolenoid.
   */
  DoubleSolenoid intakeSolenoid = new DoubleSolenoid(0-9, 0-9);
  public IntakeSolenoid() {
  }
  public void retractIntake(){
    intakeSolenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void extendIntake(){
    intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
