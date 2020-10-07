package subscriptionservice.springframework.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import subscriptionservice.springframework.models.Subscription;
import subscriptionservice.springframework.models.SubscriptionRepository;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
    private SubscriptionRepository SubscriptionRepository;

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

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        logger.debug("saveSubscription called");
        return SubscriptionRepository.save(subscription);
    }

}
