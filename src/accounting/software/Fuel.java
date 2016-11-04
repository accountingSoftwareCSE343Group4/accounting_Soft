/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

/**
 *
 * @author Ahmet Alperen Bulut
 */
public class Fuel {



 private String fuelType;
 private double fuelCapacity;
 private double  fuelAmount;
 private double buyingPrice;
 private double salePrice;
 private double tax;
 
 public  Fuel(String fuelType,double fuelCapacity,double fuelAmount){
    this.fuelCapacity=fuelCapacity;
    this.fuelAmount=fuelAmount;
    this.fuelType=fuelType;
 
 }
 public Fuel(){
 
 }
     public String getFuelType() {
        return fuelType;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
 	
}


