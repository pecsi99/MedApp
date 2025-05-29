package org.example.modell;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class Doctor {
    private int id;
    private String name;
    private String department;
    private List<User> patients = new ArrayList<>();

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
