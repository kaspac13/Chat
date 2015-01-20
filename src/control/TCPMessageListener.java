package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class TCPMessageListener implements Runnable{
    
    
    int sourcePort;
    InetAddress ip;
    String ipStr;
    Socket socket;

    @Override
    public void run() {
        BufferedReader br;
        try {
            ip = InetAddress.getByName(ipStr);
            socket = new Socket(ip, sourcePort);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Server wurde nicht gefunden!");
        } catch (IOException ex) {
            Logger.getLogger(TCPMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true)
        {
            
        }
        
    }
}
