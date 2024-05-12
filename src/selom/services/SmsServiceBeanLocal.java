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

    public List<Sms> findAll();

    public void save(Sms sms);

    Sms findById(int smsId);

    int update(final Sms sms);

    void deleteById(int smsId);
}
