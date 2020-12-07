package rmiv2;

import java.io.Serializable;

public class FileData implements Serializable{
    private static final long serialVersionUID = 1L;
    public String nguoigui;
    public String nguoinhan;
    public String tenfile;
    public long kichthuoc;
    public byte [] data;
    public String thoigian;
    public FileData(String nguoigui,String nguoinhan,String tenfile,long kichthuoc){
        this.nguoigui=nguoigui;
        this.nguoinhan=nguoinhan;
        this.tenfile=tenfile;
        this.kichthuoc=kichthuoc;
    }
}
