package example;

public class SpecialInfo {
    String date;
    String attendance;

    public SpecialInfo(String date, String attendance) {
        this.date = date;
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "SpecialInfo{" +
                "date='" + date + '\'' +
                ", attendance='" + attendance + '\'' +
                '}';
    }
}
