/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limmen.hw4.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author kim
 */
public class ConverterTest {
    private Converter converter;
    public ConverterTest() {
    }
    @Before
    public void setUp() {
        converter = new Converter();
    }
    /**
     * Test of convert method, of class Converter.
     */
    @Test
    public void testConvert() {
        ConversionRate mockRateFrom = mock(ConversionRate.class);
        ConversionRate mockRateTo = mock(ConversionRate.class);        
        when((mockRateFrom.getToRate())).thenReturn((Float) 0.114913F);
        when((mockRateTo.getFromRate())).thenReturn((Float) 0.9554F);
        Assert.assertEquals(converter.convert(10, mockRateFrom, mockRateTo), (10*(mockRateFrom.getToRate())
        *(mockRateTo.getFromRate())),0);

    }
    
}
