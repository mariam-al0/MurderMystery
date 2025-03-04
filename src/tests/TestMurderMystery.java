package tests;

import dataStructures.LinkedListNode;
import nightOfParty.GuestInformation;
import nightOfParty.MurderMystery;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestMurderMystery {

    //THIS CODE IS GIVEN TO YOU, THERE ARE NO ISSUES WITHIN HERE. I PROMISE. --MARIAM :}
    @Test
    public void testAddGuest() {
        MurderMystery party = new MurderMystery(new LinkedListNode<>(null,null), new HashMap<>(), new ArrayList<>());

        GuestInformation guest1 = new GuestInformation("Jesse", "Steak");
        party.addGuest(guest1);
        LinkedListNode<GuestInformation> guestList = party.getGuestList();

        assertNotNull(guestList);
        assertEquals("Jesse", guestList.getValue().getName());
        assertEquals("Steak", guestList.getValue().getMealChoice());
    }

    @Test
    public void testAppendGuest() {
        MurderMystery party = new MurderMystery(new LinkedListNode<>(null,null), new HashMap<>(), new ArrayList<>());

        GuestInformation guest1 = new GuestInformation("Jesse", "Steak");
        GuestInformation guest2 = new GuestInformation("Naeem", "Pasta");

        party.addGuest(guest1);
        party.addGuest(guest2);

        LinkedListNode<GuestInformation> guestList = party.getGuestList();

        assertEquals("Naeem", guestList.getNext().getValue().getName());
        assertEquals("Pasta", guestList.getNext().getValue().getMealChoice());
    }

    @Test
    public void testGroceryList() {

        MurderMystery party = new MurderMystery(new LinkedListNode<>(null,null), new HashMap<>(), new ArrayList<>());

        GuestInformation guest1 = new GuestInformation("Jesse", "Steak");
        GuestInformation guest2 = new GuestInformation("Naeem", "Pasta");
        GuestInformation guest3 = new GuestInformation("Paul", "Steak");

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

        MurderMystery party = new MurderMystery(new LinkedListNode<>(null,null), new HashMap<>(), new ArrayList<>());

        GuestInformation guest1 = new GuestInformation("Jesse", "Steak");
        GuestInformation guest2 = new GuestInformation("Naeem", "Pasta");
        //Paul changed his mind, it's Paul's fault
        GuestInformation guest3 = new GuestInformation("Paul", "Chicken");

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

