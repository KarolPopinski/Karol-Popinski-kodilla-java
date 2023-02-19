package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private boolean isTaskExecuted;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {

        System.out.println(taskName + "" + whatToPaint + "" + color );
        isTaskExecuted = true;

    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (isTaskExecuted) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "PaintingTask{" +
                "taskName='" + taskName + '\'' +
                ", color='" + color + '\'' +
                ", whatToPaint='" + whatToPaint + '\'' +
                '}';
    }
}
