package irawan.org.appensiklopediaoffline.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import irawan.org.appensiklopediaoffline.R;
import irawan.org.appensiklopediaoffline.volley.RestApi;


public class SyncData extends Fragment {

    private View view;
    private Button buttonInfo;
    private Button buttonHewan;

    private RestApi restApi;

    public SyncData() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_sync_data, container, false);
        buttonInfo = (Button) view.findViewById(R.id.buttonInformasi);
        buttonHewan = (Button) view.findViewById(R.id.buttonHewan);

        restApi = new RestApi(getContext());

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                restApi.getDataInfo();
            }
        });

        buttonHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                restApi.getDataHewan();
            }
        });


        return view;
    }


}
