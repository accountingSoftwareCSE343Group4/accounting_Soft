/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounting.software;

import java.awt.Dialog;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;

/**
 *
 * @author emre
 */
public class PersonnelFrame extends javax.swing.JPanel {

    //Add Button Dialog
    AddPersonnelDialog addDialog = new AddPersonnelDialog(MainFrame.mainFrame, true);

    private boolean edit = false;

    /**
     * Creates new form personnelFrame
     */
    public PersonnelFrame() {
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

        selectPersonnel = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        idTextBox = new javax.swing.JTextField();
        nameTextBox = new javax.swing.JTextField();
        surnameTextBox = new javax.swing.JTextField();
        phoneTextBox = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        sskPrimTextBox = new javax.swing.JTextField();
        salaryTextBox = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JobField = new javax.swing.JTextField();
        Logo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(176, 190, 197));
        setPreferredSize(new java.awt.Dimension(1149, 580));

        selectPersonnel.setName(""); // NOI18N
        selectPersonnel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectPersonnelİtemStateChanged(evt);
            }
        });
        selectPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPersonnelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID number         :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Name                :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Surname           :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Phone Number  :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Address             :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("SSk Primi          :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Salary               :");

        idTextBox.setEditable(false);
        idTextBox.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        idTextBox.setText("Idnumb");
        idTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        idTextBox.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        nameTextBox.setEditable(false);
        nameTextBox.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        nameTextBox.setText("Name");
        nameTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nameTextBox.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        nameTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextBoxActionPerformed(evt);
            }
        });

        surnameTextBox.setEditable(false);
        surnameTextBox.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        surnameTextBox.setText("Surname");
        surnameTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        surnameTextBox.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        phoneTextBox.setEditable(false);
        phoneTextBox.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        phoneTextBox.setText("Phone Number");
        phoneTextBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        phoneTextBox.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        addressField.setEditable(false);
        addressField.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        addressField.setText("Address");
        addressField.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        sskPrimTextBox.setEditable(false);
        sskPrimTextBox.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        sskPrimTextBox.setText("SSK prim");
        sskPrimTextBox.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        salaryTextBox.setEditable(false);
        salaryTextBox.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        salaryTextBox.setText("Salary");
        salaryTextBox.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/editButton.png"))); // NOI18N
        editButton.setContentAreaFilled(false);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editButtonMouseExited(evt);
            }
        });
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/deleteButton.png"))); // NOI18N
        removeButton.setContentAreaFilled(false);
        removeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeButtonMouseExited(evt);
            }
        });
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accounting/software/images/addButton.png"))); // NOI18N
        addButton.setContentAreaFilled(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButtonMouseExited(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Job                           :");

        JobField.setText("Job");
        JobField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JobFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(selectPersonnel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(surnameTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(phoneTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(idTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(sskPrimTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(salaryTextBox, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(JobField))
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(selectPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(surnameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(phoneTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JobField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(sskPrimTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(salaryTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Finds a given name in list
     *
     * @param name
     * @return returns index of founded otherwise -1
     */
    private Personnel findinList(int id) {
        for (int i = 0; i < AccountingSystem.getInstance().getPersonnelSize(); ++i) {
            if ((AccountingSystem.getInstance().getPerson(i).getId() == id)) {
                return AccountingSystem.getInstance().getPerson(i);
            }
        }
        return null;
    }

    public void updateMe() {
        selectPersonnel.removeAllItems();
        for (int i = 0; i < AccountingSystem.getInstance().getPersonnelSize(); ++i) {
            selectPersonnel.addItem(Integer.toString(AccountingSystem.getInstance().getPerson(i).getId()));
        }
        selectPersonnel.setSelectedIndex(0);
        Personnel pers = AccountingSystem.getInstance().getPerson(0);

        idTextBox.setText(String.valueOf(pers.getId()));
        nameTextBox.setText(pers.getName());
        surnameTextBox.setText(pers.getLastName());
        phoneTextBox.setText(pers.getPhoneNumber());
        addressField.setText(pers.getAddress());
        sskPrimTextBox.setText(String.valueOf(pers.getSskBonus()));
        salaryTextBox.setText(Double.toString(pers.getSalary()));
        JobField.setText(pers.getJop());
    }
    private void selectPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPersonnelActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_selectPersonnelActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        
        edit = !edit;
        
                
        if (edit) {
            Icon img = new ImageIcon(getClass().getResource("images/doneButton2.png"));
            editButton.setIcon(img);
        } else {
            Icon img = new ImageIcon(getClass().getResource("images/editButton2.png"));
            editButton.setIcon(img);
        }
        
        if (editButton.getText().equals("Edit")) {
            idTextBox.setEditable(true);
            nameTextBox.setEditable(true);
            surnameTextBox.setEditable(true);
            phoneTextBox.setEditable(true);
            addressField.setEditable(true);
            sskPrimTextBox.setEditable(true);
            salaryTextBox.setEditable(true);
            JobField.setEditable(true);
        } else {
            JobField.setEditable(false);
            idTextBox.setEditable(false);
            nameTextBox.setEditable(false);
            surnameTextBox.setEditable(false);
            phoneTextBox.setEditable(false);
            addressField.setEditable(false);
            sskPrimTextBox.setEditable(false);
            salaryTextBox.setEditable(false);
            String id = (String) selectPersonnel.getSelectedItem();

            Personnel pers = findinList(Integer.parseInt(id));
            if (pers == null) {
                return;
            }
            try {

                pers.setId(Integer.parseInt(idTextBox.getText()));
                pers.setAddress(addressField.getText());
                pers.setLastName(surnameTextBox.getText());
                pers.setName(nameTextBox.getText());
                pers.setPhoneNumber(phoneTextBox.getText());
                pers.setSalary(Double.parseDouble(salaryTextBox.getText()));
                pers.setSskBonus(Double.parseDouble(sskPrimTextBox.getText()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error !!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void nameTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextBoxActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Personnel pers = new Personnel();
        addDialog.setVisible(true);
        if (addDialog.getReturnStatus() == AddPersonnelDialog.RET_OK) {
            String Values[] = addDialog.GetValues();
            pers.setId(Integer.parseInt(Values[0]));
            pers.setName(Values[1]);
            pers.setLastName(Values[2]);
            pers.setPhoneNumber(Values[3]);
            pers.setAddress(Values[4]);
            pers.setJop(Values[5]);
            pers.setSalary(Double.parseDouble(Values[6]));
            pers.setSskBonus(Double.parseDouble(Values[7]));
            selectPersonnel.addItem(Values[0]);
            AccountingSystem.getInstance().addPerson(pers);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void selectPersonnelİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectPersonnelİtemStateChanged
        String id = (String) selectPersonnel.getSelectedItem();
        if (id == null) {
            return;
        }
        Personnel pers = findinList(Integer.parseInt(id));
        if (pers == null) {
            return;
        }

        idTextBox.setText(String.valueOf(pers.getId()));
        nameTextBox.setText(pers.getName());
        surnameTextBox.setText(pers.getLastName());
        phoneTextBox.setText(pers.getPhoneNumber());
        addressField.setText(pers.getAddress());
        sskPrimTextBox.setText(String.valueOf(pers.getSskBonus()));
        salaryTextBox.setText(Double.toString(pers.getSalary()));
        JobField.setText(pers.getJop());
    }//GEN-LAST:event_selectPersonnelİtemStateChanged

    private void JobFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JobFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JobFieldActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        
        AccountingSystem.getInstance().removePerson(Integer.parseInt((String) selectPersonnel.getSelectedItem()));
        selectPersonnel.removeItem(selectPersonnel.getSelectedItem());

    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/addButton2.png"));
        addButton.setIcon(img);
    }//GEN-LAST:event_addButtonMouseEntered

    private void addButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseExited
        Icon img = new ImageIcon(getClass().getResource("images/addButton.png"));
        addButton.setIcon(img);
    }//GEN-LAST:event_addButtonMouseExited

    private void editButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseEntered
        if (edit) {
            Icon img = new ImageIcon(getClass().getResource("images/doneButton2.png"));
            editButton.setIcon(img);
        } else {
            Icon img = new ImageIcon(getClass().getResource("images/editButton2.png"));
            editButton.setIcon(img);
        }

    }//GEN-LAST:event_editButtonMouseEntered

    private void editButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editButtonMouseExited
        if (edit) {
            Icon img = new ImageIcon(getClass().getResource("images/doneButton.png"));
            editButton.setIcon(img);
        } else {
            Icon img = new ImageIcon(getClass().getResource("images/editButton.png"));
            editButton.setIcon(img);
        }

    }//GEN-LAST:event_editButtonMouseExited

    private void removeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseEntered
        Icon img = new ImageIcon(getClass().getResource("images/deleteButton2.png"));
        removeButton.setIcon(img);
    }//GEN-LAST:event_removeButtonMouseEntered

    private void removeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeButtonMouseExited
        Icon img = new ImageIcon(getClass().getResource("images/deleteButton.png"));
        removeButton.setIcon(img);
    }//GEN-LAST:event_removeButtonMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JobField;
    private javax.swing.JLabel Logo;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField idTextBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nameTextBox;
    private javax.swing.JTextField phoneTextBox;
    private javax.swing.JButton removeButton;
    private javax.swing.JTextField salaryTextBox;
    private javax.swing.JComboBox<String> selectPersonnel;
    private javax.swing.JTextField sskPrimTextBox;
    private javax.swing.JTextField surnameTextBox;
    // End of variables declaration//GEN-END:variables
}
