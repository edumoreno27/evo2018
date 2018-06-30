package com.example.anthony.a20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.anthony.a20.Student.StudentActivity;
import com.example.anthony.a20.Teacher.TeacherActivity;

public class ChooseProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_profile);
        ImageView student = findViewById(R.id.img_student);
        ImageView teacher = findViewById(R.id.img_teacher);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),StudentActivity.class);
                startActivity(intent);
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = getIntent().getExtras();
                int idprofeenconsulta = bundle.getInt("idUserLoguin");
                Intent intent = new Intent(getApplicationContext(),TeacherActivity.class);
                Bundle bundle2 = new Bundle();
                int id = idprofeenconsulta;
                bundle2.putInt("idUserLoguin2",id);
                intent.putExtras(bundle2);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (1==1) {

        } else {
            super.onBackPressed();
        }
    }
}
