package com.lvtute.basiccourseapp.controller;

import android.animation.Animator;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.lvtute.basiccourseapp.R;
import com.lvtute.basiccourseapp.data.CourseData;
import com.lvtute.basiccourseapp.model.Course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity  implements View.OnClickListener{

    private int courseId;
    private Course course;
    private ImageView courseImageView;
    private TextView courseTitleTextView;
    private InputMethodManager inputMethodManager;
    private boolean isEditTextVisible =false;
    private LinearLayout revealView;
    private FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpUI();
        loadCourse();





    }

    private void loadCourse() {
        course = new CourseData().courseList().get(getIntent().getExtras().getInt("course_id"));
        courseImageView.setImageResource(course.getImageResourceId(this));
        courseTitleTextView.setText(course.getCourseName());


    }

    private void setUpUI() {
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        courseImageView = (ImageView) findViewById(R.id.detailsCourseImage);
        courseTitleTextView = findViewById(R.id.detailsCourseTitle);

        revealView = (LinearLayout) findViewById(R.id.revealView);
        revealView.setVisibility(View.INVISIBLE);
        isEditTextVisible = false;

        button = (FloatingActionButton) findViewById(R.id.detailsAddButton);
        button.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detailsAddButton:
                if (isEditTextVisible){
                    revealEditText(revealView);
                }
                break;
        }
    }

    private void revealEditText(LinearLayout revealView) {
        int cx = revealView.getRight() - 30;
        int cy = revealView.getBottom() -60;

        int finalRadius = Math.max(revealView.getWidth(), revealView.getHeight());
        Animator anim =  ViewAnimationUtils.createCircularReveal(revealView, cx, cy, 0f, finalRadius);
        revealView.setVisibility(View.VISIBLE);
        isEditTextVisible = true;
        anim.start();
    }
}
