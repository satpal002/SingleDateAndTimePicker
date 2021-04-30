package com.github.florent37.sample.singledateandtimepicker;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker;

public class SingleDatePickerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_date_picker_activity_main);

        final SingleDateAndTimePicker singleDateAndTimePicker = findViewById(R.id.single_day_picker2);
        // Example for setting default selected date to yesterday
//        Calendar instance = Calendar.getInstance();
//        instance.add(Calendar.DATE, -1 );
//        singleDateAndTimePicker.setDefaultDate(instance.getTime());
        SingleDateAndTimePicker.OnDateChangedListener changeListener = (displayed, date) -> display(displayed);
        singleDateAndTimePicker.setMonthNames(getResources().getStringArray(R.array.months_shorts_array));
        singleDateAndTimePicker.setDayNames(getResources().getStringArray(R.array.days_shorts_array));
        singleDateAndTimePicker.addOnDateChangedListener(changeListener);
        singleDateAndTimePicker.init();
        singleDateAndTimePicker.setItemSpacing(2);
//        singleDateAndTimePicker.setSelectorDrawable(R.drawable.ic_event_available_black_24dp);

//        singleDateAndTimePicker.setDefaultDate(new Date());

        //singleDateAndTimePicker.setTypeface(Typeface.DEFAULT);
        singleDateAndTimePicker.setTypeface(ResourcesCompat.getFont(this, R.font.dinot_regular));

        findViewById(R.id.toggleEnabled).setOnClickListener(v -> {
            singleDateAndTimePicker.setEnabled(!singleDateAndTimePicker.isEnabled());
        });
    }

    private void display(String toDisplay) {
        Toast.makeText(this, toDisplay, Toast.LENGTH_SHORT).show();
    }
}
