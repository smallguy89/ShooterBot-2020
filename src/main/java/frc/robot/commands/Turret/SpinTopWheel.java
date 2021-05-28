/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret;

public class SpinTopWheel extends CommandBase {
  /**
   * Creates a new SpinTopWheel.
   */
  Turret m_turret;
  
  public SpinTopWheel(Turret turret) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_turret = turret;
    addRequirements(turret);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_turret.spinTopWheel(0.25);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_turret.spinTopWheel(0.25);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.stopWheel();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
