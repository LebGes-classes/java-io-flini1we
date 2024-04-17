package example;

public class Teacher {
    String initials;
    Teacher(String initials){
        this.initials = initials;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + initials + '\'' +
                '}';
    }
}
