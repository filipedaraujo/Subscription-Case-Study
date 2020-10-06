package subscriptionservice.springframework.services;

import subscriptionservice.springframework.domain.Subscription;
import subscriptionservice.springframework.repositories.SubscriptionRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class SubscriptionServiceImplMockTest {

    private SubscriptionServiceImpl subscriptionServiceImpl;
    @Mock
    private SubscriptionRepository subscriptionRepository;
    @Mock
    private Subscription subscription;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        subscriptionServiceImpl=new SubscriptionServiceImpl();
        subscriptionServiceImpl.setSubscriptionRepository(subscriptionRepository);
    }
    @Test
    public void shouldReturnSubscription_whenGetSubscriptionByIdIsCalled() throws Exception {
        // Arrange
        when(subscriptionRepository.findById(5)).thenReturn(Optional.of(subscription));
        // Act
        Subscription retrievedSubscription = subscriptionServiceImpl.getSubscriptionById(5);
        // Assert
        assertThat(retrievedSubscription, is(equalTo(subscription)));

    }
    @Test
    public void shouldReturnSubscription_whenSaveSubscriptionIsCalled() throws Exception {
        // Arrange
        when(subscriptionRepository.save(subscription)).thenReturn(subscription);
        // Act
        Subscription savedSubscription = subscriptionServiceImpl.saveSubscription(subscription);
        // Assert
        assertThat(savedSubscription, is(equalTo(subscription)));
    }
    
}