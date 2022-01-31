package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    /*
        Only the place the bid if the bid is >= reserve price
     */
    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;

        // Only bid if the reserve price is met
        if (offeredBid.getBidAmount() >= reservePrice) {
            // super.placeBid() calls the version of the placeBid
            // method on the Auction super class
            super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }

    public int getReservePrice() {
        return this.reservePrice;
    }
}
