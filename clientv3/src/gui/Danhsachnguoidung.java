/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import client.Chucnang;
import client.G;

/**
 *
 * @author minhduc
 */
public class Danhsachnguoidung extends javax.swing.JPanel {

    /** Creates new form Danhsachnguoidung */
    public Danhsachnguoidung() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dsnguoidung = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        dsnguoidung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsnguoidungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsnguoidung);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Cac nguoi dung khac");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dsnguoidungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsnguoidungMouseClicked
        // TODO add your handling code here:
        String value = Danhsachnguoidung.dsnguoidung.getSelectedValue();
        if(value!=null){
            G.nguoinhan = value;
            G.featureLabel=value;
            Index.featureLabel.setText(value);
            Chucnang.An();
            Index.trochuyennguoidungPanel.setVisible(true);
            Chucnang.Batluongtrochuyennguoidung();
        }
    }//GEN-LAST:event_dsnguoidungMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JList<String> dsnguoidung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
