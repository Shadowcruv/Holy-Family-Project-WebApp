package com.example.focourseN.Entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class ApiUser {
    @javax.persistence.Id
    @SequenceGenerator(
            name = "api_user_sequence",
            sequenceName = "api_user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "api_user_sequence"
    )

    private Long Id;
    private String emailAddress;
    private String password;


    //TODO: Update1 : add more properties of the ApiUser
    private String firstName;
    private String lastName;

    private String department;
    private String level;
    private Long indentityNo;
    private Boolean enabled = false;


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private Collection<ApiRole> authoritiess;

    public ApiUser() {

    }


    public ApiUser(String emailAddress, String password, Collection<ApiRole> authoritiess, Boolean enabled) {

        this.emailAddress = emailAddress;
        this.password = password;
        this.authoritiess = authoritiess;
        this.enabled = enabled;
    }

    public ApiUser(String emailAddress, String password, String firstName, String lastName, String department, String level, Long indentityNo, Collection<ApiRole> authoritiess) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.level = level;
        this.indentityNo = indentityNo;
        this.authoritiess = authoritiess;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getIndentityNo() {
        return indentityNo;
    }

    public void setIndentityNo(Long indentityNo) {
        this.indentityNo = indentityNo;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<ApiRole> getAuthoritiess() {
        return authoritiess;
    }

    public void setAuthoritiess(Collection<ApiRole> authoritiess) {
        this.authoritiess = authoritiess;
    }
}
