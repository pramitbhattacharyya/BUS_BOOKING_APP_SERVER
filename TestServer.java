/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busserver;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author PRAMIT
 */
public class TestServer {
    public static void main(String[]args)
    {
        JavaEmail mail=new JavaEmail();
        try {
            mail.send("pramitb@iitbhilai.ac.in","abcd");
        } catch (MessagingException ex) {
            Logger.getLogger(TestServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
