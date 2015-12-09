package com.extraterristrial.healthmanagementsystem;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.ViewFlipper;

/**
 * Created by Jewel on 12/9/2015.
 */
public class HelpPageFragment extends Fragment {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    int image[]={R.drawable.addprofile,R.drawable.camera,R.drawable.file,R.drawable.save};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.help_page_layout,container,false);
        toolbar=(Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitle("Help");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.add_profile)
                {
                    Fragment createProfileFragment=new CreateProfileFragment();
                    FragmentManager fm=getActivity().getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction().replace(R.id.create_profile,createProfileFragment);
                    ft.commit();
                }
                return true;
            }
        });
        viewFlipper=(ViewFlipper)view.findViewById(R.id.viewflipper);
        for (int i=0;i<image.length;i++){
            ImageView imageView=new ImageView(getActivity());
            imageView.setImageResource(image[i]);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();
        return view;
    }
}