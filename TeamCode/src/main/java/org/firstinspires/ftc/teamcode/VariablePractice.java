package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled

@TeleOp
public class VariablePractice extends OpMode {
    @Override
    public void init() {
        int teamNumber = 34323;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String name = "RAR";
        int motorAngle = 90;

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Claw Closed", clawClosed);
        telemetry.addData("Name", name);
        telemetry.addData("Motor Angle", motorAngle);

    }


    @Override
    public void loop() {
        /*
        1. change the string variable "name" to team name
        2. create an int variable called "motorAngle" and store an angle between 0 and 180. display this in your init method.

         */

    }
}
