package auction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bid extends AbstractEntity {

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int jmbg;

    @ManyToOne(fetch = FetchType.EAGER)
    private AuctionItem auctionItem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return price == bid.price &&
                jmbg == bid.jmbg &&
                Objects.equals(firstName, bid.firstName) &&
                Objects.equals(lastName, bid.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, firstName, lastName, jmbg);
    }
}
