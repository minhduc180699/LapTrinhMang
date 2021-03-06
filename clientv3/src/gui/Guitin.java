/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import client.Chucnang;
import client.G;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingNode;
import javax.swing.JFileChooser;
import rmi.FileData;
import rmi.Tinnhan;

/**
 *
 * @author minhduc
 */
public class Guitin extends javax.swing.JPanel {

    public Guitin() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        messagecontent = new javax.swing.JTextPane();
        sendtext = new javax.swing.JButton();
        receiver = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dstindagui = new javax.swing.JList<>();
        nguoinhan = new javax.swing.JLabel();
        sendFile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        chooseFile = new javax.swing.JButton();
        filenameLabel = new javax.swing.JLabel();
        sendlabel = new javax.swing.JLabel();
        sendfilelabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(690, 550));

        messagecontent.setToolTipText("Input content ");
        jScrollPane1.setViewportView(messagecontent);

        sendtext.setBackground(new java.awt.Color(170, 170, 170));
        sendtext.setText("Gui tin");
        sendtext.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sendtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendtextActionPerformed(evt);
            }
        });

        receiver.setBackground(new java.awt.Color(254, 254, 254));
        receiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Nguoi nhan");

        jScrollPane2.setViewportView(dstindagui);

        nguoinhan.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        nguoinhan.setText("Danh sach tin da gui");

        sendFile.setText("Gui file");
        sendFile.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(170, 170, 170)));
        sendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFileActionPerformed(evt);
            }
        });

        jLabel3.setText("Gui file");

        chooseFile.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
        chooseFile.setText("Chon file");
        chooseFile.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileActionPerformed(evt);
            }
        });

        jLabel4.setText("Noi dung");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sendlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(27, 27, 27)
                                        .addComponent(filenameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sendfilelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(sendtext, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(receiver, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(nguoinhan)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filenameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receiver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseFile))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendFile, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(sendfilelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendtext, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(nguoinhan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void receiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiverActionPerformed

    private void sendtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendtextActionPerformed
        try {
                // TODO add your handling code here
                String noidung = this.messagecontent.getText();
                String nguoinhan = this.receiver.getText();
                String nguoigui = G.tennguoidung;
                if(!nguoinhan.equals("")&&!noidung.equals("")){
                    boolean guitin = G.iControl.guitin(new Tinnhan(nguoigui, nguoinhan, noidung,"text"));
                    if(guitin==true){
                        this.sendlabel.setText("Da gui");
                        this.messagecontent.setText("");
                        Chucnang.HienthiDsTindagui();
                    }
                    else{
                        this.sendlabel.setText("Khong thanh cong");
                    }
                }
                else{
                    sendlabel.setText("Kiem tra nguoi nhan noi dung");
                }
            } catch (RemoteException ex) {
            Logger.getLogger(Guitin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendtextActionPerformed

    private void chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int x = fileChooser.showOpenDialog(this);
        if(x==javax.swing.JFileChooser.APPROVE_OPTION){
            G.file = fileChooser.getSelectedFile();
            this.filenameLabel.setText(G.file.getName());
            G.chonfile=true;
        }
        //fileChooser.setBounds(100, 100, 500, 418);
        //fileChooser.setVisible(true);
    }//GEN-LAST:event_chooseFileActionPerformed

    private void sendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFileActionPerformed
        try {
            // TODO add your handling code here:
            String nguoinhan=this.receiver.getText();
            if(!nguoinhan.equals("")&&G.chonfile==true){
                boolean guitenfile = G.iControl.guitin(new Tinnhan(G.tennguoidung, nguoinhan, G.file.getName()+","+G.file.length()+"KB","file"));
                FileData fileData = new FileData(G.tennguoidung, nguoinhan,G.file.getName(),G.file.length());
                fileData.data = new byte[(int) G.file.length()];
                FileInputStream fileInputStream=new FileInputStream(G.file);
                int count;
                if((count = fileInputStream.read(fileData.data))>=0){
                }
                fileInputStream.close();
                boolean guifile = G.iControl.guifile(fileData);
                if(guitenfile==true&&guifile==true){
                    this.sendfilelabel.setText("Da gui");
                    G.chonfile=false;
                    Chucnang.HienthiDsTindagui();
                }
                else{
                    this.sendfilelabel.setText("Khong thanh cong!");
                }
            }
            else{
                sendfilelabel.setText("That bai, moi kiem tra lai");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Guitin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Guitin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Guitin.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e){
            System.out.println("loi gui file");
        }
    }//GEN-LAST:event_sendFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFile;
    public static javax.swing.JList<String> dstindagui;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane messagecontent;
    public static javax.swing.JLabel nguoinhan;
    private javax.swing.JTextField receiver;
    private javax.swing.JButton sendFile;
    public static javax.swing.JLabel sendfilelabel;
    public static javax.swing.JLabel sendlabel;
    private javax.swing.JButton sendtext;
    // End of variables declaration//GEN-END:variables
}
