public class Circle extends Shape {
    private double radius;


    public Circle(String color, double radius) {
        super(color);
        this.radius=radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double CircleArea(){
        return this.getRadius()*this.getRadius()* Math.PI;
    }

    public double CircleCircum(){
        return this.getRadius()*2*Math.PI;
    }

    public void circlePrint(Circle circle){
        System.out.println("원: "+"색 = "+circle.getColor()+", 반지름 = "+circle.getRadius());
        System.out.println("면적: "+circle.CircleArea());
        System.out.println("둘레: "+circle.CircleCircum());
    }
}
