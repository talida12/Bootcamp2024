package org.example.models;


import org.example.factory.GradeCalculator;

public class EnglishCourse extends Course {
    public EnglishCourse() {
        super("English");
    }

    @Override
    public GradeCalculator createGradeCalculator() {
        return new EnglishGradeCalculator();
    }
}
