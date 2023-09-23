package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Constants.*;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Arm;

public class ArmPIDCommand extends CommandBase{
    
    private final Arm arm;
    private final String stage;

    public ArmPIDCommand(Arm arm, String stage){
        this.arm = arm;
        this.stage = stage;
        addRequirements(arm);
    }

    public void initialize(){

    }

    public void execute(){
        arm.setPreset(stage);
    }
    public void end(boolean interrupted){
        arm.stop();
    }
    public boolean isFinished(){
        return Math.abs(OperatorConstants.armExtendPresets.get(stage) - arm.getExtendPosition()) < 3 && 
                Math.abs(OperatorConstants.armRaisePresets.get(stage) - arm.getRaise1Position()) < 3 && 
                Math.abs(OperatorConstants.armRaisePresets.get(stage) - arm.getRaise2Position()) < 3;
    }
}
