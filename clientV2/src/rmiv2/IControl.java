/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiv2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author minhduc
 */
public interface IControl extends Remote{
    public boolean dangky(String ten,String matkhau) throws RemoteException;
    public boolean dangnhap(String ten, String matkhau) throws RemoteException;
    public boolean guitin(Tinnhan tinnhan) throws RemoteException;
    public boolean guitinnhom(Tinnhan tinnhan) throws RemoteException;
    public List<Tinnhan> laydstindagui(String nguoigui) throws RemoteException;
    public List<Tinnhan> nhantin(String nguoinhan) throws RemoteException;
    public List<Tinnhan> nhantinnhom(String nguoinhan) throws RemoteException;
    public boolean guifile(FileData fileData) throws RemoteException;
    public boolean guifilenhom(FileData fileData) throws RemoteException;
    public FileData nhanfile(String nguoigui,String nguoinhan,String tenfile) throws RemoteException;
    public FileData nhanfilenhom(String nguoigui,String nguoinhan,String tenfile) throws RemoteException;
    public boolean taonhom(String nguoitao,String tennhom) throws RemoteException;
    public List<String> laydsnhomdatao(String nguoitao) throws RemoteException;
    public List<String> laydstatcanhom() throws RemoteException;
    public List<String> laydsnhomthamgia(String thanhvien) throws RemoteException;
    public List<String> laydsnguoidung() throws RemoteException;
    public List<String> laydsnguoidungonline() throws RemoteException;
    public boolean thamgianhom(String thanhvien,String tennhom) throws RemoteException;
}
