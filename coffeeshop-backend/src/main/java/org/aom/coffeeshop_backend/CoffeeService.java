package org.aom.coffeeshop_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
class CoffeeService {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeService.class);

    private final CoffeeRepository coffeeRepository;
    private final ApplicationProperties properties;

    CoffeeService(CoffeeRepository coffeeRepository, ApplicationProperties properties) {
        this.coffeeRepository = coffeeRepository;
        this.properties = properties;
    }

    PagedResult<Coffee> getProducts(int pageNo) {
        logger.info("CoffeeService:getAllCoffeePaginated() called with pageNo: {}", pageNo);
        pageNo = pageNo <= 1 ? 0: pageNo - 1;
        Sort sort = Sort.by("code").ascending();
        Pageable pageable = PageRequest.of(pageNo, properties.pageSize(), sort);
        Page<Coffee> productsPage = coffeeRepository.findAll(pageable).map(CoffeeMapper::toProduct);
        logger.info("productsPage.getSize(): {}", productsPage.getSize());
        logger.info("productsPage.getContent().size(): {}", productsPage.getContent().size());
        return new PagedResult<>(
                productsPage.getContent(),
                productsPage.getTotalElements(),
                productsPage.getNumber() + 1,
                productsPage.getTotalPages(),
                productsPage.isFirst(),
                productsPage.isLast(),
                productsPage.hasNext(),
                productsPage.hasPrevious());
    }

    public CoffeeEntity addNewCoffee(CoffeeEntity coffee){
        logger.info("CoffeeService:addNewCoffee() called with coffee: {}", coffee);
        CoffeeEntity save = coffeeRepository.save(coffee);
        logger.info("CoffeeService:addNewCoffee() saved coffee: {}", save);
        return save;
    }

    public List<CoffeeEntity> getAllCoffee() {
        return coffeeRepository.findAll();
    }
}
