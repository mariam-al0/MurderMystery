package nightOfParty;

public class guestInformation {
    //THIS IS FAIR GAME
    private String name;
    private String mealChoice;

    public guestInformation(String name, String mealChoice){
        this.name = name;
        this.mealChoice = mealChoice;
    }

    public String getName(){
        return this.mealChoice;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getMealChoice(){
        return this.name;
    }
    public void setMealChoice(String meal){
        this.mealChoice = meal;
    }
}
