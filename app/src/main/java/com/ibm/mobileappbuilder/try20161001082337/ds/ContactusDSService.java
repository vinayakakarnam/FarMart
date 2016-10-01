
package com.ibm.mobileappbuilder.try20161001082337.ds;
import java.net.URL;
import com.ibm.mobileappbuilder.try20161001082337.R;
import ibmmobileappbuilder.ds.RestService;
import ibmmobileappbuilder.util.StringUtils;

/**
 * "ContactusDSService" REST Service implementation
 */
public class ContactusDSService extends RestService<ContactusDSServiceRest>{

    public static ContactusDSService getInstance(){
          return new ContactusDSService();
    }

    private ContactusDSService() {
        super(ContactusDSServiceRest.class);

    }

    @Override
    public String getServerUrl() {
        return "https://ibm-pods.buildup.io";
    }

    @Override
    protected String getApiKey() {
        return "PEnf7vD7";
    }

    @Override
    public URL getImageUrl(String path){
        return StringUtils.parseUrl("https://ibm-pods.buildup.io/app/57ef72c257acb003000664ee",
                path,
                "apikey=PEnf7vD7");
    }

}

