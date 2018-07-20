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


   /* @Test
    public void testGetAllTasks() {
        repository.deleteAll();

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
    }*/

    @Test
    public void testGetTaskById() {
        //Given
        Task task1 = new Task(1L, "Test1", "Content1");
        Task saveTask1 = dbService.saveTask(task1);
        //When
        Task result = dbService.getTaskById(saveTask1.getId());
        //Then
        assertEquals("Test1", result.getTitle());
        assertEquals("Content1", result.getContent());
        assertEquals(result.getId(), saveTask1.getId());
    }

    @Test
    public void testSaveTask() {
        //Given
        Task task1 = new Task(1L, "Test1", "Content1");
        //When
        Task saveTask1 = dbService.saveTask(task1);
        //Then
        assertEquals(task1.getTitle(), saveTask1.getTitle());
        assertEquals(task1.getContent(), saveTask1.getContent());
    }

    @Test
    public void testDeleteTask() {
        //Given
        Task task1 = new Task(1L, "Test1", "Content1");
        //When
        Task savetask1 = dbService.saveTask(task1);
        dbService.deleteTask(savetask1.getId());
        //Then
        assertNull(dbService.getTaskById(savetask1.getId()));
    }

    @Test
    public void testGetTask() {

        //Given
        Task testTask = new Task(1L, "test", "testing");
        Task saveTask = dbService.saveTask(testTask);

        //When
        Optional<Task> result = dbService.getTask(saveTask.getId());

        //Then
        assertEquals(result.get().getId(), saveTask.getId());
        assertEquals(result.get().getTitle(), "test");
        assertEquals(result.get().getContent(), "testing");

    }
}