/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pthtw.repositories;

import com.pthtw.pojo.User;

/**
 *
 * @author admin
 */
public interface UserRepository {

    User getUserByUsername(String username);

    void addUser(User user);

    public boolean authUser(String username, String password);
}
