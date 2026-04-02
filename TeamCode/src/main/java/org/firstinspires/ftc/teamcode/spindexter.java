package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Purple Green Sensor Test", group = "Sensor")
public class spindexter extends LinearOpMode
{
    private RevColorSensorV3 colorSensor;
    private DcMotor motor;

    @Override
    public void runOpMode()
    {
        colorSensor = hardwareMap.get(RevColorSensorV3.class, "spindexter");
        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(1);

        telemetry.addLine("Ready");
        telemetry.update();

        waitForStart();

        while (opModeIsActive())
        {
            int red = colorSensor.red();
            int green = colorSensor.green();
            int blue = colorSensor.blue();

            boolean isGreen = (green > red * 1.3 && green > blue * 1.3 && green > 100);
            boolean isPurple = (blue > green && blue > red && red > 80);

            String detectedColor = "Unknown";

            if (isGreen)
            {
                detectedColor = "Green";
                motor.setTargetPosition(560);
                motor.setPower(1);
            }
            else if (isPurple)
            {
                detectedColor = "Purple";
                motor.setTargetPosition(-560);
                motor.setPower(1);
            }
            else
            {
                motor.setPower(0);
            }

            telemetry.addData("Detected", detectedColor);
            telemetry.addData("Red", red);
            telemetry.addData("Green", green);
            telemetry.addData("Blue", blue);
            telemetry.addData("Target", motor.getTargetPosition());
            telemetry.addData("Current", motor.getCurrentPosition());
            telemetry.addData("Distance (cm)", "%.2f",
                    colorSensor.getDistance(org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit.CM));
            telemetry.update();
        }
    }
}