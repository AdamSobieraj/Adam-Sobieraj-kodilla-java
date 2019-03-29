package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING);
        //Then
        Assert.assertTrue("true", drivingTask.isTaskExecuter());
        Assert.assertEquals("London Car",drivingTask.executeTask());
        Assert.assertEquals("Driving", drivingTask.getTaskName());
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING);
        //Then
        Assert.assertTrue("true", paintingTask.isTaskExecuter());
        Assert.assertEquals("Red View",paintingTask.executeTask());
        Assert.assertEquals("Painting", paintingTask.getTaskName());
    }

    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING);
        //Then
        Assert.assertTrue("true", shoppingTask.isTaskExecuter());
        Assert.assertEquals("Milk 20.0",shoppingTask.executeTask());
        Assert.assertEquals("Shopping", shoppingTask.getTaskName());
    }
}
