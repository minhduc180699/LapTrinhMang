/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverv2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiv2.IControl;

/**
 *
 * @author minhduc
 */
public class ServerV2 {
    private static final int POST = 9000;
    private static Registry registry;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        registry = LocateRegistry.createRegistry(POST);
        registry.bind(IControl.class.getSimpleName(), new Control());
    }
    
}
