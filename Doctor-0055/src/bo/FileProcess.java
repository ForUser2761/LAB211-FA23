/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import entity.Doctor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class FileProcess {

    public static void writeToFile(String fileName, List<Doctor> list) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            //viet vao file
            fileWriter = new FileWriter(fileName, false);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Doctor Doctor1 : list) {
                bufferedWriter.write(Doctor1.toString());
                bufferedWriter.newLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static List<Doctor> readFromFile(String fileName) {
        File file = new File(fileName);
        //kiem tra xem file co ton tai hay ko
        if (!file.exists()) {
            try {
                // tao moi file
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        List<Doctor> list = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            while (true) {
                String line = bufferedReader.readLine();
                //neu co du lieu thi chung ta moi doc
                //1,ABC,123
                if (line != null) {
                    String[] data = line.split("[,]");
                    //index 0:
                    String code = data[0].trim();
                    //index 1:
                    String name = data[1].trim();
                    //index 2:
                    String speci = data[2].trim();
                    //index 3:
                    int availability = Integer.parseInt(data[3].trim());
                    
                    //create instance
                    Doctor Doctor = new Doctor(code, name, speci, availability);
                    //add to list
                    list.add(Doctor);
                } else {
                    break;
                }

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }
}
