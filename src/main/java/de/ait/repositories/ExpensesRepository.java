package de.ait.repositories;

import de.ait.models.Expenses;

import java.io.FileNotFoundException;
import java.util.List;

public interface ExpensesRepository {

    List<Expenses> getAllExpenses();
    //List<Expenses> changeExpens(int number);
    void saveExpenses(Expenses expenses);
    void deleteExpenses() throws FileNotFoundException;
}
