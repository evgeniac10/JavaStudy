package 지원.threeWeek;

public class FlowerShop {
    public String flowername;
    public int price;

    public FlowerShop(String flowername, int price) {
        this.flowername = flowername;
        this.price = price;
    }

    public String getFlowername() {
        return flowername;
    }

    public int getPrice() {
        return price;
    }

    public int calTotalPrice(int quantity) throws IllegalAccessException {
        if(quantity<0){//quantity가 음수일때 예외를 발생시킨다.
            throw new IllegalAccessException("송이 수가 음수라서 총 가격을 계산할 수 없다.");
        }
        return price*quantity;
    }
}





