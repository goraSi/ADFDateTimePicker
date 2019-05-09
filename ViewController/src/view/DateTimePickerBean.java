package view;

import java.sql.Timestamp;

public class DateTimePickerBean {
    private Timestamp datetime;

    public DateTimePickerBean() {
        datetime = new Timestamp(System.currentTimeMillis());
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Timestamp getDatetime() {
        return datetime;
    }
}
