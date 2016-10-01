

package com.ibm.mobileappbuilder.try20161001082337.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.try20161001082337.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * VegetablesMenuItem2Activity list activity
 */
public class VegetablesMenuItem2Activity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.vegetablesMenuItem2Activity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return VegetablesMenuItem2Fragment.class;
    }

}

