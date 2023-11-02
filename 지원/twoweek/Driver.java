public class Driver {
    public static void main(String[] args) {
        Circle redcircle=new Circle("빨강",2.5);
        redcircle.circlePrint(redcircle);

        Rectangle bluerect=new Rectangle("파랑", 3.0,4.0);
        bluerect.rectanglePrint(bluerect);

        Circle greencircle=new Circle("초록", 3.0);
        greencircle.circlePrint(greencircle);

    }
}
