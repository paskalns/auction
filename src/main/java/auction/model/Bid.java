package auction.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "auctionItem" })
public class Bid extends AbstractEntity {

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int jmbg;

    @ManyToOne
    private AuctionItem auctionItem;

}
