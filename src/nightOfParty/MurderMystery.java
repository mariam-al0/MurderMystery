package nightOfParty;
import dataStructures.LinkedListNode;

import java.util.ArrayList;
import java.util.HashMap;

public class MurderMystery {
    //THIS IS FAIR GAME

    private LinkedListNode<GuestInformation> guestList;

    private HashMap<String, Integer> food;

    private ArrayList<String> guestsNotConfirmed;

    public LinkedListNode<GuestInformation> getGuestList() {
        return this.guestList;
    }

    public HashMap<String, Integer> getFood() {
        return this.food;
    }

    public ArrayList<String> guestsNotConfirmed() {
        return this.guestsNotConfirmed;
    }


    public MurderMystery(LinkedListNode<GuestInformation> guestList, HashMap<String,Integer> food, ArrayList<String> guestsNotConfirmed){
        this.guestList = guestList;
        this.food = food;
        this.guestsNotConfirmed = guestsNotConfirmed;
    }

    public void addGuest(GuestInformation guest) {
        if (this.guestList.getValue() == null) {
            this.guestList = null;
        } else {
            this.addGuestHelper(this.guestList, guest);
        }
    }

    public void addGuestHelper(LinkedListNode<GuestInformation> guest, GuestInformation newGuest) {
        if (guest.getNext() == null) {
            guest.setNext(new dataStructures.LinkedListNode<>(newGuest,null)) ;
        } else {
            this.addGuestHelper(guest.getNext(),newGuest);
        }
    }

    public HashMap<String, Integer> groceryList(LinkedListNode<GuestInformation> guest) {
        while (guest != null) {
            String guestMeal = guest.getValue().getMealChoice();
            if (this.food.containsKey(guestMeal)) {
                this.food.put(guestMeal, this.food.get(guestMeal) + 1);
            } else {
                this.food.put(guestMeal, 1);
            }
        }
        return this.food;
    }

    public void guestsToCall(ArrayList<String> listOfGuests){
        ArrayList<String> guestsComing = new ArrayList<>();
        LinkedListNode<GuestInformation> guest = this.guestList;

        while(guest.getValue()!=null){
            guestsComing.add(guest.getValue().getName());
            guest = guest.getNext();
        }

        for (int i = 0; i <= guestsComing.size(); i++) {
            String person = guestsComing.get(i);
            if(!listOfGuests.contains(person)){
                this.guestsNotConfirmed.add(person);
            }
        }

    }

}