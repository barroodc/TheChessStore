package com.solvd.onlinestore.model.labor;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id","departmentName"
})
@XmlRootElement(name = "Departments")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "departmentName"})

public class Departments {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("departmentName")
    private String departmentName;

    public Departments() {

    }

    public Departments(String departmentName) {
        this.departmentName = departmentName;
    }

    public Departments(Long id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
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
    @XmlElement(name = "departmentName")
    public String getDepartmentName() {
        return departmentName;
    }

    @JsonAnySetter
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
