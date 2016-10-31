/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplejms.beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author vigne
 */
@MessageDriven(mappedName = "jms/destinationQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageReceiverBean implements MessageListener{
    


    @Override
    public void onMessage(Message message) {
        try
        {
            String msg = ((TextMessage) message).getText();
            System.out.println(">>>>"+msg);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    
    }
}
