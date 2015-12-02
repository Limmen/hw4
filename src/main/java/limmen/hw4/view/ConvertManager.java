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
import javax.enterprise.context.SessionScoped;
import limmen.hw4.controller.ConversionRateFacade;

/**
 * CDI-bean representing the conversion-application.
 * @author kim
 */
@Named(value = "convertManager")
@SessionScoped
public class ConvertManager implements Serializable {
    //dependency injection to bontain reference to controller
    @EJB
    private ConversionRateFacade contr;
    private Float convertFromAmount;
    private Float convertToAmount;
    private String convertFromCurrency;
    private String convertToCurrency;
    private boolean dberror = false;   
    private List<String> currencies;    
     
    @PostConstruct
    public void init() {
        contr.test();
        currencies = contr.getCurrencies();
        System.out.println("currencies size: " + currencies.size());
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
        //currencies.add("tesst");
        return currencies;
    }
    

    /**
     * Calls the EJB to convert the currency.
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
