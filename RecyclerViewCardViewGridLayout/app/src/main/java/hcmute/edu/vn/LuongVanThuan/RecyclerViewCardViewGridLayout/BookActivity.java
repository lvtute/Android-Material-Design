package hcmute.edu.vn.LuongVanThuan.RecyclerViewCardViewGridLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BookActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView tvDescription;
    private TextView tvCategory;
    private ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        tvTitle = (TextView) findViewById(R.id.txttitle);
        tvDescription = (TextView) findViewById(R.id.txtdescr);
        tvCategory = (TextView) findViewById(R.id.txtcat);
        imgView = (ImageView) findViewById(R.id.book_thumbnail);


        Intent intent = getIntent();
        String title = intent.getExtras().getString("Title");
        String description = intent.getExtras().getString("Description");
        String category = intent.getExtras().getString("Category");
        int image = intent.getExtras().getInt("Thumbnail");

        tvTitle.setText(title);
        tvDescription.setText(description);
        tvCategory.setText(category);
        imgView.setImageResource(image);




    }
}
