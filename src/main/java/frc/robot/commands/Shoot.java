/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Turret;
import frc.robot.commands.Intake.SpinCenterIntake;
import frc.robot.commands.Turret.SpinTurretWheels;
import frc.robot.subsystems.Intake;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Shoot extends ParallelCommandGroup {
  /**
   * Creates a new Shoot.
   */
  public Shoot(Turret turret, Intake intake) {
    addCommands(new SpinTurretWheels(turret), new SpinCenterIntake(intake));
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();
  }
}
