import java.util.Scanner;
import java.util.ArrayList;

public class LaundryShopServiceManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> times = new ArrayList<>();
        ArrayList<String> serviceTypes = new ArrayList<>();
        ArrayList<Double> weights = new ArrayList<>();
        ArrayList<Double> fees = new ArrayList<>();

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nWelcome to Laundry Shop Service Management System");
            System.out.println("=================================================");
            System.out.println("System Menu: ");

            System.out.println("A. View All Orders");
            System.out.println("B. Add Laundry Order");
            System.out.println("C. Remove an Order");
            System.out.println("D. Generate Order Report:");
            System.out.println("E. Exit Application");
            
            System.out.println("-----------------");
            System.out.print("Enter the Letter: ");
            String Choice = sc.nextLine().toLowerCase().trim();

            switch (Choice) {
                case "a" -> {
                    System.out.println("-----ALL ORDERS-----");
                    if (names.isEmpty()) {
                        System.out.println("No Orders Logged Yet!");
                        System.out.println("======================");
                    } else {
                        for (int i = 0; i < names.size(); i++) {
                            System.out.println("Order #" + (i + 1));
                            System.out.println("Date: " + dates.get(i));
                            System.out.println("Time: " + times.get(i));
                            System.out.println("Customer Name: " + names.get(i));
                            System.out.println("Service Type: " + serviceTypes.get(i));
                            System.out.println("Weight in kg: " + weights.get(i));
                            System.out.println("Fee: PHP " + fees.get(i));
                            System.out.println("======================================");
                        }
                    }
                }
                case "b" -> {
                    System.out.println("-----ADD A LAUNDRY ORDER-----");

                    System.out.print("Customer name: ");
                    String name = sc.nextLine();

                    System.out.print("Date: (month/day/year): ");
                    String date = sc.nextLine();

                    System.out.print("Time: (e.g., 9:00 AM): ");
                    String time = sc.nextLine();

                    System.out.println("Service Type Choices: ");
                    System.out.println("1. Wash Only");
                    System.out.println("2. Dry Only");
                    System.out.println("3. Wash & Dry");
                    System.out.print("Enter the Number of your Choice: ");
                    String serviceInput = sc.nextLine();

                    String serviceName = "";
                    double baseFee = 0;
                    double extraRate = 0;

                    if (serviceInput.equals("1")) {
                        serviceName = "Wash Only";
                        baseFee = 60.0;
                        extraRate = 15.0;
                    } else if (serviceInput.equals("2")) {
                        serviceName = "Dry Only";
                        baseFee = 50.0;
                        extraRate = 15.0;
                    } else if (serviceInput.equals("3")) {
                        serviceName = "Wash & Dry";
                        baseFee = 100.00;
                        extraRate = 25.00;
                    } else {
                        System.out.println("Invalid Service Type!");
                        break;
                    }
                    System.out.print("Weight in KG: ");
                    double weight = Double.parseDouble(sc.nextLine());
                    double totalFee = baseFee;
                    if (weight > 3) {
                        totalFee = baseFee + ((weight - 3.0) * extraRate);
                    }
                    names.add(name);
                    dates.add(date);
                    times.add(time);
                    serviceTypes.add(serviceName);
                    weights.add(weight);
                    fees.add(totalFee);

                    System.out.println("Order Added Successfully! Total Fee: PHP " + totalFee);
                }
                case "c" -> {
                    System.out.println("-----Remove An Order-----");
                    if (names.isEmpty()) {
                        System.out.println("No Order Number to Remove.");
                        System.out.println("==========================");
                    } else {
                        System.out.print("Enter Number of the Order: ");
                        int orderNum = Integer.parseInt(sc.nextLine());
                        int index = orderNum - 1;

                        if (index >= 0 && index < names.size()) {
                            names.remove(index);
                            dates.remove(index);
                            times.remove(index);
                            serviceTypes.remove(index);
                            weights.remove(index);
                            fees.remove(index);
                            System.out.println("Order #" + orderNum + " has been removed Successfully!");
                            System.out.println("======================================================");
                        } else {
                            System.out.println("Invalid Number!");
                            System.out.println("===============");
                        }
                    }
                }
                case "d" -> {
                    System.out.println("\n----Generate Order Report----");
                    if (names.isEmpty()) {
                        System.out.println("No Orders To Generate a Report");
                        System.out.println("==============================");
                    } else {
                        double totalWeight = 0;
                        double totalFee = 0;

                        for (int i = 0; i < names.size(); i++) {
                            System.out.println("Order #" + (i + 1));
                            System.out.println("Date: " + dates.get(i));
                            System.out.println("Time: " + times.get(i));
                            System.out.println("Customer Name: " + names.get(i));
                            System.out.println("Service Type: " + serviceTypes.get(i));
                            System.out.println("Weight: " + weights.get(i));
                            System.out.println("Total Fee: " + fees.get(i));
                            System.out.println("------------------------------------");

                            totalWeight += weights.get(i);
                            totalFee += fees.get(i);
                        }
                        System.out.println("Number of Total Orders: " + names.size());
                        System.out.println("Total Weight: " + totalWeight + " kg");
                        System.out.println("Total Fees Collected: " + totalFee);
                    }
                }
                case "e" -> {
                    System.out.println("EXITED APPLICATION: Thank you!");
                    System.out.println("==============================");
                    isRunning = false;
                }
                default -> System.out.println("\nInvalid Choice! Please Try Again!");
            }
        }
        sc.close();
    }
}
