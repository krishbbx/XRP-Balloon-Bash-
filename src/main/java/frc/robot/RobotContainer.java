// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.StadiaController.Button;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArmReset;
// import frc.robot.commands.ArmSetAngle;
import frc.robot.commands.auto.AutonomousTime;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot commands are defined here...
  private final XRPOnBoardIO onboardIO = new XRPOnBoardIO();
  
  // Assumes a gamepad plugged into channel 0 in the Simulation popup
  private final Joystick controller = new Joystick(0);

  // Create SmartDashboard chooser for autonomous routines
  private final SendableChooser<Command> chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    // Sets a default command to do Arcade driving for the Drivetrain subystem
    Drivetrain.getInstance().setDefaultCommand( new ArcadeDrive(
      () -> -controller.getRawAxis(1), 
      () -> -controller.getRawAxis(2)
      ));
    
    // Binds the A button to the ArmReset command
    // Look at the Javadocs for JoystickButton: https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/wpilibj/Joystick.html
    new JoystickButton(controller, Button.kA.value).onTrue( new ArmReset() );
    
    //Bind button(s) to move the arm to different angle(s)



    //[Veteran Challenge] Arm moves with Trigger


      // Setup SmartDashboard options
      chooser.setDefaultOption("Auto Routine Distance", new AutonomousTime());
      chooser.addOption("Auto Routine Time", new AutonomousTime());
      SmartDashboard.putData(chooser);
  }

/**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }

}
