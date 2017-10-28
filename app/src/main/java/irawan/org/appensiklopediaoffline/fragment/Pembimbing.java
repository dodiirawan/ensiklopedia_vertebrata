package irawan.org.appensiklopediaoffline.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import irawan.org.appensiklopediaoffline.R;

public class Pembimbing extends Fragment {

    private View view;
    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
        adapter.addFragment(new PemValTab(getContext(),"1","pembimbing"),"Pembimbing I");
        adapter.addFragment(new PemValTab(getContext(),"2","pembimbing"),"Pembimbing II");
        viewPager.setAdapter(adapter);
    }

    public Pembimbing() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_pembimbing, container, false);

        mSectionPageAdapter = new SectionPageAdapter(getChildFragmentManager());
        mViewPager = (ViewPager) view.findViewById(R.id.viewPagerPembimbing);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabsPembimbing);
        tabLayout.setupWithViewPager(mViewPager);

        return view;
    }



}
