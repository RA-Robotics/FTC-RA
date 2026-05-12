package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
@TeleOp(name = "Tank Drive TeleOp", group = "TeleOp")
public class drive  extends LinearOpMode {

    private DcMotor leftDriveMotor;
    private DcMotor rightDriveMotor;

    @Override

    // runs when the driver clicks init(basically gets all the morors and equipment ready)
    public void runOpMode() {

        // Initialize motors
        leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");

        // Reverse one side so both wheels move forward together
        leftDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        rightDriveMotor.setDirection(DcMotor.Direction.FORWARD);

        // Make sure motors don't try to use encoders
        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addLine("Ready to run");
        telemetry.update();

        waitForStart();

        // Runs When the driver clicks start
        while (opModeIsActive()) {

            // Tank drive controls
            double leftPower = -gamepad1.left_stick_y;
            double rightPower = -gamepad1.right_stick_y;

            // Apply power
            leftDriveMotor.setPower(leftPower);
            rightDriveMotor.setPower(rightPower);

            // Telemetry for debugging
            telemetry.addData("Left Power", leftPower);
            telemetry.addData("Right Power", rightPower);
            telemetry.update();
        }
    }
}
