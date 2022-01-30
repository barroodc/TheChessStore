package com.solvd.onlinestore.model.labor;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id", "jobTitle", "minSalary", "maxSalary"
})
@XmlRootElement(name = "Jobs")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "jobTitle", "minSalary", "maxSalary"})
public class Jobs {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("minSalary")
    private float minSalary;
    @JsonProperty("maxSalary")
    private float maxSalary;

    public Jobs() {

    }

    public Jobs(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Jobs(float minSalary, float maxSalary) {
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Jobs(Long id, String jobTitle, float positionSalary, float minSalary, float maxSalary) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
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
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonAnySetter
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonAnyGetter
    @XmlElement(name = "minSalary")
    public float getMinSalary() {
        return minSalary;
    }

    @JsonAnySetter
    public void setMinSalary(float minSalary) {
        this.minSalary = minSalary;
    }

    @JsonAnyGetter
    @XmlElement(name = "maxSalary")
    public float getMaxSalary() {
        return maxSalary;
    }

    @JsonAnySetter
    public void setMaxSalary(float maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
