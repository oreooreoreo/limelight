/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
/**
 * Add your docs here.
 */
public class angle {
    final double V = 1;
    final double h = 249.0;
    public double θ;
    final double g = 9.8;
    Robot d = new Robot();
    double distence = d.dist;
    final double tar = 1; //limelight 高度
    double a, b, c;
    double θ1, θ2;
    
    public double geta(){
        return a = tar-h;
    }

    public double getb(){
        return b = distence;
    }

    public double getc(){
        return c = 0.5*g*distence*distence/V*V;
    }
    
    public void getθ1(double a, double b, double c){
        θ1 = Math.atan(((b + Math.sqrt(b*b-4*a*c-4*c*c))/2*c));
        θ2 = Math.atan(((b - Math.sqrt(b*b-4*a*c-4*c*c))/2*c));
        if (θ1 > θ2){
            θ = θ2;
        }
    }
}


