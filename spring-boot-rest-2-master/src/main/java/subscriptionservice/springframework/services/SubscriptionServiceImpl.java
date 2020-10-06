package subscriptionservice.springframework.services;

import subscriptionservice.springframework.domain.Subscription;
import subscriptionservice.springframework.repositories.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private SubscriptionRepository SubscriptionRepository;

    @Autowired
    public void setSubscriptionRepository(SubscriptionRepository subscriptionRepository) {
        this.SubscriptionRepository = subscriptionRepository;
    }

    @Override
    public Iterable<Subscription> listAllSubscriptions() {
        logger.debug("listAllSubscriptions called");
        return SubscriptionRepository.findAll();
    }

    @Override
    public Subscription getSubscriptionById(Integer subscriptionId) {
        logger.debug("getSubscriptionById called");
        return SubscriptionRepository.findById(subscriptionId).orElse(null);
    }

    //@Override
    public Subscription saveSubscription(Subscription subscription) {
        logger.debug("saveSubscription called");
        return SubscriptionRepository.save(subscription);
    }

  
}
