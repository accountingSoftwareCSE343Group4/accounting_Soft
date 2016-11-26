/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.*;

/**
 *
 * @author Ahmet Alperen Bulut
 * @author Arif Dogru
 */
public class AccountingSystem {

    // Lists of Classes
    private List<Personnel> personnelList = new ArrayList();
    private List<Fuel> fuelList = new ArrayList();

    /**
     *
     */
    public List<BillAndTax> billsTaxes = new ArrayList<BillAndTax>(); //deneme
    private List<SalesClass> salesclassList = new ArrayList();
    

    // For Gui
    private List<PersonnelPanel> personnelPanelList = new ArrayList();
    private List<IncomePanel> incomePanelList = new ArrayList();
    private List<ExpensePanel> expensePanelList = new ArrayList();

    // For Json
    private JSONObject jsonObject = new JSONObject();
    private JsonParser jsonParser = new JsonParser();

    private static final AccountingSystem INSTANCE = new AccountingSystem();

    private AccountingSystem() {
    }

    /**
     *
     * @return
     */
    public static AccountingSystem getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param index
     * @return
     */
    public SalesClass getSale(int index) {
        if (index >= salesclassList.size()) {
            return null;
        }
        return salesclassList.get(index);
    }

    /**
     *
     * @param index
     * @return
     */
    public Personnel getPerson(int index) {
        if (index >= personnelList.size()) {
            return null;
        }
        return personnelList.get(index);

    }

    /**
     *
     * @param saleID
     * @return
     */
    public SalesClass getSaleById(int saleID) {

        for (int i = 0; i < salesclassList.size(); ++i) {
            if (salesclassList.get(i).getID() == saleID) {
                return salesclassList.get(i);
            }
        }

        return null;
    }

    /**
     *
     * @param personId
     * @return
     */
    public Personnel getPersonById(int personId) {

        for (int i = 0; i < personnelList.size(); ++i) {
            if (personnelList.get(i).getId() == personId) {
                return personnelList.get(i);
            }
        }

        return null;
    }

    /**
     *
     * @param index
     * @return
     */
    public SalesClass getSales(int index) {
        if (index >= salesclassList.size()) {
            return null;
        }

        return salesclassList.get(index);
    }

    /**
     *
     * @param index
     * @return
     */
    public Fuel getFuel(int index) {
        if (index >= fuelList.size()) {
            return null;
        }

        return fuelList.get(index);
    }

    /**
     *
     * @return
     */
    public int getSalesListSize() {
        return salesclassList.size();
    }

    /**
     *
     * @return
     */
    public int getPersonnelSize() {
        return personnelList.size();
    }

    /**
     *
     * @return
     */
    public int getFuelSize() {
        return fuelList.size();
    }

