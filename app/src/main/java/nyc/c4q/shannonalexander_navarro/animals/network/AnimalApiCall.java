package nyc.c4q.shannonalexander_navarro.animals.network;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.animals.models.Animal;
import nyc.c4q.shannonalexander_navarro.animals.models.AnimalResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shannonalexander-navarro on 12/21/16.
 */

public class AnimalApiCall {

    private static final String HOUSE_URL = "http://jsjrobotics.nyc/";
    private static final String TAG = "success";
    List<Animal> animalList = new ArrayList<>();


    public static void getAnimalJson() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOUSE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimalService service = retrofit.create(AnimalService.class);

        Call<AnimalResponse> call = service.getAllAnimals();

        call.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {


                AnimalResponse animalResponse = response.body();


                if (response.isSuccessful()) {
                    Log.d(TAG, "Success: " + animalResponse.getAnimals().get(0).getName());
                } else {
                    try {
                        Log.d(TAG, "Error" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Log.e("FAILURE", "GOT NOTHING" + t);

            }

        });
    }
}
