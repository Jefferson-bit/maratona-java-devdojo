package Threads.teste;

import Threads.dominio.Members;
import Threads.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTest01 {

    public static void main(String[] args) {

        Members members = new Members();

        Thread eren = new Thread(new EmailDeliveryService(members), "Eren");
        Thread armin = new Thread(new EmailDeliveryService(members), "Armin");

        eren.start();
        armin.start();

        while (true) {
            String email = JOptionPane.showInputDialog("Insira seu email");
            if (email == null || email.isEmpty()) {
                members.close();
                break;
            }
            members.addMembers(email);
        }
    }
}
