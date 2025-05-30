public class Radio {
    private int currentStation; // Текущая радиостанция
    private int currentVolume;  // Уровень громкости

    public Radio() {
        this.currentStation = 0;
        this.currentVolume = 50; // Начальная громкость
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) { // Проверка границ канала
            this.currentStation = station;
        }
    }

    public void next() {
        this.currentStation = (this.currentStation + 1) % 10;
    }

    public void prev() {
        this.currentStation = (this.currentStation == 0) ? 9 : this.currentStation - 1;
    }

    public void increaseVolume() {
        if (this.currentVolume < 100) {
            this.currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (this.currentVolume > 0) {
            this.currentVolume--;
        }
    }

    public int getCurrentStation() {
        return this.currentStation;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }
}