package accounting.software;

import java.text.ParseException; // for date format
import java.text.SimpleDateFormat; // for date format
import java.util.Date;

/**
 *
 * @author zubeyde ozge yilmaz
 */
public class SalesClass implements Income {

    private String description;
    private int ID;
    private Double price;
    private Date saleDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // format : 21/11/2016

    /**
     *
     * @param description
     * @param ID
     * @param price
     * @param date
     */
    public SalesClass(String description, int ID, Double price, String date) {
        this.description = description;
        this.ID = ID;
        this.price = price;
        saleDate = new Date();
        try {
            this.saleDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return Date
     */
    public Date getSaleDate() {
        return saleDate;
    }

    /**
     *
     * @param date
     */
    public void setSaleDate(String date) {
        try {
            this.saleDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return Double
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Double getIncome() {
        return getPrice();
    }

    @Override
    public String getName() {
        return "Sale";
    }

    @Override
    public String toString() {
        return "ID = " + ID + "Date = " + dateFormat.format(saleDate)
                + " Description = " + description + " Price = " + price;
    }
}
