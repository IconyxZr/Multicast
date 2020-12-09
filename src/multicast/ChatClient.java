/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */

public class ChatClient {

    public static void main(String[] args) throws Exception {
        MulticastSocket chat = new MulticastSocket();
        InetAddress group = InetAddress.getByName("234.5.6.7");
        chat.joinGroup(group);
        System.out.println("Type a username : ");
        String username = new Scanner(System.in).nextLine();
        while (true) {
            String msg = "";
            System.out.print("Type a message : ");
            String br = new Scanner(System.in).nextLine();
            msg = username+"|"+br;
            DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, 1234);
            chat.send(data);
        }
    }
}
