package auction.repository;

import auction.model.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {

    @Query("SELECT DISTINCT i FROM AuctionItem i JOIN FETCH i.bids b WHERE b.jmbg = ?1")
    List<AuctionItem> getAuctionItemsByJmbg(int jmbg);

    AuctionItem findByName(String name);

}
