package com.onetap.billzBackend.service;

import com.onetap.billzBackend.model.AppUser;
import com.onetap.billzBackend.model.Role;

import java.util.List;

public interface UserService {
    AppUser registerUser(AppUser user);
    List<AppUser> getUsers();
    AppUser getUser(String email);
    void addRoleToUser(String email, String roleName);
    Role saveRole(Role role);
}
