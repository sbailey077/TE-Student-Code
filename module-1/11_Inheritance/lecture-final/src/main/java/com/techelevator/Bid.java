package com.techelevator;

public class Bid {

	private String bidder;
	private int bidAmount;

	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}

	public String getBidder() {
		return bidder;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	/*
		toString() is inherited from Object and the Override
		should return the String representation of the object
	 */
	@Override
	public String toString() {
		return this.bidder + " bids $" + this.bidAmount;
	}

	@Override
	public boolean equals(Object obj) {
		Bid otherBid = (Bid) obj;
		if (this.bidder.equals(otherBid.getBidder()) &&
				this.bidAmount == otherBid.getBidAmount()) {
			return true;
		}
		return false;
	}
}
