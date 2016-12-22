package nyc.c4q.shannonalexander_navarro.animals.network;

import nyc.c4q.shannonalexander_navarro.animals.models.AnimalResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shannonalexander-navarro on 12/21/16.
 */

public interface AnimalService {

    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalResponse> getAllAnimals();
}
