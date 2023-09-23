/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import constant.CommonConst;
import entity.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DoctorBO {

    List<Doctor> list;

    public DoctorBO() {
        list = FileProcess.readFromFile(CommonConst.FILE_NAME);
    }

    public List<Doctor> getList() {
        return list;
    }

    public boolean checkCodeExist(String code) {
        for (Doctor doctor : list) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public void addDoctor(Doctor doctor) {
        list.add(doctor);
    }

    public void writeToFile() {
        FileProcess.writeToFile(CommonConst.FILE_NAME, list);
    }

    public void loadData() {
        list = FileProcess.readFromFile(CommonConst.FILE_NAME);
    }

    public Doctor findDoctorByCode(String codeBeUpdate) {
        for (Doctor doctor : list) {
            if (doctor.getCode().equalsIgnoreCase(codeBeUpdate)) {
                return doctor;
            }
        }
        return null;
    }

    public void removeDoctor(Doctor doctor) {
        list.remove(doctor);
    }

    public List<Doctor> findDoctorByText(String text) {
        List<Doctor> listSearch = new ArrayList<>();
        for (Doctor doctor : list) {
            if (doctor.getCode().contains(text) || (doctor.getAvailability() + "").contains(text)
                    || doctor.getName().contains(text) || doctor.getSpecialization().contains(text)) {
                listSearch.add(doctor);
            }
        }
        return listSearch;
    }

}
