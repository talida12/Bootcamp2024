package org.example.models;

import org.example.factory.GradeCalculator;

public class MathCourse extends Course {
    public MathCourse() {
        super("Math");
    }

    @Override
    public GradeCalculator createGradeCalculator() {
        return new MathGradeCalculator();
    }
}
