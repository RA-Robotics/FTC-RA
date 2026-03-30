package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Purple Green Sensor Test", group = "Sensor")
public class colorSensor extends LinearOpMode
{
    private RevColorSensorV3 colorSensor;

    @Override
    public void runOpMode()
    {
        colorSensor = hardwareMap.get(RevColorSensorV3.class, "colorSensor");

        telemetry.addLine("Ready");
        telemetry.addLine("Point sensor close to purple or green object");
        telemetry.update();

        waitForStart();

        while (opModeIsActive())
        {
            int red = colorSensor.red();
            int green = colorSensor.green();
            int blue = colorSensor.blue();

            String detectedColor = "Unknown";

            if (green > red && green > blue)
            {
                detectedColor = "Green";
            }
            else if (blue > green && red > green)
            {
                detectedColor = "Purple";
            }

            telemetry.addData("Detected", detectedColor);
            telemetry.addData("Red", red);
            telemetry.addData("Green", green);
            telemetry.addData("Blue", blue);
            telemetry.addData("Distance (cm)", "%.2f", colorSensor.getDistance(org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit.CM));
            telemetry.update();
        }
    }
}