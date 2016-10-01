
package com.ibm.mobileappbuilder.try20161001082337.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.try20161001082337.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.ImageView;
import android.widget.TextView;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.StringUtils;
import java.net.URL;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.try20161001082337.ds.ContactusDSItem;
import com.ibm.mobileappbuilder.try20161001082337.ds.ContactusDS;

public class ContactusScreen1Fragment extends ibmmobileappbuilder.ui.DetailFragment<ContactusDSItem>  {

    private Datasource<ContactusDSItem> datasource;
    private SearchOptions searchOptions;

    public static ContactusScreen1Fragment newInstance(Bundle args){
        ContactusScreen1Fragment card = new ContactusScreen1Fragment();
        card.setArguments(args);

        return card;
    }

    public ContactusScreen1Fragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
      if (datasource != null) {
          return datasource;
      }
          datasource = ContactusDS.getInstance(searchOptions);
          return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.contactusscreen1_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final ContactusDSItem item, View view) {
        
        ImageView view0 = (ImageView) view.findViewById(R.id.view0);
        URL view0Media = ((AppNowDatasource) getDatasource()).getImageUrl(item.picture);
        if(view0Media != null){
          ImageLoader imageLoader = new PicassoImageLoader(view0.getContext());
          imageLoader.load(imageLoaderRequest()
                                   .withPath(view0Media.toExternalForm())
                                   .withTargetView(view0)
                                   .fit()
                                   .build()
                    );
        	
        } else {
          view0.setImageDrawable(null);
        }
        if (item.address != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.address);
            
        }
        if (item.phone != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText(StringUtils.doubleToString(item.phone, true));
            
        }
        if (item.email != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.email);
            
        }
    }

    @Override
    protected void onShow(ContactusDSItem item) {
        // set the title for this fragment
        getActivity().setTitle("Contact us");
    }

}

