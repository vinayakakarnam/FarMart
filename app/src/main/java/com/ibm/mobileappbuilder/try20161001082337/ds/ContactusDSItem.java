
package com.ibm.mobileappbuilder.try20161001082337.ds;
import android.graphics.Bitmap;
import android.net.Uri;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class ContactusDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("address") public String address;
    @SerializedName("phone") public Double phone;
    @SerializedName("picture") public String picture;
    @SerializedName("email") public String email;
    @SerializedName("id") public String id;
    @SerializedName("pictureUri") public transient Uri pictureUri;

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
        dest.writeString(address);
        dest.writeValue(phone);
        dest.writeString(picture);
        dest.writeString(email);
        dest.writeString(id);
    }

    public static final Creator<ContactusDSItem> CREATOR = new Creator<ContactusDSItem>() {
        @Override
        public ContactusDSItem createFromParcel(Parcel in) {
            ContactusDSItem item = new ContactusDSItem();

            item.address = in.readString();
            item.phone = (Double) in.readValue(null);
            item.picture = in.readString();
            item.email = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public ContactusDSItem[] newArray(int size) {
            return new ContactusDSItem[size];
        }
    };

}


