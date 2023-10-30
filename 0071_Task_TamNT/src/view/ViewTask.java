/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import constant.Constant;
import controller.ManageTask;
import java.util.ArrayList;
import java.util.Date;
import model.Assignee;
import model.Task;
import utils.Utility;

/**
 *
 * @author ADMIN
 */
public class ViewTask {

    ManageTask manage = new ManageTask();

    private String getRequirementName() {
        String requirement = Utility.getString("Requirement Name: ", "Requirement "
                + "Name must be letters or digits", Constant.REGEX_STRING);
        return requirement;
    }

    private int getTaskType() {
        int result = Utility.getInteger("Enter task type: ", "It must be digits",
                1, 4);
        return result;
    }

    private double getFrom() {
        double from = Utility.getDouble("Enter from: ", "Wrong", 8, 17);
        return from;
    }

    private double getTo(double from) {
        double to = Utility.getDouble("Enter to: ", "Wrong", from + 0.5, 17.5);
        return to;
    }

    private String getReviewer() {
        String reviewer = Utility.getString("Enter reviewer: ", "Wrong", Constant.REGEX_STRING);
        return reviewer;
    }

    void deleteTask() {
        System.out.print("Nhập id of assignee: ");
        int idEmployee = Utility.getInteger("Enter id: ", "Error", 0, Integer.MAX_VALUE);
        Assignee selectedAssignee = manage.findAssById(idEmployee);

        if (selectedAssignee == null) {
            System.out.println("Assignee không tồn tại!");
            return;
        }

        // show ra assignee đó có những task nào đang list
        ArrayList<Task> tasks = selectedAssignee.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Assignee này không có task nào!");
            return;
        }
        System.out.println("Danh sách tasks của assignee:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getName()); // Giả sử Task có phương thức getName() để lấy tên task
        }

        System.out.print("");
        int taskIndex = Utility.getInteger("Chọn số thứ tự task để xóa: ",
                "Lỗi", 1, tasks.size()) - 1;

        selectedAssignee.removeTask(tasks.get(taskIndex));
        System.out.println("Đã xóa task thành công!");
    }


    void displayTask() {
    }

    void createAssignee() {
        //input name
        String name = Utility.getString("Enter name: ", "Error", Constant.REGEX_STRING);
        Assignee assignee = new Assignee(name);
        manage.addAssignee(assignee);
    }

    void createTask() {
        int idEmployee = Utility.getInteger("Enter id: ", "Error", 0, Integer.MAX_VALUE);
        //tim assignee dua tren id
        Assignee assignee = manage.findAssById(idEmployee);
        if (assignee != null) {
            //nhap thong tin cua task
            String name = getRequirementName();
            int type = getTaskType();
            double from = getFrom();
            double to = getTo(from);
            String reviewer = getReviewer();
            //check duplicate

            //tao doi tuong assignee
            Task task = new Task(assignee.getId(), name, type, from, to, reviewer);
            assignee.addTask(task);
        } else {
            System.out.println("NOT FOUND !!");
        }
    }

    public void displayAssignee() {
        if (manage.getListAssignee().isEmpty()) {
            System.out.println("Không có dữ liệu.");
            return;
        }

        for (Assignee assignee : manage.getListAssignee()) {
            System.out.println(assignee); // Hiển thị thông tin Assignee

            ArrayList<Task> tasks = assignee.getTasks();
            if (tasks.isEmpty()) {
                System.out.println(" --> Không có công việc nào được giao.");
                continue;
            }

            for (Task task : tasks) {
                System.out.println(" --> " + task); // Hiển thị thông tin Task của Assignee đó
            }
        }
    }

}
