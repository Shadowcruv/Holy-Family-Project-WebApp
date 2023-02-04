package com.example.focourseN.Controller;

import com.example.focourseN.Entity.ApiUser;
import com.example.focourseN.Service.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/adminPage")
@Controller
public class AdminPage {

    private final ApiServiceImpl apiService;

    @Autowired
    public AdminPage(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/all")
    public String getAdminPage(){
        return "admin";
    }

    @GetMapping("/allusers")
    public List<ApiUser> retrieveAllUsersList(){
        List<ApiUser> apiUsers = apiService.retrieveAllUsers();
        return apiUsers;
    }


    @PostMapping("/updateApiUser")
    public void saveUpdateApiUser(@RequestBody ApiUser apiUser){
        apiService.saveApiUser(apiUser);
        System.out.println("Updated Successfully");
    }

    @PutMapping("/saveParticular/{id}")
    public ApiUser saveParticularStudent(@PathVariable Long id, @RequestBody ApiUser apiUser){
        return apiService.updateUser(id,apiUser);
    }

    @PutMapping("/saveParticular/{email}")
    public ApiUser saveParticularStudent(@PathVariable String email, @RequestBody ApiUser apiUser){
        return apiService.updateUser(email,apiUser);
    }

    @PutMapping("/updatetoadmin/{email}")
    public ApiUser UpdateParticularStudentRoleAdmin(@PathVariable String email){
        return apiService.updateUserRoleAdmin(email);
    }

    @PutMapping("/updateToAdminTrainee/{email}")
    public ApiUser UpdateParticularStudentRoleAdminTrainee(@PathVariable String email){
        return apiService.updateUserRoleAdminTrainee(email);
    }

    @PutMapping("/updateToUser/{email}")
    public ApiUser UpdateParticularStudentRoleStudent(@PathVariable String email){
        return apiService.updateUserRoleUser(email);
    }

}
