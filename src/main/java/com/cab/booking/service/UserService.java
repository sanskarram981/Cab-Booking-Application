package com.cab.booking.service;

import com.cab.booking.dto.Driver;
import com.cab.booking.dto.User;

import java.util.List;

public interface UserService {
    public void addUser(User userDetail);
    public List<User> getAllUsers();
}
