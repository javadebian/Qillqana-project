package pe.edu.unsaac.in.qillqana.client.swing;

import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import pe.edu.unsaac.in.qillqana.client.swing.ui.MainFrm;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.MessageMediator;
import pe.edu.unsaac.in.qillqana.client.swing.ui.mediator.suscriptors.SocketClient;

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
        Mediator mediator=new MessageMediator();
        SocketClient socketClient=new SocketClient("localhost", 1234, mediator);
        mediator.addSuscriptor(socketClient);
        socketClient.start();
        MainFrm frm=new MainFrm(mediator);
        frm.setVisible(true);
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//        MainFrm frm=new MainFrm(mediator);
//                frm.setVisible(true);
//            }
//        });
        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
////                new MainWindow().lanzaVentanaSeparada();
//                new MainWindow().setVisible(true);
//            }
//        });

//        PropertyConfigurator.configure("log4j.properties");
//
//        Client c01 = new Client();
//        Client c02 = new Client();
//        Client c03 = new Client();
//
//        c01.setId(1);
//        c02.setId(2);
//        c03.setId(3);
//
//        c01.start();
//        c02.start();
//        c03.start();
//
//        Gson gson = new Gson();
//        Command cmd = new Command();
//        cmd.setName("Mensaje");
//
//        cmd.addParameter("msg", "Mensaje desde el Cliente 01");
//        c01.enviarMensaje(gson.toJson(cmd));
//        System.out.println(gson.toJson(cmd));
//
//        cmd.addParameter("msg", "Mensaje desde el Cliente 02");
//        c02.enviarMensaje(gson.toJson(cmd));
//        System.out.println(gson.toJson(cmd));
//
//        cmd.addParameter("msg", "Mensaje desde el Cliente 03");
//        c03.enviarMensaje(gson.toJson(cmd));
//        System.out.println(gson.toJson(cmd));
    }
}
