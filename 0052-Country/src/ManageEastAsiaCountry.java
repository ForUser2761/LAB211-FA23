
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class ManageEastAsiaCountry {

    ArrayList<EastAsiaCountry> countryList;

    public ManageEastAsiaCountry() {
        countryList = new ArrayList<>();
        countryList.add(new EastAsiaCountry("VN", "Viet Nam", 1000, "A"));
        countryList.add(new EastAsiaCountry("IDN", "Indonesia", 1000, "A"));
        countryList.add(new EastAsiaCountry("TL", "Thai Lan", 1000, "A"));
        countryList.add(new EastAsiaCountry("SGP", "Singapore", 1000, "A"));
    }

    public void addCountry(EastAsiaCountry country) {
        countryList.add(country);
    }

    /**
     * Hàm này dùng để check duplicate code, nếu như bị duplicate => trả về giá
     * trị true, còn không duplicate thì trả về giá trị là false
     *
     * @param code
     * @return
     */
    boolean isDuplicateCode(String code) {
        //loop for each element in countryList
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            //check element's code equal code
            if (eastAsiaCountry.getCode().equalsIgnoreCase(code)) {
                //duplicate
                return true;
            }
        }
        return false;
    }

    boolean isDuplicateName(String name) {
        //loop for each element in countryList
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            //check element's code equal code
            if (eastAsiaCountry.getName().equalsIgnoreCase(name)) {
                //duplicate
                return true;
            }
        }
        return false;
    }

    ArrayList<EastAsiaCountry> searchByName(String name) {
        ArrayList<EastAsiaCountry> searchList = new ArrayList<>();
        //loop for each element in countryList
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            //check element's name contain name, ignore case
            if (eastAsiaCountry.getName().toUpperCase().contains(name.toUpperCase())) {
                searchList.add(eastAsiaCountry);
            }
        }
        return searchList;
    }

    void sortCountries(ArrayList<EastAsiaCountry> sortList) {
        Collections.sort(sortList, new Comparator<EastAsiaCountry>() {
            @Override
            public int compare(EastAsiaCountry o1, EastAsiaCountry o2) {
                //sap xep theo name
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

}
