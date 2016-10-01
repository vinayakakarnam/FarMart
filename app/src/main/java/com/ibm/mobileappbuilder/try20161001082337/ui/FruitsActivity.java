

package com.ibm.mobileappbuilder.try20161001082337.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.try20161001082337.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * FruitsActivity list activity
 */
public class FruitsActivity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.fruitsActivity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return FruitsFragment.class;
    }

}

