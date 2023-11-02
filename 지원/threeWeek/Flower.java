package 지원.threeWeek;

public class Flower {
    public FlowerShop[] flowers;

    public Flower(){
        flowers=new FlowerShop[]{
                new FlowerShop("수선화",2000),
                new FlowerShop("장미", 3000),
                new FlowerShop("카네이션", 5000),
                new FlowerShop("튤립",7000),
                new FlowerShop("국화",4000)
        };
    }

    public FlowerShop findFlowerName(String flowerName){
        for(FlowerShop flower: flowers){
            if(flower.getFlowername().equals(flowerName)){
                return flower;
            }
        }
        return null;
    }
}
