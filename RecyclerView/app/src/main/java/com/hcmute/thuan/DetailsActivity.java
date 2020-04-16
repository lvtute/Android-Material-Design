package com.hcmute.thuan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    private TextView name;
    private TextView description;
    private TextView rating;

    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras = getIntent().getExtras();

        name = (TextView) findViewById(R.id.dName);
        description = (TextView)findViewById(R.id.dDescription);
        rating = (TextView)findViewById(R.id.dRating);

        if (extras != null){
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
            rating.setText(extras.getString("rating"));
        }

    }
}
