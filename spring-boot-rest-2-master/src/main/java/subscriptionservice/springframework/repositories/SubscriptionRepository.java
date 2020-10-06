package subscriptionservice.springframework.repositories;

import subscriptionservice.springframework.domain.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer>{


}
