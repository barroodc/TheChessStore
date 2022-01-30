package com.solvd.onlinestore.model.labor;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;
import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "jobsID", "departmentsID", "mobile", "email", "hireDate",
        "idCardNumber", "salary", "managerID", "departmentID"
})
@XmlRootElement(name = "Employees")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "jobsID", "departmentsID", "mobile", "email", "hireDate",
        "idCardNumber", "salary", "managerID", "departmentID"})

public class Employees {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("jobsID")
    private Long jobsID;
    @JsonProperty("departmentsID")
    private Long departmentsID;
    @JsonProperty("mobile")
    private String mobile;
    @JsonProperty("email")
    private String email;
    @JsonProperty("hireDate")
    private Date hireDate;
    @JsonProperty("idCardNumber")
    private String idCardNumber; //look into this one. It does make sense. Consider renaming
    @JsonProperty("salary")
    private float salary;
    @JsonProperty("managerID")
    private long managerID;
    @JsonProperty("departmentID")
    private long departmentID;

    public Employees() {

    }


    public Employees(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Employees(float salary) {
        this.salary = salary;
    }

    public Employees(String mobile, String email){
        this.mobile = mobile;
        this.email = email;
    }


    public Employees(Long id, Long jobsID, Long departmentsID, String mobile, String email, Date hireDate, String idCardNumber, float salary, long managerID, long departmentID) {
        this.id = id;
        this.jobsID = jobsID;
        this.departmentsID = departmentsID;
        this.mobile = mobile;
        this.email = email;
        this.hireDate = hireDate;
        this.idCardNumber = idCardNumber;
        this.salary = salary;
        this.managerID = managerID;
        this.departmentID = departmentID;
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
    public Long getJobsID() {
        return jobsID;
    }

    @JsonAnySetter
    public void setJobsID(Long jobsID) {
        this.jobsID = jobsID;
    }

    @JsonAnyGetter
    @XmlAttribute
    public Long getDepartmentsID() {
        return departmentsID;
    }

    @JsonAnySetter
    public void setDepartmentsID(Long departmentsID) {
        this.departmentsID = departmentsID;
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
    @XmlElement(name = "hireDate")
    public Date getHireDate() {
        return hireDate;
    }

    @JsonAnySetter
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @JsonAnyGetter
    @XmlElement(name = "idCardNumber")
    public String getIdCardNumber() {
        return idCardNumber;
    }

    @JsonAnySetter
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    @JsonAnyGetter
    @XmlElement(name = "salary")
    public float getSalary() {
        return salary;
    }

    @JsonAnySetter
    public void setSalary(float salary) {
        this.salary = salary;
    }

    @JsonAnyGetter
    @XmlElement(name = "managerID")
    public long getManagerID() {
        return managerID;
    }

    @JsonAnySetter
    public void setManagerID(Long managerID) {
        this.managerID = managerID;
    }

    @JsonAnyGetter
    @XmlElement(name = "departmentID")
    public long getDepartmentID() {
        return departmentID;
    }

    @JsonAnySetter
    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }


    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", jobsID=" + jobsID +
                ", departmentsID=" + departmentsID +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", hireDate=" + hireDate +
                ", idCardNumber='" + idCardNumber + '\'' +
                ", salary=" + salary +
                ", managerID=" + managerID +
                ", departmentID=" + departmentID +
                '}';
    }
}
