package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test", "Testing");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        assertEquals(taskDto.getId(), task.getId());
        assertEquals("Test", task.getTitle());
        assertEquals("Testing", task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Test", "Testing");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        assertEquals(task.getId(), taskDto.getId());
        assertEquals("Test", taskDto.getTitle());
        assertEquals("Testing", taskDto.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "Test", "Testing");
        Task task2 = new Task(2L, "Test2", "Testing2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        //When
        List<TaskDto> taskDtoList= taskMapper.mapToTaskDtoList(taskList);
        assertEquals(2, taskDtoList.size());
    }
}