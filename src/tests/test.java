package tests;

import dataStructures.LinkedListNode;
import nightOfParty.guestInformation;
import nightOfParty.murderMystery;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

import java.util.ArrayList;


public class test {
    private murderMystery party;

    @Test
    public void testAddGuest() {
        murderMystery party = new murderMystery(new LinkedListNode<>(null,null), new HashMap<>(), new ArrayList<>());

        guestInformation guest1 = new guestInformation("Jesse", "Steak");
        party.addGuest(guest1);
        LinkedListNode<guestInformation> guestList = party.getGuestList();

        assertNotNull(guestList);
        assertEquals("Jesse", guestList.getValue().getName());
        assertEquals("Steak", guestList.getValue().getMealChoice());
    }

    @Test
    public void testAppendGuest() {
        murderMystery party = new murderMystery(new LinkedListNode<>(null,null), new HashMap<>(), new ArrayList<>());

        guestInformation guest1 = new guestInformation("Jesse", "Steak");
        guestInformation guest2 = new guestInformation("Naeem", "Pasta");

        party.addGuest(guest1);
        party.addGuest(guest2);

        LinkedListNode<guestInformation> guestList = party.getGuestList();

        assertEquals("Naeem", guestList.getNext().getValue().getName());
        assertEquals("Pasta", guestList.getNext().getValue().getMealChoice());
    }

    @Test
    public void testGroceryList() {

        murderMystery party = new murderMystery(new LinkedListNode<>(null,null), new HashMap<>(), new ArrayList<>());

        guestInformation guest1 = new guestInformation("Jesse", "Steak");
        guestInformation guest2 = new guestInformation("Naeem", "Pasta");
        guestInformation guest3 = new guestInformation("Paul", "Steak");

        party.addGuest(guest1);
        party.addGuest(guest2);
        party.addGuest(guest3);

        party.groceryList(party.getGuestList());
        HashMap<String, Integer> foodMap = party.getFood();

        assertNotNull(foodMap);
        assertEquals(foodMap.get("Steak").intValue(),2);
        assertEquals(1, foodMap.get("Pasta").intValue());
    }

    @Test
    public void testGuestsToCall() {

        murderMystery party = new murderMystery(new LinkedListNode<>(null,null), new HashMap<>(), new ArrayList<>());

        guestInformation guest1 = new guestInformation("Jesse", "Steak");
        guestInformation guest2 = new guestInformation("Naeem", "Pasta");
        //Paul changed his mind, it's Paul's fault
        guestInformation guest3 = new guestInformation("Paul", "Chicken");

        party.addGuest(guest1);
        party.addGuest(guest2);
        party.addGuest(guest3);

        ArrayList<String> confirmedGuests = new ArrayList<>();
        confirmedGuests.add("Jesse");
        confirmedGuests.add("Naeem");

        party.guestsToCall(confirmedGuests);

        ArrayList<String> notConfirmed = party.guestsNotConfirmed();

        assertEquals(1, notConfirmed.size());
        assertTrue(notConfirmed.contains("Paul"));

    }
}

