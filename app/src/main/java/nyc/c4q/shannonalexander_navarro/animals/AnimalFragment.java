package nyc.c4q.shannonalexander_navarro.animals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.shannonalexander_navarro.animals.models.Animal;

/**
 * Created by shannonalexander-navarro on 12/21/16.
 */

public class AnimalFragment extends Fragment {

    AnimalAdapter animalAdapter;
    RecyclerView rv;
    List<Animal> animals = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.animal_fragment, container, false);

        rv = (RecyclerView) root.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //   getTheRecords();
        animalAdapter = new AnimalAdapter(animals);
        rv.setAdapter(animalAdapter);
        return root;
    }
}
