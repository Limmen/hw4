/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package limmen.hw4.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import limmen.hw4.model.ConversionRate;
import limmen.hw4.model.Converter;

/**
 *
 * @author kim
 */
@Stateless
public class ConversionRateFacade extends AbstractFacade<ConversionRate> {
    @PersistenceContext(unitName = "hw4PU")
    private EntityManager em;
    private final Converter converter = new Converter();
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public float convert(float amount, String convertFromCurrency, String convertToCurrency){
        try {
            ConversionRate from = super.find(convertFromCurrency);
            ConversionRate to = super.find(convertToCurrency);
            return converter.convert(amount, from, to);
        }
        catch(Exception e){
            e.printStackTrace();
            return 404;
        }
    }
    
    public ConversionRateFacade() {
        super(ConversionRate.class);
    }
    
}
