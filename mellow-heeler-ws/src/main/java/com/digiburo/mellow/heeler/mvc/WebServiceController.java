package com.digiburo.mellow.heeler.mvc;

import com.digiburo.mellow.heeler.entity.RawGeographicLocation;
import com.digiburo.mellow.heeler.entity.RawObservation;
import com.digiburo.mellow.heeler.json.GeoLocationRequest;
import com.digiburo.mellow.heeler.json.GeoLocationResponse;
import com.digiburo.mellow.heeler.json.ObservationRequest;
import com.digiburo.mellow.heeler.json.ObservationResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

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
  public GeoLocationResponse newLocation(HttpServletRequest request, @RequestBody GeoLocationRequest geoLocationRequest) {
    logger.info("newLocation:" + geoLocationRequest.getInstallationId() + ":" + geoLocationRequest.getSortieId());

    //TODO test for legal installation UUID

    if (geoLocationRequest.getMessageVersion().intValue() != 1) {
      logger.warning("V1 message handler w/bad version:" + geoLocationRequest.getMessageVersion());

      GeoLocationResponse response = new GeoLocationResponse();
      response.setRemoteIpAddress(request.getRemoteAddr());
      response.setReceipt(UUID.randomUUID().toString());
      response.setStatus("FAIL");

      return response;
    }

    LocationHelper helper = new LocationHelper();
    int count = helper.persist(geoLocationRequest);
//    List<RawGeographicLocation> xxx = helper.selectBySortie(geoLocationRequest.getSortieId());
//    logger.info("sortie count:" + xxx.size());

    GeoLocationResponse response = new GeoLocationResponse();
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setReceipt(UUID.randomUUID().toString());
    response.setStatus("OK");

    GeoLocationResponse.Self self = new GeoLocationResponse.Self();
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

    //TODO test for legal installation UUID
    //TODO test for legal message version

    ObservationHelper helper = new ObservationHelper();
    int count = helper.persist(observationRequest);

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
