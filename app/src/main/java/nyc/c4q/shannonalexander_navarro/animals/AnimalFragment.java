package nyc.c4q.shannonalexander_navarro.animals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.animals.models.Animal;
import nyc.c4q.shannonalexander_navarro.animals.models.AnimalResponse;
import nyc.c4q.shannonalexander_navarro.animals.network.AnimalService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shannonalexander-navarro on 12/21/16.
 */

public class AnimalFragment extends Fragment {

    AnimalAdapter animalAdapter;
    RecyclerView rv;
    private static final String HOUSE_URL = "http://jsjrobotics.nyc/";
    private static final String TAG = "success";
    static List<Animal> animalList = new ArrayList<>();
    static LinearLayout fragLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.animal_fragment, container, false);

        fragLayout = (LinearLayout) root.findViewById(R.id.frag);

        rv = (RecyclerView) root.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        getAnimalJson();
    }

    private void getAnimalJson() {
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

                List<Animal> ourAnimals = response.body().getAnimals();
                animalList = ourAnimals;

                animalAdapter = new AnimalAdapter(animalList);
                rv.setAdapter(animalAdapter);

                if (response.isSuccessful()) {

                    Log.d(TAG, "Success: " + animalResponse.getAnimals().get(0).getBackground());
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
