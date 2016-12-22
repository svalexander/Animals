package nyc.c4q.shannonalexander_navarro.animals;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import nyc.c4q.shannonalexander_navarro.animals.models.Animal;

/**
 * Created by shannonalexander-navarro on 12/21/16.
 */

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    TextView animalName;
    LinearLayout layout;

    public AnimalViewHolder(View itemView) {
        super(itemView);

        animalName = (TextView) itemView.findViewById(R.id.name);
        layout = (LinearLayout) itemView.findViewById(R.id.animal_layout);
    }

    public void bind(Animal anAnimal) {
        animalName.setText(anAnimal.getName());
    }
}
