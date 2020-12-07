/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientv2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import rmiv2.IControl;
import rmiv2.Tinnhan;

/**
 *
 * @author minhduc
 */
public class G {
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
    public static List<String> dstatcanhom = new ArrayList<>();
    public static List<String> dsnguoidung = new ArrayList<>();
    //public static javax.swing.JFrame startFrame;
}
