package hcmute.edu.vn.LuongVanThuan.RecyclerViewCardViewGridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> lstBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstBook = new ArrayList<>();
        lstBook.add(new Book("The Vegitarian","Category book","Description book", R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild robot","Category book","Description book", R.drawable.thewildrobot));
        lstBook.add(new Book("Maria semples","Category book","Description book", R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Category book","Description book", R.drawable.themartian));
        lstBook.add(new Book("He died with...","Category book","Description book", R.drawable.hediedwith));
        lstBook.add(new Book("The Vegitarian","Category book","Description book", R.drawable.thevigitarian));
        lstBook.add(new Book("The Wild robot","Category book","Description book", R.drawable.thewildrobot));
        lstBook.add(new Book("Maria semples","Category book","Description book", R.drawable.mariasemples));
        lstBook.add(new Book("The Martian","Category book","Description book", R.drawable.themartian));
        lstBook.add(new Book("He died with...","Category book","Description book", R.drawable.hediedwith));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this, 3));
        myrv.setAdapter(myadapter);
    }
}
