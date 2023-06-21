package de.ait.app;

import de.ait.models.Category;
import de.ait.models.Expenses;
import de.ait.repositories.ExpensesRepository;
import de.ait.repositories.ExpensesRepositoryText;
import de.ait.services.ExpensesServices;
import de.ait.services.ExpensesServicesImpl;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        ExpensesRepository expensesRepository = new ExpensesRepositoryText("expenses.txt");
        ExpensesServices expensesServices = new ExpensesServicesImpl(expensesRepository);

        while (true) {

            //System.out.println(Category.valueOf("Питание"));


            System.out.println("1. Добавить расход");
            System.out.println("2. Изменить расход");
            System.out.println("3. Удалить расход");
            System.out.println("4. Вывести расходы за период");
            System.out.println("0. Выход");

            int command = 0;
            if(scanner.hasNextInt()){
                command = scanner.nextInt();
                scanner.nextLine();
                switch (command) {
                    case 1:
                        System.out.println("Введите номер записи: ");
                        int number = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Введите наименование расхода:");
                        String title = scanner.nextLine();

                        System.out.println("Введите сумму расхода: ");
                        double sumExpenses = scanner.nextDouble();

                        System.out.println("Выберите категорию расхода: ");
                        for(int i = 0; i < Category.values().length; i++){
                            System.out.println(i+1 + " - " + Category.values()[i]);
                        }
                        int numberCategory = scanner.nextInt();
                        Category category = null;
                        switch (numberCategory){
                            case 1:
                                category = Category.NUTRITION.valueOf(Category.NUTRITION.name());
                                break;
                            case 2:
                                category = Category.HOUSEHOLD.valueOf(Category.HOUSEHOLD.name());
                                break;
                            case 3:
                                category = Category.HEALTH.valueOf(Category.HEALTH.name());
                                break;
                            case 4:
                                category = Category.CLOTH.valueOf(Category.CLOTH.name());
                                break;
                            case 5:
                                category = Category.PUBLICUTILITES.valueOf(Category.PUBLICUTILITES.name());
                                break;
                            case 6:
                                category = Category.AUTOMOBILE.valueOf(Category.AUTOMOBILE.name());
                                break;

                        }

                        expensesServices.createNewExpenses(number, title, sumExpenses, category);
                        System.out.println("Запись успешно сохранена.");
                        break;

                    case 2:
                            System.out.println("Все расходы за весь период: ");
                            List<Expenses> expenses = expensesServices.getAll();
                            printExpensesList(expenses);
                            System.out.println("Введите порядковый номер расхода, который нужно изменить: ");

                            if(scanner.hasNextInt()){
                                number = scanner.nextInt();
                                System.out.println("Вы выбрали поле: ");
                                System.out.println(expensesServices.getOneExpenses(number));
                                scanner.nextLine();
                                System.out.println("Введите новое значение поля 'Наименование': ");
                                title = scanner.nextLine();
                                System.out.println("Введите новое значение поля 'Сумма расхода': ");
                                sumExpenses = scanner.nextDouble();
                                System.out.println("Выберите новое значение поля 'Категория расхода': ");
                                for(int i = 0; i < Category.values().length; i++){
                                    System.out.println(i+1 + " - " + Category.values()[i]);
                                }
                                numberCategory = scanner.nextInt();
                                category = null;
                                switch (numberCategory){
                                        case 1:
                                            category = Category.NUTRITION.valueOf(Category.NUTRITION.name());
                                        break;
                                        case 2:
                                            category = Category.HOUSEHOLD.valueOf(Category.HOUSEHOLD.name());
                                        break;
                                        case 3:
                                            category = Category.HEALTH.valueOf(Category.HEALTH.name());
                                        break;
                                        case 4:
                                            category = Category.CLOTH.valueOf(Category.CLOTH.name());
                                        break;
                                        case 5:
                                            category = Category.PUBLICUTILITES.valueOf(Category.PUBLICUTILITES.name());
                                        break;
                                        case 6:
                                            category = Category.AUTOMOBILE.valueOf(Category.AUTOMOBILE.name());
                                        break;

                                }

                                expensesServices.changeExpens(number,
                                        title,
                                        sumExpenses,
                                        category);
                                System.out.println("Запись успешно изменена.");
                            }
                            else{
                                System.out.println("Неправильный ввод данных!" +
                                        "\n Перезапустите программу!");
                                return;
                            }

                        break;

                    case 3:
                        expensesServices.deleteAllExpenses();
                        break;

                    case 4:
                        System.out.println("Все расходы за весь период: ");
                        expenses = expensesServices.getAll();
                        printExpensesList(expenses);

                        break;

                    case 0:
                        System.out.println("Выход");
                        System.exit(0);
                    default:
                        System.out.println("Команда не распознана");
                }
            } else{
                System.out.println("Введенное значение не является числом!");
                System.out.println("Перезапустите программу!");
                return;
            }
        }

    }//void main


    public static void printExpensesList(List<Expenses> expensesList){
        for(Expenses expenses : expensesList){
            System.out.println("Номер " + expenses.getNumber()
            + ": Наименование: " + expenses.getTitle()
            + "; сумма: " + expenses.getSumExpenses()
            + "; дата: " + expenses.getDate()
            + "; категория: " + expenses.getCategoryExpenses());
        }
    }

}//class Main