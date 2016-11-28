package accounting.software.GUIStaffs;

import accounting.software.AccountingSystem;
import accounting.software.OtherExpense;
import accounting.software.SalesClass;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author emre
 */
public class FinanceFrame extends javax.swing.JPanel {

    //Total Income and Total Outcome
    private double totalin = 0;
    private double totalout = 0;
    /**
     * Expenses
     */
    public ArrayList<OtherExpense> others = new ArrayList<OtherExpense>();

    //lists   
    private Vector<String> giderler = new Vector<String>();
    private Vector<String> gelirler = new Vector<String>();
    private Vector<Integer> gelirIDs = new Vector<Integer>();
    private Vector<Integer> giderIDs = new Vector<Integer>();

    //Dialogs
    AddFinanceDialog addDialog = new AddFinanceDialog(MainFrame.mainFrame, true);
    EditFinanceDialog editDialog = new EditFinanceDialog(MainFrame.mainFrame, true);
    DeleteFinanceDialog deleteDialog = new DeleteFinanceDialog(MainFrame.mainFrame, true);

    /**
     * Creates new form FinanceFrame
     */
    public FinanceFrame() {
        initComponents();
        UpdateMe();
    }
    static int temp = 10;

    /**
     *
     */
    public void UpdateMe() {
        outcomePanel.removeAll();
        incomePanel.removeAll();
        gelirler.clear();
        giderler.clear();

        int count_in = 0, count_out = 0;
        int freeOutcomeY = 0;
        int freeIncomeY = 0;
        for (int i = 0; i < AccountingSystem.getInstance().getPersonnelSize(); ++i) {
            totalout += AccountingSystem.getInstance().getPerson(i).getSalary()
                    + AccountingSystem.getInstance().getPerson(i).getSskBonus();
            ++count_out;
            outcomePanel.add(new ExpensePanelFinance(AccountingSystem.getInstance().getPerson(i), freeOutcomeY));
            freeOutcomeY += 50;
        }

        for (int i = 0; i < AccountingSystem.getInstance().getFuelSize(); ++i) {
            ++count_in;
            ++count_out;
            totalout += AccountingSystem.getInstance().getFuel(i).getTax();
            outcomePanel.add(new ExpensePanelFinance(AccountingSystem.getInstance().getFuel(i), freeOutcomeY));
            freeOutcomeY += 50;
            totalin += AccountingSystem.getInstance().getFuel(i).getIncome();
            incomePanel.add(new IncomePanelFinance(AccountingSystem.getInstance().getFuel(i), freeIncomeY));
            freeIncomeY += 50;

        }

        for (int i = 0; i < AccountingSystem.getInstance().getSalesListSize(); ++i) {
            gelirler.add(AccountingSystem.getInstance().getSale(i).toString());
            gelirIDs.add(AccountingSystem.getInstance().getSale(i).getID());
            ++count_in;
            totalin += AccountingSystem.getInstance().getSale(i).getPrice();
            incomePanel.add(new IncomePanelFinance(AccountingSystem.getInstance().getSale(i), freeIncomeY));
            freeIncomeY += 50;
        }
        // TODO :
        for (int i = 0; i < AccountingSystem.getInstance().getOtherExpenseSize(); ++i) {
            totalout += AccountingSystem.getInstance().getOtherExpense(i).getExpense();
            giderler.add(AccountingSystem.getInstance().getOtherExpense(i).getName() + " "
                    + AccountingSystem.getInstance().getOtherExpense(i).getDate().toString());
            outcomePanel.add(new ExpensePanelFinance(AccountingSystem.getInstance().getOtherExpense(i), freeOutcomeY));
            ++count_out;
            freeOutcomeY += 50;
        }

        if (count_in * 50 >= 450) {
            incomePanel.setPreferredSize(new Dimension(530, freeIncomeY + 50));
        }
        if (count_out * 50 >= 450) {
            outcomePanel.setPreferredSize(new Dimension(530, freeOutcomeY + 50));
        }
        this.revalidate();
        this.repaint();
        totalIncome.setText(Double.toString(totalin));
        totalOutCome.setText(Double.toString(totalout));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AddIncomeBut = new javax.swing.JButton();
        DeleteIncomeBut = new javax.swing.JButton();
        AddOutcomeBut = new javax.swing.JButton();
        DeleteOutcomeBut = new javax.swing.JButton();
        leftPane = new javax.swing.JScrollPane();
        incomePanel = new javax.swing.JPanel();
        rightPane = new javax.swing.JScrollPane();
        outcomePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        totalIncome = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalOutCome = new javax.swing.JLabel();

        setBackground(new java.awt.Color(176, 190, 197));
        setPreferredSize(new java.awt.Dimension(1149, 580));
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("INCOMES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("EXPENSES");

        AddIncomeBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/addButton.png"))); // NOI18N
        AddIncomeBut.setContentAreaFilled(false);
        AddIncomeBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddIncomeBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddIncomeButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddIncomeButMouseExited(evt);
            }
        });
        AddIncomeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddIncomeButActionPerformed(evt);
            }
        });

        DeleteIncomeBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/deleteButton.png"))); // NOI18N
        DeleteIncomeBut.setContentAreaFilled(false);
        DeleteIncomeBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteIncomeBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteIncomeButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteIncomeButMouseExited(evt);
            }
        });
        DeleteIncomeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteIncomeButActionPerformed(evt);
            }
        });

        AddOutcomeBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/addButton.png"))); // NOI18N
        AddOutcomeBut.setContentAreaFilled(false);
        AddOutcomeBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddOutcomeBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddOutcomeButMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddOutcomeButMouseEntered(evt);
            }
        });
        AddOutcomeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOutcomeButActionPerformed(evt);
            }
        });

        DeleteOutcomeBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/deleteButton.png"))); // NOI18N
        DeleteOutcomeBut.setContentAreaFilled(false);
        DeleteOutcomeBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeleteOutcomeBut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteOutcomeButMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteOutcomeButMouseExited(evt);
            }
        });
        DeleteOutcomeBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteOutcomeButActionPerformed(evt);
            }
        });

        leftPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        leftPane.setPreferredSize(new java.awt.Dimension(548, 430));

        incomePanel.setPreferredSize(new java.awt.Dimension(530, 350));
        incomePanel.setRequestFocusEnabled(false);
        incomePanel.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout incomePanelLayout = new javax.swing.GroupLayout(incomePanel);
        incomePanel.setLayout(incomePanelLayout);
        incomePanelLayout.setHorizontalGroup(
            incomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        incomePanelLayout.setVerticalGroup(
            incomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        leftPane.setViewportView(incomePanel);

        rightPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outcomePanel.setPreferredSize(new java.awt.Dimension(530, 350));
        outcomePanel.setRequestFocusEnabled(false);
        outcomePanel.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout outcomePanelLayout = new javax.swing.GroupLayout(outcomePanel);
        outcomePanel.setLayout(outcomePanelLayout);
        outcomePanelLayout.setHorizontalGroup(
            outcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        outcomePanelLayout.setVerticalGroup(
            outcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        rightPane.setViewportView(outcomePanel);

        jLabel3.setText("Total :");

        totalIncome.setText("0.00");

        jLabel4.setText("Total :");

        totalOutCome.setText("0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(245, 245, 245))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leftPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rightPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddIncomeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(DeleteIncomeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 194, Short.MAX_VALUE)
                        .addComponent(AddOutcomeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(DeleteOutcomeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalIncome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalOutCome)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(leftPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rightPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totalIncome)
                    .addComponent(jLabel4)
                    .addComponent(totalOutCome))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddIncomeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DeleteIncomeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddOutcomeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteOutcomeBut, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddIncomeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddIncomeButActionPerformed
        addDialog.setVisible(true);

        if (addDialog.getReturnStatus() == AddFinanceDialog.RET_OK) {
            String[] s = new String[3];
            s = addDialog.GetValues();

            //bakilacak
            SalesClass sale = new SalesClass(s[1], temp, Double.parseDouble(s[2]), "11/11/2011");

            AccountingSystem.getInstance().addSale(sale);
            UpdateMe();
            temp++;
        }
    }//GEN-LAST:event_AddIncomeButActionPerformed


    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void DeleteIncomeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteIncomeButActionPerformed
        deleteDialog.setItems(gelirler);
        deleteDialog.setVisible(true);

        if (deleteDialog.getReturnStatus() == DeleteFinanceDialog.RET_OK) {
            String delete = deleteDialog.getSelecteditem();
            for (int i = 0; i < gelirler.size(); ++i) {
                if (delete.equals(gelirler.get(i))) {
                    AccountingSystem.getInstance().removeSale(gelirIDs.elementAt(i));
                    gelirler.remove(i);
                    gelirIDs.remove(i);
                }
            }
            UpdateMe();
        }


    }//GEN-LAST:event_DeleteIncomeButActionPerformed

    private void AddOutcomeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOutcomeButActionPerformed
        addDialog.setVisible(true);

        if (addDialog.getReturnStatus() == AddFinanceDialog.RET_OK) {
            String[] s = new String[3];
            s = addDialog.GetValues();

            OtherExpense other = new OtherExpense(s[0], s[1], Double.parseDouble(s[2]), java.time.LocalDate.now().toString());
            AccountingSystem.getInstance().addOtherExpense(other);
            giderler.add(s[0] + " " + s[1]);
            giderIDs.add(other.getID());
            UpdateMe();
        }

    }//GEN-LAST:event_AddOutcomeButActionPerformed

    /**
     * TODO : Delete action is Not completed Delete Outcome Button
     *
     * @param evt
     */
    private void DeleteOutcomeButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteOutcomeButActionPerformed
        deleteDialog.setItems(giderler);
        deleteDialog.setVisible(true);

        if (deleteDialog.getReturnStatus() == DeleteFinanceDialog.RET_OK) {
            String delete = deleteDialog.getSelecteditem();
            for (int i = 0; i < giderler.size(); ++i) {
                if (delete.equals(giderler.get(i))) {
                    String s[] = delete.split(" ");
                    //     AccountingSystem.getInstance().removeOtherExpense(new Date);
                    giderler.remove(i);
                    giderIDs.remove(i);
                }
            }
            UpdateMe();
        }
    }//GEN-LAST:event_DeleteOutcomeButActionPerformed

    private void DeleteIncomeButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteIncomeButMouseEntered

        Icon img = new ImageIcon("src/accounting/software/images/deleteButton2.png");

        DeleteIncomeBut.setIcon(img);
    }//GEN-LAST:event_DeleteIncomeButMouseEntered

    private void AddIncomeButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddIncomeButMouseEntered

        Icon img = new ImageIcon("src/accounting/software/images/addButton2.png");

        AddIncomeBut.setIcon(img);
    }//GEN-LAST:event_AddIncomeButMouseEntered

    private void AddOutcomeButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddOutcomeButMouseEntered

        Icon img = new ImageIcon("src/accounting/software/images/addButton2.png");

        AddOutcomeBut.setIcon(img);
    }//GEN-LAST:event_AddOutcomeButMouseEntered

    private void DeleteOutcomeButMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteOutcomeButMouseEntered

        Icon img = new ImageIcon("src/accounting/software/images/deleteButton2.png");

        DeleteOutcomeBut.setIcon(img);
    }//GEN-LAST:event_DeleteOutcomeButMouseEntered

    private void AddIncomeButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddIncomeButMouseExited

        Icon img = new ImageIcon("src/accounting/software/images/addButton.png");

        AddIncomeBut.setIcon(img);
    }//GEN-LAST:event_AddIncomeButMouseExited

    private void DeleteIncomeButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteIncomeButMouseExited

        Icon img = new ImageIcon("src/accounting/software/images/deleteButton.png");

        DeleteIncomeBut.setIcon(img);
    }//GEN-LAST:event_DeleteIncomeButMouseExited

    private void AddOutcomeButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddOutcomeButMouseExited

        Icon img = new ImageIcon("src/accounting/software/images/addButton.png");

        AddOutcomeBut.setIcon(img);
    }//GEN-LAST:event_AddOutcomeButMouseExited

    private void DeleteOutcomeButMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteOutcomeButMouseExited

        Icon img = new ImageIcon("src/accounting/software/images/deleteButton.png");

        DeleteOutcomeBut.setIcon(img);
    }//GEN-LAST:event_DeleteOutcomeButMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddIncomeBut;
    private javax.swing.JButton AddOutcomeBut;
    private javax.swing.JButton DeleteIncomeBut;
    private javax.swing.JButton DeleteOutcomeBut;
    private static javax.swing.JPanel incomePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane leftPane;
    private static javax.swing.JPanel outcomePanel;
    private javax.swing.JScrollPane rightPane;
    private javax.swing.JLabel totalIncome;
    private javax.swing.JLabel totalOutCome;
    // End of variables declaration//GEN-END:variables
}
