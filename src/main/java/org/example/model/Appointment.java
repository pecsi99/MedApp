package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Appointment that = (Appointment) o;
        return id == that.id
                && Objects.equals(doctor, that.doctor)
                && Objects.equals(patient, that.patient)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, doctor, patient, date);
    }

    @Override
    public String toString() {
        return "Appointment{"
                + "id=" + id
                + ", doctor=" + doctor
                + ", patient=" + patient
                + ", date=" + date
                + '}';
    }
}
