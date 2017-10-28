package irawan.org.appensiklopediaoffline.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import irawan.org.appensiklopediaoffline.entity.Hewan;
import irawan.org.appensiklopediaoffline.entity.Person;

/**
 * Created by dodi on 26/10/17.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE = "ensiklopedia_vertebrata.db";
    public static final String TABLE_HEWAN = "hewan";
    public static final String TABLE_INFO = "info";
    public static final String COL_ID = "id";

    public static final String COL_HEWAN_NAMA = "nama";
    public static final String COL_HEWAN_KINGDOM = "kingdom";
    public static final String COL_HEWAN_PHYLUM = "phylum";
    public static final String COL_HEWAN_SUBPHYLUM = "subphylum";
    public static final String COL_HEWAN_KELAS = "kelas";
    public static final String COL_HEWAN_ORDO = "ordo";
    public static final String COL_HEWAN_FAMILY = "family";
    public static final String COL_HEWAN_GENUS = "genus";
    public static final String COL_HEWAN_SPESIES = "spesies";
    public static final String COL_HEWAN_CIRICIRI = "ciriciri";
    public static final String COL_HEWAN_MAKANAN = "makanan";
    public static final String COL_HEWAN_PERKEMBANGBIAKAN = "perkembangbiakan";
    public static final String COL_HEWAN_HABITAT = "habitat";
    public static final String COL_HEWAN_IMAGE = "image";
    public static final String COL_HEWAN_SUMBERFOTO = "sumberfoto";
    public static final String COL_HEWAN_STATUSKONSERVASI = "statuskonservasi";
    public static final String COL_HEWAN_SUMBERREF = "sumberref";

    public static final String CREATE_TABLE_HEWAN = "CREATE TABLE " + TABLE_HEWAN + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_HEWAN_NAMA + " TEXT," +
            COL_HEWAN_KINGDOM + " TEXT," +
            COL_HEWAN_PHYLUM + " TEXT," +
            COL_HEWAN_SUBPHYLUM + " TEXT," +
            COL_HEWAN_KELAS + " TEXT," +
            COL_HEWAN_ORDO + " TEXT," +
            COL_HEWAN_FAMILY + " TEXT," +
            COL_HEWAN_GENUS + " TEXT," +
            COL_HEWAN_SPESIES + " TEXT," +
            COL_HEWAN_CIRICIRI + " TEXT," +
            COL_HEWAN_MAKANAN + " TEXT," +
            COL_HEWAN_PERKEMBANGBIAKAN + " TEXT," +
            COL_HEWAN_HABITAT + " TEXT," +
            COL_HEWAN_IMAGE + " TEXT," +
            COL_HEWAN_SUMBERFOTO + " TEXT," +
            COL_HEWAN_STATUSKONSERVASI + " TEXT," +
            COL_HEWAN_SUMBERREF + " TEXT)";

   
    public static final String COL_INFO_NOURUT = "nourut";
    public static final String COL_INFO_INFO = "info";
    public static final String COL_INFO_NAMA = "nama";
    public static final String COL_INFO_NIM_NIP = "nim_nip";
    public static final String COL_INFO_TEMPATLAHIR = "tempat_lahir";
    public static final String COL_INFO_TANGGALLAHIR = "tanggal_lahir";
    public static final String COL_INFO_ALAMAT = "alamat";
    public static final String COL_INFO_PEKERJAAN = "pekerjaan";
    public static final String COL_INFO_FAKULTAS = "fakultas";
    public static final String COL_INFO_PROGRAMSTUDI = "programstudi";
    public static final String COL_INFO_PROGRAMKEAHLIAN = "programkeahlian";
    public static final String COL_INFO_KETERANGAN = "keterangan";
    public static final String COL_INFO_FOTO = "foto";

    public static final String CREATE_TABLE_INFO = "CREATE TABLE " + TABLE_INFO + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_INFO_NOURUT + " TEXT," +
            COL_INFO_INFO + " TEXT," +
            COL_INFO_NAMA + " TEXT," +
            COL_INFO_NIM_NIP + " TEXT," +
            COL_INFO_TEMPATLAHIR + " TEXT," +
            COL_INFO_TANGGALLAHIR + " TEXT," +
            COL_INFO_ALAMAT + " TEXT," +
            COL_INFO_PEKERJAAN + " TEXT," +
            COL_INFO_FAKULTAS + " TEXT," +
            COL_INFO_PROGRAMSTUDI + " TEXT," +
            COL_INFO_PROGRAMKEAHLIAN + " TEXT," +
            COL_INFO_KETERANGAN + " TEXT," +
            COL_INFO_FOTO  + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_HEWAN);
        sqLiteDatabase.execSQL(CREATE_TABLE_INFO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_HEWAN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_INFO);
    }

    public void deleteHewan() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HEWAN);
        db.execSQL(CREATE_TABLE_HEWAN);
    }

    public long addDataHewan(Hewan hewan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_HEWAN_NAMA,hewan.getNama());
        cv.put(COL_HEWAN_KINGDOM,hewan.getKingdom());
        cv.put(COL_HEWAN_PHYLUM,hewan.getPhylum());
        cv.put(COL_HEWAN_SUBPHYLUM,hewan.getSubphylum());
        cv.put(COL_HEWAN_KELAS,hewan.getKelas());
        cv.put(COL_HEWAN_ORDO,hewan.getOrdo());
        cv.put(COL_HEWAN_FAMILY,hewan.getFamily());
        cv.put(COL_HEWAN_GENUS,hewan.getGenus());
        cv.put(COL_HEWAN_SPESIES,hewan.getSpesies());
        cv.put(COL_HEWAN_CIRICIRI,hewan.getCiriciri());
        cv.put(COL_HEWAN_MAKANAN,hewan.getMakanan());
        cv.put(COL_HEWAN_PERKEMBANGBIAKAN,hewan.getPerkembangbiakan());
        cv.put(COL_HEWAN_HABITAT,hewan.getHabitat());
        cv.put(COL_HEWAN_IMAGE,hewan.getImage());
        cv.put(COL_HEWAN_SUMBERFOTO,hewan.getSumberfoto());
        cv.put(COL_HEWAN_STATUSKONSERVASI,hewan.getStatuskonservasi());
        cv.put(COL_HEWAN_SUMBERREF,hewan.getSumberref());

        long result = db.insert(TABLE_HEWAN,null,cv);
        //Log.d("Tambah",hewan.getNama() + " " + hewan.getSpesies() + " " + hewan.getKelas());

        return result;
    }

    public void deleteInfo() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INFO);
        db.execSQL(CREATE_TABLE_INFO);
    }

    public long addDataInfo(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_INFO_NOURUT,person.getNourut());
        cv.put(COL_INFO_INFO,person.getInfo());
        cv.put(COL_INFO_NAMA,person.getNama());
        cv.put(COL_INFO_NIM_NIP,person.getNim_nip());
        cv.put(COL_INFO_TEMPATLAHIR,person.getTempat_lahir());
        cv.put(COL_INFO_TANGGALLAHIR,person.getTanggal_lahir());
        cv.put(COL_INFO_ALAMAT,person.getAlamat());
        cv.put(COL_INFO_PEKERJAAN,person.getPekerjaan());
        cv.put(COL_INFO_FAKULTAS,person.getFakultas());
        cv.put(COL_INFO_PROGRAMSTUDI,person.getProgramstudi());
        cv.put(COL_INFO_PROGRAMKEAHLIAN,person.getProgramkeahlian());
        cv.put(COL_INFO_KETERANGAN,person.getKeterangan());
        cv.put(COL_INFO_FOTO,person.getFoto());

        long result = db.insert(TABLE_INFO,null,cv);

//        Log.d("tambah info",person.getNama() + " " + person.getFoto());
        return result;
    }

    public Cursor getHewanCursors(String kelas) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT id,nama,spesies,image FROM " + TABLE_HEWAN + " WHERE kelas LIKE '" + kelas + "' ORDER BY nama";
        Cursor data = db.rawQuery(query,null);

//        String query = "SELECT id,nama,spesies,image FROM " + TABLE_HEWAN + " WHERE kelas = ? ORDER BY nama";

//        Cursor data = db.rawQuery(query,new String[] { kelas });
//        Log.d("query",query);
        return data;
    }

    public Hewan getHewan(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_HEWAN + " WHERE id LIKE " + id + "";
        Cursor data = db.rawQuery(query,null);

        Hewan hwn = new Hewan();
        while (data.moveToNext()) {
            hwn.setNama(data.getString(1));
            hwn.setKingdom(data.getString(2));
            hwn.setPhylum(data.getString(3));
            hwn.setSubphylum(data.getString(4));
            hwn.setKelas(data.getString(5));
            hwn.setOrdo(data.getString(6));
            hwn.setFamily(data.getString(7));
            hwn.setGenus(data.getString(8));
            hwn.setSpesies(data.getString(9));
            hwn.setCiriciri(data.getString(10));
            hwn.setMakanan(data.getString(11));
            hwn.setPerkembangbiakan(data.getString(12));
            hwn.setHabitat(data.getString(13));
            hwn.setImage(data.getString(14));
            hwn.setSumberfoto(data.getString(15));
            hwn.setStatuskonservasi(data.getString(16));
            hwn.setSumberref(data.getString(17));
        }

        return hwn;
    }

    public Person getPerson(String nourut, String info) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_INFO + " WHERE nourut LIKE '" + nourut + "' AND info LIKE '" + info + "'";
        Cursor data = db.rawQuery(query,null);
        Person p = new Person();

        while (data.moveToNext()) {
//            p.setNama(data.getString(0));
//            p.setNim_nip(data.getString(1));
//            p.setFoto(data.getString(2));
//            Log.d("foto",data.getString(2));
            p.setNourut(data.getString(1));
            p.setInfo(data.getString(2));
            p.setNama(data.getString(3));
            p.setNim_nip(data.getString(4));
            p.setTempat_lahir(data.getString(5));
            p.setTanggal_lahir(data.getString(6));
            p.setAlamat(data.getString(7));
            p.setPekerjaan(data.getString(8));
            p.setFakultas(data.getString(9));
            p.setProgramstudi(data.getString(10));
            p.setProgramkeahlian(data.getString(11));
            p.setKeterangan(data.getString(12));
            p.setFoto(data.getString(13));
        }
        return p;
    }
}
