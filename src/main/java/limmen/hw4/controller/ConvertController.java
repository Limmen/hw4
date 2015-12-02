/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limmen.hw4.controller;

import javax.ejb.Stateless;

/**
 *
 * @author kim
 */
@Stateless
public class ConvertController {

    public float convertSEKtoEUR(float sek){
        return sek*9;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
