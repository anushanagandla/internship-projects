package com.sample;

import com.sample.models.User;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        InMemoryStorageUserManager userManager = new InMemoryStorageUserManager();
        Scanner user_id= new Scanner(System.in);
       Scanner user_name = new Scanner(System.in);
        Scanner companyName = new Scanner(System.in);
        User user = new User();
        int i = 0;
        do {
            System.out.println("1.inserting user");
            System.out.println("2.displaying users");
            System.out.println("3.searching user");
            System.out.println("4.updating use");
            System.out.println("5.deleting");
            System.out.println("6.exiting");

            int choice =user_id.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter User Id:");
                    user.setId(user_id.nextInt());
                    System.out.print("Enter User name:");
                    user.setName(user_name.nextLine());
                    System.out.println("enter company name");
                    user.setCompany_name(companyName.nextLine());
                    userManager.addUser(user);
                    break;
                case 2:
                    userManager.listUsers();
                    break;
                case 3:
                    System.out.println("Search username");
                    userManager.searchUsers("anusha");
                    break;
                case 4:
                    User newUser=new User();
                    System.out.println("update username");
                    newUser.setId(1);
                    newUser.setName("kavya");
                    newUser.setCompany_name("pramati");
                    userManager.updateUser(newUser);
                    break;
                case 5:

                    System.out.println("enter userid which you want to delete");
                    int id=user_id.nextInt();
                    userManager.deleteUser(id);
                    break;
                case 6:
                    System.out.println("exiting");
                    break;

            }


        } while (i != 6);
    }


}
