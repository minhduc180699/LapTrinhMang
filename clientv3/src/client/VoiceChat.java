/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

/**
 *
 * @author minhduc
 */
public class VoiceChat {
    public TargetDataLine dataLine;
    public AudioFormat format;
    public static DatagramSocket socket;
    public static DatagramPacket packetgui;
    public static DatagramPacket packetnhan;
    public static InetAddress IP;
    public VoiceChat(){
        try {
            socket = new DatagramSocket();
            IP = InetAddress.getByName(G.config.get("HOST"));
        } catch (SocketException ex) {
            Logger.getLogger(VoiceChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(VoiceChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    AudioFormat getAudioFormat() {
        float sampleRate = 14000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
                bigEndian);
    }
    public void ThuAm() throws LineUnavailableException, IOException{
        format= this.getAudioFormat();
        //khởi tạo Dataline.info
        DataLine.Info info = new DataLine.Info(TargetDataLine.class,format);
        //Kiểm tra hệ thống có hỗ trợ frormat
        if(!AudioSystem.isLineSupported(info)) {
            System.out.println("System no support");
        }
        //Lấy line từ AudioSystem
        dataLine = AudioSystem.getTargetDataLine(format);
        dataLine.open(format);
        dataLine.start();
        System.out.println("san sang gui am thanh");
        byte[] data = new byte[4096];
        int count=0;
        while((count = dataLine.read(data,0,data.length))>0){
            packetgui = new DatagramPacket(data, data.length, IP, 9001);
            //Gửi gói tin
            socket.send(packetgui);
        }

    }
    public void PhatAm(){
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class,format);
            SourceDataLine audioLine =(SourceDataLine) AudioSystem.getLine(info);
            audioLine.open(format);
            audioLine.start();
            int BUFFER_SIZE = 4096;
            System.out.println("San sang phat am thanh");
            byte[] data = new byte[BUFFER_SIZE];
            while (true) {
                packetnhan= new DatagramPacket(data, data.length);
                socket.receive(packetnhan);
                audioLine.write(packetnhan.getData(), 0,packetnhan.getData().length);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
