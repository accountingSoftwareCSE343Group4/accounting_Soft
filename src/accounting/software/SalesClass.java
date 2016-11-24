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
    public Date getSaleDate(){
        return saleDate;
    }
    
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Double getPrice() {
        return price;
    }

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
