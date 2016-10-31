/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplejms.beans;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 *
 * @author vigne
 */
@Named
@SessionScoped

public class MessageSenderBean implements Serializable {
    private String message;
    
     @Resource(mappedName="jms/ConnecFactory")    
     private ConnectionFactory connectionFactory; 
     
     
     @Resource(mappedName="jms/destinationQueue")    
     private Queue destinationQueue;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
        
    
    public void send()
    {
        try
        {
        JMSContext ctx = connectionFactory.createContext();
        JMSProducer producer = ctx.createProducer();
        TextMessage msg = ctx.createTextMessage(message);
        producer.send(destinationQueue, msg);
        ctx.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
}
