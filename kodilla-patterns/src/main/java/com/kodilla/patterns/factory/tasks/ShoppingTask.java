package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean isTaskExecuted;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println(taskName + "" + whatToBuy + "" + quantity + "pieces");
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
        return "ShoppingTask{" +
                "taskName='" + taskName + '\'' +
                ", whatToBuy='" + whatToBuy + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
