/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import gui.Danhsachnguoidung;
import gui.Nhomchuathamgia;
import gui.Guitin;
import gui.Index;
import gui.Nhomthamgia;
import gui.Taonhom;
import gui.Tinnhannhom;
import gui.Trochuyennguoidung;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.DefaultListModel;
import rmi.Tinnhan;

/**
 *
 * @author minhduc
 */
public class Chucnang {
    public static void Config() throws FileNotFoundException{
        try {
            FileReader fileReader = new FileReader("net.conf");
            BufferedReader buf = new BufferedReader(fileReader);
            String value;
            while((value=buf.readLine())!=null){
                String[] data = value.split("=");
                G.config.put(data[0],data[1]);
            }
            fileReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void An(){
        Index.guitinPanel.setVisible(false);
        Index.taonhomPanel.setVisible(false);
        Index.nhomchuathamgiaPanel.setVisible(false);
        Index.tinnhannhomPanel.setVisible(false);
        Index.noidungPanel.setVisible(false);
        Index.nhomthamgiaPanel.setVisible(false);
        Index.dsnguoidungPanel.setVisible(false);
        Index.trochuyennguoidungPanel.setVisible(false);
    }
    public static void Tatluong(){
        G.luongtrochuyennguoidung=false;
        G.luongtinnhan=false;
        G.luongtinnhannhom=false;
        G.luongnhomchuathamgia=false;
    }
    public static void Batluongtrochuyennguoidung(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    G.luongtrochuyennguoidung=true;
                    while(G.luongtrochuyennguoidung){
                        Chucnang.HienthiDsTinguivanhan();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Trochuyennguoidung.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    public static void Batluongtinnhannhom(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    G.luongtinnhannhom=true;
                    while(G.luongtinnhannhom){
                        Chucnang.HienthiDsTinnhannhom();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Trochuyennguoidung.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    public static void Batluongnhomchuathamgia(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    G.luongnhomchuathamgia=true;
                    while(G.luongnhomchuathamgia){
                        Chucnang.HienthiDsNhomchuathamgia();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Trochuyennguoidung.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    public static void BatluongNguoidungOnline(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    G.luongnguoidungonline=true;
                    while(G.luongnguoidungonline){
                        Chucnang.HienthiDsNguoidungOnline();
                        Thread.sleep(1500);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    public static void Xoanhan(){
        Taonhom.taonhomms.setText("");
        Guitin.sendlabel.setText("");
        Guitin.sendfilelabel.setText("");
        Tinnhannhom.guifilenhomms.setText("");
        Tinnhannhom.guitinnhomms.setText("");
    }
    public static synchronized void HienthiDsTinnhan(){
        try {
                G.featureLabel="Tin nhan";
                Chucnang.An();
                Index.noidungPanel.setVisible(true);
                G.dstinnhan = G.iControl.nhantin(G.tennguoidung);
                DefaultListModel listmodel = new DefaultListModel();
                int count=0;
                for(count=0;count<G.dstinnhan.size();count++){
                    listmodel.addElement(G.dstinnhan.get(count).thoigian+"||"+G.dstinnhan.get(count).loai+"||"+G.dstinnhan.get(count).nguoigui+"||"+G.dstinnhan.get(count).noidung);
                }
                Index.messageList.setModel(listmodel);
                
            }catch (Exception e){
                System.out.println("Khong load duoc tin");
            }
    }
    public static synchronized void HienthiDsTinnhannhom(){
        try {
                G.dstinnhannhom = G.iControl.nhantinnhom(G.nhomdachon);
                DefaultListModel listmodel = new DefaultListModel();
                int count=0;
                for(count=0;count<G.dstinnhannhom.size();count++){
                    listmodel.addElement(G.dstinnhannhom.get(count).thoigian+"||"+G.dstinnhannhom.get(count).loai+"||"+G.dstinnhannhom.get(count).nguoigui+"||"+G.dstinnhannhom.get(count).noidung);
                }
                Tinnhannhom.dstinnhannhom.setModel(listmodel);
            }catch (Exception e){
                System.out.println("Khong nhan duoc tin nhan nhom");
            }
    }
    public static synchronized void HienthiDsNhomdatao(){
        try {
                G.dsnhomdatao = G.iControl.laydsnhomdatao(G.tennguoidung);
                DefaultListModel nhomdataoModel = new DefaultListModel();
                for(int count=0;count<G.dsnhomdatao.size();count++){
                    nhomdataoModel.addElement(G.dsnhomdatao.get(count));
                }
                Taonhom.dsnhomdatao.setModel(nhomdataoModel);
            } catch (RemoteException ex) {
                Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static synchronized void HienthiDsNhomthamgia(){
        try {
                G.dsnhomthamgia = G.iControl.laydsnhomthamgia(G.tennguoidung);
                DefaultListModel nhomthamgiaModel = new DefaultListModel();
                for(int count=0;count<G.dsnhomthamgia.size();count++){
                    nhomthamgiaModel.addElement(G.dsnhomthamgia.get(count));
                }
                Nhomthamgia.dsnhomthamgia.setModel(nhomthamgiaModel);
            } catch (RemoteException ex) {
                Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static synchronized void HienthiDsNhomchuathamgia(){
        try { 
                DefaultListModel listModel = new DefaultListModel();
                G.dsnhomchuathamgia = G.iControl.laydsnhomchuathamgia(G.tennguoidung);
                for(int count=0;count<G.dsnhomchuathamgia.size();count++){
                    listModel.addElement(G.dsnhomchuathamgia.get(count));
                }
                Nhomchuathamgia.dsnhomchuathamgia.setModel(listModel);
            } catch (RemoteException ex) {
                Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    public static synchronized void HienthiDsNguoidung(){
        try {
                G.dsnguoidung = G.iControl.laydsnguoidung(G.tennguoidung);
                DefaultListModel dsnguoidungModel = new DefaultListModel();
                for(int count=0;count<G.dsnguoidung.size();count++){
                    dsnguoidungModel.addElement(G.dsnguoidung.get(count));
                }
                Danhsachnguoidung.dsnguoidung.setModel(dsnguoidungModel);
            } catch (RemoteException ex) {
                Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static synchronized void HienthiDsTindagui(){
        try {
                G.dstindagui = G.iControl.laydstindagui(G.tennguoidung);
                System.out.println(G.dstindagui.size());
                DefaultListModel lmodel = new DefaultListModel();
                int count=0;
                for(count=0;count<G.dstindagui.size();count++){
                    lmodel.addElement(G.dstindagui.get(count).thoigian+"||"+G.dstindagui.get(count).loai+"||"+G.dstindagui.get(count).nguoinhan+"||"+G.dstindagui.get(count).noidung);
                }
                Guitin.dstindagui.setModel(lmodel);
                
            }catch (Exception e){
                System.out.println("Khong load duoc tin da gui");
            }
    }
    public static synchronized void HienthiDsTinguivanhan(){
        try {
                G.dstinguivanhan = G.iControl.laydstinguivanhan(G.tennguoidung,G.nguoinhan);
                DefaultListModel lmodel = new DefaultListModel();
                int count=0;
                for(count=0;count<G.dstinguivanhan.size();count++){
                    if(G.dstinguivanhan.get(count).nguoigui.equals(G.tennguoidung)){
                        lmodel.addElement(G.dstinguivanhan.get(count).thoigian+
                                "||"+G.dstinguivanhan.get(count).loai+"||"+G.dstinguivanhan.get(count).noidung);
                    }else{
                        lmodel.addElement(">>>To me>>>"+G.dstinguivanhan.get(count).thoigian+
                                "||"+G.dstinguivanhan.get(count).loai+"||"+G.dstinguivanhan.get(count).noidung);
                    }
                }
                Trochuyennguoidung.dstinnhannguoidung.setModel(lmodel);
                
            }catch (Exception e){
                System.out.println("Khong load duoc tin da gui va nhan");
            }
    }
    public static void HienthiDsNguoidungOnline(){
        try {
            G.dsnguoidungonline = G.iControl.laydsnguoidungonline(G.tennguoidung);
            G.dsnguoidungonline.remove(G.tennguoidung);
            DefaultListModel listModel = new DefaultListModel();
            for(int i=0;i<G.dsnguoidungonline.size();i++){
                listModel.addElement(G.dsnguoidungonline.get(i));
            }
            Index.dsuseronline.setModel(listModel);
        } catch (RemoteException ex) {
            Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void TatVoicechat(){
        try {
            // TODO add your handling code here:
            boolean b = G.iControl.tatvoicechat(G.tennguoidung, G.nguoinhan);
            G.voiceOn=false;
            boolean voicems = G.iControl.guitin(new Tinnhan(G.tennguoidung, G.nguoinhan, "Turn off VOICE", "voice"));
            G.thuamThread.stop();
            G.phatamThread.stop();
            
        } catch (RemoteException ex) {
            Logger.getLogger(Trochuyennguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void BatVoiceChat(){
        G.voiceChat = new VoiceChat();
        G.thuamThread  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    G.voiceChat.ThuAm();
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Trochuyennguoidung.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Trochuyennguoidung.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        G.thuamThread.start();
        G.phatamThread = new Thread(new Runnable() {
            @Override
            public void run() {
                G.voiceChat.PhatAm();
            }
        });
        G.phatamThread.start();
        
        try {
            G.voiceOn=true;
            boolean voicems = G.iControl.guitin(new Tinnhan(G.tennguoidung, G.nguoinhan, "Please turn on VOICE", "voice"));
            System.out.println("voicems:"+voicems);
            long t1 = System.currentTimeMillis();
            long t2 = t1+5000;
            while(System.currentTimeMillis()<t2){}
            boolean b = G.iControl.batvoicechat(G.tennguoidung, G.nguoinhan);
        } catch (RemoteException ex) {
            Logger.getLogger(Trochuyennguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
