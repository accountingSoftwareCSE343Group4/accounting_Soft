package accounting.software;

/**
 *
 * @author Ahmet Alperen Bulut
 */
public class Fuel implements Expenses,Income{

 private String fuelType;
 private double fuelCapacity;
 private double  fuelAmount;
 private double buyingPrice;
 private double salePrice;
 private double tax;
 
    /**
     *
     */
    public Fuel(){
    this.fuelType= " ";
    this.fuelCapacity=0;
    this.fuelAmount=0;
    this.buyingPrice=0;
    this.salePrice=0;
    this.tax=0;
 }
 
    /**
     *
     * @param fuelType
     * @param fuelCapacity
     * @param fuelAmount
     */
    public  Fuel(String fuelType,double fuelCapacity,double fuelAmount){
     
    this.fuelCapacity=fuelCapacity;
    this.fuelAmount=fuelAmount;
    this.fuelType=fuelType;
 
 }

    /**
     *
     * @return
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     *
     * @return
     */
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     *
     * @return
     */
    public double getFuelAmount() {
        return fuelAmount;
    }

    /**
     *
     * @return
     */
    public double getBuyingPrice() {
        return buyingPrice;
    }

    /**
     *
     * @return
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     *
     * @return
     */
    public double getTax() {
        return tax;
    }

    /**
     *
     * @param fuelType
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     *
     * @param fuelCapacity
     */
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    /**
     *
     * @param fuelAmount
     */
    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    /**
     *
     * @param buyingPrice
     */
    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    /**
     *
     * @param salePrice
     */
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     *
     * @param tax
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Fuel{" + "fuelType=" + fuelType + ", fuelCapacity=" + fuelCapacity + ", fuelAmount=" + fuelAmount + ", buyingPrice=" + buyingPrice + ", salePrice=" + salePrice + ", tax=" + tax + '}';
    }
    
    @Override
    public Double getExpense() {
        return getBuyingPrice()*fuelAmount;
    }

    @Override
    public String getName() {
        return getFuelType();
    }

    @Override
    public String getDescription() {
        return "Fuel";
    }

    @Override
    public Double getIncome() {
        return getSalePrice()*fuelAmount;
    }

}
