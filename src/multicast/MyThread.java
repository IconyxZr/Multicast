/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author ASUS
 */
public class MyThread extends Thread {

    byte buf[] = new byte[1024];
    DatagramPacket data;
    MulticastSocket chat;
    String message;
    InetAddress group;
    String display = "";
    javax.swing.JTextArea displayChat;

    public MyThread(DatagramPacket data, MulticastSocket chat, String message, InetAddress group, JTextArea displayChat) {
        this.data = data;
        this.chat = chat;
        this.message = message;
        this.group = group;
        this.displayChat = displayChat;
//        try {
//            this.chat.joinGroup(group);
//        } catch (IOException ex) {
//            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        try {
            byte buf[] = new byte[1024];
            data = new DatagramPacket(buf, buf.length);
            chat.receive(data);
            message = new String(data.getData()).trim();
            String position[] = message.split("\\|");
            display += position[0] + "\t: " + position[1] + "\n";
            displayChat.setText(display);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("error");
        }
    }

    public String getMessage() {
        return message;
    }

}
