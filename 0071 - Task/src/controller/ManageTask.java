/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Task;

/**
 *
 * @author ADMIN
 */
public class ManageTask {

    ArrayList<Task> listTask;

    public ManageTask() {
        listTask = new ArrayList<>();
    }

    //ham de kiem tra xem tat ca cac thuoc tinh nhap vao co ko bi overlaps ko
    // => true => bi overlaps
    // => false => ko bi overlaps
    public boolean isOverlaps(Date date, String assignee, double from, double to) {

        //parameter: ki hieu la 2
        //task in list: ki hieu la 1
        for (Task task : listTask) {
            //if date and assignee of task equal to parameter then compare to plan To
            if (task.getDate().equals(date) && 
                    task.getAssignee().compareTo(assignee) == 0) {

                /*NOTE
            	 * from2 : parameter (user add on method "add task")
            	 * from1 : from of task already in list 
            	 * to2   : parameter ( user add on method "add task")
            	 * to1   : to of task already in list
            	 * */
                //if from2 < from1 && to2 > from1
                if (from < task.getPlanFrom() && to > task.getPlanFrom()) {
                    return true;
                }
                //if from2 = from1 => return true
                if (from == task.getPlanFrom()) {
                    return true;
                }
                // if from2 > from1 and from2 < to1=> return true
                if (from > task.getPlanFrom()
                        && from < task.getPlanTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addTask(String requirement, int taskType, Date date, double from, double to, String assignee, String reviewer) {
        Task task = new Task(taskType, requirement, date, from, to, assignee, reviewer);
        listTask.add(task);
    }

    public Task findTaskById(int idInput) {
        for (Task task : listTask) {
            if (task.getId() == idInput) {
                return task;
            }
        }
        return null;
    }

    public void removeTask(Task task) {
        listTask.remove(task);
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }

}
