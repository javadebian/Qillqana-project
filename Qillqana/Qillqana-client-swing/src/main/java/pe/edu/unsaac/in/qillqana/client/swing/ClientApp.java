package pe.edu.unsaac.in.qillqana.client.swing;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;

import pe.edu.unsaac.in.qillqana.client.swing.ui.MainFrm;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.MessageMediador;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.SocketSession;
import pe.edu.unsaac.in.qillqana.common.mediator.Mediator;

public class ClientApp {

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
        
        Mediator mediator=new MessageMediador();
        
        SocketSession socketClient=new SocketSession("localhost", 1234, mediator);
        mediator.addSession(socketClient);
        socketClient.start();
        MainFrm frm=new MainFrm(mediator);
        frm.setVisible(true);
    }
}
