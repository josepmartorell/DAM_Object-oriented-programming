/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import principal.Component;

/**
 *
 * @author jtech
 */
public class Vehicle implements Component{
    
    private String matricula;
    private String marca;
    private String model;
    private String color;

    public Vehicle(String matricula, String marca, String model, String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public static Vehicle addVehicle() {
        String matricula, marca, model, color;

        System.out.println("\nNIF del client o clienta:");
        matricula = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del client o clienta:");
        marca = DADES.nextLine();
        System.out.println("\nTelèfon del client o clienta:");
        model = DADES.next();
        System.out.println("\nCorreu electrònic del client o clienta:");
        color = DADES.next();

        return new Vehicle(matricula, marca, model, color);
    }

    @Override
    public void updateComponent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void showComponent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}

