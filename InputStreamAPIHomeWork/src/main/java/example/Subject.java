package example;

import java.util.HashSet;

public class Subject {
    String name;
    HashSet<SpecialInfo> specialInfo = new HashSet<>();
    Teacher teacher;


    public Subject(String name, Teacher teacher, SpecialInfo specialInfo) {
        this.name = name;
        this.teacher = teacher;
        addDate(specialInfo);
    }

    public boolean addDate(SpecialInfo specialInfo){
        this.specialInfo.add(specialInfo);
        return true;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", specialInfo=" + specialInfo.toString() +
                ", teacher=" + teacher +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
