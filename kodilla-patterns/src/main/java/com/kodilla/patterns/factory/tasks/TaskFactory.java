package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String DRIVING_TASK = "DRIVING TASK";
    public static final String PAINTING_TASK = "PAINTING TASK";
    public static final String SHOPPING_TASK = "SHOPPING TASK";

    public final Task makeTask(final String taskClass) {
        return switch (taskClass) {
            case DRIVING_TASK -> new DrivingTask("Deliver order 2334", "Poznań", "train");
            case PAINTING_TASK -> new PaintingTask("Painting order 3189", "blue", "door");
            case SHOPPING_TASK -> new ShoppingTask("Shopping order 0017", "new door", 1.0);
            default -> null;
        };
    }
}
