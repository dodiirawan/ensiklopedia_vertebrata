package irawan.org.appensiklopediaoffline.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import org.w3c.dom.Text;

/**
 * Created by dodi on 25/10/17.
 */
public class PemValTab extends Fragment {


    View view;
    Context context;

    private String nourut;
    private String info;

    private TextView textViewInfoNama;
    private TextView textViewInfoNipNim;
    private TextView textViewInfoFakultas;
    private TextView textViewInfoProdi;
    private TextView textViewInfoKeahlian;

    private ImageView image_view_val_pem;
    DatabaseHelper db;

    public PemValTab(Context context, String nourut, String info) {
        this.context = context;
        this.nourut = nourut;
        this.info = info;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_pembimbing_validator_tab,container,false);

        db = new DatabaseHelper(context);
        Person person = db.getPerson(nourut,info);

        textViewInfoNama = (TextView) view.findViewById(R.id.textViewInfoNama);
        textViewInfoNipNim = (TextView) view.findViewById(R.id.textViewInfoNipNim);
        textViewInfoFakultas = (TextView) view.findViewById(R.id.textViewInfoFakultas);
        textViewInfoProdi = (TextView) view.findViewById(R.id.textViewInfoProdi);
        textViewInfoKeahlian = (TextView) view.findViewById(R.id.textViewInfoKeahlian);

        image_view_val_pem = (ImageView) view.findViewById(R.id.image_view_val_pem);

        textViewInfoNama.setText(person.getNama());
        textViewInfoNipNim.setText(person.getNim_nip());

        textViewInfoFakultas.setText(person.getFakultas());
        textViewInfoProdi.setText(person.getProgramstudi());
        textViewInfoKeahlian.setText(person.getProgramkeahlian());

//        Toast.makeText(context,person.getNama(), Toast.LENGTH_SHORT).show();

        try {

            byte[] decodeString = Base64.decode(person.getFoto(), Base64.DEFAULT);
            Bitmap decoded = BitmapFactory.decodeByteArray(decodeString, 0, decodeString.length);

            image_view_val_pem.setImageBitmap(decoded);
        } catch (Exception e) {
            Toast.makeText(context, "Terjadi Kesalahan Load Foto", Toast.LENGTH_SHORT).show();
        }

        return view;
    }
}
