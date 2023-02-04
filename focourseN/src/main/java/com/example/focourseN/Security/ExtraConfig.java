package com.example.focourseN.Security;

import com.example.focourseN.Entity.ApiRole;
import com.example.focourseN.Entity.ApiUser;
import com.example.focourseN.Repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class ExtraConfig {

    private final ApiUserRepository apiUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ExtraConfig(ApiUserRepository apiUserRepository, PasswordEncoder passwordEncoder) {
        this.apiUserRepository = apiUserRepository;
        this.passwordEncoder = passwordEncoder;
    }




    @Bean
    public ApiUser apiUser() {
        Collection<ApiRole> xc = (Collection<ApiRole>) new ArrayList<ApiRole>();
        xc.add(new ApiRole("role_Admin"));
        xc.add(new ApiRole("role_Student"));

        return   apiUserRepository.save(
                new ApiUser("holyfamily", passwordEncoder.encode("princes"),xc,true));

    }

}
