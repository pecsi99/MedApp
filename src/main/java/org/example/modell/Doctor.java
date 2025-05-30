package org.example.modell;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter

public class Doctor {
    private int id;
    private String name;
    private String department;
    private List<User> patients = new ArrayList<>();
    @Autowired
    public Doctor(int id, String name, String department, List<User> patients) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && Objects.equals(name, doctor.name) && Objects.equals(department, doctor.department) && Objects.equals(patients, doctor.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, patients);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", patients=" + patients +
                '}';
    }
}
