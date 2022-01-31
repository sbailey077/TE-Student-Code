package com.techelevator;

import java.awt.desktop.PreferencesEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Bid ourBid = new Bid("Steve", 10);
        Bid secondBid = new Bid("Steve", 10);

        System.out.println(ourBid.toString());

        if (ourBid.equals(secondBid)) {
            System.out.println("The bids are the same");
        } else {
            System.out.println("The bids are not the same");
        }



        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        BuyoutAuction buyoutAuction = new BuyoutAuction("Head First Java", 25);

        buyoutAuction.placeBid(new Bid("test", 10));
        buyoutAuction.placeBid(new Bid("test2", 30));

        ReserveAuction reserveAuction = new ReserveAuction("Book", 20);
        reserveAuction.placeBid(new Bid("John", 10));
        reserveAuction.placeBid(new Bid("Rachelle", 25));

        /*
            Upcasting allows us to treat a subclass as its superclass or ANY of its ancestors
            Upcasting is implicit because any subclass IS-A any of its ancestors
            (moving up the inheritance hierarchy)

            Casting does not change the object, only our view of it and what functionality is
            available.
         */
        Auction reserveAuctionAsAuction = reserveAuction;

        /*
            Downcasting allows us to treat an object cast as its superclass or an ancestor as
            that class.   (going lower in the inheritance hierarchy).  For an object to be downcast
            it must already be able to be that data type.

            Downcasting is explict since it is possible to have an Auction that cannot be a ReserveAuction
         */
        ReserveAuction auctionCastBackToReserve = (ReserveAuction) reserveAuctionAsAuction;

        Object auctionAsObject = auctionCastBackToReserve;


        List<Auction> auctions = new ArrayList<Auction>();
        auctions.add(generalAuction);
        auctions.add(buyoutAuction);
        auctions.add(reserveAuction);

        for (Auction auction : auctions) {
            auction.placeBid(new Bid("John", 20));
        }


        /*
            BigDecimal
         */
        BigDecimal numOne = BigDecimal.ZERO;
        BigDecimal numTwo = new BigDecimal(100.25);

        BigDecimal answer = numTwo.add( new BigDecimal(10) );


    }
}
