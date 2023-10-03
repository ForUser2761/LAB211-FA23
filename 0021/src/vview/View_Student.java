/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vview;

import controller.Manage;
import model.Student;

public class View_Student {
    Manage manage = new Manage();
    void createStudent() {
        String id, name;
        int semester, course;
        //input information
        id = getId();
        //check 1ID - 1Name
        //tim kiem ban ghi dua tren id
        Student studentById = manage.getStudentById(id);
        // studentById = null => enter name
        if (studentById == null) {
            name = getName();
            //else student != null => display name
        }else {
            name = studentById.getName();
            System.out.println("Enter name: " + name);
        }
        semester = getSemester();
        course = getCourse();
        
        //check duplicate
        boolean checkDuplicate = manage.checkDuplicate(id, name, semester, course);
        
        //not duplicate
        if (!checkDuplicate) {
            //create instance and add to list
            manage.addStudent(id, name,semester, course);
            // duplicate
        }else {
            System.out.println("DUPLICATE !!!");
            
        }
        
    }

    private String getId() {
        String id = Utility.getString("Enter id: ", "Wrong", Utility.REGEX_STRING);
        return id;
    }

    private String getName() {
        String name = Utility.getString("Enter name: ", "Wrong", Utility.REGEX_STRING);
        return name;
    }

    private int getSemester() {
        int semester = Utility.getInt("Enter semester: ", "Wrong", 1, 10);
        return semester;
    }

    private int getCourse() {
        int course = Utility.getInt("Enter course\n (1.Java || 2. .Net || 3. C/C++): ",
                "Wrong", 1, 3);
        return course;
    }

}
