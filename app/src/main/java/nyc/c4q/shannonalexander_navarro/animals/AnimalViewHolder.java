package nyc.c4q.shannonalexander_navarro.animals;

import android.graphics.Color;
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
    LinearLayout animalLayout;
    LinearLayout fragLayout;


    public AnimalViewHolder(View itemView) {
        super(itemView);

        animalName = (TextView) itemView.findViewById(R.id.name);
        animalLayout = (LinearLayout) itemView.findViewById(R.id.animal_layout);
        fragLayout = (LinearLayout) itemView.findViewById(R.id.frag);
    }

    public void bind(final Animal anAnimal) {
        animalName.setText(anAnimal.getName());
        animalName.setTextColor(Color.parseColor(anAnimal.getTextColor()));

        animalName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.parseColor(anAnimal.getBackground());
                AnimalFragment.fragLayout
                        .setBackgroundColor(color);

            }
        });
    }
}
