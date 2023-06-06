package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class TodosTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям Хлеб");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения Хлеб",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void TestWhenfewTask() {

        Task[] expected = {simpleTask,};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestWhenNotTask() {

        Task[] expected = {};
        Task[] actual = todos.search("Бабушке");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestWhenOneTask() {

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void NoTaskAtAll() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(actual, expected);
    }


    @Test
    public void MakeAllTasks() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(actual, expected);
    }


}
