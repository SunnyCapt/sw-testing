package models;

public class Lackey extends Human{

    public Lackey(String name, Clothes clothes, String mood,Sound sound) {
        super(name, clothes, mood, sound);
    }

    @Override
    public boolean blockPath(Human blockedHuman) {
        System.out.printf("Лакей пытается заблокировать %s %s\n", blockedHuman.toString(), blockedHuman.getName());

        if (blockedHuman.toString().equals("студент")) {
            System.out.println("попытка провалена\n");
            return false;
        }

        System.out.println("Попытка завершилась успехом\n");
        return true;
    }

    @Override
    public boolean generateSound(Sound sound) {
        System.out.printf("Лакей издаёт %s\n", sound.toString());
        return true;
    }

    @Override
    public String toString() {
        return "лакей";
    }
}
