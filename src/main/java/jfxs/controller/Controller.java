package jfxs.controller;

public class Controller implements ControllerStage{
    private StageControlller stageControlller;
    @Override
    public void setStageController(StageControlller stageController) {
        this.stageControlller = stageController;
    }
}
