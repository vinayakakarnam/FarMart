

package com.ibm.mobileappbuilder.try20161001082337.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.try20161001082337.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * FarMarketFragment menu fragment.
 */
public class FarMarketFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public FarMarketFragment(){
        super();
    }

    // Factory method
    public static FarMarketFragment newInstance(Bundle args) {
        FarMarketFragment fragment = new FarMarketFragment();

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
        items.add(new MenuItem()
            .setLabel("Fruits")
            .setIcon(R.drawable.jpg_organicfruits692)
            .setAction(new StartActivityAction(FruitsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Vegetables")
            .setIcon(R.drawable.jpg_fruitveggies290)
            .setAction(new StartActivityAction(VegetablesMenuItem2Activity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Greens")
            .setIcon(R.drawable.jpg_bunchgreenmintleaves12230717274)
            .setAction(new StartActivityAction(GreensActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Groceries")
            .setIcon(R.drawable.jpg_7614448505)
            .setAction(new StartActivityAction(GroceriesActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Cleaning")
            .setIcon(R.drawable.jpg_imagehandlerashx864)
            .setAction(new StartActivityAction(CleaningActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.farmarket_item;
    }
}

