/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.ArrayList;
import model.Student;

public class Manage {
    ArrayList<Student> listStudent;

    public Manage() {
        listStudent = new ArrayList<>();
        listStudent.add(new Student("1", "Nguyen Van A", 1, 2));
        listStudent.add(new Student("2", "Nguyen Van B", 1, 2));
        listStudent.add(new Student("1", "Nguyen Van A", 1, 2));
        listStudent.add(new Student("2", "Nguyen Van B", 1, 2));
    }

    public Student getStudentById(String id) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean checkDuplicate(String id, String name, int semester, int course) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)  
                   && student.getName().equalsIgnoreCase(name)
                    && student.getSemester() == semester
                    && student.getCourse() == course) {
                return true;
            }
        }
        return  false;
    }

    public void addStudent(String id, String name, int semester, int course) {
        Student student = new Student(id, name, semester, course);
        listStudent.add(student);
    }
    
    
    
}
