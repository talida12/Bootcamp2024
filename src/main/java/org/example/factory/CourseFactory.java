package org.example.factory;

import org.example.models.Course;
import org.example.models.EnglishCourse;
import org.example.models.MathCourse;
import org.example.models.ScienceCourse;

public class CourseFactory {
   public static Course createCourse(String courseType) {
      switch (courseType.toLowerCase()) {
         case "math":
            return new MathCourse();
         case "science":
            return new ScienceCourse();
         case "english":
            return new EnglishCourse();
         default:
            throw new IllegalArgumentException("Unknown Course Type");
      }
   }
}

