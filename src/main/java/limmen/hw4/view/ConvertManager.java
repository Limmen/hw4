/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package limmen.hw4.view;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import limmen.hw4.controller.ConversionRateFacade;

/**
 * CDI-bean representing the conversion-application.
 * Request scoped since it does'nt handle any client-specific data or
 * sessions. (scope represents the lifetime of the bean).
 * @author kim
 */
@Named(value = "convertManager")
@RequestScoped
public class ConvertManager implements Serializable {
    //dependency injection to obtain reference to controller-buisness-interface.
    @EJB
    private ConversionRateFacade contr;
    private Float convertFromAmount;
    private Float convertToAmount;
    private String convertFromCurrency;
    private String convertToCurrency;
    private boolean dberror = false;   
    private List<String> currencies;    
     
    /*currencies need to be requested when the bean is fullt initialized
    with all it's dependencies, that's why this method is called here and
    not in the constructor.*/
    @PostConstruct
    public void init() {
        currencies = contr.getCurrencies();
    }
    /*
    * Getters and setters
    */
    public String getConvertFromCurrency() {
        return convertFromCurrency;
    }
    public void setConvertFromCurrency(String convertFromCurrency) {
        this.convertFromCurrency = convertFromCurrency;
    }
    public String getConvertToCurrency() {
        return convertToCurrency;
    }
    public void setConvertToCurrency(String convertToCurrency) {
        this.convertToCurrency = convertToCurrency;
    }
    public Float getConvertFromAmount() {
        return null;
    }
    public void setConvertFromAmount(Float convertFromAmount) {
        this.convertFromAmount = convertFromAmount;
    }
    public Float getConvertToAmount() {
        return convertToAmount;
    }
    public void setConvertToAmount(Float convertToAmount) {
        this.convertToAmount = convertToAmount;
    }
    public boolean isDberror() {
        return dberror;
    }
    public List<String> getCurrencies() {   
        return currencies;
    }    
    /**
     * Calls the EJB-buisness interface to convert the currency.
     * Will catch database-exceptions and set error-flag.
     */
    public void convert(){
        dberror = false;
        if(convertFromCurrency.equals(convertToCurrency))
            convertToAmount = convertFromAmount;
        else{
            try{
                convertToAmount = contr.convert(convertFromAmount, convertFromCurrency, convertToCurrency);
            }
            catch(Exception e){
                dberror = true;
            }
        } 
    }
}
