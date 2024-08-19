package org.raghav.springreactmongoapp.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;

import java.util.Objects;

@Setter
@Getter
@Document(collection = "students")
public class Student {
    @Id
    private long id;
    private String firstName;
    private int age;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Pattern(regexp = "\\d+", message = "Phone number must contain only digits.")
    private String phoneNumber;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email address")
    private String emailId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getId() == student.getId() && getAge() == student.getAge() && Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getPhoneNumber(), student.getPhoneNumber()) && Objects.equals(getEmailId(), student.getEmailId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getAge(), getPhoneNumber(), getEmailId());
    }

    public Student(long id, String firstName, int age, String phoneNumber, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
