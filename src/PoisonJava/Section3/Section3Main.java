package PoisonJava.Section3;

public class Section3Main {
    public static void main(String[] args) {
        MyEngine engine1 = new MyEngine("직렬 3기통 엔진", "80마력");
        MyCar car1 = new MyCar("모닝",engine1);
        MyEngine engine2 = new MyEngine( "직렬 4기통 엔진", "95마력");
        MyCar car2 = new MyCar("프라이드",engine2);

        //얕은복사를 실험하는 자동차 -> 생성자에서 아무 값도 넣지 않았지만, 콘솔창에 출력되는 내용은 car1객체 내용이 출력되어야함
        MyCar CopyCar1 = new MyCar("복사 자동차1");
        System.out.println("-------------------------------얕은 복사 전 자동차-------------------------------");
        System.out.println(CopyCar1.toString());
        CopyCar1.shallowCopy(car1);
        System.out.println("-------------------------------얕은 복사 후 자동차-------------------------------");
        System.out.println(CopyCar1.toString());
        //얕은 복사가 되었는지 엔진을 바꿔서 확인해본다.
        engine1.changeEngine("바뀐 직렬 3기통 엔진","바뀐 80마력");
        System.out.println("-------------------------------바꾼 후 원본 자동차-------------------------------");
        System.out.println(car1.toString());
        System.out.println("-------------------------------바꾼 후 복사본 자동차-------------------------------");
        System.out.println(CopyCar1.toString());

        //깊은 복사를 실험하는 자동차 -> 생성자에서 아무값도 넣지 않았지만, 콘솔창에 출력되는 내용은 car2객체 내용이 출력되어야함
        MyCar CopyCar2 = new MyCar("복사 자동차2");
        System.out.println("-------------------------------깊은 복사 전 자동차-------------------------------");
        System.out.println(CopyCar2);
        CopyCar2.DeepCopy(car2);
        System.out.println("-------------------------------깊은 복사 후 자동차-------------------------------");
        System.out.println(CopyCar2.toString());
        //깊은 복사가 되었는지 엔진을 바꿔서 확인해본다.
        engine2.changeEngine("바뀐 직렬 4기통 엔진","바뀐 95마력");
        System.out.println("-------------------------------바꾼 후 원본 자동차-------------------------------");
        System.out.println(car2.toString());
        System.out.println("-------------------------------바꾼 후 복사본 자동차-------------------------------");
        System.out.println(CopyCar2.toString());

    }
}
