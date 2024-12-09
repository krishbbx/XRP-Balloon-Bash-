// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

  //FIELDS
  private static Arm instanceArm; 
  // Task 3A. Declare the XRPServo motor here
  private XRPServo poker;

  //CONSTRUCTOR METHOD
  public Arm() {

    //Task 3B. Construct the XRPServo object here
    poker = new XRPServo(1);

  }

  //Arm singleton method
  public static Arm getInstance(){
    if(instanceArm == null){
      instanceArm = new Arm();
    }
    return instanceArm;
  }

  //Reset arm method - moves arm to a 0 degree angle
  public void resetArm(){
    
    //Task 3C. Set the XRPServo's angle to 0
    poker.setAngle(0);
  }

  //Task 3D. Write moveArm() method here - move arm to a specified angle
 


  
  // Periodic method - included in every subystem class
  // Place anything here that you want to be called once per scheduler run
  @Override
  public void periodic() {
    
  }
}
