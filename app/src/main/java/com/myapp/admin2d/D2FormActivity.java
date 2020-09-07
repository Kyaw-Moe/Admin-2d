package com.myapp.admin2d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.myapp.admin2d.models.D2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class D2FormActivity extends AppCompatActivity {

    Button btnSetDate, btnAdd;
    EditText etMorning, etEvening;
    Calendar calendar = Calendar.getInstance();
    int day, month, year;
    int morningNum, eveningNum;
    long date;
    TextView dateFormat;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2_form);

        etMorning = findViewById(R.id.et_morning);
        etEvening = findViewById(R.id.et_evening);
        btnAdd = findViewById(R.id.btn_add);
        btnSetDate = findViewById(R.id.btn_set_date);
        dateFormat = findViewById(R.id.date_in);

        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                git init
                DatePickerDialog datePickerDialog = new DatePickerDialog(D2FormActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateFormat.setText(SimpleDateFormat.getInstance().format(calendar.getTime()));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = UUID.randomUUID().toString();
                morningNum = Integer.parseInt(etMorning.getText().toString().trim());
                eveningNum = Integer.parseInt(etEvening.getText().toString().trim());
                date =calendar.getTimeInMillis();

                D2 d2 = new D2(id, morningNum, eveningNum, date);

                db.collection(getString(R.string.parth))
                        .document(id)
                        .set(d2)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(D2FormActivity.this, "Success", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(D2FormActivity.this, "Fail", Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
    }
}