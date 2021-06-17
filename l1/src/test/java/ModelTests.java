import models.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Model tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModelTests {
    private Student student;
    private Human randomHuman;
    private Lackey lackey;

    private Location openedRoom;
    private Location closedRoom;

    private Sound studentNotInRoomSound;
    private Sound studentInRoomSound;
    private Sound randomHumanSound;
    private Sound lackeySound;

    @BeforeEach
    void init() {
        Clothes studentClothes = new Clothes("синий", "балахон и пояс", "выцветшая");
        Clothes humanClothes = new Clothes("чёрный", "брикю и костюм", "новая");
        Clothes lackeyClothes = new Clothes("белый", "рубашка", "потёртая");

        studentNotInRoomSound = new Sound("плач");
        studentInRoomSound = new Sound("крик");
        randomHumanSound = new Sound("шёпот");
        lackeySound = new Sound("просьба покинуть помещение");

        student = new Student("Карлен", studentClothes, "сердитый", studentInRoomSound);
        randomHuman = new Human("Евгений", humanClothes, "спокойный", randomHumanSound);
        lackey = new Lackey("Эридан", lackeyClothes, "радостный", lackeySound);

        openedRoom = new Location("коворкинг", false);
        closedRoom = new Location("деканат", true);
    }

    @Test
    @DisplayName("Human can break in any open room")
    void humanBreakInOpenedRoom() {
        assertTrue(randomHuman.breakInRoom(openedRoom));
    }

    @Test
    @DisplayName("Human can't break in any closed room")
    void humanBreakInClosedRoom() {
        assertFalse(randomHuman.breakInRoom(closedRoom));
    }

    @Test
    @DisplayName("Human can pull anyone")
    void humanPullPeople() {
        boolean humanPullFootman = randomHuman.pullPeople(lackey);
        boolean humanPullStudent = randomHuman.pullPeople(student);

        boolean result = humanPullFootman && humanPullStudent;

        assertTrue(result);
    }

    @Test
    @DisplayName("Human can generate any noise")
    void humanGenerateNoise() {
        boolean randomHumanNoiseGeneration = randomHuman.generateSound(randomHumanSound);
        boolean studentNotInRoomNoiseGeneration = randomHuman.generateSound(studentNotInRoomSound);
        boolean studentInRoomNoiseGeneration = randomHuman.generateSound(studentInRoomSound);
        boolean footmanNoiseGeneration = randomHuman.generateSound(lackeySound);

        boolean result = randomHumanNoiseGeneration
                && studentInRoomNoiseGeneration
                && studentNotInRoomNoiseGeneration
                && footmanNoiseGeneration;

        assertTrue(result);
    }

    @Test
    @DisplayName("Student can break in some rooms")
    void studentPullPeople() {
        if (student.breakInRoom(closedRoom)) {
            student.generateSound(studentInRoomSound);
            student.pullPeople(lackey);
            assertFalse(randomHuman.blockPath(student));
        } else {
            student.generateSound(studentNotInRoomSound);
            student.pullPeople(randomHuman);
            assertFalse(false);
        }
    }

    @Test
    @DisplayName("Lackey can't block student")
    void lackeyCantBlockStudent() {
        assertFalse(lackey.blockPath(student));
    }

    @Test
    @DisplayName("Lackey can block anyone except student")
    void lackeyCanBlockHuman() {
        boolean blockHuman = lackey.blockPath(randomHuman);
        boolean blockFootman = lackey.blockPath(lackey);

        boolean result = blockFootman && blockHuman;

        assertTrue(result);
    }

}
