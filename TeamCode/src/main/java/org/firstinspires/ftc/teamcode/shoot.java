package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class shoot extends LinearOpMode {

    private DcMotor shooter;

    @Override
    public void runOpMode() {

        shooter = hardwareMap.get(DcMotor.class, "shooterMotor");

        shooter.setDirection(DcMotor.Direction.REVERSE);
        shooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        double shooterPower = 0.0;
        double step = 0.02;

        waitForStart();

        while (opModeIsActive()) {

            // Increase power
            if (gamepad1.right_trigger > 0) {
                shooterPower += step * gamepad1.right_trigger;
            }

            // Decrease power
            if (gamepad1.left_trigger > 0) {
                shooterPower -= step * gamepad1.left_trigger;
            }

            // Clamp 0–1
            shooterPower = Math.max(0.0, Math.min(1.0, shooterPower));

            shooter.setPower(shooterPower);

            telemetry.addData("Right Trigger", gamepad1.right_trigger);
            telemetry.addData("Left Trigger", gamepad1.left_trigger);
            telemetry.addData("Shooter Power", shooterPower);
            telemetry.update();

            idle();
        }
    }
}
