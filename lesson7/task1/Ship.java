package homeworks.lesson7;

public class Ship implements Runnable{
    private String name;
    private int volume;
    private Port port;

    public Ship(String name, int volume, Port port) {
        this.name = name;
        this.volume = volume;
        this.port = port;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void run() {
        port.setLoad(this);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", dock=" + port +
                '}';
    }
}
