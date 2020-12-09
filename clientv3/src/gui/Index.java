/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import client.Chucnang;
import client.G;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import rmi.FileData;
import rmi.Tinnhan;
/**
 *
 * @author minhduc
 */
public class Index extends javax.swing.JPanel {

    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
        addPanel();
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
        menu = new javax.swing.JScrollPane();
        featureList = new javax.swing.JList<>();
        usersOnlinePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsuseronline = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        contentTitlePanel = new javax.swing.JPanel();
        featureLabel = new javax.swing.JLabel();
        noidungPanel = new javax.swing.JScrollPane();
        messageList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        tennguoidung = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(233, 233, 233));
        setMaximumSize(new java.awt.Dimension(800, 510));
        setName("IndexPanel"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 600));

        menu.setPreferredSize(new java.awt.Dimension(250, 600));

        featureList.setBackground(new java.awt.Color(104, 223, 253));
        featureList.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        featureList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Tin nhan", "Gui tin nhan", "Tao nhom", "Nhom tham gia", "Nhom chua tham gia", "Danh sach nguoi dung" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        featureList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                featureListMouseClicked(evt);
            }
        });
        menu.setViewportView(featureList);

        usersOnlinePanel.setPreferredSize(new java.awt.Dimension(250, 600));

        dsuseronline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsuseronlineMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsuseronline);

        jLabel2.setBackground(new java.awt.Color(104, 223, 253));
        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Truc tuyen");

        javax.swing.GroupLayout usersOnlinePanelLayout = new javax.swing.GroupLayout(usersOnlinePanel);
        usersOnlinePanel.setLayout(usersOnlinePanelLayout);
        usersOnlinePanelLayout.setHorizontalGroup(
            usersOnlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        usersOnlinePanelLayout.setVerticalGroup(
            usersOnlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usersOnlinePanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        contentPanel.setPreferredSize(new java.awt.Dimension(690, 550));

        contentTitlePanel.setBackground(new java.awt.Color(1, 127, 1));
        contentTitlePanel.setForeground(new java.awt.Color(254, 254, 254));

        featureLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        featureLabel.setForeground(new java.awt.Color(254, 254, 254));
        featureLabel.setText("Tin nhan");

        javax.swing.GroupLayout contentTitlePanelLayout = new javax.swing.GroupLayout(contentTitlePanel);
        contentTitlePanel.setLayout(contentTitlePanelLayout);
        contentTitlePanelLayout.setHorizontalGroup(
            contentTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentTitlePanelLayout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(featureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        contentTitlePanelLayout.setVerticalGroup(
            contentTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(featureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        messageList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageListMouseClicked(evt);
            }
        });
        noidungPanel.setViewportView(messageList);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(noidungPanel)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addComponent(contentTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noidungPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(255, 4, 0));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Ubuntu", 1, 10)); // NOI18N
        back.setText("DANG XUAT");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        tennguoidung.setFont(new java.awt.Font("Yrsa Medium", 1, 15)); // NOI18N
        tennguoidung.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tennguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usersOnlinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back)
                    .addComponent(tennguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usersOnlinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void featureListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_featureListMouseClicked
        // TODO add your handling code here:
        
        int s = this.featureList.getSelectedIndex();
        if(s>=0){
            DefaultListModel defaultListModel = new DefaultListModel();
            Chucnang.Xoanhan();
            Chucnang.Tatluong();
            if(G.voiceOn==true) Chucnang.TatVoicechat();
            if(s==0){
                Chucnang.HienthiDsTinnhan();
            }
            if(s==1){
                G.featureLabel="Gui tin nhan";
                Chucnang.An();
                Index.guitinPanel.setVisible(true);
                Chucnang.HienthiDsTindagui();
            }
            if(s==2){
                G.featureLabel="Tao nhom";
                Chucnang.An();
                Index.taonhomPanel.setVisible(true);
                Chucnang.HienthiDsNhomdatao();
                Chucnang.HienthiDsNhomthamgia();
            }
            if(s==3){
                G.featureLabel="Nhom tham gia";
                Chucnang.An();
                Index.nhomthamgiaPanel.setVisible(true);
                Chucnang.HienthiDsNhomthamgia();
            }
            if(s==4){
                G.featureLabel="Nhom chua tham gia";
                Chucnang.An();
                Index.nhomchuathamgiaPanel.setVisible(true);
                Chucnang.Batluongnhomchuathamgia();
            }
            if(s==5){
                G.featureLabel="Danh sach nguoi dung";
                Chucnang.An();
                Index.dsnguoidungPanel.setVisible(true);
                Chucnang.HienthiDsNguoidung();
            }
            this.featureLabel.setText(G.featureLabel);
        }
    }//GEN-LAST:event_featureListMouseClicked

    private void messageListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageListMouseClicked
        // TODO add your handling code here:
        try {
                String value = this.messageList.getSelectedValue();
                if(value!=null){
                    String[] data=value.split("\\|\\|");
                    String[] fileinfo = data[3].split(",");
                    if(data[1].equals("file")){
                        int x=javax.swing.JOptionPane.showConfirmDialog(guitinPanel, "Download "+fileinfo[0]);
                        if(x==javax.swing.JOptionPane.YES_OPTION){
                        FileOutputStream fileOutputStream;
                        File file = new File(fileinfo[0]);
                        fileOutputStream = new FileOutputStream(file);
                        FileData fileData = G.iControl.nhanfile(data[2],G.tennguoidung, fileinfo[0]);
                        fileOutputStream.write(fileData.data);
                        fileOutputStream.close();
                        }
                        
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            }catch (Exception e){
                System.out.println("Khong load duoc tin");
            }
    }//GEN-LAST:event_messageListMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        try {
            // TODO add your handling code here:
            G.iControl.dangxuat(G.tennguoidung);
            StartClient.index.setVisible(false);
            StartClient.page1.setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        
    }//GEN-LAST:event_backMouseClicked

    private void dsuseronlineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsuseronlineMouseClicked
        // TODO add your handling code here:
        String value=Index.dsuseronline.getSelectedValue();
        if(value!=null){
            
            G.nguoinhan = value;
            Chucnang.An();
            Chucnang.Tatluong();
            Chucnang.Batluongtrochuyennguoidung();
            Index.featureLabel.setText(value);
            Index.trochuyennguoidungPanel.setVisible(true);
        }
    }//GEN-LAST:event_dsuseronlineMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            boolean dx = G.iControl.dangxuat(G.tennguoidung);
            System.exit(0);
        } catch (RemoteException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void addPanel(){
        this.guitinPanel = new Guitin();
        this.guitinPanel.setBounds(0,40,690,550);
        this.guitinPanel.setVisible(false);
        Index.contentPanel.add(guitinPanel);
        this.taonhomPanel = new Taonhom();
        this.taonhomPanel.setBounds(0,40,690,550);
        this.taonhomPanel.setVisible(false);
        Index.contentPanel.add(taonhomPanel);
        this.nhomchuathamgiaPanel = new Nhomchuathamgia();
        this.nhomchuathamgiaPanel.setBounds(0,40,690,550);
        this.nhomchuathamgiaPanel.setVisible(false);
        Index.contentPanel.add(nhomchuathamgiaPanel);
        this.tinnhannhomPanel = new Tinnhannhom();
        this.tinnhannhomPanel.setBounds(0,40,690,550);
        this.tinnhannhomPanel.setVisible(false);
        Index.contentPanel.add(tinnhannhomPanel);
        this.nhomthamgiaPanel = new Nhomthamgia();
        this.nhomthamgiaPanel.setBounds(0,40,690,550);
        this.nhomthamgiaPanel.setVisible(false);
        Index.contentPanel.add(nhomthamgiaPanel);
        this.dsnguoidungPanel = new Danhsachnguoidung();
        this.dsnguoidungPanel.setBounds(0,40,690,550);
        this.dsnguoidungPanel.setVisible(false);
        Index.contentPanel.add(dsnguoidungPanel);
        this.trochuyennguoidungPanel = new Trochuyennguoidung();
        this.trochuyennguoidungPanel.setBounds(0,40,690,550);
        this.trochuyennguoidungPanel.setVisible(false);
        Index.contentPanel.add(trochuyennguoidungPanel);
        contentPanel.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    public static javax.swing.JPanel contentPanel;
    private javax.swing.JPanel contentTitlePanel;
    public static javax.swing.JList<String> dsuseronline;
    public static javax.swing.JLabel featureLabel;
    private javax.swing.JList<String> featureList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane menu;
    public static javax.swing.JList<String> messageList;
    public static javax.swing.JScrollPane noidungPanel;
    public static javax.swing.JLabel tennguoidung;
    private javax.swing.JPanel usersOnlinePanel;
    // End of variables declaration//GEN-END:variables
    public static javax.swing.JPanel guitinPanel;
    public static javax.swing.JPanel taonhomPanel;
    public static javax.swing.JPanel nhomchuathamgiaPanel;
    public static javax.swing.JPanel tinnhannhomPanel;
    public static javax.swing.JPanel nhomthamgiaPanel;
    public static javax.swing.JPanel trochuyennguoidungPanel;
    public static javax.swing.JPanel dsnguoidungPanel;
    
}
