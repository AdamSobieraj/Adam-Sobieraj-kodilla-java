package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {

    private String taskName;
    private String where;
    private String using;
    private boolean execute;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String executeTask() {
        return where + " "+ using;
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
