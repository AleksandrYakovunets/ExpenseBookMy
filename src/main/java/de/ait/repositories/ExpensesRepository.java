package de.ait.repositories;

import de.ait.models.Expenses;

import java.util.List;

public interface ExpensesRepository {

    List<Expenses> getAllExpenses();
}
