package auction;

import auction.service.AuctionItemService;
import auction.service.BidService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractIntegrationTests {

    protected BidService bidService;
    protected AuctionItemService auctionItemService;
    protected TestRestTemplate restTemplate;

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @Autowired
    public void setRestTemplate(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setAuctionItemService(AuctionItemService auctionItemService) {
        this.auctionItemService = auctionItemService;
    }

}
