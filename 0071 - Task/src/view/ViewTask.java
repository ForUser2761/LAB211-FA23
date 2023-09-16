/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import constant.Constant;
import controller.ManageTask;
import java.util.Date;
import model.Task;
import utils.Utility;

/**
 *
 * @author ADMIN
 */
public class ViewTask {

    ManageTask manage = new ManageTask();

    void inputTask() {
        //input information + check valid data
        //input properties
        System.out.println("------------Add Task---------------");
        String requirement = getRequirementName();
        int taskType = getTaskType();
        Date date = getDate();
        double from = getFrom();
        double to = getTo(from);
        String assignee = getAssignee();
        String reviewer = getReviewer();

        boolean isOverlap = manage.isOverlaps(date, assignee, from, to);
        if (isOverlap) {
            System.err.println("Overlap task");
        } else {
            System.out.println("Add successfull !");
        }
        //create instance

        //add to program
        manage.addTask(requirement, taskType, date, from, to, assignee, reviewer);

    }

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

    private Date getDate() {
        Date date = Utility.inputDateWithFormat("Input first date:",
                "Input must be in format dd-MM-yyyy", Constant.REGEX_DATE);
        return date;
    }

    private double getFrom() {
        double from = Utility.getDouble("Enter from: ", "Wrong", 8, 17);
        return from;
    }

    private double getTo(double from) {
        double to = Utility.getDouble("Enter to: ", "Wrong", from + 0.5, 17.5);
        return to;
    }

    private String getAssignee() {
        String assignee = Utility.getString("Enter assignee: ",
                "Wrong", Constant.REGEX_STRING);
        return assignee;
    }

    private String getReviewer() {
        String reviewer = Utility.getString("Enter reviewer: ", "Wrong", Constant.REGEX_STRING);
        return reviewer;
    }

    void deleteTask() {
        int idInput = Utility.getInteger("Enter id: ", "Wrong", 0, Integer.MAX_VALUE);

        Task task = manage.findTaskById(idInput);
        if (task == null) {
            System.out.println("NOT FOUND TASK !!");
        } else {
            manage.removeTask(task);
            System.out.println("Remove successful !!");
        }

    }

    void displayTask() {
        for (Task task : manage.getListTask()) {
            System.out.println(task);
        }
    }

}
