/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

/**
 *
 * @author Arif Dogru
 */
public interface Expenses {
        /**
     * Return to Expense
     * @return 
     */
    Double getExpense();
    /**
     * Return to Expense Name
     * @return 
     */
    String getName();
    /**
     * Return to Description
     * @return 
     */
    String getDescription();

}
