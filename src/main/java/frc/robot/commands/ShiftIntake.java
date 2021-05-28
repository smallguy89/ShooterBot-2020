/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSolenoid;

public class ShiftIntake extends CommandBase {
  /**
   * Creates a new ShiftIntake.
   */
  IntakeSolenoid m_intakeSolenoid;
  public ShiftIntake(IntakeSolenoid intakeSolenoid) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intakeSolenoid = intakeSolenoid;
    addRequirements(intakeSolenoid);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intakeSolenoid.extendIntake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSolenoid.retractIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
