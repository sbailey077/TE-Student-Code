package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false, defaultValue = "") String title_like,
                              @RequestParam(required = false, defaultValue = "0") double currentBid_lte) {

        List<Auction> filteredAuctions = new ArrayList<Auction>();

        if (title_like.length() == 0 && currentBid_lte == 0) {
            return dao.list();
        }

        if (title_like.length() > 0 && currentBid_lte > 0) {
            filteredAuctions = dao.searchByTitleAndPrice(title_like, currentBid_lte);
        } else if (title_like.length() > 0) {
            filteredAuctions = dao.searchByTitle(title_like);
        } else if (currentBid_lte > 0) {
            filteredAuctions = dao.searchByPrice(currentBid_lte);
        }

        return filteredAuctions;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable("id") int auctionId){
        return dao.get(auctionId);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction addAuction(@RequestBody Auction auction ) {
        return dao.create(auction);
    }


}
