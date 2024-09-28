package nightOfParty;
import dataStructures.LinkedListNode;

import java.util.ArrayList;
import java.util.HashMap;

//THIS IS FAIR GAME
public class murderMystery {
    private LinkedListNode<guestInformation> guestList;

    private HashMap<String, Integer> food;

    private ArrayList<String> guestsNotConfirmed;

    public murderMystery(LinkedListNode<guestInformation> guestList, HashMap<String,Integer> food, ArrayList<String> guestsNotConfirmed){
        this.guestList = guestList;
        this.food = food;
        this.guestsNotConfirmed = guestsNotConfirmed;
    }

    public LinkedListNode<guestInformation> getGuestList() {
        return this.guestList;
    }

    public HashMap<String, Integer> getFood() {
        return this.food;
    }

    public ArrayList<String> guestsNotConfirmed() {
        return this.guestsNotConfirmed;
    }

    public HashMap<String, Integer> groceryList(LinkedListNode<guestInformation> guest) {
        if (this.food == null) {
            this.food = new HashMap<>();
        }

        while (guest != null) {
            String guestMeal = guest.getValue().getMealChoice();
            if (this.food.containsKey(guestMeal)) {
                this.food.put(guestMeal, this.food.get(guestMeal) + 1);
            } else {
                this.food.put(guestMeal, 1);
            }
            guest = guest.getNext();
        }

        return this.food;
    }

    public void addGuest(guestInformation guest) {
        if (this.guestList.getValue() == null) {
            this.guestList = new LinkedListNode<>(guest, null);
        } else {
            this.append(this.guestList, guest);
        }
    }

    public void append(LinkedListNode<guestInformation> guest, guestInformation newGuest) {
        if (guest.getNext() == null) {
            guest.setNext(new dataStructures.LinkedListNode<>(newGuest,null)) ;
        } else {
            this.append(guest.getNext(),newGuest);
        }
    }


    public void guestsToCall(ArrayList<String> listOfGuests){
        ArrayList<String> guestsComing = new ArrayList<>();
        LinkedListNode<guestInformation> guest = this.guestList;

        while(guest!=null){
            guestsComing.add(guest.getValue().getName());
            guest = guest.getNext();
        }

        for (int i = 0; i != guestsComing.size(); i++) {
            String person = guestsComing.get(i);
            if(!listOfGuests.contains(person)){
                this.guestsNotConfirmed.add(person);
            }
        }

    }

}