package auction.service;

import auction.dto.BidDTO;
import auction.model.Bid;

import java.util.List;

public interface BidService {

    BidDTO createBid(BidDTO bidDTO);

    Bid save(Bid bid);

    List<Bid> findAll();

}
