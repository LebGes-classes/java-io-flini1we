package example;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Serialization {
    /*
    create a private array "key" to
    match with InputStream values
    */
    private static String[] keys = {"Subject",
                                    "Teacher",
                                    "Student",
                                    "Attendance",
                                    "Date"};

    public static ArrayList<Student> serialization(String filePath) {
        InputStream inStream = new InputStream();
        Map<String, String> map = new HashMap<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();
        /*
        @param String filePath
        -for each String[] from IO skip the first line
        -fill the map for more comfortable appeal
        -filling the objects using basic logic
        @return ArrayList<Student>
         */
        inStream.reader(filePath).stream()
                .skip(1)
                .forEach(line -> {

                    IntStream.
                            range(0, line.length)
                            .forEach(i -> {
                                map.put(keys[i], line[i]);
                            });

                    AtomicBoolean isAddedStudent = new AtomicBoolean(true);
                    AtomicBoolean isAddedSubject = new AtomicBoolean(false);

                    studentArrayList
                            .stream()
                            .parallel()
                            .forEach(student -> {
                                if (student.name.equals(map.get("Student"))) {
                                    isAddedStudent.set(false);

                                    student.subject.stream()
                                            /*
                                            for each sub we check it's Atomic state
                                            "break" the loop ASAP with true AtomicState
                                             */
                                            .takeWhile(sub -> isAddedSubject.get())
                                            .forEach(sub -> {
                                                if (sub.name.equals(map.get("Subject"))) {
                                                    isAddedSubject.set(sub.addDate(new SpecialInfo(map.get("Date"),
                                                                                                   map.get("Attendance"))));
                                                }
                                            });

                                    if (!isAddedSubject.get()) {
                                        Subject subject = new Subject(map.get("Subject"),
                                                          new Teacher(map.get("Teacher")),
                                                          new SpecialInfo(map.get("Date"),
                                                                          map.get("Attendance")));
                                        student.addSubject(subject);
                                    }
                                }
                            });

                    if (isAddedStudent.get()) {
                        Subject subject = new Subject(map.get("Subject"),
                                          new Teacher(map.get("Teacher")),
                                          new SpecialInfo(map.get("Date"),
                                                          map.get("Attendance")));
                        Student student = new Student(map.get("Student"),
                                                      subject);
                        studentArrayList.add(student);
                    }
                });

        return studentArrayList;
    }
}