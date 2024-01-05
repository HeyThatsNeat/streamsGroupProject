package domain;
import java.time.LocalDate;

import java.time.LocalDate;

public class Student {

    private final Integer id;
    private final String first_name;
    private final String last_name;
    private final String email;
    private final String gender;
    private final LocalDate dob;
    private int ageYear;
    private int ageMonth;
    private int ageDay;

    public Student(Integer id, String first_name, String last_name, String email, String gender, String dob) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.dob = LocalDate.parse(dob);
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getAgeYear() {
        return ageYear; // Getter for age
    }

    public void setAgeYear(int ageYear) {
        this.ageYear = ageYear; // Setter for age
    }

    public int getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(int ageMonth) {
        this.ageMonth = ageMonth;
    }

    public int getAgeDay() {
        return ageDay;
    }

    public void setAgeDay(int ageDay) {
        this.ageDay = ageDay;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                '}';
    }
}


