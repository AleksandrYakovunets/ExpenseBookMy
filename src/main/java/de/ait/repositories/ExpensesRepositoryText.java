package de.ait.repositories;

import de.ait.models.Category;
import de.ait.models.Expenses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpensesRepositoryText implements ExpensesRepository {

    private String fileName;

    public ExpensesRepositoryText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Expenses> getAllExpenses() {
        List<Expenses> expenses = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                Expenses expenses1 = parseLine(line);
                expenses.add(expenses1);
                line = bufferedReader.readLine();
            }
        } catch (IOException | ParseException e) {
            System.err.println("Что-то пошло не так");
        }
        return expenses;
    }

    private static Expenses parseLine(String line) throws ParseException {
        String[] parsed = line.split("\\|");
        String title = parsed[0];
        double sumExpenses = Double.parseDouble(parsed[1]);
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(parsed[2]);
        Category categoryExpenses = Category.valueOf(parsed[3]);

        return new Expenses(title, sumExpenses, date, categoryExpenses);
    }


}
