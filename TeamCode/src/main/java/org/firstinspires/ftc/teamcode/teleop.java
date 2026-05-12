package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Teleop", group = "TeleOp")
public class teleop extends LinearOpMode {

    private DcMotor leftDriveMotor;
    private DcMotor rightDriveMotor;

    private DcMotor shooter;
    private DcMotor buffer;

    private double power = 0.0;

    private boolean prevRightTrigger = false;
    private boolean prevLeftTrigger = false;

    @Override
    public void runOpMode() {

        leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");

        shooter = hardwareMap.get(DcMotor.class, "shootMotor");
        buffer = hardwareMap.get(DcMotor.class, "intakeMotor");

        leftDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        rightDriveMotor.setDirection(DcMotor.Direction.FORWARD);

        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addLine("Ready to run");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            double leftPower = -gamepad1.left_stick_y;
            double rightPower = -gamepad1.right_stick_y;

            leftDriveMotor.setPower(leftPower);
            rightDriveMotor.setPower(rightPower);

            boolean currentRightTrigger = gamepad1.right_trigger > 0.1;
            boolean currentLeftTrigger = gamepad1.left_trigger > 0.1;

            if (gamepad1.y) {
                buffer.setPower(1.0);
            }
            else if (gamepad1.b) {
                buffer.setPower(0);
            }

            if (currentRightTrigger && !prevRightTrigger) {
                power += 0.1;
            }

            if (currentLeftTrigger && !prevLeftTrigger) {
                power -= 0.1;
            }

            if (gamepad1.right_bumper) {
                power = 0.0;
            }

            if (power > 1.0) power = 1.0;
            if (power < 0.0) power = 0.0;

            shooter.setPower(power);

            prevRightTrigger = currentRightTrigger;
            prevLeftTrigger = currentLeftTrigger;

            telemetry.addData("Left Drive Power", leftPower);
            telemetry.addData("Right Drive Power", rightPower);
            telemetry.addData("Shooter Power", power);
            telemetry.update();
        }
    }
}