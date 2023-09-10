package basic_classes;

import java.util.ArrayList;

public class Restaurant {
    private int id;
    private String name;
    private double score;
    private String price;
    private int zipcode;
    private ArrayList<String> categories;
    private ArrayList<Food> foods;

    public Restaurant(int id, String name, double score, String price, int zipcode, ArrayList<String> categories) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.price = price;
        this.zipcode = zipcode;
        this.categories = categories;
        foods= new ArrayList<Food>();
    }
    String getName()
    {
        return name;
    }
    void show()
    {
        System.out.println("id: "+id);
        System.out.println("name: "+name);
        System.out.println("score: "+score);
        System.out.println("price: "+price);
        System.out.println("zipcode: "+zipcode);
        System.out.println("categories: ");
        for(int i=0;i<categories.size();i++)
        {
            System.out.println(categories.get(i));
        }
        System.out.println("Food List:");
        for(int i=0;i<foods.size();i++)
        {
            System.out.print(i+1+". ");
            foods.get(i).show_for_res();
        }
     
    }
    
    int getId()
    {
        return id;
    }
    
    double getScore()
    {
        return score;
    }
    String getPrice()
    {
        return price;
    }
    int getZipcode()
    {
        return zipcode;
    }
    ArrayList<String> getCategories()
    {
        return categories;
    }
    Food food_price_max()
    {
        if(foods.size()==0)
        {
            System.out.println("No food in this restaurant");
            return null;
        }
        Food max=foods.get(0);
        for(int i=1;i<foods.size();i++)
        {
            if(foods.get(i).getPrice()>max.getPrice())
            {
                max=foods.get(i);
            }
        }
        return max;
    }
    ArrayList<Food> getFoods()
    {
        return foods;
    }
    void add_food(Food food)
    {
        foods.add(food);
    }
    

}
