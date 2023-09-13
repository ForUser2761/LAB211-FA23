
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class ViewCountry {

    ManageEastAsiaCountry manage = new ManageEastAsiaCountry();

    void inputCountry() {
        //check 11 country
        if (manage.countryList.size() >= 11) {
            System.out.println("Enough country !!");
            return;
        }
        
        //a. Require to input country information including (code, name, total area, terrain) .
        //code
        String code;
        while (true) {
            code = Utility.getString("Enter code: ", "Code must be string",
                    "[a-zA-Z0-9 ]+");
            //check duplicate code
            if (manage.isDuplicateCode(code) == true) {
                System.out.println("Duplicate code !!");
            } else {
                break;
            }
        }
        //name
        String name;
        while (true) {
            name = Utility.getString("Enter name: ",
                    "Name must be string", "[a-zA-Z0-9 ]+");
            //check duplicate name
            if (manage.isDuplicateName(name)) {
                System.out.println("Duplicate name !!");
            } else {
                break;
            }
        }
        float area = Utility.getFloat("Enter area: ", "Area must be number",
                1, Float.MAX_VALUE);
        String terrain = Utility.getString("Enter terrain: ",
                "Terrain must be string", "[a-zA-Z0-9 ]+");

        //tao doi tuong
        EastAsiaCountry country = new EastAsiaCountry(code, name, area, terrain);

        //Add data into the program
        manage.addCountry(country);
    }
    
    void display() {
        for (EastAsiaCountry eastAsiaCountry : manage.countryList) {
            eastAsiaCountry.display();
        }
    }

    void displayCountryJustInput() {
        //get ve country just input <=> quoc gia nam o index cuoi cung
        //index cuoi cung
        int lastIndex = manage.countryList.size() - 1;
        //get ra quoc gia dua tren index cuoi cung
        EastAsiaCountry country = manage.countryList.get(lastIndex);
        //display
        country.display();
    }

    void searchCountriesByName() {
        //input name
        String name = Utility.getString("Enter name: ",
                    "Name must be string", "[a-zA-Z0-9 ]+");
        //search country by name
        ArrayList<EastAsiaCountry> searchList = manage.searchByName(name);
        
        //not found
        if (searchList.isEmpty()) {
            System.out.println("Not found");
        }else {
            //found
            for (EastAsiaCountry eastAsiaCountry : searchList) {
                eastAsiaCountry.display();
            }
        }
    }

    void sortCountriesByName() {
        //sort
        ArrayList<EastAsiaCountry> sortList = new ArrayList<>();
        //them toan bo phan tu o trong countryList => sort LIst
        sortList.addAll(manage.countryList);
        //sort trong sortList
        manage.sortCountries(sortList);
        //display sortList
        for (EastAsiaCountry eastAsiaCountry : sortList) {
            eastAsiaCountry.display();
        }
    }

}
