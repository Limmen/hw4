/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limmen.hw4.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author kim
 */
@Entity
public class ConversionRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String currency;
    private float toRate;
    private float fromRate;


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getToRate() {
        return toRate;
    }

    public void setToRate(float toRate) {
        this.toRate = toRate;
    }

    public float getFromRate() {
        return fromRate;
    }

    public void setFromRate(float fromRate) {
        this.fromRate = fromRate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currency != null ? currency.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the currency fields are not set
        if (!(object instanceof ConversionRate)) {
            return false;
        }
        ConversionRate other = (ConversionRate) object;
        if ((this.currency == null && other.currency != null) || (this.currency != null && !this.currency.equals(other.currency))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "limmen.hw4.model.ConversionRate[ id=" + currency + " ]";
    }
    
}
