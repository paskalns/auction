package auction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDTO {

    private Long id;

    private String name;

    private int minBidPrice;

    private int minBuyoutPrice;

    private boolean sold;

}
