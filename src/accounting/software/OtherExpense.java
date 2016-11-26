/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;
import java.text.ParseException; // for date format
import java.text.SimpleDateFormat; // for date format
import java.util.Date; 

/**
 *
 * @author emre
 */
public class OtherExpense implements Expenses{
    private String name;
    private String Desc;
    private Double amount;
    private Date date;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); // format : 21/11/2016
    private static int inp=0;

    /**
     *
     * @param name
     * @param Desc
     * @param amount
     */
    public OtherExpense(String name, String Desc, Double amount, String date) {
        this.name = name;
        this.Desc = Desc;
        this.amount = amount;
        this.date = new Date();
        try{
            this.date = dateFormat.parse(date);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        ++inp;
    }
    /*
     * @return Date
    */
    public Date getDate(){
        return date;
    }
    /*
     * @param date
     */
    public void setDate(String date){
        try{
            this.date = dateFormat.parse(date);
        }
        catch(ParseException e){
            e.printStackTrace();
        }        
    }
    /**
     *
     * @return
     */
    public int getID(){
        return inp;
    }
    
    @Override
    public Double getExpense() {
       return amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return Desc;
    }
    
}
