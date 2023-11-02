public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle(String color, double width, double length) {
        super(color);
        this.width=width;
        this.length=length;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

    public double RecArea(){
        return this.length*this.width;
    }

    public double RecCircum(){
        return (this.length+this.width)*2;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;

    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void rectanglePrint(Rectangle rectangle){
        System.out.println("직사각형: "+"색 = "+rectangle.getColor()+", 가로 = "+rectangle.getWidth()+", 세로 = "+rectangle.getLength());
        System.out.println("면적: "+rectangle.RecArea());
        System.out.println("둘레: "+rectangle.RecCircum());
    }
}


