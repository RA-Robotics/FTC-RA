package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class GamePadPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        // runs 50x* a second
        double speedForwardLeft = -gamepad1.left_stick_y;
        double speedForwardRight = -gamepad1.right_stick_y;
        double diffXJoysticks = gamepad1.left_stick_x - gamepad1.right_stick_x;
        double sumTriggers = gamepad1.left_trigger + gamepad1.right_trigger;


        telemetry.addData("left x", gamepad1.left_stick_x);
        telemetry.addData("left y", speedForwardLeft);
        telemetry.addData("right x", gamepad1.right_stick_x);
        telemetry.addData("right y", speedForwardRight);
        telemetry.addData("difference x", diffXJoysticks);

        telemetry.addData("a button", gamepad1.a);
        telemetry.addData("b button", gamepad1.b);

        telemetry.addData("left trigger", gamepad1.left_trigger);
        telemetry.addData("right trigger", gamepad1.right_trigger);
        telemetry.addData("sum triggers", sumTriggers);




    }
    /*
    1. add telemetry for the right joystick
    2. add telemetry for the b button
    3. add telemetry data for the difference between left and right x joystick values.
    4. add telemetry data to report the sum of both rear triggers.
     */
}
