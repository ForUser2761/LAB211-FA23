/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class EastAsiaCountry extends Country{
    private String terrain;

    public EastAsiaCountry() {
    }

    public EastAsiaCountry(String code, String name, float area, String terrain) {
        super(code, name, area);
        this.terrain = terrain;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @Override
    public void display() {
        super.display(); 
    }
    
    
    
}
