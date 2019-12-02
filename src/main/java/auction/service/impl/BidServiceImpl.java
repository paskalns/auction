package auction.service.impl;

import auction.dto.AuctionItemDTO;
import auction.dto.BidDTO;
import auction.exception.BadRequestException;
import auction.model.AuctionItem;
import auction.model.Bid;
import auction.repository.BidRepository;
import auction.service.AuctionItemService;
import auction.service.BidService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BidServiceImpl implements BidService {

    private final AuctionItemService auctionItemService;
    private final BidRepository bidRepository;
    private final ConversionService conversionService;

    @Override
    public BidDTO createBid(BidDTO bidDTO) {
        AuctionItem auctionItem = auctionItemService.findOne(bidDTO.getAuctionItemId());
        if (auctionItem.isSold()) {
            throw new BadRequestException("Item is sold!");
        }

        int currentPrice = auctionItem.getBids().stream()
                .mapToInt(Bid::getPrice)
                .max()
                .orElse(auctionItem.getMinBidPrice());

        if (currentPrice >= bidDTO.getPrice()) {
            throw new BadRequestException("Bid is to low.");
        }

        if (bidDTO.getPrice() >= auctionItem.getMinBuyoutPrice()) {
            auctionItem.setSold(true);
            auctionItemService.save(conversionService.convert(auctionItem, AuctionItemDTO.class));
        }

        Bid bid = conversionService.convert(bidDTO, Bid.class);
        bid.setAuctionItem(auctionItem);
        save(bid);

        return bidDTO;
    }

    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

}
