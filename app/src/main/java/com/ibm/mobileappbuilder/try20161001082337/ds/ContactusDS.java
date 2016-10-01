

package com.ibm.mobileappbuilder.try20161001082337.ds;

import android.content.Context;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.StringUtils;
import ibmmobileappbuilder.ds.restds.TypedByteArrayUtils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * "ContactusDS" data source. (e37eb8dc-6eb2-4635-8592-5eb9696050e3)
 */
public class ContactusDS extends AppNowDatasource<ContactusDSItem>{

    // default page size
    private static final int PAGE_SIZE = 20;

    private ContactusDSService service;

    public static ContactusDS getInstance(SearchOptions searchOptions){
        return new ContactusDS(searchOptions);
    }

    private ContactusDS(SearchOptions searchOptions) {
        super(searchOptions);
        this.service = ContactusDSService.getInstance();
    }

    @Override
    public void getItem(String id, final Listener<ContactusDSItem> listener) {
        if ("0".equals(id)) {
                        getItems(new Listener<List<ContactusDSItem>>() {
                @Override
                public void onSuccess(List<ContactusDSItem> items) {
                    if(items != null && items.size() > 0) {
                        listener.onSuccess(items.get(0));
                    } else {
                        listener.onSuccess(new ContactusDSItem());
                    }
                }

                @Override
                public void onFailure(Exception e) {
                    listener.onFailure(e);
                }
            });
        } else {
                      service.getServiceProxy().getContactusDSItemById(id, new Callback<ContactusDSItem>() {
                @Override
                public void success(ContactusDSItem result, Response response) {
                                        listener.onSuccess(result);
                }

                @Override
                public void failure(RetrofitError error) {
                                        listener.onFailure(error);
                }
            });
        }
    }

    @Override
    public void getItems(final Listener<List<ContactusDSItem>> listener) {
        getItems(0, listener);
    }

    @Override
    public void getItems(int pagenum, final Listener<List<ContactusDSItem>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
        int skipNum = pagenum * PAGE_SIZE;
        String skip = skipNum == 0 ? null : String.valueOf(skipNum);
        String limit = PAGE_SIZE == 0 ? null: String.valueOf(PAGE_SIZE);
        String sort = getSort(searchOptions);
                service.getServiceProxy().queryContactusDSItem(
                skip,
                limit,
                conditions,
                sort,
                null,
                null,
                new Callback<List<ContactusDSItem>>() {
            @Override
            public void success(List<ContactusDSItem> result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    private String[] getSearchableFields() {
        return new String[]{"address", "email"};
    }

    // Pagination

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getUniqueValuesFor(String searchStr, final Listener<List<String>> listener) {
        String conditions = getConditions(searchOptions, getSearchableFields());
                service.getServiceProxy().distinct(searchStr, conditions, new Callback<List<String>>() {
             @Override
             public void success(List<String> result, Response response) {
                                  result.removeAll(Collections.<String>singleton(null));
                 listener.onSuccess(result);
             }

             @Override
             public void failure(RetrofitError error) {
                                  listener.onFailure(error);
             }
        });
    }

    @Override
    public URL getImageUrl(String path) {
        return service.getImageUrl(path);
    }

    @Override
    public void create(ContactusDSItem item, Listener<ContactusDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().createContactusDSItem(item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().createContactusDSItem(item, callbackFor(listener));
        
    }

    private Callback<ContactusDSItem> callbackFor(final Listener<ContactusDSItem> listener) {
      return new Callback<ContactusDSItem>() {
          @Override
          public void success(ContactusDSItem item, Response response) {
                            listener.onSuccess(item);
          }

          @Override
          public void failure(RetrofitError error) {
                            listener.onFailure(error);
          }
      };
    }

    @Override
    public void updateItem(ContactusDSItem item, Listener<ContactusDSItem> listener) {
                    
        if(item.pictureUri != null){
            service.getServiceProxy().updateContactusDSItem(item.getIdentifiableId(),
                item,
                TypedByteArrayUtils.fromUri(item.pictureUri),
                callbackFor(listener));
        }
        else
            service.getServiceProxy().updateContactusDSItem(item.getIdentifiableId(), item, callbackFor(listener));
        
    }

    @Override
    public void deleteItem(ContactusDSItem item, final Listener<ContactusDSItem> listener) {
                service.getServiceProxy().deleteContactusDSItemById(item.getIdentifiableId(), new Callback<ContactusDSItem>() {
            @Override
            public void success(ContactusDSItem result, Response response) {
                                listener.onSuccess(result);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    @Override
    public void deleteItems(List<ContactusDSItem> items, final Listener<ContactusDSItem> listener) {
                service.getServiceProxy().deleteByIds(collectIds(items), new Callback<List<ContactusDSItem>>() {
            @Override
            public void success(List<ContactusDSItem> item, Response response) {
                                listener.onSuccess(null);
            }

            @Override
            public void failure(RetrofitError error) {
                                listener.onFailure(error);
            }
        });
    }

    protected List<String> collectIds(List<ContactusDSItem> items){
        List<String> ids = new ArrayList<>();
        for(ContactusDSItem item: items){
            ids.add(item.getIdentifiableId());
        }
        return ids;
    }

}

