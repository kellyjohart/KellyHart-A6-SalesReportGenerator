package com.coderscampus;

import java.time.YearMonth;

public class Sales {

    private YearMonth date;
    private int sales;

    public Sales(YearMonth date, int sales) {
        this.date = date;
        this.sales = sales;
    }


    public YearMonth getDate() {
        return date;
    }

    public int getSales() {
        return sales;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Sales [date=" + date + ", sales=" + sales + "]";
    }
}