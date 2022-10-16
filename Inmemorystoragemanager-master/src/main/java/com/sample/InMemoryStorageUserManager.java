package com.sample;

import com.sample.models.User;

import java.util.*;


public class InMemoryStorageUserManager implements UserManager {

    private List<User> usersList = new ArrayList<>();
    @Override
    public List<User> addUser(User newUser) {
        usersList.add(newUser);
        return usersList;
    }

    @Override
    public void updateUser(User user) {
        ListIterator<User> userListIterator = usersList.listIterator();
        while (userListIterator.hasNext()) {
            User existingUser = userListIterator.next();
            if (existingUser.getId() == user.getId()) {
                //userListIterator.set(user);
                existingUser.setName(user.getName());
                existingUser.setCompany_name(user.getCompany_name());
            }
        }
    }

    @Override
    public List<User> listUsers() {
        System.out.println(usersList);
        return usersList;
    }

    @Override
    public void deleteUser(int id) {
        boolean flag=false;

        Iterator<User> userIterator = usersList.iterator();
        while (userIterator.hasNext()) {

            User eId = userIterator.next();
            System.out.println(eId.getId());
            System.out.println();
            if (eId.getId() == id) {
                flag = true;
                userIterator.remove();
                break;

            }
        }
        if (flag == true) {
            System.out.println(usersList);

        } else {
            System.out.println("NOT FOUND");
        }
    }

    @Override
    public List<User> searchUsers(String searchWord) {
        ArrayList<User> searchlist = new ArrayList<User>();
        boolean flag = false;
        Iterator<User> userIterator = usersList.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getName() == searchWord) {
                flag= true;
                searchlist.add(user);
                break;

            }
        }
        if (flag == true) {
            System.out.println(searchlist);
        } else {
            System.out.println("Not Found");
        }

        return searchlist;
    }
}