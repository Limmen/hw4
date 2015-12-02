/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package limmen.hw4.view;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import limmen.hw4.controller.ConversionRateFacade;

/**
 *
 * @author kim
 */
@Named(value = "convertManager")
@SessionScoped
public class ConvertManager implements Serializable {
    @EJB
    private ConversionRateFacade contr;
    private Float convertFromAmount;
    private Float convertToAmount;
    private String convertFromCurrency;
    private String convertToCurrency;
    
    
    public ConvertManager() {
        
    }
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
    public Float convert(){
        if(convertFromCurrency.equals(convertToCurrency))
            convertToAmount = convertFromAmount;
        else{
            convertToAmount = contr.convert(convertFromAmount, convertFromCurrency, convertToCurrency);
        }
        return convertToAmount;
    }
}
