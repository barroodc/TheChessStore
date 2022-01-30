package com.solvd.onlinestore.model.user;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "employeesID", "firstName", "middleName", "lastName", "mobile",
        "email", "password", "userName", "timeCreated", "lastLogin"
})
@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "employeesID", "firstName", "middleName", "lastName", "mobile",
        "email", "password", "userName", "timeCreated", "lastLogin"})

public class User {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("employeesID")
    private Long employeesID;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("timeCreated")
    private Date timeCreated;
    @JsonProperty("lastLogin")
    private Date lastLogin;

    public User() {

    }

    public User(String firstName, String middleName, String lastName, String mobile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
    }

    public User(Date timeCreated, String email, String userName, String password, Date lastLogin) {
        this.timeCreated = timeCreated;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public User(Long id, Long employeesID, String firstName, String lastName, String mobile, String email, String password, String userName, Date timeCreated, Date lastLogin) {
        this.id = id;
        this.employeesID = employeesID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.timeCreated = timeCreated;
        this.lastLogin = lastLogin;
    }

    public User(Long id, Long employeesID, String firstName, String middleName, String lastName, String mobile, String email, String password, String userName, Date timeCreated, Date lastLogin) {
        this.id = id;
        this.employeesID = employeesID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.timeCreated = timeCreated;
        this.lastLogin = lastLogin;
    }

    @JsonAnyGetter
    @XmlAttribute
    public Long getId() {
        return id;
    }

    @JsonAnySetter
    public void setId(Long id) {
        this.id = id;
    }

    @JsonAnyGetter
    @XmlAttribute
    public Long getEmployeesID() {
        return employeesID;
    }

    @JsonAnySetter
    public void setEmployeesID(Long employeesID) {
        this.employeesID = employeesID;
    }

    @JsonAnyGetter
    @XmlElement(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonAnySetter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonAnyGetter
    @XmlElement(name = "middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonAnySetter
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonAnyGetter
    @XmlElement(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonAnySetter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonAnyGetter
    @XmlElement(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    @JsonAnySetter
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JsonAnyGetter
    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    @JsonAnySetter
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonAnyGetter
    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }

    @JsonAnySetter
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonAnyGetter
    @XmlElement(name = "userName")
    public String getUserName() {
        return userName;
    }

    @JsonAnySetter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonAnyGetter
    @XmlElement(name = "timeCreated")
    public Date getTimeCreated() {
        return timeCreated;
    }

    @JsonAnySetter
    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    @JsonAnyGetter
    @XmlElement(name = "lastLogin")
    public Date getLastLogin() {
        return lastLogin;
    }

    @JsonAnySetter
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", employeesID=" + employeesID +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", timeCreated=" + timeCreated +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
