/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placement.client.dlgs;

import com.placement.business.CollegeBLRemote;
import com.placement.business.PlacementBLRemote;
import com.placement.business.RuleBLRemote;
import com.placement.client.PlacementsDialog;
import com.placement.entity.College;
import com.placement.entity.Placement;
import com.placement.entity.Rule;
import com.placement.utility.EJBWrapperFactory;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kemele
 */
public class EditPlacementDialog extends javax.swing.JDialog {

    int type = 0;
    PlacementBLRemote placementBL = null;
    PlacementsDialog plcDialog = null;
    Placement selectedPlacement = null;
    /**
     * Creates new form EditPlacementDialog
     */
    public EditPlacementDialog(java.awt.Frame parent, boolean modal, int type, PlacementsDialog plcDialog, Placement plc) {
        super(parent, modal);
        this.type = type;
        this.plcDialog = plcDialog;        
        CollegeBLRemote collegeBL = new EJBWrapperFactory().getCollegeBL();        
        initComponents();
        List<College> colleges = collegeBL.getAll();
        for(College c: colleges){
            collegeCmb.addItem(c);
        }
        collegeBL = null; //disconnect session
        RuleBLRemote ruleBL = new EJBWrapperFactory().getRuleBL();
        List<Rule> rules = ruleBL.getAll();
        for(Rule r: rules){
            ruleCmb.addItem(r);
        }
        if(type ==0){
            this.setTitle("New Placement");
            saveBtn.setText("Save");
        }else{
            this.setTitle("Edit Placement");
            saveBtn.setText("Update");
            this.selectedPlacement = plc;
            codeTxt.setText(plc.getCode());
            nameTxt.setText(plc.getName());
            acYearTxt.setText(plc.getAcademicYear());
            collegeCmb.setSelectedItem(plc.getCollegeId());
            ruleCmb.setSelectedItem(plc.getRuleId());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codeTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        acYearTxt = new javax.swing.JTextField();
        collegeCmb = new javax.swing.JComboBox();
        ruleCmb = new javax.swing.JComboBox();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Placement");
        setAlwaysOnTop(true);
        setModal(true);

        jLabel1.setText("Code:");

        jLabel2.setText("Name:");

        jLabel3.setText("College:");

        jLabel4.setText("Ac. Year:");

        jLabel5.setText("Rule:");

        ruleCmb.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acYearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(collegeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ruleCmb, 0, 496, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(collegeCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(acYearTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruleCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        placementBL = new EJBWrapperFactory().getPlacementBL();
        if (type == 0) {
            //save new rule
            try {
                selectedPlacement = this.getPlacement();
                if (selectedPlacement != null && placementBL.save(selectedPlacement)) {
                    plcDialog.prepareDataVector();
                    placementBL = null;
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Cannot save placement data! \n Please review the information u provided!!","Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //update existing rule
            try {          
                selectedPlacement = this.getPlacement();
                if (selectedPlacement != null && placementBL.update(selectedPlacement)) {
                    plcDialog.prepareDataVector();
                    placementBL = null;
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Cannot update placement data! \n Please review the information u provided!!","Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        placementBL=null;           
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private Placement getPlacement(){
        try{
            String code = codeTxt.getText();
            String name = nameTxt.getText();
            String acYear = acYearTxt.getText();
            College  college =(College) collegeCmb.getSelectedItem();
            Rule rule = (Rule)ruleCmb.getSelectedItem();
            Placement p = new Placement();
            if(type !=0){
                p.setId(selectedPlacement.getId());
            }
            p.setCode(code);
            p.setName(name);
            p.setAcademicYear(acYear);
            p.setCollegeId(college);
            p.setRuleId(rule);
            return p;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acYearTxt;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField codeTxt;
    private javax.swing.JComboBox collegeCmb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JComboBox ruleCmb;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
