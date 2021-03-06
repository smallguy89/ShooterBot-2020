/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Turret;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TestAuto extends SequentialCommandGroup {
  /**
   * Creates a new TestAuto.
   */
  public TestAuto(Drivetrain drivetrain, Intake intake, Turret turret) {
    addCommands(new DriveIntake(drivetrain, intake).withTimeout(5), new Shoot(turret, intake).withTimeout(5));
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand()); super();
  }
}
