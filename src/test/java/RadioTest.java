import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    private Radio radio;

    @BeforeEach
    public void setup() {
        radio = new Radio();
    }

    @Test
    public void testNextStationCycle() {
        assertEquals(0, radio.getCurrentStation());
        for (int i = 0; i < 10; i++) {
            radio.next();
        }
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationCycle() {
        assertEquals(0, radio.getCurrentStation());
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testSetStationValidNumbers() {
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetStationInvalidNumbers() {
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolumeToMax() {
        assertEquals(50, radio.getCurrentVolume());
        while (radio.getCurrentVolume() < 100) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeToMin() {
        assertEquals(50, radio.getCurrentVolume());
        while (radio.getCurrentVolume() > 0) {
            radio.decreaseVolume();
        }
        assertEquals(0, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testSetVolumeValidValues() {
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());
        radio.setCurrentVolume(100);
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testSetVolumeInvalidValues() {
        radio.setCurrentVolume(-1);
        assertEquals(50, radio.getCurrentVolume());
        radio.setCurrentVolume(101);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void testFullCoverage() {
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
        radio.prev();
        assertEquals(5, radio.getCurrentStation());

        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(50, radio.getCurrentVolume());
    }
}