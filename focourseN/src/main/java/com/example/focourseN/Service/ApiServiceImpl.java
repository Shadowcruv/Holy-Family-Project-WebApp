package com.example.focourseN.Service;

import com.example.focourseN.Entity.ApiUser;
import com.example.focourseN.Repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService, UserDetailsService {
    private ApiUserRepository apiUserRepository;

    @Autowired
    public ApiServiceImpl(ApiUserRepository apiUserRepository){
        this.apiUserRepository = apiUserRepository;
    }


    public void saveApiUser(ApiUser apiUser){
        apiUserRepository.save(apiUser);
    }

    @Override
    public List<ApiUser> retrieveAllUsers() {
        return apiUserRepository.findAll();
    }

    @Override
    public ApiUser updateUserRoleUser(String email) {
        return null;
    }

    @Override
    public ApiUser updateUserRoleAdminTrainee(String email) {
        return null;
    }

    @Override
    public ApiUser updateUserRoleAdmin(String email) {
        return null;
    }

    @Override
    public ApiUser updateUser(String email, ApiUser apiUser) {
        return null;
    }

    @Override
    public ApiUser updateUser(Long id, ApiUser apiUser) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String emailaddress) throws UsernameNotFoundException {
        ApiUser apiUser = apiUserRepository.findByemailAddress(emailaddress);
        if (apiUser == null){
            System.out.println("ApiUser not found in the database");
            throw new UsernameNotFoundException("ApiUser not found in the database");
        }else {
            System.out.println("User found in the database: "+ emailaddress);
        }
        Collection<SimpleGrantedAuthority> authoritiessList = new ArrayList<>();
        apiUser.getAuthoritiess().forEach(apiRole->{
            authoritiessList.add(new SimpleGrantedAuthority(apiRole.getName()));
        });


       /*
       Collection<ApiRole> authoritiess = apiUser.getAuthoritiess();
        for(ApiRole apiRole: authoritiess){
            authoritiessList.add(new SimpleGrantedAuthority(apiRole.getName()));

        }
      */

        return new org.springframework.security.core.userdetails.User(apiUser.getEmailAddress(),apiUser.getPassword(),apiUser.getEnabled(), true,
                true, true, authoritiessList);
    }

}
