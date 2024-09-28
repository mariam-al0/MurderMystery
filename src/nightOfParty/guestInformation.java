package nightOfParty;

//THIS IS FAIR GAME
public class guestInformation {
    private String name;
    private String mealChoice;

    public guestInformation(String name, String mealChoice){
        //WRONG, SHOULD BE SWITCHED
        this.name = mealChoice;
        this.mealChoice = name;
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
