package irawan.org.appensiklopediaoffline.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import irawan.org.appensiklopediaoffline.R;

/**
 * Created by dodi on 25/10/17.
 */
public class ValidatorTab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pembimbing_validator_tab,container,false);
    }
}
