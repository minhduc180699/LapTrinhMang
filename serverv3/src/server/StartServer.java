/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.IControl;

/**
 *
 * @author minhduc
 */
public class StartServer {

    private static final int POST = 9000;
    private static Registry registry;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, SocketException {
        registry = LocateRegistry.createRegistry(POST);
        registry.bind(IControl.class.getSimpleName(), new Control());
        G.socketudp = new DatagramSocket(9001);
        Thread threadudp =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int BUFFER_SIZE = 4096;

                    byte[] packetgui = new byte[BUFFER_SIZE];
                    byte[] packetnhan = new byte[BUFFER_SIZE];
                    //int bytesRead = -1;
                    DatagramPacket rcvPkt;
                    DatagramPacket sendPkt;
                    for(int i=0;i<G.userhost_userhost.size();i++){
                        System.out.println(G.userhost_userhost.toString());
                    }
                    int count=0;
                    while (true) {
                        rcvPkt= new DatagramPacket(packetnhan, packetnhan.length);
                        G.socketudp.receive(rcvPkt);
                        String host1 =rcvPkt.getAddress().getHostAddress();
                        G.host_port.put(host1,rcvPkt.getPort());
                        if(G.userhost_userhost.containsKey(G.userhost_userhost.get(host1))&&G.userhost_userhost.get(G.userhost_userhost.get(host1)).equals(host1)){
                            String host2 = G.userhost_userhost.get(host1);
                            InetAddress IP2 = InetAddress.getByName(host2);
                            int port2 = G.host_port.get(host2);
                            System.out.println(host1+":"+port2+"->"+host2+":"+port2);
                            sendPkt= new DatagramPacket(rcvPkt.getData(), rcvPkt.getData().length,IP2,port2);
                            G.socketudp.send(sendPkt);
                        }
                    }
                } catch (Exception e) {
                }
            }
        });
        threadudp.start();
        Thread threadflow=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        //                    for(int i=0;i<G.host_port.size();i++){
//                        System.out.println(G.host_port.p);
//                    }
System.out.println("G.host_port"+G.host_port.toString());
                        System.out.println("G.userhost_userhost:"+G.userhost_userhost.toString());
                        //System.out.println("G.");
Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
}
