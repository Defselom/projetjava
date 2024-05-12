/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package selom.services;

import java.util.List;
import selom.entities.Sms;

/**
 *
 * @author m2pro
 */
public interface SmsServiceBeanLocal {
    
    public List<Sms> getAll();
    
    public void save(Sms sms);
    
    public void modifier();
    
    public void supprimer();
}

