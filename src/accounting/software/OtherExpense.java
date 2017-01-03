package accounting.software;

import java.text.ParseException; // for date format
import java.text.SimpleDateFormat; // for date format
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emre
 */
public class OtherExpense implements Expenses {

    private String name;
    private String Desc;
    private Double amount;
    private String date;
    private int ID;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // format : 2016-11-26
    private static int inp = 0;

    /**
     *
     * @param name
     * @param Desc
     * @param amount
     */
    public OtherExpense(String name, String Desc, Double amount, String eDate) {
        this.name = name;
        this.Desc = Desc;
        this.amount = amount;
        date = systemDate();
        ID = inp;
        this.date = eDate;
        
        ++inp;
    }

    public Double getAmount() {
        return amount;
    }

    /*
     * @return Date
     */
    public String getDate() {
        return date;
    }

    /*
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    private String systemDate() {
        Date systemDate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(systemDate);
        return date;
    }
    /**
     *
     * @return
     */
    public int getID() {
        return ID;
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
