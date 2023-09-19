/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Employee {

    private String id, firstName, lastName, phone, email, address, agency;
    private Date DOB;
    private int sex;
    private double salary;

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Employee(String id, String firstName, String lastName, String phone, String email, String address, Date DOB, String agency, int sex, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.agency = agency;
        this.sex = sex;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSexString() {
        String result = null;
        switch(sex) {
            case 1:
                result = "Male";
                break;
            case 0:
                result = "Female";
                break;
        }
        return  result;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s",
                id,firstName, lastName, phone, email, address, DOB, getSexString(), salary, agency);
    }



}
