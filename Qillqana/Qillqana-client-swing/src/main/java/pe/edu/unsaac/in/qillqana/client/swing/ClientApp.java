package pe.edu.unsaac.in.qillqana.client.swing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import pe.edu.unsaac.in.qillqana.client.swing.ui.MainFrm;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.MessageMediador;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.SocketSession;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;

public class ClientApp {
    private static final Logger logger = Logger.getLogger(ClientApp.class.getName());

    public static void main(String[] args) throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        // Here we are changing the Look&Feel of our application
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        logger.info("Reading configuration parameters");
        Properties conf = new Properties();
        FileInputStream fis = new FileInputStream("conf/configuration.properties");
        conf.load(fis);
        String host=conf.getProperty("server.host");
        int port = Integer.parseInt(conf.getProperty("server.port"));
        logger.info("Configuration parameters readed");
        
        Mediator mediator=new MessageMediador();
        
        SocketSession socketClient=new SocketSession(host, port, mediator);
        mediator.addSession(socketClient);
        socketClient.start();
        MainFrm frm=new MainFrm(mediator);
        frm.setVisible(true);
    }
}
