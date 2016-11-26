/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software.GUIStaffs;

import accounting.software.Expenses;

/**
 *
 * @author emre
 */
public class ExpensePanelFinance extends javax.swing.JPanel {
    Expenses exp;
    /**
     * Creates new form gider
     * @param expe
     * @param Y
     */
    public ExpensePanelFinance(Expenses expe, int Y) {
        initComponents();
        exp = expe;
        Name.setText(exp.getName());
        amount.setText(String.format("%.2f", expe.getExpense()));
        desc.setText(exp.getDescription());
        setBounds(0, Y, 500, 50);
    }
    
    /**
     *
     */
    public ExpensePanelFinance(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Name = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();

        Name.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        Name.setText("Name");

        desc.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        desc.setText("Description");

        amount.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        amount.setText("Amount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(amount)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(desc))
                    .addComponent(amount))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param text
     */
    public void setTextName(String text){
        Name.setText(text);
    }
    
    /**
     *
     * @param text
     */
    public void setAmount(String text){
        amount.setText(text);
    }
    
    /**
     *
     * @param text
     */
    public void setDesc(String text){
        desc.setText(text);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JLabel amount;
    private javax.swing.JLabel desc;
    // End of variables declaration//GEN-END:variables
}
