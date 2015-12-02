/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limmen.hw4.model;

/**
 * Converter class.
 * Contains methods for converting currencies.
 * @author kim
 */
public class Converter {       
    
    /**
     * Converts from one currency to another.
     * 
     * @param amount
     * @param from
     * @param to
     * @return
     */
    public float convert(float amount, ConversionRate from, ConversionRate to){
        float temp = amount*from.getToRate();
        return temp*to.getFromRate();
    }
}
