/*
From https://leetcode.com/problems/design-a-food-rating-system/description/

Design a food rating system that can do the following:
  Modify the rating of a food item listed in the system.
  Return the highest-rated food item for a type of cuisine in the system.

Implement the FoodRatings class:
  FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
foods[i] is the name of the ith food,
  cuisines[i] is the type of cuisine of the ith food, and
  ratings[i] is the initial rating of the ith food.
  void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
  String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
*/

class Food implements Comparable{
    public final String food;
    public final String cuisine;
    public int rating;
    
    public Food(String food, String cuisine, int rating){
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
    
    public int compareTo(Object other){
        Food otherFood =  ((Food)other);
        int ratingDiff = this.rating -otherFood.rating;
        return ratingDiff == 0 ? otherFood.food.compareTo(this.food) : ratingDiff;
    }
}


class FoodRatings {
    
    Map<String,Food> foodMap = new HashMap<>();
    Map<String,TreeSet<Food>> cuisineToFoods = new HashMap<>();
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0;i<foods.length;i++){
            Food f = new Food(foods[i],cuisines[i],ratings[i]);
            foodMap.put(foods[i],f);
            cuisineToFoods.putIfAbsent(cuisines[i],new TreeSet<Food>());
            cuisineToFoods.get(cuisines[i]).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food currFood = foodMap.get(food);
        cuisineToFoods.get(currFood.cuisine).remove(currFood);
        currFood.rating=newRating;
        cuisineToFoods.get(currFood.cuisine).add(currFood);
        
    }
    
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).last().food;
    }
}
