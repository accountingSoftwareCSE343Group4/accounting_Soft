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
public class Personnel implements Expenses{
    private int id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String job;
    private double salary;
    private double sskBonus;

    /**
     *
     * @param name
     * @param id
     * @param lastName
     * @param address
     * @param phoneNumber
     * @param job
     * @param salary
     * @param sskprim
     */
    public Personnel(String name, int id, String lastName, String address, String phoneNumber, String job, double salary, double sskprim) {
        this.name = name;
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.salary = salary;
        this.sskBonus = sskprim;
    }

    /**
     *
     * @param id
     */
    public Personnel(int id) {
        this.id = id;
    }
    
    /**
     *
     */
    public Personnel(){
        this.id = -1;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public double getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     *
     * @return
     */
    public String getJop() {
        return job;
    }

    /**
     *
     * @param jop
     */
    public void setJop(String jop) {
        this.job = jop;
    }

    /**
     *
     * @return
     */
    public double getSskBonus() {
        return sskBonus;
    }

    /**
     *
     * @param sskbonus
     */
    public void setSskBonus(double sskbonus) {
        this.sskBonus = sskbonus;
    }
    
    @Override
    public Double getExpense() {
        return getSalary() + getSskBonus();
    }

    @Override
    public String getDescription() {
        return "Employee_Expense";
    }

}