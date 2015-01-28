package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.TCP_UDP_Chat;

public class TCPMessageListener implements Runnable {

    
    private int destinationPort;
    private InetAddress ip;
    private String host;
    private Socket socket;
    private BufferedReader br;

    public TCPMessageListener(String ipStr, int destinationPort) throws Exception {
        if (ipStr == null || ipStr.equals("") || destinationPort < 0) {
            throw new Exception("You have to input a correct host");
        }

        
        this.host = ipStr;
        this.destinationPort = destinationPort;
    }

    public void connect() throws Exception {
        ip = InetAddress.getByName(host);
        System.out.println(ip.getHostAddress());
        socket = new Socket(ip, destinationPort);
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Connected");
    }

    @Override
    public void run() {
        JOptionPane.showMessageDialog(null, "TROLOLOLOLOLOLLOoo");
        String message;
        try {

            while ((message = br.readLine()) != null) {
                System.out.println(message);
                TCP_UDP_Chat.taChatroom.append(message + "\n");
            }
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Server wurde nicht gefunden!");
        } catch (IOException ex) {
            Logger.getLogger(TCPMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
