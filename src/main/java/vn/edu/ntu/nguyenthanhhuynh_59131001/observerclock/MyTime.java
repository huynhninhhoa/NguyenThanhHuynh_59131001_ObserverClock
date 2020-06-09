package vn.edu.ntu.nguyenthanhhuynh_59131001.observerclock;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTime {
    Context context;
    Calendar calendar;

    OnMyTimeChangeListener onMyTimeChangeListener;

    public MyTime(Context context, Calendar calendar, OnMyTimeChangeListener onMyTimeChangeListener) {
        this.context = context;
        this.calendar = calendar;
        this.onMyTimeChangeListener = onMyTimeChangeListener;
    }

    public void showMyTime(){
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(calendar.HOUR, hourOfDay);
                calendar.set(calendar.MINUTE, minute);
                //calendar.set(calendar.SECOND, second);

                if(onMyTimeChangeListener != null)
                    onMyTimeChangeListener.timeUpdate(calendar);
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                context,
                listener,
                calendar.get(calendar.HOUR),
                calendar.get(calendar.MINUTE),
                true);

        timePickerDialog.show();
    }

    public static interface OnMyTimeChangeListener{
        public void timeUpdate(Calendar calendar);
    }
}
