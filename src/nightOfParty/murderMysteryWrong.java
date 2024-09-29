package nightOfParty;

import dataStructures.LinkedListNode;

import java.util.ArrayList;
import java.util.HashMap;

public class murderMysteryWrong {
    private LinkedListNode<guestInformation> guestList;

    private HashMap<String, Integer> food;

    private ArrayList<String> guestsNotConfirmed;

    public murderMysteryWrong(LinkedListNode<guestInformation> guestList, HashMap<String,Integer> food, ArrayList<String> guestsNotConfirmed){
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

    public void addGuest(guestInformation guest) {
        if (this.guestList.getValue() == null) {
            //NOT HOW YOU MAKE AN EMPTY LINKED LIST
            this.guestList = null;
        } else {
            this.addGuestHelper(this.guestList, guest);
        }
    }

    public void addGuestHelper(LinkedListNode<guestInformation> guest, guestInformation newGuest) {
        if (guest.getNext() == null) {
            guest.setNext(new dataStructures.LinkedListNode<>(newGuest,null)) ;
        } else {
            this.addGuestHelper(guest.getNext(),newGuest);
        }
    }

    public HashMap<String, Integer> groceryList(LinkedListNode<guestInformation> guest) {
        while (guest != null) {
            String guestMeal = guest.getValue().getMealChoice();
            if (this.food.containsKey(guestMeal)) {
                this.food.put(guestMeal, this.food.get(guestMeal) + 1);
            } else {
                this.food.put(guestMeal, 1);
            }
            // NEVER MOVES TO NEXT GUEST
        }
        return this.food;
    }

    public void guestsToCall(ArrayList<String> listOfGuests){
        ArrayList<String> guestsComing = new ArrayList<>();
        LinkedListNode<guestInformation> guest = this.guestList;

        //NULL POINTER EXCEPTION
        while(guest.getValue()!=null){
            guestsComing.add(guest.getValue().getName());
            guest = guest.getNext();
        }

        //LESS THAN OR EQUAL TO NOT JUST LESS THAN
        for (int i = 0; i <= guestsComing.size(); i++) {
            String person = guestsComing.get(i);
            if(!listOfGuests.contains(person)){
                this.guestsNotConfirmed.add(person);
            }
        }

    }

}
