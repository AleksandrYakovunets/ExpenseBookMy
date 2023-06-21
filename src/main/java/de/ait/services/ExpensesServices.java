package de.ait.services;

import de.ait.models.Category;
import de.ait.models.Expenses;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

public interface ExpensesServices {

    List<Expenses> getAll();
    Expenses getOneExpenses(int number);

    void deleteAllExpenses() throws FileNotFoundException;

    void changeExpens(int number, String title, double sumExpenses, Category categoryExpenses) throws FileNotFoundException;
    void createNewExpenses(int number, String title, double sumExpenses, Category categoryExpenses);
}
