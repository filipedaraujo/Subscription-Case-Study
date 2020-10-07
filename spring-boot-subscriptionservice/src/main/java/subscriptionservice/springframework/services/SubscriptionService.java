package subscriptionservice.springframework.services;

import subscriptionservice.springframework.models.Subscription;

public interface SubscriptionService {
    
	public Iterable<Subscription> listAllSubscriptions();

    public Subscription getSubscriptionById(Integer subscriptionId);

    public Subscription saveSubscription(Subscription subscription);

}
