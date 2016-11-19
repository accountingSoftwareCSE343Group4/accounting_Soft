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
public interface Income {
    
        /**
     * Miktarı return eder
     * @return 
     */
    Double getIncome();
    /**
     * Income Adını Return eder
     * @return 
     */
    String getName();
    /**
     * Descrition return eder
     * @return 
     */
    String getDescription();
}
