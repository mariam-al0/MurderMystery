package nightOfParty;
import dataStructures.BinaryTreeNode;
import dataStructures.LinkedListNode;

import java.util.ArrayList;
import java.util.HashMap;

public class MurderMystery {
    //THIS IS FAIR GAME

    private LinkedListNode<GuestInformation> guestList;

    private HashMap<String, Integer> food;

    private ArrayList<String> guestsNotConfirmed;


    public MurderMystery(LinkedListNode<GuestInformation> guestList, HashMap<String,Integer> food, ArrayList<String> guestsNotConfirmed){
        this.guestList = guestList;
        this.food = food;
        this.guestsNotConfirmed = guestsNotConfirmed;
    }

    public LinkedListNode<GuestInformation> getGuestList() {
        return this.guestList;
    }

    public HashMap<String, Integer> getFood() {
        return this.food;
    }

    public ArrayList<String> guestsNotConfirmed() {
        return this.guestsNotConfirmed;
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

    public static void groceryListHelper(BinaryTreeNode<GuestInformation> guest, HashMap<String,Integer> map) {
        if (map.containsKey(guest.getValue().getMealChoice())) {
            map.put(guest.getValue().getMealChoice(), map.get(guest.getValue().getMealChoice()) + 1);
        } else {
            map.put(guest.getValue().getMealChoice(), 1);
        }
        if (guest.getLeft() != null) {
            groceryListHelper(guest.getLeft(),map);
        }
        if (guest.getRight() != null) {
            groceryListHelper(guest.getRight(),map);
        }
    }
    public static HashMap<String, Integer> groceryList(BinaryTreeNode<GuestInformation> guest) {
        HashMap<String,Integer> map = new HashMap<>();
        groceryListHelper(guest,map);
        return map;
    }

    public static boolean guestsToCall(LinkedListNode<GuestInformation> guests, String name){
        if(guests.getValue().getName().equals(name)){
            return true;
        }
        else{
            return false;
        }
    }
}