package auction.service;

import auction.dto.AuctionItemDTO;
import auction.model.AuctionItem;

import java.util.List;

public interface AuctionItemService {

    List<AuctionItemDTO> findAll();

    AuctionItemDTO save(AuctionItemDTO auctionItemDTO);

    AuctionItem findOne(long id);

    List<AuctionItemDTO> getAuctionItemsByJbmg(int jmbg);

    AuctionItem getAuctionItemByName(String name);

    void delete(Long id);

}
