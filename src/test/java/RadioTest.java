import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void testNextStationCycle() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        for (int i = 0; i < 10; i++) {
            radio.next();
        }
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationCycle() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testSetStationDirectly() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        assertEquals(50, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        assertEquals(50, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void testVolumeLimits() {
        Radio radio = new Radio();
        while(radio.getCurrentVolume() < 100) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());

        while(radio.getCurrentVolume() > 0) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testInvalidStationNumber() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }
}