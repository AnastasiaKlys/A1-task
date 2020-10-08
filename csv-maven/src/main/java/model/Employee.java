package model;
import java.util.Objects;

public class Employee {
    private Long id;
    private String application;
    private String appAccountName;
    private Boolean isActive;
    private String jobTitle;
    private String department;

    public Employee(String application, String appAccountName, String isActive, String jobTitle, String department) {
        this.application = application;
        this.appAccountName = appAccountName;
        this.isActive = convertStringToBoolean(isActive);
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getApplication() {
        return application;
    }

    public String getAppAccountName() {
        return appAccountName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public void setAppAccountName(String appAccountName) {
        this.appAccountName = appAccountName;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private boolean convertStringToBoolean(String strBoolean){
        String [] strBoolParts = strBoolean.split(",");
        Boolean resBoolean = Boolean.parseBoolean(strBoolParts[0]);
        return resBoolean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(application, employee.application) &&
                Objects.equals(appAccountName, employee.appAccountName) &&
                Objects.equals(isActive, employee.isActive) &&
                Objects.equals(jobTitle, employee.jobTitle) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, application, appAccountName, isActive, jobTitle, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", application='" + application + '\'' +
                ", app_account_name='" + appAccountName + '\'' +
                ", is_active=" + isActive +
                ", job_title='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
