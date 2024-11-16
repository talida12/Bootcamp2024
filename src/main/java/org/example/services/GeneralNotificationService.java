package org.example.services;

import org.example.models.Student;
import org.example.models.Course;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GeneralNotificationService {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void startNotifications(List<Course> courses) {
        scheduler.scheduleAtFixedRate(() -> {
            for (Course course : courses) {
                sendGeneralNotifications(course);
            }
        }, 0, 1, TimeUnit.MINUTES);
    }

    private void sendGeneralNotifications(Course course) {
        String notificationMessage = course.getRandomNotification();
        for (Student student : course.getEnrolledStudents()) {
            student.update(notificationMessage);
        }
    }

    public void stopNotifications() {
        scheduler.shutdown();
    }
}
