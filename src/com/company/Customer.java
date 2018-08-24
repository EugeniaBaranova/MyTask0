package com.company;

import java.util.Scanner;

public class Customer {

    private int id;
    private String surname;
    private String name;
    private String address;
    private int noOfCard;
    private int noOfBankAccount;

    private Scanner scanner = new Scanner(System.in);

    public Customer() {
        this.fillCustomer();
    }
    public Customer(int id,
             String surname,
             String name,
             String address,
             int noOfCard,
             int noOfBankAccount) {
        setId(id);
        setSurname(surname);
        setName(name);
        setAddress(address);
        setNoOfCard(noOfCard);
        setNoOfBankAccount(noOfBankAccount);
    }

    private void setId(int id) {
        this.id = id;
    }
    private void setSurname(String surname) {
        this.surname = surname;
    }
    private void setName(String name) {
        this.name = name;
    }
    private void setAddress(String address) {
        this.address = address;
    }
    private void setNoOfCard(int noOfCard) {
        this.noOfCard = noOfCard;
    }
    private void setNoOfBankAccount(int noOfBankAccount) {
        this.noOfBankAccount = noOfBankAccount;
    }

    private int getId() {
        return id;
    }
    private String getSurname() {
        return surname;
    }
    private String getName() {
        return name;
    }
    private String getAddress() {
        return address;
    }
    private int getNoOfCard() {
        return noOfCard;
    }
    private int getNoOfBankAccount() {
        return noOfBankAccount;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n"
                + "Surname: " + surname + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "No of card: " + noOfCard + "\n"
                + "No of Bank Account: " + noOfBankAccount + "\n";
    }
    private static void printList(Customer[] customers) {
        for(Customer customer: customers) {
            System.out.println(customer.toString());
        }
    }

    public static void sortBySurname(Customer[] customers) {
        for (int i = 0; i < customers.length-2 ; i++) {
            for (int j = customers.length-1; j > i ; j--) {
                if (customers[i] != null && customers[j] != null) {
                    if (customers[i].getSurname() != null && customers[j].getSurname() != null) {
                        if (customers[i].getSurname().toLowerCase().charAt(0) > customers[j].getSurname().toLowerCase().charAt(0)) {
                            Customer transitCustomer = customers[i];
                            customers[i] = customers[j];
                            customers[j] = transitCustomer;
                        }
                    }
                }
            }
        }
        System.out.println("List of customers sorted by surname");
        printList(customers);
    }

    public static void cardOfInterval(Customer[] customers, int from, int to) {
        System.out.println("List of customer's cards (interval from " + from + " to " + to + ")");
        for (Customer customer: customers){
            if(customer.getNoOfCard() > from && customer.getNoOfCard() < to){
                System.out.println(customer);
            }
        }
    }

    private String customerNextLine() {
        String string = this.scanner.nextLine();
        while (string.isEmpty()) {
            System.out.println("Try again!");
            string = this.scanner.nextLine();
        }
        return string;
    }
    private int customerNextInt() {
        String string = this.scanner.nextLine();
        while (string.isEmpty()) {
            System.out.println("Try again!");
            string = this.scanner.nextLine();
        }
        boolean a = true;
        while(a) {
            for(int j = 0; j < string.length(); j++) {
                if (!(string.charAt(j) >= 48 && string.charAt(j) <= 57)) {
                    a = false;
                }
            }
            String s = "don't need check";
            if(!a) {
                System.out.println("Wrong format! Use numerals and try again!");
                string = this.scanner.nextLine();
                while (string.isEmpty()) {
                    System.out.println("Wrong format! Use numerals and try again!");
                    string = this.scanner.nextLine();
                }
                s = "need check";
            }
            if(s.equals("need check")) {
                a = true;
            } else {
                return Integer.parseInt(string);
            }
        }
        return 0;
    }

    private void fillCustomer(){
        while(this.getId() == 0 || this.getId() < 100 || this.getId() > 999) {
            System.out.println("Enter ID (3 symbols): ");
            this.setId(this.customerNextInt());
        }
        System.out.println("Enter Surname: ");
        this.setSurname(this.customerNextLine());
        System.out.println("Enter Name: ");
        this.setName(this.customerNextLine());
        System.out.println("Enter Address: ");
        this.setAddress(this.customerNextLine());
        while(this.getNoOfCard() == 0 || this.getNoOfCard() < 1000 || this.getNoOfCard() > 9999) {
            System.out.println("Enter Number of card (4 symbols): ");
            this.setNoOfCard(this.customerNextInt());
        }
        while(this.getNoOfBankAccount() == 0 || this.getNoOfBankAccount() < 1000 || this.getNoOfBankAccount() > 9999) {
            System.out.println("Enter Number of bank account (4 symbols): ");
            this.setNoOfBankAccount(this.customerNextInt());
        }
    }
}
