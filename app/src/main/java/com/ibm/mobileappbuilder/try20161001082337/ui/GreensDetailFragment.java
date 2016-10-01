
package com.ibm.mobileappbuilder.try20161001082337.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.try20161001082337.R;
import ibmmobileappbuilder.actions.ActivityIntentLauncher;
import ibmmobileappbuilder.actions.OpenUriAction;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.StringUtils;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.try20161001082337.ds.DatacsvDSSchemaItem;
import com.ibm.mobileappbuilder.try20161001082337.ds.DatacsvDS;

public class GreensDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<DatacsvDSSchemaItem> implements ShareBehavior.ShareListener  {

    private Datasource<DatacsvDSSchemaItem> datasource;
    public static GreensDetailFragment newInstance(Bundle args){
        GreensDetailFragment fr = new GreensDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public GreensDetailFragment(){
        super();
    }

    @Override
    public Datasource<DatacsvDSSchemaItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = DatacsvDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.greensdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final DatacsvDSSchemaItem item, View view) {
        if (item.name != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.name);
            
        }
        if (item.dataField0 != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.dataField0);
            
        }
        if (item.category != null){
            
            TextView view2 = (TextView) view.findViewById(R.id.view2);
            view2.setText(item.category);
            
        }
        if (item.price != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(StringUtils.doubleToString(item.price, true));
            
        }
        if (item.rating != null){
            
            TextView view4 = (TextView) view.findViewById(R.id.view4);
            view4.setText(item.rating);
            
        }
        
        TextView view5 = (TextView) view.findViewById(R.id.view5);
        view5.setText("For Buying Options Click Here");
        bindAction(view5, new OpenUriAction(
        new ActivityIntentLauncher()
        , item.webaddress));
        
        if(item.picture != null){
            ImageView view6 = (ImageView) view.findViewById(R.id.view6);
            ImageLoader imageLoader = new PicassoImageLoader(view.getContext());
            imageLoader.load(imageLoaderRequest()
                            .withResourceToLoad(item.picture)
                            .withTargetView(view6)
                            .build()
            );
            
        }
    }

    @Override
    protected void onShow(DatacsvDSSchemaItem item) {
        // set the title for this fragment
        getActivity().setTitle(item.name);
    }
    @Override
    public void onShare() {
        DatacsvDSSchemaItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.name != null ? item.name : "" ) + "\n" +
                    (item.dataField0 != null ? item.dataField0 : "" ) + "\n" +
                    (item.category != null ? item.category : "" ) + "\n" +
                    (item.price != null ? StringUtils.doubleToString(item.price, true) : "" ) + "\n" +
                    (item.rating != null ? item.rating : "" ) + "\n" +
                    "For Buying Options Click Here");
        intent.putExtra(Intent.EXTRA_SUBJECT, item.name);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

