/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package limmen.hw4.view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author kim
 */

@FacesValidator("currencyValidator")
public class CurrencyValidator implements Validator  {
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        try{
            float amount = (Float) value;
        }
        catch(ClassCastException e){
            FacesMessage msg = new FacesMessage(
                    "The amount you entered is not a valid number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            
            throw new ValidatorException(msg);
        }
        
    }
    
    
}
