package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {

    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean execute;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String executeTask() {
        return color + " "+ whatToPaint;
    }

    @Override
    public boolean isTaskExecuter() {
        executeNewTask();
        return execute;
    }

    public void executeNewTask(){
        if(!execute){
            execute = true;
        }
    }
}
