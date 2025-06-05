package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
@Entity
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Doctor doctor;
    @ManyToOne(optional = true)
    private Patient patient;
    @Column(name = "date_time")
    private LocalDateTime date;

    public Appointment() {
    }

    public Appointment(int id, Doctor doctor, Patient patient, LocalDateTime date) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id && Objects.equals(doctor, that.doctor) && Objects.equals(patient, that.patient) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, patient, date);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
