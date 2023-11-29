package oop.example.project_oop.classes;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Levels extends Lessons {
    private String level;
    private String levelProgress;
    private int lessonsNumber;
}