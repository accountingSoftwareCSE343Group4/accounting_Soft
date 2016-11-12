/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;



import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Furkan
 */
public class MainFrame extends javax.swing.JFrame {

    public static MainFrame mainFrame;
    DieselDialog dieselDialog = new DieselDialog(this, rootPaneCheckingEnabled);


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

        Icon img = new ImageIcon(getClass().getResource("images/Asset 22.png"));
        sumTab.setIcon(img);
        
        mainFrame = this;

//        PersonnelPanel temp = new PersonnelPanel();
//        PersonnelPanel temp2 = new PersonnelPanel();
//        PersonnelPanel temp3 = new PersonnelPanel();
//
//        mainFrame = this;
//
//        this.jPanel7.add(temp);
//        temp.setBounds(0, 0, 283, 60);
//        this.jPanel7.add(temp2);
//        temp2.setBounds(0, 80, 283, 60);
//        this.jPanel7.add(temp3);
//
//        temp3.setBounds(0, 160, 283, 60);

        this.add(persframe);
        persframe.setVisible(false);
        
        temp();

//        
//        jPanel7.setPreferredSize(new Dimension(283, jPanel7.getHeight() + 180));
//        this.revalidate();
//        this.repaint();
        //     this.jPanel7.setSize(283, 180);

    }

    private void updatePersonelPannel() {
        
        jPanel7.removeAll();
        
        int bound = 0;
        
        for(int i=0; i< AccountingSystem.getInstance().getPersonnelSize(); ++i){
           
            Personnel personnel = AccountingSystem.getInstance().getPerson(i);
            
           PersonnelPanel temp = new PersonnelPanel(personnel.getName()+ " " + personnel.getLastName(), personnel.getSalary(), personnel.getId());
           
           //add accounting system panel
            
            jPanel7.add(temp);
            temp.setBounds(0, bound, 283, 60);
            
            bound += 80;
        }
        
        this.revalidate();
        this.repaint();

    }

    private void updateExpensesPannel() {

    }

    private void updateIncomesPannel() {

    }
    
    public void updateFuels(){
        
        jLabel5.setText("AVAILABLE AMOUNT (LT)     = " + AccountingSystem.getInstance().getFuel(0).getFuelAmount());
        jLabel7.setText("PURCHASE PRICE (TL)          = " + AccountingSystem.getInstance().getFuel(0).getBuyingPrice());
        jLabel8.setText("CURRENT PRICE (TL)            = " + AccountingSystem.getInstance().getFuel(0).getSalePrice());
        
        jLabel9.setText("AVAILABLE AMOUNT (LT)     = " + AccountingSystem.getInstance().getFuel(1).getFuelAmount());
        jLabel10.setText("PURCHASE PRICE (TL)          = " + AccountingSystem.getInstance().getFuel(1).getBuyingPrice());
        jLabel11.setText("CURRENT PRICE (TL)            = " + AccountingSystem.getInstance().getFuel(1).getSalePrice());
        
        jLabel12.setText("AVAILABLE AMOUNT (LT)     = " + AccountingSystem.getInstance().getFuel(2).getFuelAmount());
        jLabel13.setText("PURCHASE PRICE (TL)          = " + AccountingSystem.getInstance().getFuel(2).getBuyingPrice());
        jLabel14.setText("CURRENT PRICE (TL)            = " + AccountingSystem.getInstance().getFuel(2).getSalePrice());
        
        System.err.println(AccountingSystem.getInstance().getFuelSize());;
    }
    
    private void temp(){
        
        
        
        AccountingSystem.getInstance().addPerson(new Personnel(0));
         AccountingSystem.getInstance().getPerson(0).setName("FURKAN");
         AccountingSystem.getInstance().getPerson(0).setLastName("ERDÖL");
         AccountingSystem.getInstance().getPerson(0).setSalary(12.5);
         
         AccountingSystem.getInstance().addPerson(new Personnel(1));
         AccountingSystem.getInstance().getPerson(1).setName("FURKAN");
         AccountingSystem.getInstance().getPerson(1).setLastName("ERDÖL");
         AccountingSystem.getInstance().getPerson(1).setSalary(12.5);
         
         AccountingSystem.getInstance().addPerson(new Personnel(2));
         AccountingSystem.getInstance().getPerson(2).setName("FURKAN");
         AccountingSystem.getInstance().getPerson(2).setLastName("ERDÖL");
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
        
        
        updatePersonelPannel();
        updateFuels();
    }

    FinanceFrame financeframe = new FinanceFrame();
    personnelFrame persframe = new personnelFrame();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        sumTab = new javax.swing.JLabel();
        PersonnelTab = new javax.swing.JLabel();
        FInanceTab = new javax.swing.JLabel();
        sumPane = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        ReportBut = new javax.swing.JButton();
        DieselBut = new javax.swing.JButton();
        GasolineBut = new javax.swing.JButton();
        LpgBut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ExpensesBut = new javax.swing.JButton();
        IncomesBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accounting Software");
        setResizable(false);

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setAlignmentX(0.0F);
        jLayeredPane1.setAlignmentY(0.0F);
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1149, 70));
        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0));

        sumTab.setBackground(new java.awt.Color(51, 153, 0));
        sumTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 7.png"))); // NOI18N
        sumTab.setAlignmentY(0.0F);
        sumTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sumTab.setMaximumSize(new java.awt.Dimension(383, 72));
        sumTab.setMinimumSize(new java.awt.Dimension(383, 72));
        sumTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sumTabMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sumTabMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sumTabMouseEntered(evt);
            }
        });
        jLayeredPane1.add(sumTab);

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
        jLayeredPane1.add(PersonnelTab);

        FInanceTab.setBackground(new java.awt.Color(51, 153, 0));
        FInanceTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 8.png"))); // NOI18N
        FInanceTab.setAlignmentY(0.0F);
        FInanceTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FInanceTab.setMaximumSize(new java.awt.Dimension(383, 72));
        FInanceTab.setMinimumSize(new java.awt.Dimension(383, 72));
        FInanceTab.setPreferredSize(new java.awt.Dimension(383, 70));
        FInanceTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FInanceTabMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FInanceTabMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FInanceTabMouseEntered(evt);
            }
        });
        jLayeredPane1.add(FInanceTab);

        getContentPane().add(jLayeredPane1, java.awt.BorderLayout.PAGE_START);

        sumPane.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(176, 190, 197));
        jPanel1.setPreferredSize(new java.awt.Dimension(383, 580));

        ReportBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 9.png"))); // NOI18N
        ReportBut.setBorderPainted(false);
        ReportBut.setContentAreaFilled(false);
        ReportBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReportBut.setPreferredSize(new java.awt.Dimension(245, 52));
        ReportBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportButMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportButMouseEntered(evt);
            }
        });

        DieselBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 12.png"))); // NOI18N
        DieselBut.setBorderPainted(false);
        DieselBut.setContentAreaFilled(false);
        DieselBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DieselBut.setPreferredSize(new java.awt.Dimension(122, 32));
        DieselBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DieselButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DieselButMouseExited(evt);
            }
        });
        DieselBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DieselButActionPerformed(evt);
            }
        });

        GasolineBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 13.png"))); // NOI18N
        GasolineBut.setBorderPainted(false);
        GasolineBut.setContentAreaFilled(false);
        GasolineBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GasolineBut.setPreferredSize(new java.awt.Dimension(122, 32));
        GasolineBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GasolineButMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GasolineButMouseEntered(evt);
            }
        });

        LpgBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 14.png"))); // NOI18N
        LpgBut.setBorderPainted(false);
        LpgBut.setContentAreaFilled(false);
        LpgBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LpgBut.setPreferredSize(new java.awt.Dimension(122, 32));
        LpgBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LpgButMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LpgButMouseEntered(evt);
            }
        });

        jLabel5.setText("AVAILABLE AMOUNT (LT) = 20");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("PURCHASE PRICE(TL)        =  5 ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("CURRENT PRICE (LT)         = 5.2");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("AVAILABLE AMOUNT (LT) = 20");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("PURCHASE PRICE(TL)        =  5 ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("CURRENT PRICE (LT)         = 5.2");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("AVAILABLE AMOUNT (LT) = 20");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("PURCHASE PRICE(TL)        =  5 ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("CURRENT PRICE (LT)         = 5.2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GasolineBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DieselBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LpgBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ReportBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(DieselBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(GasolineBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addComponent(LpgBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(72, 72, 72)
                .addComponent(ReportBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        sumPane.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(176, 190, 197));
        jPanel2.setPreferredSize(new java.awt.Dimension(383, 580));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(283, 100));

        jPanel7.setBackground(new java.awt.Color(176, 190, 197));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 284, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel7);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        sumPane.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(176, 190, 197));
        jPanel3.setPreferredSize(new java.awt.Dimension(383, 580));

        ExpensesBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 39.png"))); // NOI18N
        ExpensesBut.setBorderPainted(false);
        ExpensesBut.setContentAreaFilled(false);
        ExpensesBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExpensesBut.setPreferredSize(new java.awt.Dimension(122, 32));
        ExpensesBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExpensesButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExpensesButMouseExited(evt);
            }
        });

        IncomesBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/Asset 40.png"))); // NOI18N
        IncomesBut.setBorderPainted(false);
        IncomesBut.setContentAreaFilled(false);
        IncomesBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        IncomesBut.setPreferredSize(new java.awt.Dimension(122, 32));
        IncomesBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IncomesButMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IncomesButMouseEntered(evt);
            }
        });

        jScrollPane1.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(176, 190, 197));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel4);

        jScrollPane3.setBorder(null);

        jPanel8.setBackground(new java.awt.Color(176, 190, 197));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel8);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IncomesBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExpensesBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ExpensesBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IncomesBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        sumPane.add(jPanel3);

        getContentPane().add(sumPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sumTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumTabMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 22.png"));
        sumTab.setIcon(img);
    }//GEN-LAST:event_sumTabMouseEntered

    private void sumTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumTabMouseExited
        if (!sumOpen) {
            Icon img = new ImageIcon(getClass().getResource("images/Asset 7.png"));
            sumTab.setIcon(img);
        }

    }//GEN-LAST:event_sumTabMouseExited

    private void PersonnelTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonnelTabMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 24.png"));
        PersonnelTab.setIcon(img);
    }//GEN-LAST:event_PersonnelTabMouseEntered

    private void PersonnelTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonnelTabMouseExited
        if (!personnelOpen) {
            Icon img = new ImageIcon(getClass().getResource("images/Asset 20.png"));
            PersonnelTab.setIcon(img);
        }

    }//GEN-LAST:event_PersonnelTabMouseExited

    private void FInanceTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FInanceTabMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 27.png"));
        FInanceTab.setIcon(img);
    }//GEN-LAST:event_FInanceTabMouseEntered

    private void FInanceTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FInanceTabMouseExited
        if (!financeOpen) {
            Icon img = new ImageIcon(getClass().getResource("images/Asset 8.png"));
            FInanceTab.setIcon(img);
        }

    }//GEN-LAST:event_FInanceTabMouseExited

    private void ReportButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 29.png"));
        ReportBut.setIcon(img);
    }//GEN-LAST:event_ReportButMouseEntered

    private void ReportButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportButMouseExited
        Icon img = new ImageIcon(getClass().getResource("images/Asset 9.png"));
        ReportBut.setIcon(img);
    }//GEN-LAST:event_ReportButMouseExited

    private void DieselButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DieselButMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 30.png"));
        DieselBut.setIcon(img);
    }//GEN-LAST:event_DieselButMouseEntered

    private void DieselButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DieselButMouseExited
        Icon img = new ImageIcon(getClass().getResource("images/Asset 12.png"));
        DieselBut.setIcon(img);
    }//GEN-LAST:event_DieselButMouseExited

    private void GasolineButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GasolineButMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 32.png"));
        GasolineBut.setIcon(img);
    }//GEN-LAST:event_GasolineButMouseEntered

    private void GasolineButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GasolineButMouseExited
        Icon img = new ImageIcon(getClass().getResource("images/Asset 13.png"));
        GasolineBut.setIcon(img);
    }//GEN-LAST:event_GasolineButMouseExited

    private void LpgButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LpgButMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 33.png"));
        LpgBut.setIcon(img);
    }//GEN-LAST:event_LpgButMouseEntered

    private void LpgButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LpgButMouseExited
        Icon img = new ImageIcon(getClass().getResource("images/Asset 14.png"));
        LpgBut.setIcon(img);
    }//GEN-LAST:event_LpgButMouseExited

    private void ExpensesButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpensesButMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 41.png"));
        ExpensesBut.setIcon(img);
    }//GEN-LAST:event_ExpensesButMouseEntered

    private void ExpensesButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpensesButMouseExited
        Icon img = new ImageIcon(getClass().getResource("images/Asset 39.png"));
        ExpensesBut.setIcon(img);
    }//GEN-LAST:event_ExpensesButMouseExited

    private void IncomesButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncomesButMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/Asset 42.png"));
        IncomesBut.setIcon(img);
    }//GEN-LAST:event_IncomesButMouseEntered

    private void IncomesButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncomesButMouseExited
        Icon img = new ImageIcon(getClass().getResource("images/Asset 40.png"));
        IncomesBut.setIcon(img);
    }//GEN-LAST:event_IncomesButMouseExited

    private void PersonnelTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonnelTabMouseClicked


      

            Icon img = new ImageIcon(getClass().getResource("images/Asset 24.png"));
            PersonnelTab.setIcon(img);
            personnelOpen = true;

            sumOpen = false;

            financeOpen = false;

            img = new ImageIcon(getClass().getResource("images/Asset 7.png"));
            sumTab.setIcon(img);

            img = new ImageIcon(getClass().getResource("images/Asset 8.png"));
            FInanceTab.setIcon(img);

           

                        
            if(financeframe.isVisible())
            {
                sumPane.setVisible(true);
                this.remove(financeframe);
            }


            sumPane.setVisible(false);
            this.add(persframe);
            persframe.setVisible(true);
           
    }//GEN-LAST:event_PersonnelTabMouseClicked

    private void sumTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumTabMouseClicked
        if (!sumPane.isVisible()) {

            Icon img = new ImageIcon(getClass().getResource("images/Asset 22.png"));
            sumTab.setIcon(img);

            sumOpen = true;
            personnelOpen = false;
            financeOpen = false;

            img = new ImageIcon(getClass().getResource("images/Asset 20.png"));
            PersonnelTab.setIcon(img);

            img = new ImageIcon(getClass().getResource("images/Asset 8.png"));
            FInanceTab.setIcon(img);

            persframe.setVisible(false);
            financeframe.setVisible(false);
            sumPane.setVisible(true);
        }
    }//GEN-LAST:event_sumTabMouseClicked

    private void FInanceTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FInanceTabMouseClicked



        Icon img = new ImageIcon(getClass().getResource("images/Asset 27.png"));
        FInanceTab.setIcon(img);

        financeOpen = true;
        sumOpen = false;
        personnelOpen = false;

        img = new ImageIcon(getClass().getResource("images/Asset 7.png"));
        sumTab.setIcon(img);

        img = new ImageIcon(getClass().getResource("images/Asset 20.png"));
        PersonnelTab.setIcon(img);

       

        if(persframe.isVisible())
        {
            sumPane.setVisible(true);
            this.remove(persframe);
        }
        sumPane.setVisible(false);
         this.add(financeframe);
         financeframe.setVisible(true);


    }//GEN-LAST:event_FInanceTabMouseClicked

    private void DieselButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DieselButActionPerformed
        
        dieselDialog.setGui();
        
        dieselDialog.setVisible(true);
    }//GEN-LAST:event_DieselButActionPerformed

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
    private javax.swing.JButton DieselBut;
    private javax.swing.JButton ExpensesBut;
    private javax.swing.JLabel FInanceTab;
    private javax.swing.JButton GasolineBut;
    private javax.swing.JButton IncomesBut;
    private javax.swing.JButton LpgBut;
    private javax.swing.JLabel PersonnelTab;
    private javax.swing.JButton ReportBut;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLayeredPane sumPane;
    private javax.swing.JLabel sumTab;
    // End of variables declaration//GEN-END:variables
}
