
package com.ibm.mobileappbuilder.try20161001082337.ds;
import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.POST;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Path;
import retrofit.http.PUT;
import retrofit.mime.TypedByteArray;
import retrofit.http.Part;
import retrofit.http.Multipart;

public interface ContactusDSServiceRest{

	@GET("/app/57ef72c257acb003000664ee/r/contactusDS")
	void queryContactusDSItem(
		@Query("skip") String skip,
		@Query("limit") String limit,
		@Query("conditions") String conditions,
		@Query("sort") String sort,
		@Query("select") String select,
		@Query("populate") String populate,
		Callback<List<ContactusDSItem>> cb);

	@GET("/app/57ef72c257acb003000664ee/r/contactusDS/{id}")
	void getContactusDSItemById(@Path("id") String id, Callback<ContactusDSItem> cb);

	@DELETE("/app/57ef72c257acb003000664ee/r/contactusDS/{id}")
  void deleteContactusDSItemById(@Path("id") String id, Callback<ContactusDSItem> cb);

  @POST("/app/57ef72c257acb003000664ee/r/contactusDS/deleteByIds")
  void deleteByIds(@Body List<String> ids, Callback<List<ContactusDSItem>> cb);

  @POST("/app/57ef72c257acb003000664ee/r/contactusDS")
  void createContactusDSItem(@Body ContactusDSItem item, Callback<ContactusDSItem> cb);

  @PUT("/app/57ef72c257acb003000664ee/r/contactusDS/{id}")
  void updateContactusDSItem(@Path("id") String id, @Body ContactusDSItem item, Callback<ContactusDSItem> cb);

  @GET("/app/57ef72c257acb003000664ee/r/contactusDS")
  void distinct(
        @Query("distinct") String colName,
        @Query("conditions") String conditions,
        Callback<List<String>> cb);
    
    @Multipart
    @POST("/app/57ef72c257acb003000664ee/r/contactusDS")
    void createContactusDSItem(
        @Part("data") ContactusDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<ContactusDSItem> cb);
    
    @Multipart
    @PUT("/app/57ef72c257acb003000664ee/r/contactusDS/{id}")
    void updateContactusDSItem(
        @Path("id") String id,
        @Part("data") ContactusDSItem item,
        @Part("picture") TypedByteArray picture,
        Callback<ContactusDSItem> cb);
}

