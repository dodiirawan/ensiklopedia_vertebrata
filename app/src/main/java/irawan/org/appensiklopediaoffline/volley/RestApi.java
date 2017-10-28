package irawan.org.appensiklopediaoffline.volley;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import irawan.org.appensiklopediaoffline.entity.Hewan;
import irawan.org.appensiklopediaoffline.entity.Person;
import irawan.org.appensiklopediaoffline.sqlite.DatabaseHelper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

/**
 * Created by dodi on 26/10/17.
 */
public class RestApi {
    Context context;
    DatabaseHelper db;

//    private static final String URL = "http://192.168.43.220/biologi_api";
    private static final String URL = "http://sumardibahar.web.id/biologi_api";

    public RestApi(Context context) {
        this.context = context;
        db = new DatabaseHelper(context);

    }

    public void getDataHewan() {

        db.deleteHewan();

        final ProgressDialog progressDialog = new ProgressDialog(context);
//        progressDialog.setTitle("Sync Data Hewan");
        progressDialog.setMessage("Sync Data Hewan");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,URL + "/hewan", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int jumlah = response.getInt("total");
                            JSONArray hewan = (JSONArray) response.getJSONArray("data");
                            int jmldata = 1;
                            for(int i = 0; i < hewan.length(); i++) {
                                JSONObject obj = hewan.getJSONObject(i);

                                Hewan hwn = new Hewan();
                                hwn.setNama(obj.getString("nama"));
                                hwn.setKingdom(obj.getString("kingdom"));
                                hwn.setPhylum(obj.getString("phylum"));
                                hwn.setSubphylum(obj.getString("subphylum"));
                                hwn.setKelas(obj.getString("kelas"));
                                hwn.setOrdo(obj.getString("ordo"));
                                hwn.setFamily(obj.getString("family"));
                                hwn.setGenus(obj.getString("genus"));
                                hwn.setSpesies(obj.getString("spesies"));
                                hwn.setCiriciri(obj.getString("ciriciri"));
                                hwn.setMakanan(obj.getString("makanan"));
                                hwn.setPerkembangbiakan(obj.getString("perkembangbiakan"));
                                hwn.setHabitat(obj.getString("habitat"));
                                hwn.setImage(obj.getString("image"));
                                hwn.setSumberfoto(obj.getString("sumberfoto"));
                                hwn.setStatuskonservasi(obj.getString("statuskonservasi"));
                                hwn.setSumberref(obj.getString("sumberref"));

                                db.addDataHewan(hwn);

                                jmldata++;

                                if(jmldata > jumlah) {
                                    progressDialog.dismiss();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                    }
                }
        );

        requestQueue.add(objectRequest);
    }

    public void getDataInfo() {
        db.deleteInfo();
        final ProgressDialog progressDialog = new ProgressDialog(context);

//        progressDialog.setTitle("Sync Data Hewan");
        progressDialog.setMessage("Sync Data Informasi");
        progressDialog.show();

        final RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,URL + "/info", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            int jumlah = response.getInt("total");
                            JSONArray info = (JSONArray) response.getJSONArray("data");
                            int jmldata = 1;
                            for(int i = 0; i < info.length(); i++) {
                                JSONObject obj = info.getJSONObject(i);

                                Person p = new Person();
                                p.setNourut(obj.getString("nourut"));
                                p.setInfo(obj.getString("info"));
                                p.setNama(obj.getString("nama"));
                                p.setNim_nip(obj.getString("nim_nip"));
                                p.setTempat_lahir(obj.getString("tempat_lahir"));
                                p.setTanggal_lahir(obj.getString("tanggal_lahir"));
                                p.setAlamat(obj.getString("alamat"));
                                p.setPekerjaan(obj.getString("pekerjaan"));
                                p.setFakultas(obj.getString("fakultas"));
                                p.setProgramstudi(obj.getString("programstudi"));
                                p.setProgramkeahlian(obj.getString("programkeahlian"));
                                p.setKeterangan(obj.getString("keterangan"));
                                p.setFoto(obj.getString("foto"));

                                db.addDataInfo(p);

                                jmldata++;

                                if(jmldata > jumlah) {
                                    progressDialog.dismiss();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                    }
                }
        );

        requestQueue.add(objectRequest);
    }
}
