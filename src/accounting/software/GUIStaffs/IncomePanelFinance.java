package accounting.software.GUIStaffs;

import accounting.software.Income;

/**
 *
 * @author emre
 */
public class IncomePanelFinance extends javax.swing.JPanel {

    private Income inc;

    /**
     * Creates new form gelir
     *
     * @param inc
     * @param Y
     */
    public IncomePanelFinance(Income inc, int Y) {
        initComponents();
        this.inc = inc;
        name.setText(inc.getName());
        amount.setText(String.format("%.2f", inc.getIncome()));
        jLabel2.setText(inc.getDescription());
        setBounds(0, Y, 500, 50);
    }

    /**
     *
     */
    public IncomePanelFinance() {
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

        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        name.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        name.setText("Name");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Desc");

        amount.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        amount.setText("Amount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(amount)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name)
                            .addComponent(amount))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param text
     */
    public void setTextName(String text) {
        name.setText(text);
    }

    /**
     *
     * @param text
     */
    public void setAmount(String text) {
        amount.setText(text);
    }

    /**
     *
     * @param text
     */
    public void setDesc(String text) {
        jLabel2.setText(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
