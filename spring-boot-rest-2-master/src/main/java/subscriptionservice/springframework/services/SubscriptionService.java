package subscriptionservice.springframework.services;

import subscriptionservice.springframework.domain.Subscription;

public interface SubscriptionService {
    Iterable<Subscription> listAllSubscriptions();

    Subscription getSubscriptionById(Integer subscriptionId);

    Subscription saveSubscription(Subscription subscription);


}
