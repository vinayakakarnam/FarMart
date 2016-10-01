
package com.ibm.mobileappbuilder.try20161001082337.ds;
import java.net.URL;
import ibmmobileappbuilder.util.StringUtils;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class DatacsvDSSchemaItem implements Parcelable, IdentifiableBean {

    @SerializedName("id") public String id;
    @SerializedName("name") public String name;
    @SerializedName("dataField0") public String dataField0;
    @SerializedName("category") public String category;
    @SerializedName("price") public Double price;
    @SerializedName("rating") public String rating;
    @SerializedName("picture") public Integer picture;
    @SerializedName("thumbnail") public String thumbnail;
    @SerializedName("webaddress") public String webaddress;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(dataField0);
        dest.writeString(category);
        dest.writeValue(price);
        dest.writeString(rating);
        dest.writeValue(picture);
        dest.writeString(thumbnail);
        dest.writeString(webaddress);
    }

    public static final Creator<DatacsvDSSchemaItem> CREATOR = new Creator<DatacsvDSSchemaItem>() {
        @Override
        public DatacsvDSSchemaItem createFromParcel(Parcel in) {
            DatacsvDSSchemaItem item = new DatacsvDSSchemaItem();

            item.id = in.readString();
            item.name = in.readString();
            item.dataField0 = in.readString();
            item.category = in.readString();
            item.price = (Double) in.readValue(null);
            item.rating = in.readString();
            item.picture = (Integer) in.readValue(null);
            item.thumbnail = in.readString();
            item.webaddress = in.readString();
            return item;
        }

        @Override
        public DatacsvDSSchemaItem[] newArray(int size) {
            return new DatacsvDSSchemaItem[size];
        }
    };

}


