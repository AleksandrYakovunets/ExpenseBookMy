package de.ait.app;

import de.ait.models.Category;
import de.ait.models.Expenses;
import de.ait.repositories.ExpensesRepository;
import de.ait.repositories.ExpensesRepositoryText;
import de.ait.services.ExpensesServices;
import de.ait.services.ExpensesServicesImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpensesRepository expensesRepository = new ExpensesRepositoryText("expenses.txt");
        ExpensesServices expensesServices = new ExpensesServicesImpl(expensesRepository);

        while (true) {
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

                        break;

                    case 2:

                        break;

                    case 3:

                        break;

                    case 4:
                        System.out.println("Все расходы за весь период: ");
                        List<Expenses> expenses = expensesServices.getAll();
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
            System.out.println("Наименование: " + expenses.getTitle()
            + "; сумма: " + expenses.getSumExpenses()
            + "; дата: " + expenses.getDate()
            + "; категория: " + expenses.getCategoryExpenses());
        }
    }

}//class Main