    /**
     *
     * @param newSale
     */
    public void addSale(SalesClass newSale) {
        boolean duplicate = false;
        for (int i = 0; i < salesclassList.size(); ++i) {
            if (salesclassList.get(i).getID() == newSale.getID()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            salesclassList.add(newSale);
        }
    }

    /**
     *
     * @param newPerson
     */
    public void addPerson(Personnel newPerson) {
        boolean duplicate = false;
        for (int i = 0; i < personnelList.size(); ++i) {
            if (personnelList.get(i).getId() == newPerson.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            personnelList.add(newPerson);
        }
    }

    /**
     *
     * @param id
     */
    public void removeSale(int id) {
        for (int i = 0; i < salesclassList.size(); ++i) {
            if (salesclassList.get(i).getID() == id) {
                salesclassList.remove(i);
            }
        }

    }

    /**
     *
     * @param id
     */
    public void removePerson(int id) {
        for (int i = 0; i < personnelList.size(); ++i) {
            if (personnelList.get(i).getId() == id) {
                personnelList.remove(i);
            }
        }

    }

    /**
     *
     * @param newFuel
     */
    public void addFuel(Fuel newFuel) {
        boolean duplicate = false;
        for (int i = 0; i < fuelList.size(); ++i) {
            if (fuelList.get(i).getFuelType().equals(newFuel.getFuelType())) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            fuelList.add(newFuel);
        }
    }

    /**
     *
     * @param fuelType
     */
    public void removeFuel(String fuelType) {
        for (int i = 0; i < fuelList.size(); ++i) {
            if (fuelList.get(i).getFuelType().equals(fuelType)) {
                fuelList.remove(i);
            }
        }
    }
    /*
     * @return system date    
     */
    public String systemDate(){
        Date systemDate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String date = df.format(systemDate);
        return date;
    }
    /**
     *
     * @param index
     * @return
     */
    public PersonnelPanel getPersonnelPanel(int index) {
        if (index >= personnelPanelList.size()) {
            return null;
        }
        return personnelPanelList.get(index);
    }

    /**
     *
     * @param newPersonnelPanel
     */
    public void addPersonnelPanel(PersonnelPanel newPersonnelPanel) {
        boolean duplicate = false;
        for (int i = 0; i < personnelPanelList.size(); ++i) {
            if (personnelPanelList.get(i).getPersonnelPanelID() == newPersonnelPanel.getPersonnelPanelID()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            personnelPanelList.add(newPersonnelPanel);
        }
    }

    /**
     *
     * @param index
     */
    public void removePersonnelPanel(int index) {
        for (int i = 0; i < personnelPanelList.size(); ++i) {
            personnelPanelList.remove(i);
        }

    }

    /**
     *
     * @param index
     * @return
     */
    public IncomePanel getIncomePanel(int index) {
        if (index >= incomePanelList.size()) {
            return null;
        }
        return incomePanelList.get(index);
    }

    /**
     *
     * @param newIncomePanel
     */
    public void addIncomePanel(IncomePanel newIncomePanel) {
        boolean duplicate = false;
        for (int i = 0; i < incomePanelList.size(); ++i) {
            if (incomePanelList.get(i).getIncomePanelID() == newIncomePanel.getIncomePanelID()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            incomePanelList.add(newIncomePanel);
        }
    }

    /**
     *
     * @param index
     */
    public void removeIncomePanel(int index) {
        for (int i = 0; i < incomePanelList.size(); ++i) {
            incomePanelList.remove(i);
        }

    }

    /**
     *
     * @param index
     * @return
     */
    public ExpensePanel getExpensePanel(int index) {
        if (index >= expensePanelList.size()) {
            return null;
        }
        return expensePanelList.get(index);
    }

    /**
     *
     * @param newExpensePanel
     */
    public void addExpensePanel(ExpensePanel newExpensePanel) {
        boolean duplicate = false;
        for (int i = 0; i < expensePanelList.size(); ++i) {
            if (expensePanelList.get(i).getExpensePanelID() == newExpensePanel.getExpensePanelID()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            expensePanelList.add(newExpensePanel);
        }
    }

    /**
     *
     * @param index
     */
    public void removeExpensePanel(int index) {
        for (int i = 0; i < expensePanelList.size(); ++i) {
            expensePanelList.remove(i);
        }

    }
    
    /**
     *
     * @return
     */
    public JSONObject getJsonObject() {
        return jsonObject;
    }

    /**
     *
     * @throws JSONException
     */
    public void generateJson() throws JSONException {

        jsonObject.put("Personel", (JSONArray) jsonParser.JSONEncode((List<Object>) (Object) personnelList));

        jsonObject.put("Fuels", (JSONArray) jsonParser.JSONEncode((List<Object>) (Object) fuelList));
        
//        jsonObject.put("BillAndTax", (JSONObject)jsonParser.JSONEncode((List<Object>) (Object) billAndTaxList));

//        jsonObject.put("Sales", (JSONObject) jsonParser.JSONEncode((List<Object>) (Object) salesclassList));

        System.out.println(jsonObject.toString());

        jsonParser.writeJsonToFile(jsonObject);
    }

    /**
     *
     */
    public void readToJson() {
        List<List<Object>> allList = new ArrayList();

        for (List<Object> anyList : allList) {
            if (anyList instanceof ArrayList) {
                for (Object obj : anyList) {
                    if (obj instanceof Personnel) {

                    } else if (obj instanceof Fuel) {

                    } else if (obj instanceof SalesClass) {

                    } else {
                        System.err.println("Unknown class type");
                    }
                }
            }
        }
    }
    
    // For PDF File 
    public static void createReport()throws DocumentException, IOException{

        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 25,Font.BOLD);
        Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 14,Font.BOLD);
        Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);

        //create document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("AccountingSpftwareReport.pdf"));
        document.open();
        Paragraph preface = new Paragraph();
                
        // big header
        preface.add(new Paragraph("             Report Of Accounting System", catFont));        
        // Report Date
        preface.add(new Paragraph(
                                  "                              Date : " 
                                          + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        
        document.add(preface);
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph(" "));
        document.add(paragraph);
        // Table for fuel 
        Paragraph fuelTitle = new Paragraph();
        fuelTitle.add(new Paragraph("                   FUEL",subFont));
        document.add(fuelTitle);
        document.add(paragraph);
        PdfPTable tableFuel = new PdfPTable(2);
        for(int i= 0; i < 3 ; i++){
            tableFuel.addCell("DIESEL");
            tableFuel.addCell("");
            tableFuel.addCell("Available  Amount(lt)");
            tableFuel.addCell("");
            tableFuel.addCell("Purchase Price(TL)");
            tableFuel.addCell("");
            tableFuel.addCell("Current Price(TL)");
            tableFuel.addCell("");
        }
        document.add(tableFuel);
        ///////////////////////////////////////////////
        document.add(paragraph);
        //Table for Personel
        Paragraph personnelTitle = new Paragraph();
        personnelTitle.add(new Paragraph("                   PERSONNEL",subFont));
        document.add(personnelTitle);
        document.add(paragraph);
        
        PdfPTable tablePersonel = new PdfPTable(5);
        tablePersonel.addCell("NAME");
        tablePersonel.addCell("LASTNAME");
        tablePersonel.addCell("JOB");
        tablePersonel.addCell("SALARY");
        tablePersonel.addCell("SSK PRIM");
        for(int i= 0; i < INSTANCE.getPersonnelSize() ; i++){
            tablePersonel.addCell(INSTANCE.personnelList.get(i).getName());
            tablePersonel.addCell(INSTANCE.personnelList.get(i).getLastName());
            tablePersonel.addCell(INSTANCE.personnelList.get(i).getJop());
            String salary = ""+(INSTANCE.personnelList.get(i).getSalary());
            tablePersonel.addCell(salary);
            String prim = ""+INSTANCE.personnelList.get(i).getSskBonus();
            tablePersonel.addCell(prim);
        }
        document.add(tablePersonel);
       
        ////////////////////////////////////////////////
        document.add(paragraph);
        //Table for Expenses
        Paragraph expensesTitle = new Paragraph();
        expensesTitle.add(new Paragraph("                   EXPENSES",subFont));
        document.add(expensesTitle);
        document.add(paragraph);
        
        PdfPTable tableExpenses = new PdfPTable(2);
        for(int i=0; i<5 ; i++){
            tableExpenses.addCell("Description(TL)");
            tableExpenses.addCell("");
        }
        document.add(tableExpenses);
        //////////////////////////////////////////////////
        document.add(paragraph);
        //Table for Incomes
        Paragraph incomeTitle = new Paragraph();
        incomeTitle.add(new Paragraph("                   INCOMES",subFont));
        document.add(incomeTitle);
        document.add(paragraph);
        PdfPTable tableIncomes = new PdfPTable(2);
        for(int i=0; i<INSTANCE.getSalesListSize() ; i++){
            tableIncomes.addCell(INSTANCE.salesclassList.get(i).getDescription() +"(TL)");
            String priceSale = ""+ INSTANCE.salesclassList.get(i).getPrice();
            tableIncomes.addCell(priceSale);
        }
        document.add(tableIncomes);
        
        //////////////////////////////////////////////////
        document.close();
    }

}
