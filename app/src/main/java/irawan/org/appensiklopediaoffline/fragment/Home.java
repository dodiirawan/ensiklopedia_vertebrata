package irawan.org.appensiklopediaoffline.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import irawan.org.appensiklopediaoffline.R;
import irawan.org.appensiklopediaoffline.fragment.list.ListHewanActivity;

public class Home extends Fragment {

    private GridView gridView;
    private View view;

    public static final String[] gridViewStrings = {
            "Mamalia",
            "Pisces",
            "Aves",
            "Ampibia",
            "Reptilia",
            ""
    };

    public static final int[] gridViewImages = {
            R.drawable.mamalia,
            R.drawable.pisces,
            R.drawable.aves,
            R.drawable.ampibia,
            R.drawable.reptilia,
            0
    };

    public Home() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        gridView = (GridView) view.findViewById(R.id.grid);
        gridView.setAdapter(new CustomAndroidGridViewAdapter(getContext(),gridViewStrings,gridViewImages));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                detailView(i);
            }
        });

        return view;
    }

    public void detailView(int pos) {
        if(pos != 5) {

            Intent i = new Intent(getActivity(),ListHewanActivity.class);

            if(pos == 0) {
                i.putExtra("hewan","Mamalia");
            }

            if(pos == 1) {
                i.putExtra("hewan","Pisces");
            }

            if(pos == 2) {
                i.putExtra("hewan","Aves");
            }

            if(pos == 3) {
                i.putExtra("hewan","Amphibi");
            }

            if(pos == 4) {
                i.putExtra("hewan","Reptilia");
            }

            startActivity(i);
        }
    }


    public class CustomAndroidGridViewAdapter extends BaseAdapter {

        private Context mContex;
        private final String[] string;
        private final int[] Imageid;

        public CustomAndroidGridViewAdapter(Context mContex, String[] string, int[] imageid) {
            this.mContex = mContex;
            this.string = string;
            Imageid = imageid;
        }

        @Override
        public int getCount() {
            return string.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            View grid;

            LayoutInflater inflater = (LayoutInflater) mContex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(convertView == null) {
                grid = new View(mContex);
                grid = inflater.inflate(R.layout.fragment_home_grid,null);
                TextView textView = (TextView) grid.findViewById(R.id.gridview_text);
                ImageView imageView = (ImageView) grid.findViewById(R.id.gridview_image);
                textView.setText(string[i]);
                imageView.setImageResource(Imageid[i]);
            } else {
                grid = (View) convertView;
            }
            return grid;
        }
    }

}
