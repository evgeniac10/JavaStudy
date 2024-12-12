package PoisonJava.Section3;

public class MyEngine {
    public String engineName;
    public String enginePower;

    public MyEngine(String engineName, String enginePower) {
        this.engineName = engineName;
        this.enginePower = enginePower;
    }

    public void changeEngine(String engineName, String enginePower) {
        this.engineName = engineName;
        this.enginePower = enginePower;
    }

    @Override
    public String toString() {
        return "MyEngine{" +
                "engineName='" + engineName + '\'' +
                ", enginePower='" + enginePower + '\'' +
                '}';
    }
}
