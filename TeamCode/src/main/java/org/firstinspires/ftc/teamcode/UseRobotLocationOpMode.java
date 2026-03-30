package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class UseRobotLocationOpMode extends OpMode {
    RobotLocationPractice robotLocationPractice = new RobotLocationPractice( 0);


    @Override
    public void init() {
        robotLocationPractice.setAngle(0);
        robotLocationPractice.setX(0);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            robotLocationPractice.turnRobot(0.1);
        }
       else if (gamepad1.b) {
            robotLocationPractice.turnRobot(-0.1);
        }

       if (gamepad1.dpad_left){
           robotLocationPractice.changeX(0.1);
       }
       else if (gamepad1.dpad_right){
           robotLocationPractice.changeX(-0.1);
       }
        if (gamepad1.dpad_down){
            robotLocationPractice.changeY(0.1);
        }
        else if (gamepad1.dpad_up){
            robotLocationPractice.changeY(-0.1);
        }

       telemetry.addData("Heading", robotLocationPractice.getHeading());
       telemetry.addData("Angle", robotLocationPractice.getAngle());
       telemetry.addData("X", robotLocationPractice.getX());
       telemetry.addData("Y", robotLocationPractice.getY());
    }
}

/*

1. add a double getAngle to your RobotLocationPractice, and display in your OpMode
2. inside RobotLocationPractice class,
- create a double x
- double getX()
- void changeX(double changeAmount)
- setX(double x)

3. inside your op mode
- when left dpad pressed add 0.1 to x
- when right dpad is pressed subtract 0.1 from x
- telemetry, display x value

4. add in support for y as well
- dpad up -0.1, dpad down 0.1
 */