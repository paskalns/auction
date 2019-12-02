package auction.converter;

import auction.dto.AuctionItemDTO;
import auction.model.AuctionItem;
import org.springframework.core.convert.converter.Converter;

public class AuctionItemDTOToAuctionItemConverter implements Converter<AuctionItemDTO, AuctionItem> {

    public AuctionItem convert(AuctionItemDTO auctionItemDTO) {
        return AuctionItem.builder()
                .name(auctionItemDTO.getName())
                .minBidPrice(auctionItemDTO.getMinBidPrice())
                .minBuyoutPrice(auctionItemDTO.getMinBuyoutPrice())
                .build();
    }
}
