package org.example.modell;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Setter
@Getter
public class User {
    private int id;
    private String name;
    private String email;
    private Map<String, LocalDate> appointments = new HashMap<>();

    public User(int id, String name, String email, Map<String, LocalDate> appointments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}
