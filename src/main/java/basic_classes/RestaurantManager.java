package basic_classes;

import java.util.ArrayList;

public class RestaurantManager {
    private ArrayList<Restaurant> restaurants;
    private ArrayList<Food> foods;
    private ArrayList<String> res_categories;
    // private ArrayList<String> food_categories;

    public RestaurantManager() {
        restaurants = new ArrayList<Restaurant>();
        foods = new ArrayList<Food>();
        res_categories = new ArrayList<String>();
        // food_categories = new ArrayList<String>();
    }
    int search_res_id(int id) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    int search_res_name(String name) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    ArrayList<Food> getFoods()
    {
        return foods;
    }
    void print_res_name(int index) {
        restaurants.get(index).show();
    }
    void add_restaurant(Restaurant res) {
        for(int i=0;i<restaurants.size();i++)
        {
            if(restaurants.get(i).getName().equalsIgnoreCase(res.getName())||restaurants.get(i).getId()==res.getId())
            {
                System.out.println("Restaurant already exists");
                return;
            }
        }
        restaurants.add(res);
        for(int i=0;i<res.getCategories().size();i++)
        {
            Boolean flag=false;
            for(int j=0;j<res_categories.size();j++)
            {
                if(res.getCategories().get(i).equalsIgnoreCase(res_categories.get(j)))
                {
                    flag=true;
                    break;
                }
            }
            if(flag==false)
            {
                res_categories.add(res.getCategories().get(i));
            }
        }
    }
    ArrayList<Integer> search_res_category(String category)
    {
        ArrayList<Integer> res_id = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            for(int j=0;j<restaurants.get(i).getCategories().size();j++)
            {
                if(restaurants.get(i).getCategories().get(j).equalsIgnoreCase(category))
                {
                    res_id.add(i);
                    break;
                }
            }
        }
        return res_id;
    }
    ArrayList<Integer> search_res_score(double lower, double upper) {
        ArrayList<Integer> res_id = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getScore() >= lower && restaurants.get(i).getScore() <= upper) {
                res_id.add(i);
            }
        }
        return res_id;
    }
    ArrayList<Integer> search_res_price(String price){
        ArrayList<Integer> res_id = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getPrice().equals(price)) {
                res_id.add(i);
            }
        }
        return res_id;
    }
    ArrayList<Integer> search_res_zipcode(int zipcode){
        ArrayList<Integer> res_id = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getZipcode()==zipcode) {
                res_id.add(i);
            }
        }
        return res_id;
    }
    ArrayList<Integer> search_food_name(String name) {
        ArrayList<Integer> food_id = new ArrayList<>();
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getName().equalsIgnoreCase(name)) {
                food_id.add(i);
            }
        }
        return food_id;
    }
    ArrayList<Integer> search_food_name_res(String food,String restaurant) {
        ArrayList<Integer> food_id = new ArrayList<>();
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getName().equalsIgnoreCase(food)) {
                for(int j=0;j<restaurants.size();j++)
                {
                    if(restaurants.get(j).getName().equalsIgnoreCase(restaurant))
                    {
                        if(foods.get(i).getRes_id()==restaurants.get(j).getId())
                        {
                            food_id.add(i);
                        }
                    }
                }
            }
        }
        return food_id;
    }
    void print_food_name(int index) {
        foods.get(index).show_search_name();;
    }
    ArrayList<Integer> search_food_category(String category) {
        ArrayList<Integer> food_id = new ArrayList<>();
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getCategory().equalsIgnoreCase(category)) {
                food_id.add(i);
            }
        }
        return food_id;
    }
    void print_food_category(int index) {
        
        foods.get(index).show_search_category();;
    }
    ArrayList<Integer> search_food_price(double lower,double upper)
    {
        ArrayList<Integer> food_id = new ArrayList<>();
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getPrice() >= lower && foods.get(i).getPrice() <= upper) {
                food_id.add(i);
            }
        }
        return food_id;
    }
    ArrayList<Integer> search_food_price_res(double upper,double lower, String restaurant)
    {
        ArrayList<Integer> food_id = new ArrayList<>();
        for(int i=0;i<restaurants.size();i++)
        {
            if(restaurants.get(i).getName().equalsIgnoreCase(restaurant))
            {
                for(int j=0;j<restaurants.get(i).getFoods().size();j++)
                {
                    if(restaurants.get(i).getFoods().get(j).getPrice()>=lower&&restaurants.get(i).getFoods().get(j).getPrice()<=upper)
                    {
                        food_id.add(j);
                    }
                }
            }
        }
        return food_id;
    }
    void print_food_price(int index)
    {
        foods.get(index).show_for_price();
    }
    Food food_price_max(String restaurant)
    {
        for(int i=0;i<restaurants.size();i++)
        {
            if(restaurants.get(i).getName().equalsIgnoreCase(restaurant))
            {
                return restaurants.get(i).food_price_max();
            }
        }
        return null;
    }
    void print_res_name_only(int index) {
        System.out.print(restaurants.get(index).getName()+", ");
    }
    ArrayList<String> get_res_Categories() {
        return res_categories;
    }

    // void add_res(Restaurant res) {
    //     restaurants.add(res);
    //     Boolean flag=false;
    //     for(int i=0;i<res.getCategories().size();i++)
    //     {
    //         for(int j=0;j<res_categories.size();j++)
    //         {
    //             if(res.getCategories().get(i).equalsIgnoreCase(res_categories.get(j)))
    //             {
    //                 flag=true;
    //                 break;
    //             }
    //         }
    //         if(flag==false)
    //         {
    //             res_categories.add(res.getCategories().get(i));
    //         }
    //     }
    // }

    void add_food(Food food) {
        
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getId() == food.getRes_id()) {
                for(int j=0;j<restaurants.get(i).getFoods().size();j++)
                {
                    if(restaurants.get(i).getFoods().get(j).getName().equalsIgnoreCase(food.getName()) && restaurants.get(i).getFoods().get(j).getCategory().equalsIgnoreCase(food.getCategory()) && restaurants.get(i).getFoods().get(j).getPrice()==food.getPrice())
                    {
                        System.out.println("Food already exists");
                        return;
                    }
                }
                restaurants.get(i).add_food(food);
                foods.add(food);
                // System.out.println("food added");
            }
        }

    }

    void add_food_to_res_id(int id, Food food) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getId() == id) {
                restaurants.get(i).add_food(food);
            }
        }
    }
    
    
    
    
    
    ArrayList<Integer> search_food_category_res(String category,String restaurant) {
        ArrayList<Integer> food_id = new ArrayList<>();
        for(int i=0;i<restaurants.size();i++)
        {
            if(restaurants.get(i).getName().equalsIgnoreCase(restaurant))
            {
                for(int j=0;j<restaurants.get(i).getFoods().size();j++)
                {
                    if(restaurants.get(i).getFoods().get(j).getCategory().equalsIgnoreCase(category))
                    {
                        food_id.add(j);
                    }
                }
            }
        }
        return food_id;
    }
    ArrayList<Restaurant> getRestaurants()
    {
        return restaurants;
    }
}
