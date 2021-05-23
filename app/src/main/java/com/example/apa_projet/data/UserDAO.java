package com.example.apa_projet.data;

import com.example.apa_projet.entities.User;

import java.util.ArrayList;

public class UserDAO {

    ArrayList<User> userArrayList;

    public UserDAO(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public UserDAO() {
    }

    public void newUser(User user) {
        userArrayList.add(user);
    }
}
