package de.ait.services;

import de.ait.models.Category;
import de.ait.models.Expenses;
import de.ait.repositories.ExpensesRepository;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ExpensesServicesImpl implements ExpensesServices {
    private ExpensesRepository expensesRepository;

    public ExpensesServicesImpl(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    //получаем все записи из файла
    public List<Expenses> getAll() {
        return expensesRepository.getAllExpenses();
    }

    /*public List<Expenses> getOneExpenses(int number){
        List<Expenses> newListExpenses = new ArrayList<>();
        for(Expenses expenses : expensesRepository.getAllExpenses()){
            if(expenses.getNumber() == number){
                newListExpenses.add(expenses);
            }
        }
        return newListExpenses;
    }*/

    //получаем запись по номеру, для корректировки
    public Expenses getOneExpenses(int number) {
        Expenses oneExpenses = null;

        for (Expenses expenses : expensesRepository.getAllExpenses()) {
            if (expenses.getNumber() == number) {
                oneExpenses = expenses;
            }
        }
        return oneExpenses;
    }

    //очищаем все строки файла
    @Override
    public void deleteAllExpenses() throws FileNotFoundException {
        expensesRepository.deleteExpenses();
    }

    //изменяем поля записи
    @Override
    public void changeExpens(int number, String title, double sumExpenses, Category categoryExpenses) throws FileNotFoundException {
        List<Expenses> modifiedExpenses = getAll();
        Expenses newExpenses = null;
        //проходим по листу и в нужной записи записываем новые значения полей
        for (Expenses expenses : modifiedExpenses) {
            if (expenses.getNumber() == number) {
                expenses.setNumber(number);
                expenses.setTitle(title);
                expenses.setSumExpenses(sumExpenses);
                expenses.setDate(expenses.getDate());
                expenses.setCategoryExpenses(categoryExpenses);
            }
        }

        //очищаем файл от всех строк
        expensesRepository.deleteExpenses();

        //перезаписываем все строки файла с измененной строкой
        for (Expenses expenses : modifiedExpenses) {
            newExpenses = new Expenses(expenses.getNumber(),
                    expenses.getTitle(),
                    expenses.getSumExpenses(),
                    expenses.getDate(),
                    expenses.getCategoryExpenses());
            expensesRepository.saveExpenses(newExpenses);
        }


       /* Expenses modifiedExpenses = getOneExpenses(number);
        modifiedExpenses.setNumber(number);
        modifiedExpenses.setTitle(title);
        modifiedExpenses.setSumExpenses(sumExpenses);
        modifiedExpenses.setDate(modifiedExpenses.getDate());
        modifiedExpenses.setCategoryExpenses(categoryExpenses);
        expensesRepository.saveModifiedExpenses(modifiedExpenses);*/
    }
    //создаем новую запись
    public void createNewExpenses(int number, String title, double sumExpenses, Category categoryExpenses){
        Date date = new Date();
        Expenses newExpenses = new Expenses(number,  title,  sumExpenses, date, categoryExpenses);
        expensesRepository.saveExpenses(newExpenses);
    }

}

