package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DbServiceTest {

    @Autowired
    DbService dbService;

    @Autowired
    private TaskRepository repository;

    @Test
    public void testGetAllTasks() {

        //Given
        Task task1 = new Task(1L, "Test1", "Content1");
        Task task2 = new Task(2L, "Test2", "Content2");
        repository.save(task1);
        repository.save(task2);

        //When
        List<Task> result = dbService.getAllTasks();
        //Then
        assertEquals(2,result.size());

        //CleanUp
        repository.deleteAll();
    }

    @Test
    public void testGetTask() {
        //Given
        Task task1 = new Task(1L, "Test1", "Content1");
        Task task2 = new Task(2L, "Test2", "Content2");
        Task task3 = new Task(3L, "Test3", "Content3");
        repository.save(task1);
        repository.save(task2);
        repository.save(task3);
        //When
        Optional<Task> result = dbService.getTask(1L);
        //Then
        assertFalse(result.isPresent());
        //Clean Up
        repository.deleteAll();
    }

    @Test
    public void testSaveTask() {
    }

    @Test
    public void testDeleteTask() {
    }
}