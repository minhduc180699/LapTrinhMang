/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.sampled.Port;
import rmi.IControl;
import rmi.Tinnhan;

/**
 *
 * @author minhduc
 */
public class G {
    public static String HOST;
    public static int PORT ;
    public static VoiceChat voiceChat;
    public static boolean voiceOn = false;
    public static Thread thuamThread;
    public static Thread phatamThread;
    public static Map<String,String> config= new HashMap<String, String>();
    public static IControl iControl;
    public static String tennguoidung;
    public static String featureLabel="Tin nhan";
    public static File file;
    public static String nhomdachon;
    public static String nguoinhan;
    public static List<Tinnhan> dstinnhan = new ArrayList<>();
    public static List<Tinnhan> dstindagui = new ArrayList<>();
    public static List<Tinnhan> dstinnhannhom = new ArrayList<>();
    public static List<String> dsnhomdatao = new ArrayList<>();
    public static List<String> dsnhomthamgia = new ArrayList<>();
    public static List<String> dsnhomchuathamgia = new ArrayList<>();
    public static List<String> dsnguoidung = new ArrayList<>();
    public static List<String> dsnguoidungonline = new ArrayList<>();
    public static List<Tinnhan> dstinguivanhan = new ArrayList<>();
    public static boolean luongtrochuyennguoidung;
    public static boolean luongtinnhan;
    public static boolean luongtinnhannhom;
    public static boolean luongnhomchuathamgia;
    public static boolean luongnguoidungonline;
    public static boolean luongvoicechat;
    //public static javax.swing.JFrame startFrame;
}
