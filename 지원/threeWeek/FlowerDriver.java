package 지원.threeWeek;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlowerDriver {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Flower flower=new Flower();

        System.out.println("좋아하는 꽃을 입력하세요: ");
        String favoritFlower=scanner.nextLine();

        try {
            FlowerShop flowerShop=flower.findFlowerName(favoritFlower);

            if(flowerShop!=null){
                System.out.println("원하는 송이 수를 입력하세요: ");
                int quantity= scanner.nextInt();
                int totalPrice= flowerShop.calTotalPrice(quantity);
                System.out.println("가격이 "+flowerShop.getPrice()+"인 "+flowerShop.getFlowername()+" " +quantity+"송이의 가격 = "+totalPrice);
            }else {
                System.out.println("좋아하는 꽃이 없습니다.");
            }
        }catch (InputMismatchException e){//정수가 아닌 값을 입력할 경우
            System.out.println("송이 수가 숫자가 아니다.");
        }catch (IllegalAccessException e){// 클래스나 멤버에 접근할 권한이 없을 경우
            System.out.println(e.getMessage());
        }
    }
}
