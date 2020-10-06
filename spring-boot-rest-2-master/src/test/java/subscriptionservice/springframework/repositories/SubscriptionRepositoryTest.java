package subscriptionservice.springframework.repositories;

import subscriptionservice.springframework.configuration.RepositoryConfiguration;
import subscriptionservice.springframework.domain.Subscription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class SubscriptionRepositoryTest {
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    public void setSubscriptionRepository(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }
    @Test
    public void testSaveSubscription(){
        //setup subscription
        Subscription subscription = new Subscription();
        subscription.setsubscriptionId(1234);
        //save subscription, verify has ID value after save
        assertNull(subscription.getsubscriptionId()); //null before save
        subscriptionRepository.save(subscription);
        assertNotNull(subscription.getsubscriptionId()); //not null after save
        //fetch from DB
        Subscription fetchedSubscription = subscriptionRepository.findById(subscription.getsubscriptionId()).orElse(null);
        //should not be null
        assertNotNull(fetchedSubscription);
        //should equal
        assertEquals(subscription.getsubscriptionId(), fetchedSubscription.getsubscriptionId());
        
        subscriptionRepository.save(fetchedSubscription);
        //get from DB, should be updated
        Subscription fetchedUpdatedSubscription = subscriptionRepository.findById(fetchedSubscription.getsubscriptionId()).orElse(null);
        
        //verify count of subscriptions in DB
        long subscriptionCount = subscriptionRepository.count();
        assertEquals(subscriptionCount, 1);
        //get all subscriptions, list should only have one
        Iterable<Subscription> subscriptions = subscriptionRepository.findAll();
        int count = 0;
        for(Subscription p : subscriptions){
            count++;
        }
        assertEquals(count, 1);
    }
}
