package auction.converter;

import auction.dto.AuctionItemDTO;
import auction.model.AuctionItem;
import org.springframework.core.convert.converter.Converter;

public class AuctionItemToAuctionItemDTOConverter implements Converter<AuctionItem, AuctionItemDTO> {

    public AuctionItemDTO convert(AuctionItem auctionItem) {
        return AuctionItemDTO.builder()
                .id(auctionItem.getId())
                .name(auctionItem.getName())
                .minBidPrice(auctionItem.getMinBidPrice())
                .minBuyoutPrice(auctionItem.getMinBuyoutPrice())
                .sold(auctionItem.isSold())
                .build();
    }

}
