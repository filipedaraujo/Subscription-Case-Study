package subscriptionservice.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import subscriptionservice.springframework.models.Subscription;
import subscriptionservice.springframework.services.SubscriptionService;


@RestController
@RequestMapping("subscription")
@Api(value="subscriptionservice", description="Subscription Service")
public class SubscriptionController {
	
	@Autowired
    private SubscriptionService subscriptionService;

    @ApiOperation(value = "View a list of available subscriptions",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Subscription> list(Model model){
        return subscriptionService.listAllSubscriptions();
    }
    @ApiOperation(value = "Search a subscrition with an ID",response = Subscription.class)
    @RequestMapping(value = "/show/{subscriptionId}", method= RequestMethod.GET, produces = "application/json")
    public Subscription showSubscription(@PathVariable Integer subscriptionId, Model model){
       return subscriptionService.getSubscriptionById(subscriptionId);
    }

    @ApiOperation(value = "Register Subscription")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> saveSubscription(@RequestBody Subscription subscription){
    	subscriptionService.saveSubscription(subscription);
        return new ResponseEntity<String>("Subscription saved successfully", HttpStatus.OK);
    }

}
