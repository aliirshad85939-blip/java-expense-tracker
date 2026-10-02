import java.util.*;

class Expense {
    int id;
    double amount;
    String category;
    String description;

    Expense(int id, double amount, String category, String description) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    void display() {
        System.out.println(
            "ID: " + id +
            " | Amount: ₹" + amount +
            " | Category: " + category +
            " | Description: " + description
        );
    }
}

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int idCounter = 1;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Search by Category");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    totalExpense();
                    break;

                case 4:
                    searchCategory();
                    break;

                case 5:
                    deleteExpense();
                    break;

                case 6:
                    System.out.println("Thank you for using Expense Tracker!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addExpense() {

        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        expenses.add(
            new Expense(idCounter++, amount, category, description)
        );

        System.out.println("Expense added successfully! ✅");
    }

    static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n===== ALL EXPENSES =====");

        for (Expense expense : expenses) {
            expense.display();
        }
    }

    static void totalExpense() {

        double total = 0;

        for (Expense expense : expenses) {
            total += expense.amount;
        }

        System.out.println("Total Expense: ₹" + total);
    }

    static void searchCategory() {

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        boolean found = false;

        for (Expense expense : expenses) {

            if (expense.category.equalsIgnoreCase(category)) {
                expense.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expense found in this category.");
        }
    }

    static void deleteExpense() {

        System.out.print("Enter Expense ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < expenses.size(); i++) {

            if (expenses.get(i).id == id) {
                expenses.remove(i);
                System.out.println("Expense deleted successfully! 🗑️");
                return;
            }
        }

        System.out.println("Expense ID not found.");
    }
}