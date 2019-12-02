package auction.config;

import auction.converter.AuctionItemDTOToAuctionItemConverter;
import auction.converter.AuctionItemToAuctionItemDTOConverter;
import auction.converter.BidDTOToBidConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new AuctionItemToAuctionItemDTOConverter());
        registry.addConverter(new AuctionItemDTOToAuctionItemConverter());
        registry.addConverter(new BidDTOToBidConverter());
    }

}