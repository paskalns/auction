package auction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionItem that = (AuctionItem) o;
        return minBidPrice == that.minBidPrice &&
                minBuyoutPrice == that.minBuyoutPrice &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, minBidPrice, minBuyoutPrice);
    }

}
