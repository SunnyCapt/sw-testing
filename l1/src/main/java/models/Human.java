package models;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Human implements HumansAction{
    private String name;
    private Clothes clothes;
    private String mood;
    private Sound sound;

    @Override
    public boolean breakInRoom(Location location) {
        if (!location.isClosed()) {
            System.out.printf("Человек в одежде %s врывается в комнату %s\n", clothes.toString(),location.toString());
            return true;
        }
        System.out.printf("Человек в одежде%s не смог ворваться в комнату %s\n", clothes.toString(), location.getPlaceName());
        return false;
    }

    @Override
    public boolean pullPeople(Human human) {
        System.out.printf("Человек расталкивает %s\n", human.toString());
        return true;
    }

    @Override
    public boolean blockPath(Human blockedHuman) {
        System.out.println("Человек пытается блокировать путь ворвавшемуся\n");
        return false;
    }

    @Override
    public boolean generateSound(Sound sound) {
        System.out.printf("Человек издаёт %s\n", sound.toString());
        return true;
    }

    @Override
    public String toString() {
        return "человек";
    }
}
