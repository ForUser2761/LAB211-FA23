/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import constant.Constant;
import entity.Employee;

import utils.Ultility;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
class View_Employee {

    public void inputEmployee(List<Employee> listEmployees) {
        //input information
        //input id
        String id;
        //loop until id input not duplicate
        while (true) {
            id = getID();
            if (checkDuplicate(id, listEmployees)) {
                System.out.println("Duplicate ID !!");
            } else {
                break;
            }
        }
        String firstName = getFirstName();
        String lastName = getLastName();
        String phone = getPhone();
        String email = getEmail();
        String address = getAddress();
        Date DOB = getDOB();
        int sex = getSex();
        double salary = getSalary();
        String agency = getAgency();

        Employee employee = new Employee(id, firstName, lastName, phone, email, address, DOB, agency, sex, salary);
        listEmployees.add(employee);
    }

    private boolean checkDuplicate(String id, List<Employee> listEmployees) {
        for (Employee employee:
             listEmployees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }


    private String getID() {
        String id = Ultility.getString("Enter id: ", Constant.REGEX_STRING, "ID must be string");
        return id;
    }

    private String getFirstName() {
        String firstName = Ultility.getString("Enter firstName: ", Constant.REGEX_STRING, "firstName must be string");
        return firstName;
    }

    private String getLastName() {
        String lastName = Ultility.getString("Enter lastName: ", Constant.REGEX_STRING, "lastName must be string");
        return lastName;
    }

    private String getPhone() {
        String phone = Ultility.getString("Enter phone: ", Constant.REGEX_PHONE, "phone must be string");
        return phone;
    }

    private String getEmail() {
        String email = Ultility.getString("Enter email: ", Constant.REGEX_EMAIL, "email must be string");
        return email;
    }

    private String getAddress() {
        String address = Ultility.getString("Enter address: ", Constant.REGEX_STRING, "address must be string");
        return address;
    }

    private Date getDOB() {
        Date DOB = Ultility.inputDateWithFormat("Enter DOB: " , "Date must be in format dd/MM/yyyy",
                Constant.REGEX_DATE);
        return DOB;
    }

    private int getSex() {
        int sex = Ultility.getInteger("Enter sex (1: male; 0: female)", "Must be digit", 0 , 1);
        return sex;
    }

    private double getSalary() {
        double salary = Ultility.getDouble("Enter salary: ", "Must be digit",0, Double.MAX_VALUE);
        return salary;
    }

    private String getAgency() {
        String agency = Ultility.getString("Enter agency: ", Constant.REGEX_STRING, "ID must be string");
        return agency;
    }

    public void removeEmployee(List<Employee> listEmployees) {
        String id = getID();
        //search
        Employee employee = findEmployeeById(id, listEmployees);

        if (employee == null) {
            System.out.println("NOT FOUND");
        }else {
            listEmployees.remove(employee);
            System.out.println("REMOVE SUCCESSFULL !");
        }
    }

    private Employee findEmployeeById(String id, List<Employee> listEmployees) {
        for (Employee employee : listEmployees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;

    }

    public void updateEmployee(List<Employee> listEmployees) {
        //input id
        String id = getID();
        //search employee by id
        Employee employee = findEmployeeById(id, listEmployees);
        if (employee == null) {
            System.out.println("NOT FOUND");
            return;
        }


        if (checkWantToUpdate("first name")) {
            String firstName = getFirstName();
            employee.setFirstName(firstName);
        }
        if (checkWantToUpdate("last name")) {
            String lastName = getLastName();
            employee.setLastName(lastName);
        }
        if (checkWantToUpdate("phone")) {
            String phone = getPhone();
            employee.setPhone(phone);
        }
        if (checkWantToUpdate("email")) {
            String email = getEmail();
            employee.setEmail(email);
        }
        if (checkWantToUpdate("address")) {
            String address = getAddress();
            employee.setAddress(address);
        }
        if (checkWantToUpdate("DOB")) {
            Date DOB = getDOB();
            employee.setDOB(DOB);
        }
        if (checkWantToUpdate("sex")) {
            int sex = getSex();
            employee.setSex(sex);
        }
        if (checkWantToUpdate("salary")) {
            double salary = getSalary();
            employee.setSalary(salary);
        }
        if (checkWantToUpdate("agency")) {
            String agency = getAgency();
            employee.setAgency(agency);
        }

    }

    private boolean checkWantToUpdate(String property) {
        String result = Ultility.getString("Do you want to update " + property + " ?: ",
                Constant.REGEX_YN, "Wrong");
        if (result.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }
}
