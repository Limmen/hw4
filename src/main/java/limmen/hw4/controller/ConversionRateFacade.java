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
 * A controller and a facade for the buisness-logic.
 * All calls to the model go through here.
 * Buisness interface:
 * float convert(float amount, String fromCurrency, toCurrency)
 * @author kim
 */
@Stateless
public class ConversionRateFacade extends AbstractFacade<ConversionRate> {
    @PersistenceContext(unitName = "hw4PU")
    private EntityManager em;
    private final Converter converter = new Converter();
   /**
     *Constructor. Initializes the superclass.
     */
    public ConversionRateFacade(){
        super(ConversionRate.class);
    }
    /**
     * Method to get entitymanager. The entitymanager is provided by the 
     * container. The entitymanager manages the entities (lifecycle and
     * CRUD-operations).
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Method that converts amount from a currency to another, 
     * given that the currencies exists in the database.
     * Calls database-methods implemented in the super-class.
     * @param amount
     * @param convertFromCurrency
     * @param convertToCurrency
     * @return convertedValue
     * @throws Exception
     */
    public float convert(float amount, String convertFromCurrency, String convertToCurrency) throws Exception{        
            ConversionRate from = super.find(convertFromCurrency);
            ConversionRate to = super.find(convertToCurrency);
            return converter.convert(amount, from, to);        
    }    
    
}
