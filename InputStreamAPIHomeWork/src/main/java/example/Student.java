package example;

import java.util.HashSet;

public class Student {
    String name;
    HashSet<Subject> subject = new HashSet<>();


    public Student(String name, Subject subject) {
        this.name = name;
        addSubject(subject);
    }

    public void addSubject(Subject subject){
        this.subject.add(subject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }

    public boolean equals(Student st2){
        return this.name.compareTo(st2.name) == 0;
    }
}
