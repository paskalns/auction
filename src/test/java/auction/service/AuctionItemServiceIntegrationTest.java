package auction.service;

import auction.dto.AuctionItemDTO;
import auction.dto.BidDTO;
import auction.model.AuctionItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuctionItemServiceIntegrationTest {

    private AuctionItemService auctionItemService;
    private BidService bidService;

    @Test
    public void testSave() {
        int sizeBefore = auctionItemService.findAll().size();

        auctionItemService.save(new AuctionItemDTO
                (null, "name", 100, 150, false));
        assertEquals(sizeBefore + 1, auctionItemService.findAll().size());
    }

    @Test
    public void testGetAuctionItemsByJbmg() {
       AuctionItemDTO auctionItemDTO = auctionItemService.save(new AuctionItemDTO
                (null, "name1", 100, 150, false));
        AuctionItem auctionItem = auctionItemService.getAuctionItemByName(auctionItemDTO.getName());
        bidService.createBid(new BidDTO
                (auctionItem.getId(), 111, "name", "lastName", 456));
        bidService.createBid(new BidDTO
                (auctionItem.getId(), 112, "name", "lastName", 456));

        int itemsCount = auctionItemService.getAuctionItemsByJbmg(456).size();
        assertEquals(1, itemsCount);
    }

    @Autowired
    public void setAuctionItemService(AuctionItemService auctionItemService) {
        this.auctionItemService = auctionItemService;
    }

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

}
