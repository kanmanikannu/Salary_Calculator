import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize constants
        int baseSalaryPerHour = 100;
        int bonusPerDayWorkedMoreThan8Hours = 15;
        int bonusPerHourBeyond40Hours = 25;
        double bonusPercentageSaturday = 0.25;
        double bonusPercentageSunday = 0.5;

        // Read hours worked on each day
        int[] hoursWorked = new int[7];
        for (int i = 0; i < 7; i++) {
            hoursWorked[i] = scanner.nextInt();
        }

        // Calculate total hours worked in the week
        int totalHoursWorked = 0;
        for (int hours : hoursWorked) {
            totalHoursWorked += hours;
        }

        // Calculate base salary
        int baseSalary = totalHoursWorked * baseSalaryPerHour;

        // Calculate bonus for working more than 8 hours on any day
        int bonusMoreThan8Hours = 0;
        for (int hours : hoursWorked) {
            bonusMoreThan8Hours += Math.max(hours - 8, 0) * bonusPerDayWorkedMoreThan8Hours;
        }

        // Calculate bonus for working more than 40 hours in a week
        int bonusBeyond40Hours = 0;
        if (totalHoursWorked > 40) {
            bonusBeyond40Hours = (totalHoursWorked - 40) * bonusPerHourBeyond40Hours;
        }

        // Calculate bonus for working on Saturday and Sunday
        int bonusSaturday = (int) (hoursWorked[5] * bonusPercentageSaturday);
        int bonusSunday = (int) (hoursWorked[6] * bonusPercentageSunday);

        // Calculate total salary
        int totalSalary = baseSalary + bonusMoreThan8Hours + bonusBeyond40Hours + bonusSaturday + bonusSunday;

        // Print total salary
        System.out.println(totalSalary);
    }
}