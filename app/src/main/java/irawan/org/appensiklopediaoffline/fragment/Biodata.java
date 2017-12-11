package irawan.org.appensiklopediaoffline.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import irawan.org.appensiklopediaoffline.R;
import irawan.org.appensiklopediaoffline.entity.Person;
import irawan.org.appensiklopediaoffline.sqlite.DatabaseHelper;


public class Biodata extends Fragment {

    View view;
    Context context;

    private String nourut;
    private String info;

    public Biodata(Context context, String nourut, String info) {
        this.context = context;
        this.nourut = nourut;
        this.info = info;
    }

    private TextView textViewBioNama;
    private TextView textViewBioNipNim;
    private TextView textViewBioAlamat;
    private TextView textViewPekerjaan;

    private ImageView image_view_bio;

    DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_biodata,container,false);

        db = new DatabaseHelper(context);
        Person p = db.getPerson(nourut,info);

        textViewBioNama = (TextView) view.findViewById(R.id.textViewBioNama);
        textViewBioNipNim = (TextView) view.findViewById(R.id.textViewBioNipNim);
        textViewBioAlamat = (TextView) view.findViewById(R.id.textViewBioAlamat);
        textViewPekerjaan = (TextView) view.findViewById(R.id.textViewBioPekerjaan);

        image_view_bio = (ImageView) view.findViewById(R.id.image_view_bio);

        textViewBioNama.setText(p.getNama());
        textViewBioNipNim.setText(p.getNim_nip());
        textViewPekerjaan.setText(p.getPekerjaan());
        textViewBioAlamat.setText(p.getAlamat());

        try {
            byte[] decodeString = Base64.decode(p.getFoto(), Base64.DEFAULT);
            Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);

            image_view_bio.setImageBitmap(decoded);
        } catch (Exception e) {
            Toast.makeText(context, "Terjadi Kesalahan Load Foto", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

}
