package auction.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = { "sold", "bids" })
public class AuctionItem extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int minBidPrice;

    @Column(nullable = false)
    private int minBuyoutPrice;

    private boolean sold;

    @OneToMany(mappedBy = "auctionItem", fetch = FetchType.EAGER)
    private Set<Bid> bids = new HashSet<>();

}
