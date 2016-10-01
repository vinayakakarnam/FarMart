
package com.ibm.mobileappbuilder.try20161001082337.ds;

import ibmmobileappbuilder.ds.Count;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.Distinct;
import ibmmobileappbuilder.ds.Pagination;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import ibmmobileappbuilder.util.FilterUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * "DatacsvDS" static data source (8370d4f5-75b5-4a6b-a175-dd84538dde2a)
 */
public class DatacsvDS implements Datasource<DatacsvDSSchemaItem>, Count,
            Pagination<DatacsvDSSchemaItem>, Distinct {

    private static final int PAGE_SIZE = 20;

    private SearchOptions searchOptions;

    public static DatacsvDS getInstance(SearchOptions searchOptions){
        return new DatacsvDS(searchOptions);
    }

    private DatacsvDS(SearchOptions searchOptions){
        this.searchOptions = searchOptions;
    }

    @Override
    public void getItems(Listener<List<DatacsvDSSchemaItem>> listener) {
        listener.onSuccess(DatacsvDSItems.ITEMS);
    }

    @Override
    public int getPageSize(){
        return PAGE_SIZE;
    }

    @Override
    public void getItem(String id, Listener<DatacsvDSSchemaItem> listener) {
        final int pos = Integer.parseInt(id);
        if(DatacsvDSItems.ITEMS.size() <= pos){
        	listener.onSuccess(new DatacsvDSSchemaItem());
        }
        else {
	        DatacsvDSSchemaItem dc = DatacsvDSItems.ITEMS.get(pos);
	        if( dc != null)
	            listener.onSuccess(dc);
	        else
	            listener.onFailure(new IllegalArgumentException("DatacsvDSSchemaItem not found: " + pos));
	    }
    }

    @Override public int getCount(){
        return DatacsvDSItems.ITEMS.size();
    }

    @Override
    public void getItems(int pagenum, Listener<List<DatacsvDSSchemaItem>> listener) {
        int first = pagenum * PAGE_SIZE;
        int last = first + PAGE_SIZE;
        ArrayList<DatacsvDSSchemaItem> result = new ArrayList<DatacsvDSSchemaItem>();
        List<DatacsvDSSchemaItem> filteredList = applySearchOptions(DatacsvDSItems.ITEMS);
        if(first < filteredList.size())
            for (int i = first; (i < last) && (i < filteredList.size()); i++)
                result.add(filteredList.get(i));

        listener.onSuccess(result);
    }

    @Override
    public void onSearchTextChanged(String s){
        searchOptions.setSearchText(s);
    }

    @Override
    public void addFilter(Filter filter){
        searchOptions.addFilter(filter);
    }

    @Override
    public void clearFilters() {
        searchOptions.setFilters(null);
    }

    private List<DatacsvDSSchemaItem> applySearchOptions(List<DatacsvDSSchemaItem> result) {
        List<DatacsvDSSchemaItem> filteredList = result;

        //Searching options
        String searchText = searchOptions.getSearchText();

        if(searchOptions.getFixedFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFixedFilters());

        if(searchOptions.getFilters() != null)
            filteredList = applyFilters(filteredList, searchOptions.getFilters());

        if (searchText != null && !"".equals(searchText))
            filteredList = applySearch(filteredList, searchText);

        //Sorting options
        Comparator comparator = searchOptions.getSortComparator();
        if (comparator != null) {
            if (searchOptions.isSortAscending()) {
                Collections.sort(filteredList, comparator);
            } else {
                Collections.sort(filteredList, Collections.reverseOrder(comparator));
            }
        }

        return filteredList;
    }

    private List<DatacsvDSSchemaItem> applySearch(List<DatacsvDSSchemaItem> items, String searchText) {
        List<DatacsvDSSchemaItem> filteredList = new ArrayList<>();

        for (DatacsvDSSchemaItem item : items) {
                        
            if (FilterUtils.searchInString(item.id, searchText) ||
            FilterUtils.searchInString(item.name, searchText) ||
            FilterUtils.searchInString(item.dataField0, searchText) ||
            FilterUtils.searchInString(item.category, searchText) ||
            FilterUtils.searchInDouble(item.price, searchText) ||
            FilterUtils.searchInString(item.rating, searchText) ||
            FilterUtils.searchInString(item.thumbnail, searchText) ||
            FilterUtils.searchInString(item.webaddress, searchText))
            {
                filteredList.add(item);
            }
        }

        return filteredList;

    }

    private List<DatacsvDSSchemaItem> applyFilters(List<DatacsvDSSchemaItem> items, List<Filter> filters) {
        List<DatacsvDSSchemaItem> filteredList = new ArrayList<>();

        for (DatacsvDSSchemaItem item : items) {
            if (
                FilterUtils.applyFilters("id", item.id, filters) &&
                FilterUtils.applyFilters("name", item.name, filters) &&
                FilterUtils.applyFilters("dataField0", item.dataField0, filters) &&
                FilterUtils.applyFilters("category", item.category, filters) &&
                FilterUtils.applyFilters("price", item.price, filters) &&
                FilterUtils.applyFilters("rating", item.rating, filters) &&
                FilterUtils.applyFilters("picture", item.picture, filters) &&
                FilterUtils.applyFilters("thumbnail", item.thumbnail, filters) &&
                FilterUtils.applyFilters("webaddress", item.webaddress, filters)
                ){

                filteredList.add(item);
            }
        }

        return filteredList;
    }

    // Distinct interface

    @Override
    public void getUniqueValuesFor(String columnName, Listener<List<String>> listener) {
        List<DatacsvDSSchemaItem> filteredList = applySearchOptions(DatacsvDSItems.ITEMS);
        listener.onSuccess(mapItems(filteredList, columnName));
    }

    private List<String> mapItems(List<DatacsvDSSchemaItem> items, String columnName){
        // return only unique values
        ArrayList<String> res = new ArrayList();
        for (DatacsvDSSchemaItem item: items){
            String mapped = mapItem(item, columnName);
            if(mapped != null && !res.contains(mapped))
                res.add(mapped);
        }

        return res;
    }

    private String mapItem(DatacsvDSSchemaItem item, String columnName){
        // get fields
        switch (columnName){
                        
            case "id":
                return item.id;
            
            case "name":
                return item.name;
            
            case "dataField0":
                return item.dataField0;
            
            case "category":
                return item.category;
            
            case "rating":
                return item.rating;
            
            case "thumbnail":
                return item.thumbnail;
            
            case "webaddress":
                return item.webaddress;
            default:
               return null;
        }
    }
}


