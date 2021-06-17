package models;

public interface HumansAction {

    boolean breakInRoom(Location location);

    boolean pullPeople(Human human);

    boolean blockPath(Human blockedHuman);

    boolean generateSound(Sound sound);
}
