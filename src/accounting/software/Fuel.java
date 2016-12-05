package accounting.software;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ahmet Alperen Bulut
 */
public class Fuel implements Expenses, Income {

    private String fuelType;
    private double buyingAmount;
    private double saleAmount;
    private double buyingPrice;
    private double salePrice;
    private double tax;
    private String PurchasedDate;
    
 

    /**
     *
     * @param fuelType
     * @param fuelCapacity
     * @param fuelAmount
     */
    public Fuel(String fuelType, double buyingAmount,double buyingPrice) {

        this.buyingAmount = buyingAmount;
        this.buyingPrice= buyingPrice;
        this.fuelType = fuelType;
        this.PurchasedDate=systemDate();
    }

    /**
     *
     * @return
     */
    public String getFuelType() {
        return fuelType;
    }

    public double getBuyingAmount() {
        return buyingAmount;
    }

    public void setBuyingAmount(double buyingAmount) {
        this.buyingAmount = buyingAmount;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
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

    public String getPurchasedDate() {
        return PurchasedDate;
    }

    public void setPurchasedDate(String PurchasedDate) {
        this.PurchasedDate = PurchasedDate;
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

     private String systemDate() {
        Date systemDate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date = df.format(systemDate);
        return date;
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
        return "Fuel{" + "fuelType=" + fuelType + ", buyingAmount=" + buyingAmount + ", saleAmount=" + saleAmount + ", buyingPrice=" + buyingPrice + ", salePrice=" + salePrice + ", tax=" + tax + ", PurchasedDate=" + PurchasedDate + '}';
    }

   

    @Override
    public Double getExpense() {
        return getBuyingPrice() * buyingAmount;
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
        return getSalePrice() * saleAmount;
    }

}
