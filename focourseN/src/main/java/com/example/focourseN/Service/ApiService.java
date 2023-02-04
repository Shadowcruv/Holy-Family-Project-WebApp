package com.example.focourseN.Service;

import com.example.focourseN.Entity.ApiUser;

import java.util.List;

public interface ApiService {
       void saveApiUser(ApiUser apiUser);
       List<ApiUser> retrieveAllUsers();

    ApiUser updateUserRoleUser(String email);

    ApiUser updateUserRoleAdminTrainee(String email);

    ApiUser updateUserRoleAdmin(String email);

    ApiUser updateUser(String email, ApiUser apiUser);
    ApiUser updateUser(Long id, ApiUser apiUser);
}
