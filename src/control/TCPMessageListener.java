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
import view.TCP_UPD_Chat;

public class TCPMessageListener implements Runnable {
    
    private int sourcePort;
    private InetAddress ip;
    private String ipStr;
    private Socket socket;
    
    public TCPMessageListener(String ipStr, int sourcePort) {
        this.sourcePort = sourcePort;
        this.ipStr = ipStr;
    }
    
    @Override
    public void run() {
        String message;
        BufferedReader br = null;
        try {
            ip = InetAddress.getByName(ipStr);
            socket = new Socket(ip, sourcePort);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            while ((message = br.readLine()) != null) {
                TCP_UPD_Chat.taChatroom.append(message + "\n");
            }
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Server wurde nicht gefunden!");
        } catch (IOException ex) {
            Logger.getLogger(TCPMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
