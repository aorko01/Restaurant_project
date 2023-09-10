package basic_classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurantapp {

    private static final String FILE_NAME1 = "restaurant.txt";
    private static final String FILE_NAME2 = "menu.txt";

    public static void main(String[] args) throws Exception

    {
        RestaurantManager rm = new RestaurantManager();
//        BufferedReader br1 = new BufferedReader(new FileReader(FILE_NAME1));
//        while (true) {
//            String line = br1.readLine();
//            if (line == null)
//                break;
//            String[] array = line.split(",", -1);
//            int id = Integer.parseInt(array[0]);
//            String name = array[1];
//            double score = Double.parseDouble(array[2]);
//            String price = array[3];
//            int zipcode = Integer.parseInt(array[4]);
//            ArrayList<String> categories = new ArrayList<>();
//            for (int j = 5; j < array.length; j++) {
//                categories.add(array[j]);
//            }
//            Restaurant res = new Restaurant(id, name, score, price, zipcode, categories);
//            rm.add_restaurant(res);
//        }
//
//        br1.close();
//        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME2));
//        while (true) {
//            String line = br.readLine();
//            if (line == null)
//                break;
//            String[] array = line.split(",(?! )", -1);
//            int id = Integer.parseInt(array[0]);
//            String name = array[2];
//            String category = array[1];
//            double price = Double.parseDouble(array[3]);
//            Food food = new Food(id, name, category, price);
//            rm.add_food(food);
//        }
//        br.close();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Main Menu:");
            System.out.println("1) Search Restaurants");
            System.out.println("2) Search Food Items");
            System.out.println("3) Add Restaurant");
            System.out.println("4) Add Food Item to the Menu");
            System.out.println("5) Exit System");
            int choice;
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Restaurant Searching Options:");
                    System.out.println("1) By Name");
                    System.out.println("2) By Score");
                    System.out.println("3) By Category");
                    System.out.println("4) By Price");
                    System.out.println("5) By Zipcode");
                    System.out.println("6) Different Category Wise List of Restaurants");
                    System.out.println("7) Back to Main Menu");
                    int choice1;
                    choice1 = sc.nextInt();
                    sc.nextLine();
                    switch (choice1) {
                        case 1:
                            System.out.println("Enter the name of the restaurant:");
                            String res_name = sc.nextLine();

                            int index = rm.search_res_name(res_name);
                            if (index != -1)
                                rm.print_res_name(index);
                            else
                                System.out.println("No such restaurant with this name");
                            break;
                        case 2:
                            System.out.println("Enter the score range:");
                            double lower = sc.nextDouble();
                            double upper = sc.nextDouble();
                            sc.nextLine();
                            ArrayList<Integer> res_id = rm.search_res_score(lower, upper);
                            if (res_id.size() != 0) {
                                for (int i = 0; i < res_id.size(); i++) {
                                    rm.print_res_name(res_id.get(i));
                                }
                            } else {
                                System.out.println("No such restaurant with this score range");
                            }
                            break;

                        case 3:
                            System.out.println("Enter the category:");
                            String category = sc.nextLine();
                            ArrayList<Integer> res_id0 = rm.search_res_category(category);
                            if (res_id0.size() != 0) {
                                System.out.println("Restaurants in this category are:");
                                for (int i = 0; i < res_id0.size(); i++) {
                                    rm.print_res_name(res_id0.get(i));
                                }
                            } else
                                System.out.println("No such restaurant with this category");
                            break;
                        case 4:
                            System.out.println("Enter the price:");
                            String price = sc.nextLine();
                            ArrayList<Integer> res_id1 = rm.search_res_price(price);
                            if (res_id1.size() != 0) {
                                for (int i = 0; i < res_id1.size(); i++) {
                                    rm.print_res_name(res_id1.get(i));
                                }
                            } else
                                System.out.println("No such restaurant with this price");
                            break;
                        case 5:
                            System.out.println("Enter the zipcode:");
                            int zipcode = sc.nextInt();
                            sc.nextLine();
                            ArrayList<Integer> res_id2 = rm.search_res_zipcode(zipcode);
                            if (res_id2.size() != 0) {
                                for (int i = 0; i < res_id2.size(); i++) {
                                    rm.print_res_name(res_id2.get(i));
                                }
                            } else
                                System.out.println("No such restaurant with this zipcode");
                            break;
                        case 6:
                            ArrayList<String> categories = rm.get_res_Categories();
                            for (int i = 0; i < categories.size(); i++) {
                                System.out.println(categories.get(i) + ": ");
                                ArrayList<Integer> res_id3 = rm.search_res_category(categories.get(i));
                                for (int j = 0; j < res_id3.size(); j++) {
                                    rm.print_res_name_only(res_id3.get(j));
                                    if (j != res_id3.size() - 2)
                                        System.out.print(",");
                                }
                                System.out.println();
                            }
                            break;
                        case 7:
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Food Searching Options:");
                    System.out.println("1) By Name");
                    System.out.println("2) By Name in a Given Restaurant");
                    System.out.println("3) By Category");
                    System.out.println("4) By Category in a Given Restaurant");
                    System.out.println("5) By Price Range");
                    System.out.println("6) By Price Range in a Given Restaurant");
                    System.out.println("7) Costliest Food Item(s) on the Menu in a Given Restaurant");
                    System.out.println("8) List of Restaurants and Total Food Item on the Menu");
                    System.out.println("9) Back to Main Menu");
                    int choice2;
                    choice2 = sc.nextInt();
                    sc.nextLine();
                    switch (choice2) {
                        case 1:
                            System.out.println("Enter the name of the food item:");
                            String food_name = sc.nextLine();
                            ArrayList<Integer> food_id = rm.search_food_name(food_name);
                            if (food_id.size() != 0) {
                                System.out.println(food_name + " is available in:");
                                for (int i = 0; i < food_id.size(); i++) {
                                    rm.print_food_name(food_id.get(i));
                                }
                            } else
                                System.out.println("No such food item with this name");
                            break;
                        case 2:
                            System.out.println("Enter the food item name:");
                            String food_name1 = sc.nextLine();
                            System.out.println("Enter the restaurant name:");
                            String res_name1 = sc.nextLine();
                            ArrayList<Integer> food_id1 = rm.search_food_name_res(food_name1, res_name1);
                            if (food_id1.size() != 0) {
                                System.out.println("information about " + food_name1 + " in " + res_name1 + ":");
                                for (int i = 0; i < food_id1.size(); i++) {
                                    rm.print_food_name(food_id1.get(i));
                                }
                            } else
                                System.out.println("No such food item with this name in this restaurant");
                            break;
                        case 3:
                            System.out.println("Enter the category:");
                            String category = sc.nextLine();
                            ArrayList<Integer> food_id2 = rm.search_food_category(category);
                            if (food_id2.size() != 0) {
                                System.out.println("Food items in this category are:");
                                for (int i = 0; i < food_id2.size(); i++) {
                                    System.out.println("item " + (i + 1) + ":");
                                    rm.print_food_category(food_id2.get(i));
                                }
                            } else
                                System.out.println("No such food item with this category");
                            break;
                        case 4:
                            System.out.println("Enter the category:");
                            String category1 = sc.nextLine();
                            System.out.println("Enter the restaurant name:");
                            String res_name = sc.nextLine();
                            ArrayList<Integer> food_id4 = rm.search_food_category_res(category1, res_name);
                            if (food_id4.size() != 0) {
                                System.out.println("Food items in this category are:");
                                for (int i = 0; i < food_id4.size(); i++) {
                                    System.out.println("item " + (i + 1) + ":");
                                    rm.print_food_category(food_id4.get(i));
                                }
                            } else
                                System.out.println("No such food item with this category in this restaurant");
                            break;
                        case 5:
                            System.out.println("Enter the price range:");
                            double lower = sc.nextDouble();
                            double upper = sc.nextDouble();
                            sc.nextLine();
                            ArrayList<Integer> food_id3 = rm.search_food_price(lower, upper);
                            if (food_id3.size() != 0) {
                                System.out.println("Food items in this price range are:");
                                for (int i = 0; i < food_id3.size(); i++) {
                                    System.out.println("item " + (i + 1) + ":");
                                    rm.print_food_price(food_id3.get(i));
                                }
                            } else
                                System.out.println("No such food item with this price range");
                            break;
                        case 6:
                            System.out.println("Enter the price range:");
                            double lower1 = sc.nextDouble();
                            double upper1 = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Enter the restaurant name:");
                            String res_name3 = sc.nextLine();
                            ArrayList<Integer> food_id5 = rm.search_food_price_res(lower1, upper1, res_name3);
                            if (food_id5.size() != 0) {
                                System.out.println("Food items in this price range are:");
                                for (int i = 0; i < food_id5.size(); i++) {
                                    System.out.println("item " + (i + 1) + ":");
                                    rm.print_food_price(food_id5.get(i));
                                }
                            } else
                                System.out.println("No such food item with this price range in this restaurant");
                            break;
                        case 7:
                            System.out.println("Enter the restaurant name:");
                            String res_name2 = sc.nextLine();
                            if (rm.food_price_max(res_name2) != null) {
                                System.out.println("Costliest food item in this restaurant is:");
                                rm.food_price_max(res_name2).show_for_price();
                            } else
                                System.out.println("No such restaurant with this name");
                            break;
                        case 8:
                            for (int i = 0; i < rm.getRestaurants().size(); i++) {
                                System.out.println("Restaurant " + (i + 1) + ":");
                                rm.print_res_name(i);
                            }
                            break;
                        case 9:
                            break;
                    }
                    break;
                case 3:
                    int id, zipcode;
                    String name, price;
                    double score;
                    ArrayList<String> categories = new ArrayList<>();
                    System.out.println("Enter the id:");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the name:");
                    name = sc.nextLine();
                    System.out.println("Enter the score:");
                    score = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter the price:");
                    price = sc.nextLine();
                    System.out.println("Enter the zipcode:");
                    zipcode = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the number of categories:");
                    int n = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the categories:");
                    for (int i = 0; i < n; i++) {
                        categories.add(sc.nextLine());
                    }
                    Restaurant res = new Restaurant(id, name, score, price, zipcode, categories);
                    int res1 = rm.search_res_name(name);
                    int res2 = rm.search_res_id(id);
                    if (res1 != -1 || res2 != -1) {
                        System.out.println("Restaurant with this name or id already exists");
                        break;
                    } else {
                        rm.add_restaurant(res);
                        System.out.println("Restaurant added successfully");
                        
                    }

                    break;
                case 4:
                    int res_id;
                    String food_name, category;
                    double food_price;
                    System.out.println("Enter the restaurant id:");
                    res_id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the food name:");
                    food_name = sc.nextLine();
                    System.out.println("Enter the category:");
                    category = sc.nextLine();
                    System.out.println("Enter the price:");
                    food_price = sc.nextDouble();
                    sc.nextLine();
                    Food food = new Food(res_id, food_name, category, food_price);
                    int res_id1 = rm.search_res_id(res_id);
                    if(res_id1==-1)
                    {
                        System.out.println("No such restaurant with this id");
                        break;
                    }
                    ArrayList<Integer> food_add_check = rm.search_food_name_res(food_name,
                            rm.getRestaurants().get(res_id - 1).getName());
                    if (food_add_check.size() != 0) {
                        System.out.println("Food item with this name already exists in this restaurant");
                        break;
                    }
                    // BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME2));
                    // bw.write(food.getRes_id() + "," + food.getCategory() + "," + food.getName() +
                    // "," + food.getPrice());
                    rm.add_food(food);
                    // bw.close();
                    break;
                case 5:
//                    BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME1));
//                    for (int i = 0; i < rm.getRestaurants().size(); i++) {
//                        Restaurant res3 = rm.getRestaurants().get(i);
//                        bw.write(res3.getId() + "," + res3.getName() + "," + res3.getScore() + "," + res3.getPrice()
//                                + "," + res3.getZipcode() + ",");
//                        for (int j = 0; j < res3.getCategories().size(); j++) {
//                            bw.write(res3.getCategories().get(j));
//                            if (j != res3.getCategories().size() - 1)
//                                bw.write(",");
//                        }
//                        bw.write(System.lineSeparator());
//                    }
//                    BufferedWriter bw1 = new BufferedWriter(new FileWriter(FILE_NAME2));
//                    for (int i = 0; i < rm.getFoods().size(); i++) {
//                        Food food1 = rm.getFoods().get(i);
//                        bw1.write(food1.getRes_id() + "," + food1.getCategory() + "," + food1.getName() + ","
//                                + food1.getPrice());
//                        bw1.write(System.lineSeparator());
//                    }
//                    bw.close();
//                    bw1.close();

                        // bw.write(id + "," + name + "," + score + "," + price + "," + zipcode + ",");
                        // for (int i = 0; i < categories.size(); i++) {
                        // bw.write(categories.get(i));
                        // if (i != categories.size() - 1)
                        // bw.write(",");
                        // }
                        // bw.write(System.lineSeparator());
                        // bw.close();
                    System.exit(0);
                    sc.close();
                    break;
            }

        } while (true);

    }

}
// String text = "Hello World";
// BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
// bw.write(text);
// bw.write(System.lineSeparator());
// bw.close();