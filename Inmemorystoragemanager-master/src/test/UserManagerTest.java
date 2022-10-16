package com.sample;

import com.sample.models.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserManagerTest {



    @Test
    public void addUser() {
        UserManager userManager = new InMemoryStorageUserManager();
        userManager.addUser(new User(1));
        assertEquals(1, userManager.listUsers().size());
    }

    @Test
    public void updateUser(

    ) {
        UserManager userManager = new InMemoryStorageUserManager();
        userManager.addUser(new User(1));
        assertEquals(1, userManager.listUsers().size());

    }

    @Test
    public void listUsers() {
    }

    @Test
    public void deleteUser() {
        UserManager userManager = new InMemoryStorageUserManager();
        userManager.addUser(new User(1));
        assertEquals(1, userManager.listUsers().size());
        userManager.deleteUser(new User(1));
        assertEquals(1, userManager.listUsers().size());

    }

    @Test
    public void searchUsers() {

    }
}

