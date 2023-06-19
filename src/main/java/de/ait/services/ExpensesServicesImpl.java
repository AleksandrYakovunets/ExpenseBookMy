package de.ait.services;

import de.ait.models.Expenses;
import de.ait.repositories.ExpensesRepository;

import java.util.ArrayList;
import java.util.List;

public class ExpensesServicesImpl implements ExpensesServices {
    private ExpensesRepository expensesRepository;

    public ExpensesServicesImpl(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expenses> getAll() {

        return expensesRepository.getAllExpenses();
    }
}
