package com.ibm.mobileappbuilder.try20161001082337.ui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import ibmmobileappbuilder.ui.DrawerActivity;

import com.ibm.mobileappbuilder.try20161001082337.R;

public class FarmartMain extends DrawerActivity {

    private final SparseArray<Class<? extends Fragment>> sectionFragments = new SparseArray<>();
    {
                sectionFragments.append(R.id.entry0, FarMarketFragment.class);
            sectionFragments.append(R.id.entry1, ContactusScreen1Fragment.class);
            sectionFragments.append(R.id.entry2, LogoutFragment.class);
    }

    @Override
    public SparseArray<Class<? extends Fragment>> getSectionFragmentClasses() {
      return sectionFragments;
    }

}

