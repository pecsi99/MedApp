package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
@Entity
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String department;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

//    @OneToMany
//    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(int id, String name, String department, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && Objects.equals(name, doctor.name) && Objects.equals(department, doctor.department) && Objects.equals(appointments, doctor.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, appointments);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}
