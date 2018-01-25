package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class TaskMapperTestSuite {
    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Task title", "Task content");
        TaskMapper taskMapper = new TaskMapper();
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertEquals(1L, (long)task.getId());
        Assert.assertEquals("Task title", task.getTitle());
        Assert.assertEquals("Task content", task.getContent());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Task title", "Task content");
        TaskMapper taskMapper = new TaskMapper();
        TaskDto taskDto = new TaskDto(1L, "Task title", "Task content");
        //When
        TaskDto taskDtoMapped = taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertEquals(taskDto.getId(), taskDtoMapped.getId());
        Assert.assertEquals(taskDto.getTitle(), taskDtoMapped.getTitle());
        Assert.assertEquals(taskDto.getContent(), taskDtoMapped.getContent());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        LongStream.rangeClosed(1, 10)
                .forEach(n -> tasks.add(new Task(n, "Task no " + n, "Task no " + n + " content")));
        TaskMapper taskMapper = new TaskMapper();
        //When
        List<TaskDto> taskDtosMapped = taskMapper.mapToTaskDtoList(tasks);
        //Then
        Assert.assertEquals(10, taskDtosMapped.size());
    }
}
