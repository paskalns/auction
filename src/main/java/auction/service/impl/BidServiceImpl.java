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
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
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

        BigDecimal currentPrice = auctionItem.getBids().stream()
                .map(Bid::getPrice)
                .max(Comparator.naturalOrder())
                .orElse(auctionItem.getMinBidPrice());

        if (currentPrice.compareTo(bidDTO.getPrice()) >= 0) {
            throw new BadRequestException("Bid is to low.");
        }

        if (bidDTO.getPrice().compareTo(auctionItem.getMinBuyoutPrice()) >= 0) {
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
