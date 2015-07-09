package github.cesarferreira.pretender.rest;


import github.cesarferreira.pretender.models.FetchedData;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface ApiService {

    @GET("/")
    Observable<FetchedData> getUsers(@Query("nat") String nationality,
                                     @Query("seed") String seed,
                                     @Query("results") int amount,
                                     @Query("gender") String gender);

}
