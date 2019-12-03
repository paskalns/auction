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
@AllArgsConstructor
@NoArgsConstructor
public class BidDTO {

    @NotNull
    private Long auctionItemId;

    @Min(1)
    @NotNull
    private BigDecimal price;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private int jmbg;

}
