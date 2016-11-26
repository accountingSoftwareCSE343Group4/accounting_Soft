package accounting.software.GUIStaffs;

import accounting.software.AccountingSystem;
import accounting.software.Fuel;
import accounting.software.OtherExpense;
import accounting.software.Personnel;
import accounting.software.SalesClass;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Main Frame class.
 * @author Furkan
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * This frame
     */
    public static MainFrame mainFrame;
    
    private DieselDialog dieselDialog = new DieselDialog(this, rootPaneCheckingEnabled);
    private GasolineDialog gasolineDialog = new GasolineDialog(this, rootPaneCheckingEnabled);
    private LpgDialog lpgDialog = new LpgDialog(this, rootPaneCheckingEnabled);
    private FinanceFrame financeframe = new FinanceFrame();
    private PersonnelFrame persframe = new PersonnelFrame();
    private static Font newFont;
    private boolean sumOpen = true;
    private boolean personnelOpen = false;
    private boolean financeOpen = false;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);

        Icon img = new ImageIcon("src/accounting/software/images/Asset 22.png");
        SummaryTab.setIcon(img);

        mainFrame = this;

        this.add(persframe);
        persframe.setVisible(false);

        temp();
    }

    private void updatePersonelPannel() {

        jPanelAddPersonnel.removeAll();

        int bound = 0;

        for (int i = 0; i < AccountingSystem.getInstance().getPersonnelSize(); ++i) {

            Personnel personnel = AccountingSystem.getInstance().getPerson(i);

            PersonnelPanel temp = new PersonnelPanel(personnel.getName() + " " + personnel.getLastName() + " (" + personnel.getJop() + ")", personnel.getSalary(), personnel.getId());

            //  AccountingSystem.getInstance().addPersonnelPanel(temp);
            jPanelAddPersonnel.add(temp);
            temp.setBounds(0, bound, 283, 60);

            bound += 80;
        }

        this.revalidate();
        this.repaint();

    }

    private void updateExpensesPannel() {

        jPanelAddExpenses.removeAll();

        int bound = 0;

        for (int i = 0; i < financeframe.others.size(); ++i) {

            OtherExpense expense = financeframe.others.get(i);

            ExpensePanel temp = new ExpensePanel(expense.getName() + " (TL) = " + expense.getExpense(), expense.getID());

            //add accounting system panel
//           AccountingSystem.getInstance().addExpensePanel(temp);
//            
            jPanelAddExpenses.add(temp);
            temp.setBounds(0, bound, 320, 40);

            bound += 40;

        }

        this.revalidate();
        this.repaint();

    }

    private void updateIncomesPannel() {

        jPanelAddIncomes.removeAll();

        int bound = 0;

        for (int i = 0; i < AccountingSystem.getInstance().getSalesListSize(); ++i) {

            SalesClass sale = AccountingSystem.getInstance().getSale(i);

            IncomePanel temp = new IncomePanel(sale.getDescription() + " (TL) = " + sale.getPrice(), sale.getID());

            //add accounting system panel
            //   AccountingSystem.getInstance().addIncomePanel(temp);
            jPanelAddIncomes.add(temp);
            temp.setBounds(0, bound, 320, 40);

            bound += 40;

        }

        this.revalidate();
        this.repaint();

    }

    /**
     *
     */
    public void updateFuels() {

        jLabelDieselAvailableAmount.setText("AVAILABLE AMOUNT (LT)     = " + AccountingSystem.getInstance().getFuel(0).getFuelAmount());
        jLabelDieselPurchasePrice.setText("PURCHASE PRICE (TL)          = " + AccountingSystem.getInstance().getFuel(0).getBuyingPrice());
        jLabelDieselCurrentPrice.setText("CURRENT PRICE (TL)            = " + AccountingSystem.getInstance().getFuel(0).getSalePrice());

        jLabelGasolineAvailableAmount.setText("AVAILABLE AMOUNT (LT)     = " + AccountingSystem.getInstance().getFuel(1).getFuelAmount());
        jLabelGasolinePurchasePrice.setText("PURCHASE PRICE (TL)          = " + AccountingSystem.getInstance().getFuel(1).getBuyingPrice());
        jLabelGasolineCurrentPrice.setText("CURRENT PRICE (TL)            = " + AccountingSystem.getInstance().getFuel(1).getSalePrice());

        jLabelLpgAvailableAmount.setText("AVAILABLE AMOUNT (LT)     = " + AccountingSystem.getInstance().getFuel(2).getFuelAmount());
        jLabelLpgPurchasePrice.setText("PURCHASE PRICE (TL)          = " + AccountingSystem.getInstance().getFuel(2).getBuyingPrice());
        jLabelLpgCurrentPrice.setText("CURRENT PRICE (TL)            = " + AccountingSystem.getInstance().getFuel(2).getSalePrice());

        System.err.println(AccountingSystem.getInstance().getFuelSize());;
    }

    private void temp() {

        AccountingSystem.getInstance().addPerson(new Personnel(0));
        AccountingSystem.getInstance().getPerson(0).setName("FURKAN");
        AccountingSystem.getInstance().getPerson(0).setLastName("ERDÖL");
        AccountingSystem.getInstance().getPerson(0).setJop("FUEL SALES STAFF");
        AccountingSystem.getInstance().getPerson(0).setSalary(12.5);

        AccountingSystem.getInstance().addPerson(new Personnel(1));
        AccountingSystem.getInstance().getPerson(1).setName("Emre");
        AccountingSystem.getInstance().getPerson(1).setLastName("Bayram");
        AccountingSystem.getInstance().getPerson(1).setJop("CLEANER");
        AccountingSystem.getInstance().getPerson(1).setSalary(12.5);

        AccountingSystem.getInstance().addPerson(new Personnel(2));
        AccountingSystem.getInstance().getPerson(2).setName("Şahin");
        AccountingSystem.getInstance().getPerson(2).setLastName("Eğilmez");
        AccountingSystem.getInstance().getPerson(2).setJop("MARKET CASHIER");
        AccountingSystem.getInstance().getPerson(2).setSalary(12.5);

        AccountingSystem.getInstance().addFuel(new Fuel("DIESEL", 20.0, 21.1));
        AccountingSystem.getInstance().addFuel(new Fuel("GASOLINE", 20.0, 21.1));
        AccountingSystem.getInstance().addFuel(new Fuel("LPG", 20.0, 21.1));

        AccountingSystem.getInstance().getFuel(0).setBuyingPrice(5.0);
        AccountingSystem.getInstance().getFuel(0).setSalePrice(5.2);

        AccountingSystem.getInstance().getFuel(1).setBuyingPrice(5.1);
        AccountingSystem.getInstance().getFuel(1).setSalePrice(5.3);

        AccountingSystem.getInstance().getFuel(2).setBuyingPrice(5.4);
        AccountingSystem.getInstance().getFuel(2).setSalePrice(5.5);

        // AccountingSystem.getInstance().addSale(new SalesClass("SALE OF MARKET", 0, 5200));
        //AccountingSystem.getInstance().addSale(new SalesClass("SALE OF FUEL", 1, 5200));
        //AccountingSystem.getInstance().addSale(new SalesClass("Sale of market", 2, 5200));
        //   AccountingSystem.getInstance().addSale(new SalesClass("Sale of market", 3, 5200));
        //  AccountingSystem.getInstance().addSale(new SalesClass("Sale of market", 4, 5200));
        financeframe.others.add(new OtherExpense("RENT ", " ", 50000.0));
        financeframe.others.add(new OtherExpense("CLEANING TAX", " ", 50000.0));
        financeframe.others.add(new OtherExpense("ELECTRICT ", " ", 50000.0));
        financeframe.others.add(new OtherExpense("WATER ", " ", 50000.0));
        financeframe.others.add(new OtherExpense("NATURAL GAS ", " ", 50000.0));

        updatePersonelPannel();
        updateFuels();
        updateIncomesPannel();
        updateExpensesPannel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPaneTopMenu = new javax.swing.JLayeredPane();
        SummaryTab = new javax.swing.JLabel();
        PersonnelTab = new javax.swing.JLabel();
        FinanceTab = new javax.swing.JLabel();
        jLayeredPaneSummary = new javax.swing.JLayeredPane();
        jPanelGasoline = new javax.swing.JPanel();
        ReportButton = new javax.swing.JButton();
        DieselButton = new javax.swing.JButton();
        GasolineButton = new javax.swing.JButton();
        LpgButton = new javax.swing.JButton();
        jLabelDieselAvailableAmount = new javax.swing.JLabel();
        jLabelDieselPurchasePrice = new javax.swing.JLabel();
        jLabelDieselCurrentPrice = new javax.swing.JLabel();
        jLabelGasolineAvailableAmount = new javax.swing.JLabel();
        jLabelGasolinePurchasePrice = new javax.swing.JLabel();
        jLabelGasolineCurrentPrice = new javax.swing.JLabel();
        jLabelLpgAvailableAmount = new javax.swing.JLabel();
        jLabelLpgPurchasePrice = new javax.swing.JLabel();
        jLabelLpgCurrentPrice = new javax.swing.JLabel();
        jPanelPersonnel = new javax.swing.JPanel();
        jScrollPanePersonnel = new javax.swing.JScrollPane();
        jPanelAddPersonnel = new javax.swing.JPanel();
        jPanelExpensesAndIncomes = new javax.swing.JPanel();
        ExpensesButton = new javax.swing.JButton();
        IncomesButton = new javax.swing.JButton();
        jScrollPaneExpenses = new javax.swing.JScrollPane();
        jPanelAddExpenses = new javax.swing.JPanel();
        jScrollPaneIncomes = new javax.swing.JScrollPane();
        jPanelAddIncomes = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accounting Software");
        setResizable(false);

        jLayeredPaneTopMenu.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPaneTopMenu.setAlignmentX(0.0F);
        jLayeredPaneTopMenu.setAlignmentY(0.0F);
        jLayeredPaneTopMenu.setOpaque(true);
        jLayeredPaneTopMenu.setPreferredSize(new java.awt.Dimension(1149, 70));
        jLayeredPaneTopMenu.setLayout(new java.awt.GridLayout(1, 0));

        SummaryTab.setBackground(new java.awt.Color(51, 153, 0));
        SummaryTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 7.png"))); // NOI18N
        SummaryTab.setAlignmentY(0.0F);
        SummaryTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SummaryTab.setMaximumSize(new java.awt.Dimension(383, 72));
        SummaryTab.setMinimumSize(new java.awt.Dimension(383, 72));
        SummaryTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SummaryTabMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SummaryTabMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SummaryTabMouseEntered(evt);
            }
        });
        jLayeredPaneTopMenu.add(SummaryTab);

        PersonnelTab.setBackground(new java.awt.Color(51, 153, 0));
        PersonnelTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 20.png"))); // NOI18N
        PersonnelTab.setAlignmentY(0.0F);
        PersonnelTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PersonnelTab.setMaximumSize(new java.awt.Dimension(383, 72));
        PersonnelTab.setMinimumSize(new java.awt.Dimension(383, 72));
        PersonnelTab.setPreferredSize(new java.awt.Dimension(383, 70));
        PersonnelTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonnelTabMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PersonnelTabMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PersonnelTabMouseEntered(evt);
            }
        });
        jLayeredPaneTopMenu.add(PersonnelTab);

        FinanceTab.setBackground(new java.awt.Color(51, 153, 0));
        FinanceTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 8.png"))); // NOI18N
        FinanceTab.setAlignmentY(0.0F);
        FinanceTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FinanceTab.setMaximumSize(new java.awt.Dimension(383, 72));
        FinanceTab.setMinimumSize(new java.awt.Dimension(383, 72));
        FinanceTab.setPreferredSize(new java.awt.Dimension(383, 70));
        FinanceTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FinanceTabMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FinanceTabMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FinanceTabMouseEntered(evt);
            }
        });
        jLayeredPaneTopMenu.add(FinanceTab);

        getContentPane().add(jLayeredPaneTopMenu, java.awt.BorderLayout.PAGE_START);

        jLayeredPaneSummary.setLayout(new java.awt.GridLayout(1, 0));

        jPanelGasoline.setBackground(new java.awt.Color(176, 190, 197));
        jPanelGasoline.setPreferredSize(new java.awt.Dimension(383, 580));

        ReportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 9.png"))); // NOI18N
        ReportButton.setBorderPainted(false);
        ReportButton.setContentAreaFilled(false);
        ReportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReportButton.setEnabled(false);
        ReportButton.setPreferredSize(new java.awt.Dimension(245, 52));
        ReportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportButtonMouseEntered(evt);
            }
        });

        DieselButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 12.png"))); // NOI18N
        DieselButton.setBorderPainted(false);
        DieselButton.setContentAreaFilled(false);
        DieselButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DieselButton.setPreferredSize(new java.awt.Dimension(122, 32));
        DieselButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DieselButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DieselButtonMouseExited(evt);
            }
        });
        DieselButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DieselButtonActionPerformed(evt);
            }
        });

        GasolineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 13.png"))); // NOI18N
        GasolineButton.setBorderPainted(false);
        GasolineButton.setContentAreaFilled(false);
        GasolineButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GasolineButton.setPreferredSize(new java.awt.Dimension(122, 32));
        GasolineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GasolineButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GasolineButtonMouseExited(evt);
            }
        });
        GasolineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GasolineButtonActionPerformed(evt);
            }
        });

        LpgButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 14.png"))); // NOI18N
        LpgButton.setBorderPainted(false);
        LpgButton.setContentAreaFilled(false);
        LpgButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LpgButton.setPreferredSize(new java.awt.Dimension(122, 32));
        LpgButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LpgButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LpgButtonMouseExited(evt);
            }
        });
        LpgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LpgButtonActionPerformed(evt);
            }
        });

        jLabelDieselAvailableAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDieselAvailableAmount.setText("AVAILABLE AMOUNT (LT) = 20");

        jLabelDieselPurchasePrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDieselPurchasePrice.setText("PURCHASE PRICE(TL)        =  5 ");

        jLabelDieselCurrentPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDieselCurrentPrice.setText("CURRENT PRICE (LT)         = 5.2");

        jLabelGasolineAvailableAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGasolineAvailableAmount.setText("AVAILABLE AMOUNT (LT) = 20");

        jLabelGasolinePurchasePrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGasolinePurchasePrice.setText("PURCHASE PRICE(TL)        =  5 ");

        jLabelGasolineCurrentPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelGasolineCurrentPrice.setText("CURRENT PRICE (LT)         = 5.2");

        jLabelLpgAvailableAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLpgAvailableAmount.setText("AVAILABLE AMOUNT (LT) = 20");

        jLabelLpgPurchasePrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLpgPurchasePrice.setText("PURCHASE PRICE(TL)        =  5 ");

        jLabelLpgCurrentPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLpgCurrentPrice.setText("CURRENT PRICE (LT)         = 5.2");

        javax.swing.GroupLayout jPanelGasolineLayout = new javax.swing.GroupLayout(jPanelGasoline);
        jPanelGasoline.setLayout(jPanelGasolineLayout);
        jPanelGasolineLayout.setHorizontalGroup(
            jPanelGasolineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGasolineLayout.createSequentialGroup()
                .addGroup(jPanelGasolineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGasolineLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanelGasolineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GasolineButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DieselButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LpgButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelGasolineLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanelGasolineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelGasolineAvailableAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(jLabelLpgAvailableAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDieselAvailableAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDieselPurchasePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelDieselCurrentPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelGasolinePurchasePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelGasolineCurrentPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLpgPurchasePrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelLpgCurrentPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelGasolineLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(ReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanelGasolineLayout.setVerticalGroup(
            jPanelGasolineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGasolineLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(DieselButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDieselAvailableAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDieselPurchasePrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDieselCurrentPrice)
                .addGap(30, 30, 30)
                .addComponent(GasolineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelGasolineAvailableAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGasolinePurchasePrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelGasolineCurrentPrice)
                .addGap(30, 30, 30)
                .addComponent(LpgButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelLpgAvailableAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLpgPurchasePrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLpgCurrentPrice)
                .addGap(62, 62, 62)
                .addComponent(ReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jLayeredPaneSummary.add(jPanelGasoline);

        jPanelPersonnel.setBackground(new java.awt.Color(176, 190, 197));
        jPanelPersonnel.setPreferredSize(new java.awt.Dimension(383, 580));

        jScrollPanePersonnel.setBorder(null);
        jScrollPanePersonnel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPanePersonnel.setPreferredSize(new java.awt.Dimension(283, 100));

        jPanelAddPersonnel.setBackground(new java.awt.Color(176, 190, 197));

        javax.swing.GroupLayout jPanelAddPersonnelLayout = new javax.swing.GroupLayout(jPanelAddPersonnel);
        jPanelAddPersonnel.setLayout(jPanelAddPersonnelLayout);
        jPanelAddPersonnelLayout.setHorizontalGroup(
            jPanelAddPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        jPanelAddPersonnelLayout.setVerticalGroup(
            jPanelAddPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        jScrollPanePersonnel.setViewportView(jPanelAddPersonnel);

        javax.swing.GroupLayout jPanelPersonnelLayout = new javax.swing.GroupLayout(jPanelPersonnel);
        jPanelPersonnel.setLayout(jPanelPersonnelLayout);
        jPanelPersonnelLayout.setHorizontalGroup(
            jPanelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonnelLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jScrollPanePersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanelPersonnelLayout.setVerticalGroup(
            jPanelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonnelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPanePersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        jLayeredPaneSummary.add(jPanelPersonnel);

        jPanelExpensesAndIncomes.setBackground(new java.awt.Color(176, 190, 197));
        jPanelExpensesAndIncomes.setPreferredSize(new java.awt.Dimension(383, 580));

        ExpensesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 39.png"))); // NOI18N
        ExpensesButton.setBorderPainted(false);
        ExpensesButton.setContentAreaFilled(false);
        ExpensesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExpensesButton.setPreferredSize(new java.awt.Dimension(122, 32));
        ExpensesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExpensesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExpensesButtonMouseExited(evt);
            }
        });

        IncomesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 40.png"))); // NOI18N
        IncomesButton.setBorderPainted(false);
        IncomesButton.setContentAreaFilled(false);
        IncomesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IncomesButton.setPreferredSize(new java.awt.Dimension(122, 32));
        IncomesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IncomesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IncomesButtonMouseExited(evt);
            }
        });

        jScrollPaneExpenses.setBorder(null);

        jPanelAddExpenses.setBackground(new java.awt.Color(176, 190, 197));

        javax.swing.GroupLayout jPanelAddExpensesLayout = new javax.swing.GroupLayout(jPanelAddExpenses);
        jPanelAddExpenses.setLayout(jPanelAddExpensesLayout);
        jPanelAddExpensesLayout.setHorizontalGroup(
            jPanelAddExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanelAddExpensesLayout.setVerticalGroup(
            jPanelAddExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jScrollPaneExpenses.setViewportView(jPanelAddExpenses);

        jScrollPaneIncomes.setBorder(null);

        jPanelAddIncomes.setBackground(new java.awt.Color(176, 190, 197));

        javax.swing.GroupLayout jPanelAddIncomesLayout = new javax.swing.GroupLayout(jPanelAddIncomes);
        jPanelAddIncomes.setLayout(jPanelAddIncomesLayout);
        jPanelAddIncomesLayout.setHorizontalGroup(
            jPanelAddIncomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanelAddIncomesLayout.setVerticalGroup(
            jPanelAddIncomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );

        jScrollPaneIncomes.setViewportView(jPanelAddIncomes);

        javax.swing.GroupLayout jPanelExpensesAndIncomesLayout = new javax.swing.GroupLayout(jPanelExpensesAndIncomes);
        jPanelExpensesAndIncomes.setLayout(jPanelExpensesAndIncomesLayout);
        jPanelExpensesAndIncomesLayout.setHorizontalGroup(
            jPanelExpensesAndIncomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExpensesAndIncomesLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanelExpensesAndIncomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExpensesAndIncomesLayout.createSequentialGroup()
                        .addGroup(jPanelExpensesAndIncomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IncomesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExpensesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExpensesAndIncomesLayout.createSequentialGroup()
                        .addComponent(jScrollPaneExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExpensesAndIncomesLayout.createSequentialGroup()
                        .addComponent(jScrollPaneIncomes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanelExpensesAndIncomesLayout.setVerticalGroup(
            jPanelExpensesAndIncomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelExpensesAndIncomesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ExpensesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneExpenses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IncomesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneIncomes, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jLayeredPaneSummary.add(jPanelExpensesAndIncomes);

        getContentPane().add(jLayeredPaneSummary, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SummaryTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SummaryTabMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 22.png");
        SummaryTab.setIcon(img);
    }//GEN-LAST:event_SummaryTabMouseEntered

    private void SummaryTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SummaryTabMouseExited
        if (!sumOpen) {
            Icon img = new ImageIcon("src/accounting/software/images/Asset 7.png");
            SummaryTab.setIcon(img);
        }

    }//GEN-LAST:event_SummaryTabMouseExited

    private void PersonnelTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonnelTabMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 24.png");
        PersonnelTab.setIcon(img);
    }//GEN-LAST:event_PersonnelTabMouseEntered

    private void PersonnelTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonnelTabMouseExited
        if (!personnelOpen) {
            Icon img = new ImageIcon("src/accounting/software/images/Asset 20.png");
            PersonnelTab.setIcon(img);
        }

    }//GEN-LAST:event_PersonnelTabMouseExited

    private void FinanceTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinanceTabMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 27.png");
        FinanceTab.setIcon(img);
    }//GEN-LAST:event_FinanceTabMouseEntered

    private void FinanceTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinanceTabMouseExited
        if (!financeOpen) {
            Icon img = new ImageIcon("src/accounting/software/images/Asset 8.png");
            FinanceTab.setIcon(img);
        }

    }//GEN-LAST:event_FinanceTabMouseExited

    private void ReportButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 29.png");
        ReportButton.setIcon(img);
    }//GEN-LAST:event_ReportButtonMouseEntered

    private void ReportButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButtonMouseExited
        Icon img = new ImageIcon("src/accounting/software/images/Asset 9.png");
        ReportButton.setIcon(img);
    }//GEN-LAST:event_ReportButtonMouseExited

    private void DieselButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DieselButtonMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 30.png");
        DieselButton.setIcon(img);
    }//GEN-LAST:event_DieselButtonMouseEntered

    private void DieselButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DieselButtonMouseExited
        Icon img = new ImageIcon("src/accounting/software/images/Asset 12.png");
        DieselButton.setIcon(img);
    }//GEN-LAST:event_DieselButtonMouseExited

    private void GasolineButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GasolineButtonMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 32.png");
        GasolineButton.setIcon(img);
    }//GEN-LAST:event_GasolineButtonMouseEntered

    private void GasolineButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GasolineButtonMouseExited
        Icon img = new ImageIcon("src/accounting/software/images/Asset 13.png");
        GasolineButton.setIcon(img);
    }//GEN-LAST:event_GasolineButtonMouseExited

    private void LpgButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LpgButtonMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 33.png");
        LpgButton.setIcon(img);
    }//GEN-LAST:event_LpgButtonMouseEntered

    private void LpgButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LpgButtonMouseExited
        Icon img = new ImageIcon("src/accounting/software/images/Asset 14.png");
        LpgButton.setIcon(img);
    }//GEN-LAST:event_LpgButtonMouseExited

    private void ExpensesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpensesButtonMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 41.png");
        ExpensesButton.setIcon(img);
    }//GEN-LAST:event_ExpensesButtonMouseEntered

    private void ExpensesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpensesButtonMouseExited
        Icon img = new ImageIcon("src/accounting/software/images/Asset 39.png");
        ExpensesButton.setIcon(img);
    }//GEN-LAST:event_ExpensesButtonMouseExited

    private void IncomesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncomesButtonMouseEntered
        Icon img = new ImageIcon("src/accounting/software/images/Asset 42.png");
        IncomesButton.setIcon(img);
    }//GEN-LAST:event_IncomesButtonMouseEntered

    private void IncomesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncomesButtonMouseExited
        Icon img = new ImageIcon("src/accounting/software/images/Asset 40.png");
        IncomesButton.setIcon(img);
    }//GEN-LAST:event_IncomesButtonMouseExited

    private void PersonnelTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonnelTabMouseClicked

        Icon img = new ImageIcon("src/accounting/software/images/Asset 24.png");
        PersonnelTab.setIcon(img);
        personnelOpen = true;

        sumOpen = false;

        financeOpen = false;

        img = new ImageIcon("src/accounting/software/images/Asset 7.png");
        SummaryTab.setIcon(img);

        img = new ImageIcon("src/accounting/software/images/Asset 8.png");
        FinanceTab.setIcon(img);

        if (financeframe.isVisible()) {
            jLayeredPaneSummary.setVisible(true);
            this.remove(financeframe);
        }

        jLayeredPaneSummary.setVisible(false);
        this.add(persframe);
        persframe.setVisible(true);
        persframe.updateMe();
    }//GEN-LAST:event_PersonnelTabMouseClicked

    private void SummaryTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SummaryTabMouseClicked
        if (!jLayeredPaneSummary.isVisible()) {

            Icon img = new ImageIcon("src/accounting/software/images/Asset 22.png");
            SummaryTab.setIcon(img);

            sumOpen = true;
            personnelOpen = false;
            financeOpen = false;

            img = new ImageIcon("src/accounting/software/images/Asset 20.png");
            PersonnelTab.setIcon(img);

            img = new ImageIcon("src/accounting/software/images/Asset 8.png");
            FinanceTab.setIcon(img);

            persframe.setVisible(false);
            financeframe.setVisible(false);
            jLayeredPaneSummary.setVisible(true);
        }

        updatePersonelPannel();
        updateFuels();
        updateIncomesPannel();
        updateExpensesPannel();

    }//GEN-LAST:event_SummaryTabMouseClicked

    private void FinanceTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FinanceTabMouseClicked

        Icon img = new ImageIcon("src/accounting/software/images/Asset 27.png");
        FinanceTab.setIcon(img);

        financeOpen = true;
        sumOpen = false;
        personnelOpen = false;

        img = new ImageIcon("src/accounting/software/images/Asset 7.png");
        SummaryTab.setIcon(img);

        img = new ImageIcon("src/accounting/software/images/Asset 20.png");
        PersonnelTab.setIcon(img);

        if (persframe.isVisible()) {
            jLayeredPaneSummary.setVisible(true);
            this.remove(persframe);
        }
        jLayeredPaneSummary.setVisible(false);
        this.add(financeframe);
        financeframe.setVisible(true);

        financeframe.UpdateMe();
    }//GEN-LAST:event_FinanceTabMouseClicked

    private void DieselButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DieselButtonActionPerformed

        dieselDialog.setGui();

        dieselDialog.setVisible(true);
    }//GEN-LAST:event_DieselButtonActionPerformed

    private void GasolineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GasolineButtonActionPerformed
        gasolineDialog.setGui();

        gasolineDialog.setVisible(true);
    }//GEN-LAST:event_GasolineButtonActionPerformed

    private void LpgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LpgButtonActionPerformed
        lpgDialog.setGui();

        lpgDialog.setVisible(true);
    }//GEN-LAST:event_LpgButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    newFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/Myriad-Pro_31655.ttf"));
                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    ge.registerFont(newFont);
                } catch (IOException | FontFormatException e) {
                    // Handle exception
                    System.err.println("Error loading font: " + e.getMessage());
                }

                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DieselButton;
    private javax.swing.JButton ExpensesButton;
    private javax.swing.JLabel FinanceTab;
    private javax.swing.JButton GasolineButton;
    private javax.swing.JButton IncomesButton;
    private javax.swing.JButton LpgButton;
    private javax.swing.JLabel PersonnelTab;
    private javax.swing.JButton ReportButton;
    private javax.swing.JLabel SummaryTab;
    private javax.swing.JLabel jLabelDieselAvailableAmount;
    private javax.swing.JLabel jLabelDieselCurrentPrice;
    private javax.swing.JLabel jLabelDieselPurchasePrice;
    private javax.swing.JLabel jLabelGasolineAvailableAmount;
    private javax.swing.JLabel jLabelGasolineCurrentPrice;
    private javax.swing.JLabel jLabelGasolinePurchasePrice;
    private javax.swing.JLabel jLabelLpgAvailableAmount;
    private javax.swing.JLabel jLabelLpgCurrentPrice;
    private javax.swing.JLabel jLabelLpgPurchasePrice;
    private javax.swing.JLayeredPane jLayeredPaneSummary;
    private javax.swing.JLayeredPane jLayeredPaneTopMenu;
    private javax.swing.JPanel jPanelAddExpenses;
    private javax.swing.JPanel jPanelAddIncomes;
    private javax.swing.JPanel jPanelAddPersonnel;
    private javax.swing.JPanel jPanelExpensesAndIncomes;
    private javax.swing.JPanel jPanelGasoline;
    private javax.swing.JPanel jPanelPersonnel;
    private javax.swing.JScrollPane jScrollPaneExpenses;
    private javax.swing.JScrollPane jScrollPaneIncomes;
    private javax.swing.JScrollPane jScrollPanePersonnel;
    // End of variables declaration//GEN-END:variables
}
