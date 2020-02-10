/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.util.Units;
/**
 * Add your docs here.
 */
public class Unit {
    public final double V = 1; //初速測量
    final double h = 249.0;
    
    public double toSlugs(double Kg){
        return Kg/14.593903;
    }
    public double metersToFeet​(double meters){
        return meters/0.3048;
    }
}
