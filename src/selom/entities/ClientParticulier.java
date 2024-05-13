/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.entities;

import java.util.Date;
import javax.persistence.Column;

/**
 *
 * @author m2pro
 */
public class ClientParticulier extends Client {

    @Column(name = "dateNaissance")
    private Date dateNaissance;
    @Column(name = "lieuNaissance")
    private String lieuNaissance;

    public ClientParticulier() {

    }

    public ClientParticulier(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public ClientParticulier(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public ClientParticulier(Date dateNaissance, String lieuNaissance) {
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    @Override
    public String toString() {
        return "ClientParticulier{" + "dateNaissance=" + dateNaissance + ", lieuNaissance=" + lieuNaissance + '}';
    }

}
