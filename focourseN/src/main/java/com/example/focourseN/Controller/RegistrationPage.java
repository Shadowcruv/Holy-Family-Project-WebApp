package com.example.focourseN.Controller;

import com.example.focourseN.Entity.ApiUser;
import com.example.focourseN.Service.ApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/registrationPage")
@Controller
public class RegistrationPage {

    private final ApiServiceImpl apiServiceImpl;

    @Autowired
    public RegistrationPage(ApiServiceImpl apiServiceImpl) {
        this.apiServiceImpl = apiServiceImpl;
    }

    @GetMapping
    public String registrationPage(){
        return "registrationPage";
    }

    @GetMapping("/loginPage")
    public String getloginPage(){
        return "loginPage";
    }


    @PostMapping
    public void saveCApiUser(@RequestBody ApiUser apiUser){
           apiServiceImpl.saveApiUser(apiUser);
           System.out.println("Registered Successfully");
    }
}
