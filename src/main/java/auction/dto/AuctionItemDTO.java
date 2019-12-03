package auction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuctionItemDTO {

    private Long id;

    @NotBlank(message = "Name cannot be blunk")
    private String name;

    @Min(1)
    @NotNull
    private BigDecimal minBidPrice;

    @Min(1)
    @NotNull
    private BigDecimal minBuyoutPrice;

    private boolean sold;

}
