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
/* fuelType - gasoline - diesel - autogas
    */
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

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    } 
        
    public double getFuelCapacity() {
        return fuelCapacity;
    }
    
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
    
    public double getFuelAmount() {
        return fuelAmount;
    }
    
    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    
    public double getBuyingPrice() {
        return buyingPrice;
    }
    
    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }
    
    public double getSalePrice() {
        return salePrice;
    }
    
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getTax() {
        return tax;
    }
    
    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Fuel{ " + "fuelType= " + fuelType + ", fuelCapacity= " + fuelCapacity + ", fuelAmount= " + fuelAmount + ", buyingPrice= " + buyingPrice + ", salePrice= " + salePrice + ", tax= " + tax + " }";
    }
   
}


