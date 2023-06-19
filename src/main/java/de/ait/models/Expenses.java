package de.ait.models;

import java.util.Date;

public class Expenses {
    private String title;
    private double sumExpenses;
    private Date date;

    private Category categoryExpenses;

    public Expenses(String title, double sumExpenses, Date date, Category categoryExpenses) {
        this.title = title;
        this.sumExpenses = sumExpenses;
        this.date = date;
        this.categoryExpenses = categoryExpenses;
    }


    public Expenses(String title, double sumExpenses, Date date) {
        this.title = title;
        this.sumExpenses = sumExpenses;
        this.date = date;
        this.categoryExpenses = categoryExpenses;
    }

    public String getTitle() {
        return title;
    }

    public double getSumExpenses() {
        return sumExpenses;
    }

    public Date getDate() {
        return date;
    }
    public Category getCategoryExpenses() {
        return categoryExpenses;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "title='" + title + '\'' +
                ", sumExpenses=" + sumExpenses +
                ", date=" + date +
                ", categoryExpenses=" + categoryExpenses +
                '}';
    }
}
