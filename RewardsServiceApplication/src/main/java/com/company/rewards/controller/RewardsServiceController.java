package com.company.rewards.controller;

import com.company.rewards.dto.ServiceResponse;
import com.company.rewards.exception.MissingDataException;
import com.company.rewards.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.rewards.dto.RewardsDTO;
import com.company.rewards.service.RewardsServiceIF;

@RestController
@RequestMapping("/rewards-service/v1")
public class RewardsServiceController {
    @Autowired
    RewardsServiceIF rewardsService;

    @GetMapping(value = "/get-reward-info",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse> getRewardsByCustomerId(@RequestParam ("custId") Long custId){
        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            RewardsDTO  customerRewards = rewardsService.getRewardsByCustomerId(custId);
            serviceResponse.setRewards(customerRewards);
            serviceResponse.setErrorMessage("success");
        }catch (MissingDataException e) {
            serviceResponse.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(serviceResponse,HttpStatus.BAD_REQUEST);
        }catch(NoDataFoundException e) {
            serviceResponse.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(serviceResponse,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
    }

}
