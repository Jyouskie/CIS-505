package Module_4.BowlingShopApp;

public class ProductDB {

    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> products = new GenericQueue<>();

        if (code.equalsIgnoreCase("b")) {            // bowling balls
            for (int i = 1; i <= 5; i++) {
                Ball ball = new Ball();
                ball.setCode("B" + i);
                ball.setDescription("Bowling Ball #" + i);
                ball.setPrice(100 + i * 10);
                ball.setColor(i % 2 == 0 ? "Red" : "Blue");
                products.enqueue(ball);
            }
        } else if (code.equalsIgnoreCase("a")) {     // bags
            for (int i = 1; i <= 3; i++) {
                Bag bag = new Bag();
                bag.setCode("A" + i);
                bag.setDescription("Bowling Bag #" + i);
                bag.setPrice(75 + i * 8);
                bag.setType(i + "-Ball Bag");
                products.enqueue(bag);
            }
        } else if (code.equalsIgnoreCase("s")) {     // shoes
            for (int i = 1; i <= 5; i++) {
                Shoe shoe = new Shoe();
                shoe.setCode("S" + i);
                shoe.setDescription("Bowling Shoe #" + i);
                shoe.setPrice(50 + i * 5);
                shoe.setSize(9 + i);
                products.enqueue(shoe);
            }
        }

        return products;
    }
}

