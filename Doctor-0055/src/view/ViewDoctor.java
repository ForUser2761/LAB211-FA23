/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bo.DoctorBO;
import bo.FileProcess;
import constant.CommonConst;
import entity.Doctor;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ViewDoctor {

    DoctorBO bo = new DoctorBO();

    void addDoctor() {
        //input properties
        System.out.println("--------- Add Doctor ----------");
        String code;
        while (true) {
            // regex:
            // a-z: matches a character from a -z
            // A-Z: matches a character from A - Z
            // 0-9: matches a character from 0-9
            // + : Match 1 or more preceding token
            code = GetInput.getString("Enter Code: ", "Code must be a string", "[a-zA-Z0-9 ]+");
            if (bo.checkCodeExist(code) == true) {
                System.out.println("Invalid of Code! Code was exited in system!");
            } else {
                break;
            }
        }
        String name = GetInput.getString("Enter Name: ",
                "It must be a string ", "[a-zA-Z ]+");
        String specialization = GetInput.getString("Specialization: ",
                "It must be a string", "[a-zA-Z ]+");
        int availability = GetInput.getInteger("Availability: ",
                "It must be a decimal postive integer ", 1,
                Integer.MAX_VALUE);

        //create instance
        Doctor doctor = new Doctor(code, name, specialization, availability);
        //add to list
        bo.addDoctor(doctor);

        //write to file
        bo.writeToFile();
    }

    void updateDoctor() {
        //load data to file
        bo.loadData();
        //input code
        String codeBeUpdate = GetInput.getString("Enter Code: ",
                "Code must be a string", "[a-zA-Z0-9 ]+");

        //find doctor by code
        Doctor doctor = bo.findDoctorByCode(codeBeUpdate);
        //doctor = null => not found
        if (doctor == null) {
            System.out.println("Not found !!");
        } else {
            //update
            String codeWillUpdate;
            while (true) {
                // regex:
                // a-z: matches a character from a -z
                // A-Z: matches a character from A - Z
                // 0-9: matches a character from 0-9
                // + : Match 1 or more preceding token
                codeWillUpdate = GetInput.getString("Enter Code: ", "Code must be a string", "[a-zA-Z0-9 ]+");
                if (bo.checkCodeExist(codeWillUpdate) == true) {
                    System.out.println("Invalid of Code! Code was exited in system!");
                } else {
                    break;
                }
            }
            String name = GetInput.getString("Enter Name: ",
                    "It must be a string ", "[a-zA-Z ]+");
            String specialization = GetInput.getString("Specialization: ",
                    "It must be a string", "[a-zA-Z ]+");
            int availability = GetInput.getInteger("Availability: ",
                    "It must be a decimal postive integer ", 1,
                    Integer.MAX_VALUE);

            //update
            doctor.setCode(codeWillUpdate);
            doctor.setName(name);
            doctor.setSpecialization(specialization);
            doctor.setAvailability(availability);

            //write to file
            bo.writeToFile();
        }

    }

    void showData() {
        bo.loadData();
        for (Doctor doctor : bo.getList()) {
            System.out.println(doctor);
        }

    }

    void deleteDoctor() {
        //load data to file
        bo.loadData();
        //input code
        String codeBeUpdate = GetInput.getString("Enter Code: ",
                "Code must be a string", "[a-zA-Z0-9 ]+");

        //find doctor by code
        Doctor doctor = bo.findDoctorByCode(codeBeUpdate);
        //doctor = null => not found
        if (doctor == null) {
            System.out.println("Not found !!");
        } else {
            bo.removeDoctor(doctor);

            bo.writeToFile();
        }
    }

    void searchDoctor() {
        String text = GetInput.getString("Enter text: ", "It must be a string", "[0-9A-Za-z ]+");
        //search data
        List<Doctor> listSearch = bo.findDoctorByText(text);
        //list empty
        if (listSearch.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println("--------- Result ------------");
            String format = String.format("%-7s%-12s%-18s%s", "Code",
                    "Name", "Specialization", "Availability");
            System.out.println(format);
            for (Doctor doctor : listSearch) {
                System.out.println(doctor);
            }
        }

    }

}
