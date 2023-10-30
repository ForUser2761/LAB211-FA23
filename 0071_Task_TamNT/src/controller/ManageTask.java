/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Assignee;
import model.Task;

/**
 *
 * @author ADMIN
 */
public class ManageTask {

    private ArrayList<Assignee> listAssignee;

    public ArrayList<Assignee> getListAssignee() {
        return listAssignee;
    }

    public ManageTask() {
        listAssignee = new ArrayList<>();
        mockData();
    }

    public void mockData() {
        // Tạo Assignee 1
        Assignee assignee1 = new Assignee("Nguyen Van A");
        Task task1 = new Task(assignee1.getId(), "Phân tích yêu cầu", 1, 8.0, 12.0, "Le Thi B");
        Task task2 = new Task(assignee1.getId(), "Lập trình", 2, 13.0, 18.0, "Le Thi B");
        assignee1.addTask(task1);
        assignee1.addTask(task2);
        listAssignee.add(assignee1);

        // Tạo Assignee 2
        Assignee assignee2 = new Assignee("Tran Van C");
        Task task3 = new Task(assignee2.getId(), "Thiết kế giao diện", 3, 8.5, 11.5, "Nguyen Thi D");
        Task task4 = new Task(assignee2.getId(), "Kiểm thử", 4, 13.5, 17.0, "Nguyen Thi D");
        assignee2.addTask(task3);
        assignee2.addTask(task4);
        listAssignee.add(assignee2);
    }

    public void addAssignee(Assignee assignee) {
        listAssignee.add(assignee);
    }

    public Assignee findAssById(int idEmployee) {
        for (Assignee assignee : listAssignee) {
            if (assignee.getId() == idEmployee) {
                return assignee;
            }
        }
        return null;
    }

}
