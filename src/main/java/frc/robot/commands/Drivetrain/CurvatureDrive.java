/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Drivetrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class CurvatureDrive extends CommandBase {
  /**
   * Creates a new CurvatureDrive.
   */
  Drivetrain m_drivetrain;
  private final DoubleSupplier m_speed;
  private final DoubleSupplier m_rotation;
  private final BooleanSupplier m_isQuickTurn;
  public CurvatureDrive(Drivetrain drivetrain, DoubleSupplier speed, DoubleSupplier rotation, BooleanSupplier isQuickTurn) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drivetrain;
    m_speed = speed;
    m_rotation = rotation;
    m_isQuickTurn = isQuickTurn;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.curvatureDrive(m_speed.getAsDouble(), m_rotation.getAsDouble(), m_isQuickTurn.getAsBoolean());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
