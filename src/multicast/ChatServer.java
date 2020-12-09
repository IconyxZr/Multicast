/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author ASUS
 */
public class ChatServer {
    public static void main(String[] args) throws Exception{
        MulticastSocket server = new MulticastSocket(1234);
        InetAddress group = InetAddress.getByName("234.5.6.7");
        server.joinGroup(group);
        boolean infinite = true;
        while (infinite) {            
            byte buf[] = new byte[1024];
            DatagramPacket data = new DatagramPacket(buf, buf.length);
            server.receive(data);
            String msg = new String(data.getData()).trim();
            String position[] = msg.split("\\|");
            System.out.println(position[0] + "  :  "+position[1]);
        }
        server.close();
    }
}
