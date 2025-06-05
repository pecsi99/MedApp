package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Appointment> appointments;

    @Override
    public boolean equals(Object o) {
        if (o == null
                ||
                getClass() != o.getClass()) {
            return false;
        }
        Patient patient = (Patient) o;
        return id == patient.id
                &&
                Objects.equals(name, patient.name)
                &&
                Objects.equals(appointments, patient.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, appointments);
    }

    @Override
    public String toString() {
        return "Patient{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", appointments=" + appointments
                + '}';
    }



}
