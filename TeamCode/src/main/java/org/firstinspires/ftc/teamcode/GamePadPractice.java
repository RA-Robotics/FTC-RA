package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Joystick + Button Motor Control", group = "Practice")
public class GamePadPractice extends OpMode
{
    private DcMotor motor;

    @Override
    public void init()
    {
        motor = hardwareMap.get(DcMotor.class, "motor");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
    }

    @Override
    public void loop()
    {
        double power;

        if (gamepad1.left_stick_y != 0 )
        {
            power = -gamepad1.left_stick_y;
        }
        else if (gamepad1.a)
        {
            power = 1.0;
        }
        else
        {
            power = 0.0;
        }

        motor.setPower(power);

        telemetry.addData("Power", power);
        telemetry.update();
    }
}