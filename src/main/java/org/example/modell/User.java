package org.example.modell;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Setter
@Getter
public class User {
    private int id;
    private String name;
    private String email;
    private Map<String, LocalDate> appointments = new HashMap<>();



}
