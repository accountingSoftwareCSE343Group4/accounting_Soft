/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

/**
 *
 * @author emre
 */
public class OtherExpense implements Expenses{
    private String name;
    private String Desc;
    private Double amount;
    private static int inp=0;

    /**
     *
     * @param name
     * @param Desc
     * @param amount
     */
    public OtherExpense(String name, String Desc, Double amount) {
        this.name = name;
        this.Desc = Desc;
        this.amount = amount;
        ++inp;
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
