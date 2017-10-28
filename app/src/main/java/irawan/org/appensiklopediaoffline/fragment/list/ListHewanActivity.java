package irawan.org.appensiklopediaoffline.fragment.list;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import irawan.org.appensiklopediaoffline.R;
import irawan.org.appensiklopediaoffline.entity.Hewan;
import irawan.org.appensiklopediaoffline.sqlite.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ListHewanActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

//    ItemClickCallback

    private RecyclerView recyclerView;
//    private RecyclerView.Adapter adapter;

    private ListAdapter adapter;

    private List<Hewan> listHewan;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hewan);

        db = new DatabaseHelper(this);

        Intent intent = getIntent();
        String hewan = intent.getStringExtra("hewan");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);

        toolbar.setTitle(hewan);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.RecylerViewHewan);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listHewan = new ArrayList<>();

        Cursor cursor = db.getHewanCursors(hewan);

        while (cursor.moveToNext()) {
//            Log.d("CEK",cursor.getString(2));

            Hewan hwn = new Hewan();
            hwn.setId(cursor.getInt(0));
            hwn.setNama(cursor.getString(1));
            hwn.setSpesies(cursor.getString(2));
            hwn.setImage(cursor.getString(3));
            listHewan.add(hwn);
        }


        adapter = new ListAdapter(listHewan, this);
        adapter.setItemClickCallback(new ItemClickCallback() {
            @Override
            public void onItemClick(int p) {
                Intent i = new Intent(ListHewanActivity.this,ListHewanDetailActivity.class);
                i.putExtra("id",p);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_list_hewan_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search_hewan);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();

        ArrayList<Hewan> hewanList = new ArrayList<>();
        for(Hewan hewan : listHewan) {
            String nama = hewan.getNama().toLowerCase();

            if(nama.contains(newText)) {
                hewanList.add(hewan);
            }
        }

        adapter.setFilter(hewanList);
        return true;
    }

//    @Override
//    public void onItemClick(int p) {
//        Intent i = new Intent(this,ListHewanDetailActivity.class);
//        startActivity(i);
//    }
}
