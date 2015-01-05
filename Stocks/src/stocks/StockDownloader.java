/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


/**
 *
 * @author victor
 */
public class StockDownloader {
    public static final int DATE = 0;
    public static final int OPEN = 1;
    public static final int HIGH = 2;
    public static final int LOW = 3;
    public static final int CLOSE = 4;
    public static final int VOLUME = 5;
    public static final int ADJCLOSE = 6;
    
    private ArrayList<GregorianCalendar> dates;
    private ArrayList<Double> opens;
    private ArrayList<Double> highs;
    private ArrayList<Double> lows;
    private ArrayList<Double> closes;
    private ArrayList<Integer> volumes;
    private ArrayList<Double> adjcloses;
    
    public StockDownloader(String symbol, GregorianCalendar start, GregorianCalendar end){
        dates = new ArrayList<GregorianCalendar>();
        opens = new ArrayList<Double>();
        highs = new ArrayList<Double>();
        lows = new ArrayList<Double>();
        closes = new ArrayList<Double>();
        volumes = new ArrayList<Integer>();
        adjcloses = new ArrayList<Double>();
        
        //http://real-chart.finance.yahoo.com/table.csv?s=AAPL&d=9&e=14&f=2014&g=d&a=11&b=12&c=1980&ignore=.csv
        String url = "http://real-chart.finance.yahoo.com/table.csv?s="+symbol
                + "&d="+end.get(Calendar.MONTH)
                + "&e="+end.get(Calendar.DAY_OF_MONTH)
                + "&f="+end.get(Calendar.YEAR)
                + "&g=d"
                + "a="+start.get(Calendar.MONTH)
                + "&b="+start.get(Calendar.DAY_OF_MONTH)
                + "&c="+start.get(Calendar.YEAR)
                + "&ignore=.csv";
        
        try {
            URL yahoofin = new URL(url);
            URLConnection data = yahoofin.openConnection();
            Scanner input = new Scanner(data.getInputStream());
            if(input.hasNext()){ // skip line (header)
                input.nextLine();
            }
            
            //start reading data 
            while(input.hasNextLine()){
                String line = input.nextLine();
                //connect data to correct ArrayList
                System.out.println(line);
            }
            
        }catch(Exception e){
            System.err.println(e); 
        }
        
    }
    
    public ArrayList<GregorianCalendar> getDates(){
        return dates;
    }
    
}
