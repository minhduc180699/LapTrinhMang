/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientv2;


import gui.Page1;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiv2.IControl;
import rmiv2.Tinnhan;

public class ClientV2 {
    private static final String HOST = "localhost";
    private static final int PORT = 9000;
    private static Registry registry;
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    registry = LocateRegistry.getRegistry(HOST,PORT);
                    G.iControl = (IControl) registry.lookup(IControl.class.getSimpleName());
                    System.out.println();
                    
                    //frameClient.add(FrameClient.page1);
                    //System.out.println(FrameClient.page1.isVisible());
//                    Tinnhan tinnhan = new Tinnhan("duc","xoai","What you name?");
//                    boolean guitin = G.iControl.guitin(tinnhan);
                    List<Tinnhan> list = new ArrayList<>();
                    list = G.iControl.nhantin("xoai");
                    System.out.println(list.get(1).noidung);
                } catch (IOException ex) {
                    Logger.getLogger(ClientV2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex) {
                    Logger.getLogger(ClientV2.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }
    
}
