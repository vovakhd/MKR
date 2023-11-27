package oop.example.project_oop.Classes;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Levels extends Lessons {
    private String level;
    private String levelProgress;
    private int lessonsNumber;
}