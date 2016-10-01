

package com.ibm.mobileappbuilder.try20161001082337.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.try20161001082337.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;


/**
 * ContactusFragment menu fragment.
 */
public class ContactusFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public ContactusFragment(){
        super();
    }

    // Factory method
    public static ContactusFragment newInstance(Bundle args) {
        ContactusFragment fragment = new ContactusFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
                }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_list;
    }

    @Override
    public int getItemLayout() {
        return R.layout.contactus_item;
    }
}

