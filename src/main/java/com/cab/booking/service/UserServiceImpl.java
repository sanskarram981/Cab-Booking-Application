package com.cab.booking.service;

import com.cab.booking.dto.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User userDetail) {
        this.users.add(userDetail);
        System.out.println("User : " + userDetail +" added successfully");
    }

}
