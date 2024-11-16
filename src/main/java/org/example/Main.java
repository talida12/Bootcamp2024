package org.example;

import org.example.factory.CourseFactory;
import org.example.models.Course;
import org.example.models.Student;
import org.example.services.GPANotificationService;
import org.example.services.GeneralNotificationService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GPANotificationService GPAnotificationService = new GPANotificationService();

        Course mathCourse = CourseFactory.createCourse("math");
        Course scienceCourse = CourseFactory.createCourse("science");
        Course englishCourse = CourseFactory.createCourse("english");

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        mathCourse.enrollStudent(alice);
        englishCourse.enrollStudent(alice);
        scienceCourse.enrollStudent(bob);
        englishCourse.enrollStudent(bob);

        alice.addCourseGrades("Math", 85, 90, 95);
        alice.addCourseGrades("English", 80, 85, 90);
        bob.addCourseGrades("Science", 70, 70, 80);
        bob.addCourseGrades("English", 90, 90, 100);

        GPAnotificationService.notifyObservers(Arrays.asList(alice, bob), Arrays.asList(mathCourse, scienceCourse, englishCourse));

        mathCourse.addGeneralNotification("Math: Remember to review integrals before the next class.");
        mathCourse.addGeneralNotification("Math: Extra office hours this Thursday from 3-5 PM.");
        scienceCourse.addGeneralNotification("Science: Lab safety session next Monday.");
        englishCourse.addGeneralNotification("English: Optional poetry reading on Friday evening.");

        GeneralNotificationService generalNotificationService = new GeneralNotificationService();
        generalNotificationService.startNotifications(Arrays.asList(mathCourse, scienceCourse, englishCourse));
    }
}