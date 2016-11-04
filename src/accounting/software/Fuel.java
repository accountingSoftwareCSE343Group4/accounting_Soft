<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======

>>>>>>> refs/remotes/origin/FuelClass
package accounting.software;

/**
 *
 * @author Ahmet Alperen Bulut
 */
public class Fuel {
<<<<<<< HEAD



=======
/* fuelType - gasoline - diesel - autogas
    */
>>>>>>> refs/remotes/origin/FuelClass
 private String fuelType;
 private double fuelCapacity;
 private double  fuelAmount;
 private double buyingPrice;
 private double salePrice;
 private double tax;
 
<<<<<<< HEAD
 public  Fuel(String fuelType,double fuelCapacity,double fuelAmount){
=======
 public Fuel(){
    this.fuelType="";
    this.fuelCapacity=0;
    this.fuelAmount=0;
    this.buyingPrice=0;
    this.salePrice=0;
    this.tax=0;
 }
 public  Fuel(String fuelType,double fuelCapacity,double fuelAmount){
     
>>>>>>> refs/remotes/origin/FuelClass
    this.fuelCapacity=fuelCapacity;
    this.fuelAmount=fuelAmount;
    this.fuelType=fuelType;
 
 }
<<<<<<< HEAD
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
=======

    public String getFuelType() {
        return fuelType;
>>>>>>> refs/remotes/origin/FuelClass
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
<<<<<<< HEAD
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

=======
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
    
>>>>>>> refs/remotes/origin/FuelClass
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

<<<<<<< HEAD
=======
    public double getTax() {
        return tax;
    }
    
>>>>>>> refs/remotes/origin/FuelClass
    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
<<<<<<< HEAD
    public String toString() {
=======
    public String toString() {//added
>>>>>>> refs/remotes/origin/FuelClass
        return "Fuel{ " + "fuelType= " + fuelType + ", fuelCapacity= " + fuelCapacity + ", fuelAmount= " + fuelAmount + ", buyingPrice= " + buyingPrice + ", salePrice= " + salePrice + ", tax= " + tax + " }";
    }
   
}


