

package com.ibm.mobileappbuilder.try20161001082337.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.try20161001082337.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * GreensActivity list activity
 */
public class GreensActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.greensActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return GreensFragment.class;
    }

}

