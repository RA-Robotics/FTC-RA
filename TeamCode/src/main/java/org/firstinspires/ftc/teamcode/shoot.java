package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class shoot extends LinearOpMode {

    private DcMotor shooter;
    private DcMotor buffer;

    private double power = 0.0;

    private boolean prevRightTrigger = false;
    private boolean prevLeftTrigger = false;

    @Override
    public void runOpMode() {

        shooter = hardwareMap.get(DcMotor.class, "shooterMotor");
        buffer = hardwareMap.get(DcMotor.class, "bufferMotor");

        waitForStart();

        while (opModeIsActive()) {

            boolean currentRightTrigger = gamepad1.right_trigger > 0.1;
            boolean currentLeftTrigger = gamepad1.left_trigger > 0.1;

            if (gamepad1.y) {
                buffer.setPower(1.0);

            }
            else if (gamepad1.b) {
                buffer.setPower(0);
            }

            // if right trigger pressed power increases by 1/10
            if (currentRightTrigger && !prevRightTrigger) {
                power += 0.1;
            }

            // if the left trigger was pressed power goes down by 1/10
            if (currentLeftTrigger && !prevLeftTrigger) {
                power -= 0.1;
            }

            // turns off shooter
            if (gamepad1.right_bumper) {
                power = 0.0;
            }
            
            // clamp power between 0-1
            if (power > 1.0) power = 1.0;
            if (power < 0.0) power = 0.0;

            shooter.setPower(power);

            prevRightTrigger = currentRightTrigger;
            prevLeftTrigger = currentLeftTrigger;

            telemetry.addData("Shooter Power", power);
            telemetry.update();
        }
    }
}
