package de.ait.models;

import java.util.Date;

public class Expenses {
    private String title;
    private double sumExpenses;
    private Date date;

    private Category categoryExpenses;
    private int number = 0;

    public Expenses(int number, String title, double sumExpenses, Date date, Category categoryExpenses) {
        this.title = title;
        this.sumExpenses = sumExpenses;
        this.date = date;
        this.categoryExpenses = categoryExpenses;
        this.number = number;
    }


   /* public Expenses(String title, double sumExpenses, Date date) {
        this.title = title;
        this.sumExpenses = sumExpenses;
        this.date = date;
        this.categoryExpenses = categoryExpenses;
    }*/

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

    public int getNumber() {
        return number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSumExpenses(double sumExpenses) {
        this.sumExpenses = sumExpenses;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCategoryExpenses(Category categoryExpenses) {
        this.categoryExpenses = categoryExpenses;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Expenses{" + number + ":" +
                " title='" + title + '\'' +
                ", sumExpenses=" + sumExpenses +
                ", date=" + date +
                ", categoryExpenses=" + categoryExpenses +
                '}';
    }
}
