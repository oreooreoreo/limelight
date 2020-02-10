/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    private final XboxController m_stick = new XboxController(0);
    double limelightturn;
    double kp = 0.4 / 28.5;
  
    double ADCd = 1*1*0.47;
    static double Fd(double k, double ADCd, double V){       //k:常數 A:面積 D:空氣密度 Cd:阻力係數
      return k*ADCd*V*V;
    }

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-unicorn");
  
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    public double x, y, area,d,p;
    private VictorSPX L1 = new VictorSPX(1);
    private VictorSPX L2 = new VictorSPX(2);
    private VictorSPX R1 = new VictorSPX(3);
    private VictorSPX R2 = new VictorSPX(4);
    final double g = 9.8;
    int Vx = 1 ; //水平速度 定值 <--if不考慮阻力
    int t;
    final double V = 1;
    final double h = 249.0;
    double θ;
    /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    x = tx.getDouble(0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);
    d = (205-73)/Math.tan(Math.toRadians(39
    +y));
    p = ((d-135)/135)*0.1 + 0.6;
      
  //R2.set(ControlMode.PercentOutput, p);

    //post to smart dashboard periodiXcally
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("Limelightd", d);
    SmartDashboard.putNumber("Limelightp", p);
    SmartDashboard.putNumber("LimelightArea", area);

    //R2.set(ControlMode.PercentOutput, m_stick.getTriggerAxis(Hand.kRight));
    R2.set(ControlMode.PercentOutput, -p);



  }

  @Override
  public void teleopInit() {

 
    }
    
        
  
  

  @Override
  public void teleopPeriodic() {
    
    x = tx.getDouble(0);
    y = ty.getDouble(0.0);
    area = ta.getDouble(0.0);

    d = (205-73)/Math.tan(Math.toRadians(25+y));
    limelightturn = kp*x;
    
    R1.set(ControlMode.PercentOutput, -limelightturn);

    //post to smart dashboard periodiXcally
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("Limelightd", d);
    SmartDashboard.putNumber("LimelightArea", area);
    
    SmartDashboard.putNumber("joystick",-m_stick.getY(Hand.kLeft));
  }

  public int method(int d) {
    return t = d/Vx;
  }

  double angle = Math.sinh(Vx);
  double Vy = Math.cos(Math.toDegrees(angle));
  double v = Vx*Vx + Vy*Vy ;
  double Fd = Fd(1,ADCd,0);
  public double phy(double d){
    double k = 1/(Math.sqrt((Math.pow(V,4)) * (Math.pow(h,2))+ Math.pow(d,2))); 
    double rep = Math.acos(V*V*y*k);
    return θ = 1; 
  }
    
  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
