package oop.example.project_oop.classes;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Levels extends Lessons {
    private String level;
    private String levelProgress;
    private int lessonsNumber;
}