/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverv2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import rmiv2.*;
public class Control extends UnicastRemoteObject implements IControl{
    private static final long serialVersionUID = 1L;
    public Control() throws RemoteException{
        super();
    }
    @Override
    public boolean dangky(String ten, String matkhau) throws RemoteException {
        try {
            String message;
            Statement statement;
            statement = G.connection.createStatement();
            System.out.println(ten+matkhau);
            String dataTen = "select count(*) as num from users where username="+"'"+ten+ "'";
            System.out.println(dataTen);
            ResultSet resultSet = statement.executeQuery(dataTen);
            
            boolean b = resultSet.next();
            int n = resultSet.getInt("num");
            if(n==0 && b==true){
                String insert = "insert into users(username,passwd,state) values(?,?,1)";
                PreparedStatement preparedStatement = G.connection.prepareStatement(insert);
                preparedStatement.setString(1, ten);
                preparedStatement.setString(2, matkhau);
                preparedStatement.execute();
                System.out.println("da insert");
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean dangnhap(String ten, String matkhau) throws RemoteException {
        try {
            String message;
            String dataTen = "select count(*) as num from users where username="+"'"+ten+"'"+"and passwd="+"'"+matkhau+"'";
            System.out.println(dataTen);
            Statement statement = G.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(dataTen);
            
            boolean b = resultSet.next();
            int n = resultSet.getInt("num");
            System.out.println(b);
            if(b&& n ==1){
                String updateState = "UPDATE users SET state = 1 WHERE username ="+ "'"+ten+"'";
                statement.executeUpdate(updateState);
                System.out.println("ok login");
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean guitin(Tinnhan tinnhan) {
        try {
            String sql = "insert into tinnhan(noidung,nguoigui,nguoinhan,loai) values(?,?,?,?)";
            PreparedStatement preparedStatement = G.connection.prepareStatement(sql);
            preparedStatement.setString(1,tinnhan.noidung);
            preparedStatement.setString(2, tinnhan.nguoigui);
            preparedStatement.setString(3, tinnhan.nguoinhan);
            preparedStatement.setString(4, tinnhan.loai);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Tinnhan> nhantin(String nguoinhan) {
        try {
            List<Tinnhan> list = new ArrayList<>();
            String sql = "select * from tinnhan where nguoinhan="+"'"+nguoinhan+"'"+"order by thoigian desc";
            Statement statement = G.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Tinnhan tinnhan = new Tinnhan();
                tinnhan.noidung = resultSet.getString("noidung");
                tinnhan.nguoigui=resultSet.getString("nguoigui");
                tinnhan.nguoinhan=resultSet.getString("nguoinhan");
                tinnhan.thoigian = resultSet.getString("thoigian");
                tinnhan.loai = resultSet.getString("loai");
                list.add(tinnhan);
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean guifile(FileData fileData) throws RemoteException {
        try {
            String pathdir = "FileUser/"+fileData.nguoinhan+"/"+fileData.nguoigui;
            System.out.println(pathdir);
            java.io.File dir = new java.io.File(pathdir);
            System.out.println("(Nhan file) Tao thu muc OK");
            if(!dir.exists()){
                boolean createDir = dir.mkdirs();
                System.out.println("Tao thu muc client OK");
            }
            java.io.File file = new java.io.File(pathdir+"/"+fileData.tenfile);
            FileOutputStream fileout = new FileOutputStream(file);
            System.out.println("Tao file OK");
            fileout.write(fileData.data);
            System.out.println("Ghi file user OK");
            fileout.close();
            //ghi vao database
            //Statement s = Connector.getConnection().createStatement();
            String sql = "INSERT INTO file (tenfile,kichthuoc,nguoigui,nguoinhan, path) "
                    + "VALUES (?, ?, ?, ?,?)";
            PreparedStatement pst = G.connection.prepareStatement(sql);
            pst.setString(1, fileData.tenfile);
            pst.setLong(2, fileData.kichthuoc);
            pst.setString(3, fileData.nguoigui);
            pst.setString(4, fileData.nguoinhan);
            pst.setString(5, pathdir+"/"+fileData.tenfile);
            pst.execute();
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public FileData nhanfile(String nguoigui,String nguoinhan, String tenfile) throws RemoteException {
        FileInputStream filein = null;
        try {
            File file = new File("FileUser/"+nguoinhan+"/"+nguoigui+"/"+tenfile);
            filein = new FileInputStream(file);
            FileData fileData = new FileData(nguoigui, nguoinhan, tenfile, file.length());
            fileData.data = new byte[(int) file.length()];
            int count;
            count = filein.read(fileData.data);
            return fileData;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                filein.close();
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean taonhom(String nguoitao, String tennhom) throws RemoteException {
        try {
            String sql = "insert into nhom(tennhom,nguoitao) values (?,?)";
            PreparedStatement preparedStatement = G.connection.prepareStatement(sql);
            preparedStatement.setString(1, tennhom);
            preparedStatement.setString(2, nguoitao);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<String> laydsnhomdatao(String nguoitao) throws RemoteException {
        try {
            List<String> list = new ArrayList<>();
            String sql = "select * from nhom where nguoitao="+"'"+nguoitao+"'"+"order by thoigian desc";
            Statement statement = G.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(resultSet.getString("tennhom"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<String> laydstatcanhom() throws RemoteException {
        try {
            List<String> list = new ArrayList<>();
            String sql = "select * from nhom where 1 order by thoigian desc";
            Statement statement = G.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(resultSet.getString("tennhom"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<String> laydsnhomthamgia(String thanhvien) throws RemoteException {
        try {
            List<String> list = new ArrayList<>();
            String sql = "select * from thamgianhom where state=1 and thanhvien="+"'"+thanhvien+"'"+"order by thoigian desc";
            Statement statement = G.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(resultSet.getString("tennhom"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<String> laydsnguoidungonline() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean thamgianhom(String thanhvien, String tennhom) throws RemoteException {
        try {
            String sql = "insert into thamgianhom(tennhom,thanhvien,state) values(?,?,1)";
            PreparedStatement preparedStatement = G.connection.prepareStatement(sql);
            preparedStatement.setString(1,tennhom);
            preparedStatement.setString(2,thanhvien);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean guitinnhom(Tinnhan tinnhan) throws RemoteException {
        try {
            String sql = "insert into tinnhannhom(noidung,nguoigui,tennhom,loai) values(?,?,?,?)";
            PreparedStatement preparedStatement = G.connection.prepareStatement(sql);
            preparedStatement.setString(1,tinnhan.noidung);
            preparedStatement.setString(2, tinnhan.nguoigui);
            preparedStatement.setString(3, tinnhan.nguoinhan);
            preparedStatement.setString(4, tinnhan.loai);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean guifilenhom(FileData fileData) throws RemoteException {
        try {
            String pathdir = "FileGroup/"+fileData.nguoinhan+"/"+fileData.nguoigui;
            System.out.println(pathdir);
            java.io.File dir = new java.io.File(pathdir);
            System.out.println("(Nhan file) Tao thu muc OK");
            if(!dir.exists()){
                boolean createDir = dir.mkdirs();
                System.out.println("Tao thu muc client OK");
            }
            java.io.File file = new java.io.File(pathdir+"/"+fileData.tenfile);
            FileOutputStream fileout = new FileOutputStream(file);
            System.out.println("Tao file OK");
            fileout.write(fileData.data);
            System.out.println("Ghi file user OK");
            fileout.close();
            
            return true;
        }
        catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return  false;
        }
    }

    @Override
    public List<Tinnhan> nhantinnhom(String nguoinhan) throws RemoteException {
        try {
            List<Tinnhan> list = new ArrayList<>();
            String sql = "select * from tinnhannhom where tennhom="+"'"+nguoinhan+"'"+"order by thoigian desc";
            Statement statement = G.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Tinnhan tinnhan = new Tinnhan();
                tinnhan.noidung = resultSet.getString("noidung");
                tinnhan.nguoigui=resultSet.getString("nguoigui");
                tinnhan.nguoinhan=resultSet.getString("tennhom");
                tinnhan.thoigian = resultSet.getString("thoigian");
                tinnhan.loai = resultSet.getString("loai");
                list.add(tinnhan);
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public FileData nhanfilenhom(String nguoigui, String nguoinhan, String tenfile) throws RemoteException {
        FileInputStream filein = null;
        try {
            File file = new File("FileGroup/"+nguoinhan+"/"+nguoigui+"/"+tenfile);
            filein = new FileInputStream(file);
            FileData fileData = new FileData(nguoigui, nguoinhan, tenfile, file.length());
            fileData.data = new byte[(int) file.length()];
            int count;
            count = filein.read(fileData.data);
            return fileData;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                filein.close();
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<String> laydsnguoidung() throws RemoteException {
        try {
            List<String> list = new ArrayList<>();
            String sql = "select username from users where 1 order by username";
            Statement statement = G.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                list.add(resultSet.getString("username"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<Tinnhan> laydstindagui(String nguoigui) throws RemoteException {
        try {
            List<Tinnhan> list = new ArrayList<>();
            String sql = "select * from tinnhan where nguoigui="+"'"+nguoigui+"'"+"order by thoigian desc";
            Statement statement = G.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Tinnhan tinnhan = new Tinnhan();
                tinnhan.noidung = resultSet.getString("noidung");
                tinnhan.nguoigui=resultSet.getString("nguoigui");
                tinnhan.nguoinhan=resultSet.getString("nguoinhan");
                tinnhan.thoigian = resultSet.getString("thoigian");
                tinnhan.loai = resultSet.getString("loai");
                list.add(tinnhan);
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
