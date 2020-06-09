package vn.edu.ntu.nguyenthanhhuynh_59131001.observerclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

import static vn.edu.ntu.nguyenthanhhuynh_59131001.observerclock.MyDatePicker.OnMyDateChangeListener;
import static vn.edu.ntu.nguyenthanhhuynh_59131001.observerclock.MyTime.OnMyTimeChangeListener;

public class MainActivity extends AppCompatActivity implements MyDatePicker.OnMyDateChangeListener, MyTime.OnMyTimeChangeListener {

    EditText edtDate, edtTime;
    ImageView imvDate, imvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }

    private void addView(){
        edtDate = findViewById(R.id.edtDate);
        edtTime = findViewById(R.id.edtTime);

        imvDate = findViewById(R.id.imvDate);
        imvTime = findViewById(R.id.imvTime);
    }

    private void addEvent(){
        imvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatePicker myDatePicker = new MyDatePicker(MainActivity.this, Calendar.getInstance(),
                        MainActivity.this);
                myDatePicker.showMyDatePicker();
            }
        });

        imvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTime myTime = new MyTime(MainActivity.this, Calendar.getInstance(),
                        MainActivity.this);
                myTime.showMyTime();
            }
        });
    }
    @Override
    public void dateUpdate(Calendar calendar) {

        StringBuilder builder = new StringBuilder();

        //Định dạng: Ngày/Tháng/Năm
        builder.append(calendar.get(calendar.DAY_OF_MONTH))
                .append("/")
                .append(calendar.get(calendar.MONTH) + 1)
                .append("/")
                .append(calendar.get(calendar.YEAR));

        //Hiển thị ngày/tháng/năm lên editTextDate
        edtDate.setText(builder.toString());
    }

    @Override
    public void timeUpdate(Calendar calendar) {
        StringBuilder builder = new StringBuilder();

        //Định dạng: Giờ/Phút/Giây
        builder.append(calendar.get(calendar.HOUR))
                .append(":")
                .append(calendar.get(calendar.MINUTE))
                .append(":")
                .append(calendar.get(calendar.SECOND));

        //Hiển thị giờ/phút/giây lên editTextTime
        edtTime.setText(builder.toString());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
