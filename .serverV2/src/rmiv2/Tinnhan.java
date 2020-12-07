/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiv2;

import java.io.Serializable;

public class Tinnhan implements Serializable{
    private static final long serialVersionUID = 1L;
    public Tinnhan() {
        System.out.println("Tin nhan contructor");
    }
    public Tinnhan(String nguoigui,String nguoinhan,String noidung,String loai){
        this.nguoigui = nguoigui;
        this.nguoinhan=nguoinhan;
        this.noidung = noidung;
        this.loai = loai;
    }
    public String nguoigui;
    public String nguoinhan;
    public String noidung;
    public String thoigian;
    public String loai;
}
