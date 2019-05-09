package view;

import java.sql.Timestamp;

import java.util.Calendar;
import java.util.Date;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.context.AdfFacesContext;

public class DateTimePicker {
    private RichInputDate comp;

    public DateTimePicker() {
    }

    private void setDateTime(Timestamp timestamp) {
        comp.setValue(null);
        comp.resetValue();
        comp.setValue(timestamp);
        JSFUtils.setExpressionValue("#{attrs.value}", timestamp);
        AdfFacesContext.getCurrentInstance().addPartialTarget(comp);
    }

    public void selectHours(ActionEvent actionEvent) {
        RichButton component = (RichButton) actionEvent.getComponent();
        Integer hour = Integer.valueOf(component.getText());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) comp.getValue());
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        setDateTime(new Timestamp(calendar.getTimeInMillis()));
    }

    public void selectMinutes(ActionEvent actionEvent) {
        RichButton component = (RichButton) actionEvent.getComponent();
        Integer minute = Integer.valueOf(component.getText());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) comp.getValue());
        calendar.set(Calendar.MINUTE, minute);
        setDateTime(new Timestamp(calendar.getTimeInMillis()));
    }

    public void setComp(RichInputDate comp) {
        this.comp = comp;
    }

    public RichInputDate getComp() {
        return comp;
    }
}
