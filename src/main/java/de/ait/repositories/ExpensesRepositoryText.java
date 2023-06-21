package de.ait.repositories;

import de.ait.models.Category;
import de.ait.models.Expenses;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExpensesRepositoryText implements ExpensesRepository {

    private String fileName;

    public ExpensesRepositoryText(String fileName) {
        this.fileName = fileName;
    }

   /* @Override
    public List<Expenses> changeExpens(int number) {
        List<Expenses> newListExpenses = new ArrayList<>();
        for(Expenses expenses : getAllExpenses()){

            if(expenses.getNumber() == number){
                newListExpenses.add(expenses);
            }
        }
        return newListExpenses;
    }*/

    //получаем все записи из файла
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


    //записываем в файл запись
    public void saveExpenses(Expenses expenses) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(fileName, true))){

            String newExpenses = expenses.getNumber() + "|" +
                    expenses.getTitle() + "|" +
                    expenses.getSumExpenses() + "|" +
                    expenses.getDate() + "|" +
                    expenses.getCategoryExpenses();
            bufferedWriter.write(newExpenses);
            bufferedWriter.newLine();
        }catch(IOException e){
            System.out.println("Произошла ошибка");
        }
    }

    // парсим строку файла и возвращаем новый расход
    private static Expenses parseLine(String line) throws ParseException {
        String[] parsed = line.split("\\|");
        int number = Integer.parseInt(parsed[0]);
        String title = parsed[1];
        double sumExpenses = Double.parseDouble(parsed[2]);

        //тут проблема с парсингом даты в формате со временем.
        //Если дата записана (ручками) в файл в формате dd.MM.yyyy - все работает
        Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(parsed[3]);
        Category categoryExpenses = Category.valueOf(parsed[4]);

        return new Expenses(number, title, sumExpenses, date, categoryExpenses);
    }

    //очищаем все строки файла
    public void deleteExpenses() {
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //удаляем выбранную строку

}
