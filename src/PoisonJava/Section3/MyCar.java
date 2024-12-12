package PoisonJava.Section3;

/*
깊은 복사,얕은 복사,복사생성자 연습코드입니다.
 */
public class MyCar {
    private String name;
    private MyEngine engine;

    public MyCar(String name) {
        this.name = name;
    }

    public MyCar(String name, MyEngine engine) {
        this.name = name;
        this.engine = engine;
    }
    public void shallowCopy(MyCar copiedCar){
        //이 메서드를 사용하는 객체 car가 매개변수로 들어온 car를 복사 했다고 생각하겠지만
        // 이는 this가 가르키는 참조를 copiedCar주소로 방향만 옮긴것
        this.engine = copiedCar.engine;
    }
    public void DeepCopy(MyCar copiedCar){
        // if로 null체크를 할 수 밖에 없는 이유는 깊은 복사는 실제 내용 값을 복사해야하는데 engine이 null일 경우에는 engine 객체가 없으니
        // 값을 정의(초기화)할 수 조차 없어 nullPointException이 발생한다.
        if(this.engine==null){
            this.engine = new MyEngine(copiedCar.engine.engineName, copiedCar.engine.enginePower);
        }else{
        //실제로 인스턴스를 복사하는 메서드
        this.engine.enginePower = copiedCar.engine.enginePower;
        this.engine.engineName = copiedCar.engine.engineName;
        }
    }

    public void setEngine(MyEngine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "MyCar{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                '}';
    }
}
