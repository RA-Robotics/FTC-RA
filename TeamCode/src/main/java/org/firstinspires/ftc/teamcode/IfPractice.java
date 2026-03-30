package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfPractice extends OpMode {

    @Override
    public void init () {

    }

    @Override
    public void loop () {
        double motorSpeed = gamepad1.left_stick_y;

        if (!gamepad1.a) {
            motorSpeed *= 0.5;
        } else {
            motorSpeed *= 1;
        }


      telemetry.addData("Left Stick Value", motorSpeed);
    }
}
/*
1. make a turbo button. if the a button is NOT pressed, multiply the motor speed by 0.5, otherwise use the standard speed.
 */
/*
AND - && if (leftY < 0.5 && left Y> 0); {
OR || if (leftY < 0 || rightY <0); {
NOT ! if (!clawClosed); {

 */