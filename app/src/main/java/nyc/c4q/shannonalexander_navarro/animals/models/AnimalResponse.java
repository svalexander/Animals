package nyc.c4q.shannonalexander_navarro.animals.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shannonalexander-navarro on 12/21/16.
 */

public class AnimalResponse {

    boolean success;
    List<Animal> animals = new ArrayList<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
