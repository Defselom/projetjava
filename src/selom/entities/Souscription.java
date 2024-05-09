/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selom.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author m2pro
 */
@Entity
@Table(name = "Souscription")
@NamedQueries({
    @NamedQuery(name = "Souscription.findAll", query = "SELECT s FROM Souscription s"),
    @NamedQuery(name = "Souscription.findById", query = "SELECT s FROM Souscription s WHERE s.id = :id"),
    @NamedQuery(name = "Souscription.findByDateHeureSous", query = "SELECT s FROM Souscription s WHERE s.dateHeureSous = :dateHeureSous"),
    @NamedQuery(name = "Souscription.findByActif", query = "SELECT s FROM Souscription s WHERE s.actif = :actif")})
public class Souscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateHeureSous")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeureSous;
    @Column(name = "actif")
    private String actif;
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne
    private Client idClient;
    @JoinColumn(name = "idProduit", referencedColumnName = "id")
    @ManyToOne
    private Produit idProduit;

    public Souscription() {
    }

    public Souscription(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateHeureSous() {
        return dateHeureSous;
    }

    public void setDateHeureSous(Date dateHeureSous) {
        this.dateHeureSous = dateHeureSous;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Produit getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Produit idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Souscription)) {
            return false;
        }
        Souscription other = (Souscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ppoo_sadzomla.Souscription[ id=" + id + " ]";
    }
    
}
