/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rmi.IControl;

/**
 *
 * @author minhduc
 */
public class G {
    public static DatagramSocket socketudp;
    public static DatagramPacket packetgui;
    public static DatagramPacket packetnhan;
    public static Connection connection = Connector.getConnection();
    public static Map<String,String> user = new HashMap<>();
    public static Map<String,String> host_user = new HashMap<>();
    public static Map<String,String> user_connect_user=new HashMap<>();
    public static Map<String,String> userhost_userhost = new HashMap<>();
    public static Map<String,Integer> host_port = new HashMap<>();
    public static Map<String,String> user_host = new HashMap<>();
    public static List<String> usersonline = new ArrayList<>();
    public static Thread thread;
}
