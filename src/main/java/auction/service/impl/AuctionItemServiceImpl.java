package auction.service.impl;

import auction.dto.AuctionItemDTO;
import auction.exception.NotFoundException;
import auction.model.AuctionItem;
import auction.repository.AuctionItemRepository;
import auction.service.AuctionItemService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService {

    private final AuctionItemRepository auctionItemRepository;
    private final ConversionService conversionService;

    @Override
    public List<AuctionItemDTO> findAll() {
        return auctionItemRepository.findAll().stream()
                .map(auctionItem -> conversionService.convert(auctionItem, AuctionItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuctionItemDTO save(AuctionItemDTO auctionItemDTO) {
        return conversionService.convert(auctionItemRepository
                .save(conversionService.convert(auctionItemDTO, AuctionItem.class)), AuctionItemDTO.class);
    }

    @Override
    public AuctionItem findOne(long id) {
        return auctionItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("AuctionItem with id %s not found", id)));
    }

    @Override
    public List<AuctionItemDTO> getAuctionItemsByJbmg(int jmbg) {
        return auctionItemRepository.getAuctionItemsByJmbg(jmbg).stream()
                .map(auctionItem -> conversionService.convert(auctionItem, AuctionItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuctionItem getAuctionItemByName(String name) {
        return auctionItemRepository.findByName(name);
    }

}
