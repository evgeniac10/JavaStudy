package PoisonJava.Section3;

public class User {
    private String name;
    private Address address;

    User(String name , String address, String phone){
        this.name = name;
        this.address = new Address(address,phone);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void copy(User copiedUser){
        /*
        얕은 복사(매개변수로 받은 User의 인스턴스 주소를 현재 this객체 주소에 오버라이트
        문제점 : GC는 this 인스턴스의 address 인스턴스를 더 이상 쓰여지지 않는다고 판단하여 지워진다.
         */
        this.name = copiedUser.name;
        this.address = copiedUser.address;
    }
}
