package org.maac.ezstocks;


public class StockData
{
    private String stockDate;
    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;
    private int volumeSold;

    public StockData(String someDate, double someOpen, double someHigh, double someLow, double someClose, int someVolume)
    {
        stockDate = someDate;
        openPrice = someOpen;
        highPrice = someHigh;
        lowPrice = someLow;
        closePrice = someClose;
        volumeSold = someVolume;
    }


    public String getDate()
    {
        return stockDate;
    }

    public double getOpen()
    {
        return openPrice;
    }

    public double getHigh()
    {
        return highPrice;
    }

    public double getLow()
    {
        return lowPrice;
    }

    public double getClose()
    {
        return closePrice;
    }

    public int getVolume()
    {
        return volumeSold;
    }
}

