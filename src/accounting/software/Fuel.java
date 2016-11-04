
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
 
 public Fuel(){
    this.fuelType="";
    this.fuelCapacity=0;
    this.fuelAmount=0;
    this.buyingPrice=0;
    this.salePrice=0;
    this.tax=0;
 }
 public  Fuel(String fuelType,double fuelCapacity,double fuelAmount){
     
    this.fuelCapacity=fuelCapacity;
    this.fuelAmount=fuelAmount;
    this.fuelType=fuelType;
 
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
    public String toString() {//added
        return "Fuel{ " + "fuelType= " + fuelType + ", fuelCapacity= " + fuelCapacity + ", fuelAmount= " + fuelAmount + ", buyingPrice= " + buyingPrice + ", salePrice= " + salePrice + ", tax= " + tax + " }";
    }
   
}


