package br.com.deisesales.exercise;

import br.com.deisesales.exercise.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        // Altera o separador de decimais para padrão US
        Locale.setDefault(Locale.US);

        Scanner input = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();

        System.out.print("How many employees will be registred?");
        int quantity = input.nextInt();

        for (int i = 0; i < quantity; i++) {
            System.out.println();
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id:");
            Integer id = input.nextInt();

            System.out.print("Name:");
            input.nextLine();
            String name = input.nextLine();

            System.out.print("Salary:");
            Double salary = input.nextDouble();

            employeeList.add(new Employee(id, name, salary));
        }

        System.out.println("Enter the employee ID that will have salary increase:");
        Integer idSalary = input.nextInt();

        Employee employee = employeeList.stream().filter(employee1 -> employee1.getId() == idSalary).findFirst().orElse(null);

        if (employee == null) {
            System.out.println("This ID does not exist");

        } else {
            System.out.println("How much is the percentage?");
            Double percentage = input.nextDouble();
            employee.increaseSalary(percentage);
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee emp : employeeList) {
            System.out.println(emp.toString());
        }

        input.close();
    }

}
