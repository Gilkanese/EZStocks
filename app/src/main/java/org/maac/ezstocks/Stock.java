package org.maac.ezstocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class Stock {
    private ArrayList<StockData> stockList = new ArrayList<StockData>();

    public Stock(String ticker) throws IOException
    {
        String sym = ticker.toUpperCase();

        try {
            URL yahoo = new URL("http://chart.finance.yahoo.com/table.csv?s=" + sym);
            URLConnection connection = yahoo.openConnection();
            InputStreamReader is = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(is);
            String line = br.readLine();

            for (int i = 0; i < 364; i++)
            {
                line = br.readLine();
                // use comma as separato
                String[] cols = line.split(",");
                // 0 = date, 1 = open, 2 = high, 3 = low, 4 = close, 5 = volume
                StockData tempStock = new StockData(cols[0], Double.parseDouble(cols[1]), Double.parseDouble(cols[2]), Double.parseDouble(cols[3]), Double.parseDouble(cols[4]), Integer.parseInt(cols[5]));
                stockList.add(tempStock);
            }

        } catch (IOException e)
        {
            Logger log = Logger.getLogger(Stock.class.getName());
            log.log(Level.SEVERE, e.toString(), e);
        }

    }

    //

    private double averageFourteen()
    {
        double sum = 0;
        for (int i = 0; i < 14; i++)
        {
            sum += stockList.get(i).getClose();
        }
        sum = sum/14;
        return sum;
    }

    private int indexHigh()
    {
        double temp = 0;
        double highest = 0;
        int indexHigh = 0;
        for (int i = 0; i < 14; i++)
        {
            temp = stockList.get(i).getClose();
            if (temp > highest)
            {
                highest = temp;
                indexHigh = i;
            }
        }
        return indexHigh;
    }

    private int indexLow()
    {
        double temp = 0;
        double lowest = 0;
        int indexLow = 0;
        for (int i = 0; i < 14; i++)
        {
            temp = stockList.get(i).getClose();
            if (temp < lowest)
            {
                lowest = temp;
                indexLow = i;
            }
        }
        return indexLow;
    }

    private String date(int i)
    {
        String date = stockList.get(i).getDate();
        return date;
    }

    private double fourteenHigh(int i)
    {
        double price = stockList.get(i).getHigh();
        return price;
    }

    private double fourteenLow(int i)
    {
        double price = stockList.get(i).getLow();
        return price;
    }

    private int volume()
    {
        int volume = 0;
        for (int i = 0; i < 14; i++)
        {
            volume += stockList.get(i).getVolume();
        }
        return volume;
    }

    public ArrayList histPrices()
    {
        ArrayList histArray = new ArrayList();
        for (int i = 0; i < 364; i++)
        {
            histArray.set(i, stockList.get(i).getClose());
        }
        return histArray;
    }

    public String toString()
    {
        double highPrice = fourteenHigh(indexHigh());
        double lowPrice = fourteenLow(indexLow());

        String highDate = date(indexHigh());
        String lowDate = date(indexLow());

        double average = averageFourteen();

        int volume = volume();

        String result = "In the last 14 days, the highest price was " + highPrice + " on the day of " + highDate + "\n"
                + "The lowest price was " + lowPrice + " on the day of " + lowDate + "\n"
                + "The average price was " + average + "\n"
                + "The volume sold was " + volume;
        return result;
    }

}
