package auction.converter;

import auction.dto.BidDTO;
import auction.model.Bid;
import org.springframework.core.convert.converter.Converter;

public class BidDTOToBidConverter implements Converter<BidDTO, Bid> {

    public Bid convert(BidDTO bidDTO) {
        return Bid.builder()
                .firstName(bidDTO.getFirstName())
                .lastName(bidDTO.getLastName())
                .jmbg(bidDTO.getJmbg())
                .price(bidDTO.getPrice())
                .build();
    }

}
