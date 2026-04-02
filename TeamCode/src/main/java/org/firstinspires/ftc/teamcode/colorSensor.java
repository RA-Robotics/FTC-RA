package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Purple Green Sensor Test", group = "Sensor")
public class colorSensor extends LinearOpMode
{
    private RevColorSensorV3 colorSensor;
    private DcMotor motor;

    @Override
    public void runOpMode()
    {
        colorSensor = hardwareMap.get(RevColorSensorV3.class, "colorSensor");
        motor = hardwareMap.get(DcMotor.class, "motor");

        telemetry.addLine("Ready");
        telemetry.addLine("Point sensor close to purple or green object");
        telemetry.update();

        waitForStart();

        while (opModeIsActive())
        {
            int red = colorSensor.red();
            int green = colorSensor.green();
            int blue = colorSensor.blue();

            // add some threshhold to get an accurate color reading
            boolean isGreen = (green > red * 1.3 && green > blue * 1.3 && green > 100);
            boolean isPurple = (blue > green && blue > red && red > 80);

            String detectedColor = "Unknown";

            if (isGreen)
            {
                detectedColor = "Green";
                motor.setTargetPosition(560);
            }
            else if (isPurple)
            {
                detectedColor = "Purple";
                motor.setTargetPosition(-560);
            }

            telemetry.addData("Detected", detectedColor);
            telemetry.addData("Red", red);
            telemetry.addData("Green", green);
            telemetry.addData("Blue", blue);
            telemetry.addData("Distance (cm)", "%.2f",
                    colorSensor.getDistance(org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit.CM));
            telemetry.update();
        }
    }
}