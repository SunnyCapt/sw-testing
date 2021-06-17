package models;

import lombok.Data;

@Data
public class Student extends Human {
    private String university = "Круксванский";
    private Location newLocation = null;

    public Student(String name, Clothes clothes, String mood, Sound sound) {
        super(name, clothes, mood, sound);
    }

    @Override
    public boolean breakInRoom(Location location) {
        System.out.printf("Студент в одежде %s врывается %s\n", super.getClothes().toString(), location.toString());
        this.newLocation = location;
        return true;
    }

    @Override
    public boolean pullPeople(Human human) {
        if (newLocation != null) {
            System.out.printf("Студент толкает %s\n", human,toString());
            return true;
        } else {
            System.out.println("Студенту некого толкать\n");
            return false;
        }
    }

    @Override
    public boolean generateSound(Sound sound) {
        System.out.printf("Студент издаёт звук %s\n", sound.getSoundName());
        return true;
    }

    @Override
    public String toString() {
        return "студент";
    }
}
