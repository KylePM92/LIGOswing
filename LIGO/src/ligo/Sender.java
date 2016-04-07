/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligo;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPortOut;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Kyle
 */
public class Sender {
  public static void main(String[] args) throws UnknownHostException, SocketException, java.io.IOException, InterruptedException {
  
    InetAddress remoteIP = InetAddress.getByName("192.168.1.79");
    int remotePort = 8000;
    OSCPortOut sender = new OSCPortOut(remoteIP, remotePort);
    
    String address1 = "/a";
    String address2 = "/b";
    String address3 = "/c";
    
    Object values1[] = new Object[2];
    values1[0] = new Integer(3);
    values1[1] = "Hello World";
    
    Object values2[] = new Object[3];
    values2[0] = new Integer(4);
    values2[1] = new Float(3.14);
    values2[2] = "Hello Sender!";
    
    OSCMessage message1 = new OSCMessage(address1, values1);
    OSCMessage message2 = new OSCMessage(address2, values2);
    OSCMessage message3 = new OSCMessage(address3, values1);
   
    sender.send(message1);
    sender.send(message2);
    sender.send(message3);
  }
}