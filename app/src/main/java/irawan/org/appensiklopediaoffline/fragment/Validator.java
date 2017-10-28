package irawan.org.appensiklopediaoffline.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import irawan.org.appensiklopediaoffline.R;


public class Validator extends Fragment {

    private View view;
    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    public Validator() {
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
        view =  inflater.inflate(R.layout.fragment_validator, container, false);
        mSectionPageAdapter = new SectionPageAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) view.findViewById(R.id.viewPagerValidator);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabsValidator);
        tabLayout.setupWithViewPager(mViewPager);
        return view;
    }


    public void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
        adapter.addFragment(new PemValTab(getContext(),"1","validator"),"Validator I");
        adapter.addFragment(new PemValTab(getContext(),"2","validator"),"Validator II");
        viewPager.setAdapter(adapter);
    }
}
