package accounting.software;

/**
 *
 * @author Arif Dogru
 */
public class Personnel implements Expenses {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String job;
    private double salary;
    private double sskBonus;

    /**
     * Create Personnel Object
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
     * Create Personnel Object by id
     *
     * @param id
     */
    public Personnel(int id) {
        this.id = id;
        this.name = "";
        this.lastName = "";
        this.address = "";
        this.phoneNumber = "";
        this.job = "";
        this.salary = 0.0;
        this.sskBonus = 0.0;
    }

    /**
     * Create Personnel Object default
     */
    public Personnel() {
        this.id = -1;
        this.name = "";
        this.lastName = "";
        this.address = "";
        this.phoneNumber = "";
        this.job = "";
        this.salary = 0.0;
        this.sskBonus = 0.0;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set personnel id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set Personnel name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set Personnel Surname
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set Personnel address
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
     * Set Personnel Phone Number
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
     * Set Personnel Salary
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
     * Set
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
     * Set Personnel sskBonus
     *
     * @param sskbonus
     */
    public void setSskBonus(double sskbonus) {
        this.sskBonus = sskbonus;
    }

    /**
     * @return personnel expense
     */
    @Override
    public Double getExpense() {
        return getSalary() + getSskBonus();
    }

    @Override
    public String getDescription() {
        return "Employee_Expense";
    }

    /*
    * @return Personnel information
     */
    @Override
    public String toString() {
        return "Personnel{" + "Id=" + id + ", Name=" + name + " ,Sur Name=" + lastName + "}";
    }
}
