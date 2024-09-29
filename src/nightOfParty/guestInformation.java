package nightOfParty;

//THIS IS FAIR GAME
public class guestInformation {
    private String name;
    private String mealChoice;

    public guestInformation(String name, String mealChoice){
        this.name = name;
        this.mealChoice = mealChoice;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getMealChoice(){
        return this.mealChoice;
    }
    public void setMealChoice(String meal){
        this.mealChoice = meal;
    }
}
