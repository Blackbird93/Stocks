/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks;

import java.util.GregorianCalendar;


/**
 *
 * @author victor
 */
public class Stocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GregorianCalendar start = new GregorianCalendar(2013, 1, 18);
        GregorianCalendar end = new GregorianCalendar(2014, 1, 18);
        StockDownloader test = new StockDownloader("RY.TO", start, end);
    }
    
}
