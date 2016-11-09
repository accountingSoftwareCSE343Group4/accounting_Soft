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
public class Personal{
    int id;
    String name;
    String lastName;
    String address;
    String phoneNumber;
    String job;
    double salary;
    double sskBonus;

    public Personal(String name, int id, String lastName, String address, String phoneNumber, String job, double salary, double sskprim) {
        this.name = name;
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.salary = salary;
        this.sskBonus = sskprim;
    }

    public Personal(int id) {
        this.id = id;
    }
    
    public Personal(){
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJop() {
        return job;
    }

    public void setJop(String jop) {
        this.job = jop;
    }

    public double getSskprim() {
        return sskBonus;
    }

    public void setSskprim(double sskprim) {
        this.sskBonus = sskprim;
    }
}