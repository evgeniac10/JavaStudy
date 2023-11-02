import java.util.Scanner;

public class Shape {
    Scanner sc=new Scanner(System.in);
    private String color;

    public Shape(String color) {
        this.color = color;

    }

    public double area(){
        return 0.0;
    }

    public double circumference(){
        return 0.0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
