/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ShiftIntake;
import frc.robot.commands.TestAuto;
import frc.robot.commands.Drivetrain.CurvatureDrive;
import frc.robot.commands.Intake.SpinIntake;
import frc.robot.commands.Turret.SpinTopWheel;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeSolenoid;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Turret;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  private final Turret turret;
  private final Intake intake;
  private final Drivetrain drivetrain;
  private final IntakeSolenoid intakeSolenoid;
  private final Limelight limelight;
  private final Joystick throttleStick;
  private final Joystick curveStick;
  private final Joystick buttonStick;
  private final JoystickButton isQuickTurnButton;
  private final Command testAuto;
  public RobotContainer() {
    turret = new Turret();
    intake = new Intake();
    drivetrain = new Drivetrain();
    testAuto = new TestAuto(drivetrain, intake, turret);
    intakeSolenoid = new IntakeSolenoid();
    limelight = new Limelight();
    throttleStick = new Joystick(0);
    curveStick = new Joystick(1);
    buttonStick = new Joystick(2);
    isQuickTurnButton = new JoystickButton(curveStick, 0-9);
    drivetrain.setDefaultCommand(new CurvatureDrive(drivetrain, ()->throttleStick.getY(), ()->curveStick.getX(), ()->isQuickTurnButton.get()));
    configureButtonBindings();       // last thing
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(buttonStick, 0-9).whileHeld(new SpinTopWheel(turret));
    new JoystickButton(buttonStick, 0-9).whileHeld(new SpinIntake(intake));
    new JoystickButton(buttonStick, 0-9).toggleWhenPressed(new ShiftIntake(intakeSolenoid));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return testAuto;
  }
}
