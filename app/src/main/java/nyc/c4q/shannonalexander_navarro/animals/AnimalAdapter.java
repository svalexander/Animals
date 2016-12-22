package nyc.c4q.shannonalexander_navarro.animals;

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

public class AnimalAdapter extends RecyclerView.Adapter {

    List<Animal> animals = new ArrayList<>();

    public AnimalAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item, parent, false);
        return new AnimalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AnimalViewHolder viewHolder = (AnimalViewHolder) holder;

        Animal anAnimal = animals.get(position);
        viewHolder.bind(anAnimal);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
