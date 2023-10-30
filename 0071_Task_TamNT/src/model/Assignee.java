package model;

import java.util.ArrayList;

public class Assignee {

    private int id;
    private String name;
    private ArrayList<Task> tasks;
    private static int autoIncrement = 1;
    public Assignee() {
        id = autoIncrement++;
        tasks = new ArrayList<>();
    }

    public Assignee(String name) {
        this.id = autoIncrement++;
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public String toString() {
        return "Assignee{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", tasks=" + tasks
                + '}';
    }
}
