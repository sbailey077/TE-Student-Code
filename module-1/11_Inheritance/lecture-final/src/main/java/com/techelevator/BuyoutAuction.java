package com.techelevator;

/*
    extends makes this class a subclass of Auction
 */
public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        /*
            super() calls the constructor of the super class, and must
            provide all the arguments for the super class's constructor.

            The call to super must be the first line in the subclasses constructor
         */
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        // if the current high bid is < buyout price
        if (getHighBid().getBidAmount() < buyoutPrice) {
            // if the offerred bid is > buyout price set it to the buyout price
            if (offeredBid.getBidAmount() >= buyoutPrice) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            /*
                Now that the buyout auction specific functionality has been
                completed, call the original Auction placeBid method to place
                the bid.
             */
            isCurrentWinningBid = super.placeBid(offeredBid);
        }

        return isCurrentWinningBid;
    }

    public int getBuyoutPrice() {
        return this.buyoutPrice;
    }

}
