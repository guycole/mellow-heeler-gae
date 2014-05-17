package com.digiburo.mellow.heeler.mvc;

import com.digiburo.mellow.heeler.model.LocationRequest;
import com.digiburo.mellow.heeler.model.LocationResponse;
import com.digiburo.mellow.heeler.model.ObservationRequest;
import com.digiburo.mellow.heeler.model.ObservationResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.logging.Logger;

@Controller
@RequestMapping("/ws/v1")
public class WebServiceController {

  //
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   * POST a new location
   * @param request
   * @param location payload
   * @return
   */
  @RequestMapping(value = "/location", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public LocationResponse newLocation(HttpServletRequest request, @RequestBody LocationRequest locationRequest) {
    logger.info("newLocation:" + locationRequest.getInstallationId() + ":" + locationRequest.getSortieId());
    logger.info("newLocation:" + locationRequest.getRawLocationList().size());

    LocationResponse response = new LocationResponse();
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setReceipt(UUID.randomUUID().toString());
    response.setStatus("OK");

    LocationResponse.Self self = new LocationResponse.Self();
    self.setHref(request.getRequestURL().toString());
    response.getLinks().setSelf(self);

    return response;
  }

  /**
   * POST a new observation
   * @param request
   * @param observation payload
   * @return
   */
  @RequestMapping(value = "/observation", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public ObservationResponse newObservation(HttpServletRequest request, @RequestBody ObservationRequest observationRequest) {
    logger.info("newObservation:" + observationRequest.getInstallationId() + ":" + observationRequest.getSortieId());

    ObservationResponse response = new ObservationResponse();
    response.setReceipt(UUID.randomUUID().toString());
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setStatus("OK");

    ObservationResponse.Self self = new ObservationResponse.Self();
    self.setHref(request.getRequestURL().toString());
    response.getLinks().setSelf(self);

    return response;
  }
}

/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */
