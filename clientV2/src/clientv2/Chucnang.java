/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientv2;

import clientv2.G;
import gui.Danhsachnguoidung;
import gui.Danhsachnhom;
import gui.Guitin;
import gui.Index;
import gui.Nhomthamgia;
import gui.Taonhom;
import gui.Tinnhannhom;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author minhduc
 */
public class Chucnang {
    public static void An(){
        Index.guitinPanel.setVisible(false);
        Index.taonhomPanel.setVisible(false);
        Index.danhsachnhomPanel.setVisible(false);
        Index.tinnhannhomPanel.setVisible(false);
        Index.noidungPanel.setVisible(false);
        Index.nhomthamgiaPanel.setVisible(false);
        Index.dsnguoidungPanel.setVisible(false);
    }
    public static void Xoanhan(){
        Taonhom.taonhomms.setText("");
        Guitin.sendlabel.setText("");
        Guitin.sendfilelabel.setText("");
        Tinnhannhom.guifilenhomms.setText("");
        Tinnhannhom.guitinnhomms.setText("");
    }
    public static void HienthiDsTinnhan(){
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
    public static void HienthiDsTinnhannhom(){
        try {
                G.dstinnhannhom = G.iControl.nhantinnhom(G.nhomdachon);
                DefaultListModel listmodel = new DefaultListModel();
                int count=0;
                for(count=0;count<G.dstinnhannhom.size();count++){
                    listmodel.addElement(G.dstinnhannhom.get(count).thoigian+"||"+G.dstinnhannhom.get(count).loai+"||"+G.dstinnhannhom.get(count).nguoigui+"||"+G.dstinnhannhom.get(count).noidung);
                }
                Tinnhannhom.dstinnhannhom.setModel(listmodel);
                System.out.println("Hien thi ds tin nhan nhom OK");
            }catch (Exception e){
                System.out.println("Khong nhan duoc tin nhan nhom");
            }
    }
    public static void HienthiDsNhomdatao(){
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
    public static void HienthiDsNhomthamgia(){
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
    public static void HienthiDsTatcanhom(){
        try {
                
                DefaultListModel dsnhomModel = new DefaultListModel();
                G.dstatcanhom = G.iControl.laydstatcanhom();
                for(int count=0;count<G.dstatcanhom.size();count++){
                    dsnhomModel.addElement(G.dstatcanhom.get(count));
                }
                Danhsachnhom.tatcanhomJlist.setModel(dsnhomModel);
            } catch (RemoteException ex) {
                Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void HienthiDsNguoidung(){
        try {
                G.dsnguoidung = G.iControl.laydsnguoidung();
                DefaultListModel dsnguoidungModel = new DefaultListModel();
                for(int count=0;count<G.dsnguoidung.size();count++){
                    dsnguoidungModel.addElement(G.dsnguoidung.get(count));
                }
                Danhsachnguoidung.dsnguoidung.setModel(dsnguoidungModel);
            } catch (RemoteException ex) {
                Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void HienthiDsTindagui(){
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
}
