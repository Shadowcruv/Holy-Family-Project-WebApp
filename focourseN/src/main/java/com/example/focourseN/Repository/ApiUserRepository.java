package com.example.focourseN.Repository;

import com.example.focourseN.Entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {
      ApiUser findByemailAddress(String emailaddress);
}
