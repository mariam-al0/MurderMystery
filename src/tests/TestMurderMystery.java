package tests;

import dataStructures.BinaryTreeNode;
import dataStructures.LinkedListNode;
import nightOfParty.GuestInformation;
import nightOfParty.MurderMystery;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestMurderMystery {

    //THIS CODE IS GIVEN TO YOU, THERE ARE NO ISSUES WITHIN HERE. I PROMISE.
    @Test
    public void testAddGuest() {
        MurderMystery party = new MurderMystery(null, new HashMap<>(), new ArrayList<>());

        GuestInformation guest1 = new GuestInformation("Jesse", "Steak");
        party.addGuest(guest1);
        LinkedListNode<GuestInformation> guestList = party.getGuestList();

        assertNotNull(guestList);
        assertEquals("Jesse", guestList.getValue().getName());
        assertEquals("Steak", guestList.getValue().getMealChoice());
    }

    @Test
    public void testAppendGuest() {
        MurderMystery party = new MurderMystery(null, new HashMap<>(), new ArrayList<>());

        GuestInformation guest1 = new GuestInformation("Jesse", "Steak");
        GuestInformation guest2 = new GuestInformation("Gary", "Pasta");

        party.addGuest(guest1);
        party.addGuest(guest2);

        LinkedListNode<GuestInformation> guestList = party.getGuestList();

        assertNotNull(guestList);
        assertEquals("Gary", guestList.getNext().getValue().getName());
        assertEquals("Pasta", guestList.getNext().getValue().getMealChoice());
    }

    @Test
    public void testGroceryList() {

        GuestInformation guest1 = new GuestInformation("Jesse", "Steak");
        GuestInformation guest2 = new GuestInformation("Gary", "Pasta");
        GuestInformation guest3 = new GuestInformation("Paul", "Steak");

        BinaryTreeNode<GuestInformation> chefTree = new BinaryTreeNode<>(guest1,
                new BinaryTreeNode<GuestInformation>(guest2,null,null),
                new BinaryTreeNode<>(guest3,null,null));

        HashMap<String, Integer> food = MurderMystery.groceryList(chefTree);

        assertEquals(food.get("Steak"), Integer.valueOf(2));
        assertEquals(food.get("Pasta"), Integer.valueOf(1));
    }

    @Test
    public void testGuestsToCall() {
        GuestInformation guest1 = new GuestInformation("Jesse", "Steak");
        GuestInformation guest2 = new GuestInformation("Gary", "Pasta");
        GuestInformation guest3 = new GuestInformation("Paul", "Steak");
        GuestInformation guest4 = new GuestInformation("Secret Murder Guy", "Horse");

        LinkedListNode<GuestInformation> guestList = new LinkedListNode<>(guest1,
                new LinkedListNode<>(guest2, new LinkedListNode<>(guest3, new LinkedListNode<>(guest4,null))));

        assertTrue(MurderMystery.guestsToCall(guestList, "Jesse"));
        assertTrue(MurderMystery.guestsToCall(guestList, "Gary"));
        assertTrue(MurderMystery.guestsToCall(guestList, "Paul"));
        assertTrue(MurderMystery.guestsToCall(guestList, "Secret Murder Guy"));
    }
}