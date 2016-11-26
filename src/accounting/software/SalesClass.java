package accounting.software;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author zozge
 */
public class SalesClass implements Income{
    String description;
    int ID;
    Double price;
    private Date saleDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // format is 21/11/2016

    /**
     *
     * @param description
     * @param ID
     * @param price
     * @param date
     */
    public SalesClass(String description, int ID, Double price,String date) {
        this.description = description;
        this.ID = ID;
        this.price = price;
        saleDate = new Date();
        try{
            this.saleDate = dateFormat.parse(date);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        
       

    }

    /**
     *
     * @return
     */
    public Date getSaleDate(){
        return saleDate;
    }
    
    /**
     *
     * @param date
     */
    public void setSaleDate(String date){
        try{
            this.saleDate = dateFormat.parse(date);
        }
        catch(ParseException e){
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
     * @return
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
    public String toString(){
        return "Date = " + dateFormat.format(saleDate) + " Description = " + description + " price = " + price ;
    }
}
