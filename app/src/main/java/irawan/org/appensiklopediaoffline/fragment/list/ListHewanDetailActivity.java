package irawan.org.appensiklopediaoffline.fragment.list;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import irawan.org.appensiklopediaoffline.R;
import irawan.org.appensiklopediaoffline.entity.Hewan;
import irawan.org.appensiklopediaoffline.sqlite.DatabaseHelper;

public class ListHewanDetailActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hewan_detail);

        db = new DatabaseHelper(this);
        Intent intent = getIntent();
        int idHewan = intent.getIntExtra("id",0);
        Hewan hewan = db.getHewan(idHewan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail_hewan);

        toolbar.setTitle(hewan.getNama());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        byte[] decodeString = Base64.decode(hewan.getImage(), Base64.DEFAULT);
        Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);
        ((ImageView) findViewById(R.id.imageViewThDetail)).setImageBitmap(decoded);
        ((TextView) findViewById(R.id.thDetail_Kingdom)).setText(hewan.getKingdom());
        ((TextView) findViewById(R.id.thDetail_Phylum)).setText(hewan.getPhylum());
        ((TextView) findViewById(R.id.thDetail_Subphylum)).setText(hewan.getSubphylum());
        ((TextView) findViewById(R.id.thDetail_Kelas)).setText(hewan.getKelas());
        ((TextView) findViewById(R.id.thDetail_Ordo)).setText(hewan.getOrdo());
        ((TextView) findViewById(R.id.thDetail_Family)).setText(hewan.getFamily());
        ((TextView) findViewById(R.id.thDetail_Genus)).setText(hewan.getGenus());
        ((TextView) findViewById(R.id.thDetail_Spesies)).setText(hewan.getSpesies());
        ((TextView) findViewById(R.id.thDetail_Deskripsi_Singkat)).setText(hewan.getCiriciri());
        ((TextView) findViewById(R.id.thDetail_Makanan)).setText(hewan.getMakanan());
        ((TextView) findViewById(R.id.thDetail_Perkembangbiakan)).setText(hewan.getPerkembangbiakan());
        ((TextView) findViewById(R.id.thDetail_Habitat_Distribusi)).setText(hewan.getHabitat());
        ((TextView) findViewById(R.id.thDetail_Status_Konservasi)).setText(hewan.getStatuskonservasi());
        ((TextView) findViewById(R.id.thDetail_Sumber)).setText(hewan.getSumberref());
        ((TextView) findViewById(R.id.thDetail_Sumber_Foto)).setText(hewan.getSumberfoto());

//        ((TextView) findViewById(R.id.thDetailNama)).setText(hewan.getNama());

//        Toast.makeText(this, "" + idHewan, Toast.LENGTH_SHORT).show();
    }
}
