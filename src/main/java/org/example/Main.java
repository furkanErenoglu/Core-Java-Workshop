package org.example;

import java.util.Scanner;

public class Main {
    static final int MAX_ACCOUNT =100;
    String[] accountNumbers;
    String[] accountHolders;
    Double[] accountBalance;
    int numberOfAccount;

    public Main(){
        accountNumbers = new String[MAX_ACCOUNT];
        accountHolders = new String[MAX_ACCOUNT];
        accountBalance = new Double[MAX_ACCOUNT];
        numberOfAccount = 0;
    }

    public int findAccountIndex(String accountNumber){
        for (int i=0; i < numberOfAccount; i++){
            if (accountNumbers[i].equals(accountNumber)){
                return i;
            }
        }
        return -1;
    }

    public void createAccount(String name){
        if (numberOfAccount<MAX_ACCOUNT){
            String accountNumber = generateAccountNumber();
            accountNumbers[numberOfAccount] = accountNumber;
            accountHolders[numberOfAccount] = name;
            accountBalance[numberOfAccount] = 0.0;
            numberOfAccount++;
            System.out.println("Account Created Successfully. Your Account Number: "+ accountNumber);
        }else{
            System.out.println("Maximum account");
        }
    }

    public String generateAccountNumber(){
        return "CVC"+(1000+numberOfAccount);
    }

    public void depositFunds (String accountNumber, double amount){
        int accountIndex = findAccountIndex(accountNumber);

        if (accountIndex != -1){
            accountBalance[accountIndex] += amount;
            System.out.println("Deposit succesfully. Current Balance: "+ accountBalance[accountIndex]);
        }else {
            System.out.println("Invalid account Number");
        }
    }

    public void withdrawFunds (String accountNumber, double amount){
        int accountIndex = findAccountIndex(accountNumber);

        if (accountIndex != -1){
            accountBalance[accountIndex] -= amount;
            System.out.println("Deposit succesfully. Current Balance: "+ accountBalance[accountIndex]);
        }else {
            System.out.println("Invalid account Number");
        }
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Main main = new Main();

        while (true) {
            System.out.println("Welcome to our bank");
            System.out.println("1. Create account");
            System.out.println("2. Deposit amount");
            System.out.println("3. Withdraw amount");
            System.out.println("4. Exit");


            System.out.println("enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter your name :");
                    String name = scanner.next();
                    main.createAccount(name);
                    break;
                case 2:
                    System.out.println("Enter your account Number");
                    String accountNumber = scanner.next();

                    System.out.println("Enter your amount to deposit: ");
                    double amount = scanner.nextDouble();

                    main.depositFunds(accountNumber, amount);
                    break;

                case 3:
                    System.out.println("Enter your account Number");
                    String accountNumberForWithdraw = scanner.next();

                    System.out.println("Enter your amount to deposit: ");
                    double amountForWithdraw = scanner.nextDouble();

                    main.withdrawFunds(accountNumberForWithdraw, amountForWithdraw);
                    break;

                case 4:
                    System.out.println("Exiting");
                    System.exit(0);


            }

        }



    }
}