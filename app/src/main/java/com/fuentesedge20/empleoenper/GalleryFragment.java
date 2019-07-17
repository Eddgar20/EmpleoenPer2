package com.fuentesedge20.empleoenper;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GalleryFragment extends Fragment {
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            view=inflater.inflate(R.layout.fragment_gallery, container, false);

        View contenedor=(View)container.getParent();
        appBar=(AppBarLayout) contenedor.findViewById(R.id.appBar);
        pestanas=new TabLayout(getActivity());

        pestanas.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#ffffff"));
        appBar.addView(pestanas);

        viewPager=(ViewPager)view.findViewById(R.id.pager1);
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        pestanas.setupWithViewPager(viewPager);
        setupTabLayout();

        return view;
    }
    private void setupTabLayout() {
        pestanas.getTabAt(0).setIcon(R.drawable.busqueda);
        pestanas.getTabAt(1).setIcon(R.drawable.tra6);
        pestanas.getTabAt(2).setIcon(R.drawable.trabajo1);
        pestanas.getTabAt(3).setIcon(R.drawable.trabajo3);
        pestanas.getTabAt(4).setIcon(R.drawable.trabajo5);

    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        appBar.removeView(pestanas);
    }
    public class ViewPagerAdapter extends FragmentStatePagerAdapter{
        public ViewPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        String [] tituloPestana={"Busqueda","Tu","Ustedes","Vosotros","Todos"};
        //String [] iconPestañas={Drawable};




        @Override
        public Fragment getItem(int posecion){
            switch (posecion){
                case 0 : return new BUSCARFragment();
                case 1 : return new TUFragment();
                case 2 : return new USTEDESFragment();
                case 3 : return new VOSOTROSFragment();
                case 4 : return new TODOSFragment();
            }

            return null;

        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tituloPestana[position];
        }

        @Override
        public int getCount() {
            return 5;
        }



    }
}
/*

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_gallery, container, false);


        View contenedor=(View)container.getParent();
        appBar=(AppBarLayout) contenedor.findViewById(R.id.appBar);
        pestanas=new TabLayout(getActivity());
        pestanas.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#ffffff"));
        appBar.addView(pestanas);

        viewPager=(ViewPager)view.findViewById(R.id.pager1);
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        pestanas.setupWithViewPager(viewPager);


        return view;
    }



        @Override
        public CharSequence getPageTitle(int position) {
            return tituloPestana[position];

        }

        @Override
        public int getCount() {
            return 2;
        }



    }
}
            */