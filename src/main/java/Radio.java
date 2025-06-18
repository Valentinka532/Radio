public class Radio {
    private int currentStation;
    private int currentVolume;

    public Radio() {
        this.currentStation = 0;
        this.currentVolume = 50;
    }

    public void next() {
        if (this.currentStation == 9) {
            this.currentStation = 0;
        } else {
            this.currentStation++;
        }
    }

    public void prev() {
        if (this.currentStation == 0) {
            this.currentStation = 9;
        } else {
            this.currentStation--;
        }
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) {
            this.currentStation = station;
        }
    }

    public int getCurrentStation() {
        return this.currentStation;
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

    public void setCurrentVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.currentVolume = volume;
        }
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }
}