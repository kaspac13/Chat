package view;

import control.TCPMessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class TCP_UDP_Chat extends javax.swing.JFrame {

    private String nickName, host;
    private int source, dest;
    private TCPMessageListener tcpListener;
    private Thread tcpThread, udpThread;

    private final String[] protocols = {"TCP", "UDP"};

    public TCP_UDP_Chat() {
        initComponents();
        initCombobox();
    }

    private void loadInformation() throws Exception {
        nickName = tfNickname.getText();
        host = tfIP.getText();
        source = Integer.parseInt(tfSourcePort.getText());
        dest = Integer.parseInt(tfDestinationPort.getText());

        if (nickName == null || nickName.isEmpty()) {
            throw new Exception("You have to input a nickname");
        }

        if (host == null || host.isEmpty()) {
            throw new Exception("You have to input a host");
        }

        if (source <= 0 || dest <= 0) {
            throw new Exception("The port must be bigger than 0");
        }

    }

    private void initCombobox() {
        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        cbModel.addElement("TCP");
        cbModel.addElement("UDP");
        cbWhichProtocol.setModel(cbModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfIP = new javax.swing.JTextField();
        tfSourcePort = new javax.swing.JTextField();
        tfDestinationPort = new javax.swing.JTextField();
        tfNickname = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbWhichProtocol = new javax.swing.JComboBox();
        btConnect = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taChatroom = new javax.swing.JTextArea();
        tfMessage = new javax.swing.JTextField();
        btSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat with TCP or UPD");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Send-Data"));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setLayout(new java.awt.GridLayout(4, 0));

        jLabel1.setText("IP-Address:");
        jPanel3.add(jLabel1);

        jLabel2.setText("Source-Port:");
        jPanel3.add(jLabel2);

        jLabel3.setText("Destination-Port:");
        jPanel3.add(jLabel3);

        jLabel4.setText("Nickname:");
        jPanel3.add(jLabel4);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel3, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridLayout(4, 0));

        tfIP.setText("188.173.255");
        jPanel4.add(tfIP);
        jPanel4.add(tfSourcePort);
        jPanel4.add(tfDestinationPort);
        jPanel4.add(tfNickname);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel4, gridBagConstraints);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setText("TCP or UPD");
        jPanel6.add(jLabel5);

        cbWhichProtocol.setToolTipText("");
        jPanel6.add(cbWhichProtocol);

        btConnect.setText("Connect");
        btConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onConnect(evt);
            }
        });
        jPanel6.add(btConnect);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel6, gridBagConstraints);

        getContentPane().add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat"));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        taChatroom.setColumns(20);
        taChatroom.setRows(5);
        jScrollPane2.setViewportView(taChatroom);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(jScrollPane2, gridBagConstraints);

        tfMessage.setToolTipText("Enter a message ;-)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(tfMessage, gridBagConstraints);

        btSend.setText("Send");
        btSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSend(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel2.add(btSend, gridBagConstraints);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSend(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSend
        //dann Senden Klasse öffnen
    }//GEN-LAST:event_onSend

    private void onConnect(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onConnect
        try {
            loadInformation();

            if (cbWhichProtocol.getSelectedItem().toString().equals("TCP")) {
                System.out.println("Combobox equals TCP");
                tcpListener = new TCPMessageListener(host, source, dest);
                tcpListener.connect();
                tcpThread = new Thread(tcpThread);
                tcpThread.start();
            }

            btConnect.setEnabled(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "SCHEISS EXCEPTION AUFGETRETEN");
            System.out.println("LOL");
        }
    }//GEN-LAST:event_onConnect

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TCP_UDP_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TCP_UDP_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TCP_UDP_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TCP_UDP_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TCP_UDP_Chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConnect;
    private javax.swing.JButton btSend;
    private javax.swing.JComboBox cbWhichProtocol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea taChatroom;
    private javax.swing.JTextField tfDestinationPort;
    private javax.swing.JTextField tfIP;
    private javax.swing.JTextField tfMessage;
    private javax.swing.JTextField tfNickname;
    private javax.swing.JTextField tfSourcePort;
    // End of variables declaration//GEN-END:variables
}
