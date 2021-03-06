/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package limmen.hw4.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import limmen.hw4.model.ConversionRate;
import limmen.hw4.model.Converter;

/**
 * A controller and a facade for the buisness-logic.
 * All calls to the model go through here.
 * Stateless session EJB that represents a single client inside the application-
 * server. Stateless since it handles only a single request, there is no
 * request-state that needs to be stored.
 * No interface-implementation-statement, instead all public methods are
 * automaticly exposed to the client.
 * Buisness interface (the methods used by client):
 * float convert(float amount, String fromCurrency, toCurrency)
 * List<String> getCurrencies()
 * @author kim
 */
@Stateless
public class ConversionRateFacade extends AbstractFacade<ConversionRate> {
    @PersistenceContext(unitName = "hw4PU")
    protected EntityManager em;
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
    
    /**
     *Method to fetch currencies from database.
     * @return list of currencies <String>
     */
    public List<String> getCurrencies(){
        List<ConversionRate> rates = super.findAll();
        List<String> currencies = new ArrayList();
        for(ConversionRate rate : rates)
            currencies.add(rate.getCurrency());
        return currencies;
    }
    
}
