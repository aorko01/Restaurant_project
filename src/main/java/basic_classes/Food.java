package basic_classes;

public class Food {
    private int Restaurant_id;
    private String category;
    private String name;
    private double price;

    public Food(int Restaurant_id, String name, String category, double price) {
        this.Restaurant_id = Restaurant_id;
        this.category = category;
        this.name = name;
        this.price = price;
    }
    void show_for_res()
    {
        System.out.println(name);
    }
    void show_search_name()
    {
        System.out.println("Restaurant_id: "+Restaurant_id);
        System.out.println("category: "+category);
        System.out.println("price: "+price);
    }
    int getRes_id()
    {
        return Restaurant_id;
    } 
    String getCategory()
    {
        return category;
    }
    String getName()
    {
        return name;
    }
    double getPrice()
    {
        return price;
    }
    
    void show_search_category()
    {
        System.out.println("Restaurant_id: "+Restaurant_id);
        System.out.println("name: "+name);
        System.out.println("price: "+price);
    }
    
    void show_for_price()
    {
        System.out.println("Restaurant_id: "+Restaurant_id);
        System.out.println("name: "+name);
        System.out.println("price"+price);
        System.out.println("category: "+category);
    }
}
