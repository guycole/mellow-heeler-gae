package com.digiburo.mellow.heeler.mvc;

import com.digiburo.mellow.heeler.json.AuthorizeRequest1;
import com.digiburo.mellow.heeler.json.AuthorizeResponse1;
import com.digiburo.mellow.heeler.json.GeoLocationRequest1;
import com.digiburo.mellow.heeler.json.GeoLocationResponse1;
import com.digiburo.mellow.heeler.json.ObservationRequest1;
import com.digiburo.mellow.heeler.json.ObservationResponse1;

import com.digiburo.mellow.heeler.json.SortieRequest1;
import com.digiburo.mellow.heeler.json.SortieResponse1;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ws/v1")
public class WebServiceController {

  //
  private final Logger logger = Logger.getLogger(getClass().getName());

  /**
   * POST an authorization test
   * @param request
   * @param location payload
   * @return
   */
  @RequestMapping(value = "/authorize", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public AuthorizeResponse1 newAuthorize(HttpServletRequest request, @RequestBody AuthorizeRequest1 authorizeRequest) {
    logger.info("authorize:" + authorizeRequest.getInstallationId());

    if (authorizeRequest.getMessageVersion().intValue() != 1) {
      logger.warning("V1 message handler w/bad version:" + authorizeRequest.getMessageVersion());

      AuthorizeResponse1 response = new AuthorizeResponse1();
      response.setRemoteIpAddress(request.getRemoteAddr());
      response.setReceipt(UUID.randomUUID().toString());
      response.setStatus("FAIL");

      return response;
    }

    AuthorizeResponse1 response = new AuthorizeResponse1();
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setReceipt(UUID.randomUUID().toString());
    response.setStatus("OK");

    AuthorizeResponse1.Self self = new AuthorizeResponse1.Self();
    self.setHref(request.getRequestURL().toString());
    response.getLinks().setSelf(self);

    return response;
  }

  /**
   * POST a new location
   * @param request
   * @param location payload
   * @return
   */
  @RequestMapping(value = "/location", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public GeoLocationResponse1 newLocation(HttpServletRequest request, @RequestBody GeoLocationRequest1 geoLocationRequest) {
    logger.info("newLocation::" + geoLocationRequest.getInstallationId() + "::" + geoLocationRequest.getSortieId() + "::");

    //TODO test for legal installation UUID

    /*
    if (geoLocationRequest.getMessageVersion().intValue() != 1) {
      logger.warning("V1 message handler w/bad version:" + geoLocationRequest.getMessageVersion());

      GeoLocationResponse1 response = new GeoLocationResponse1();
      response.setRemoteIpAddress(request.getRemoteAddr());
      response.setReceipt(UUID.randomUUID().toString());
      response.setStatus("FAIL");

      return response;
    }
    */

    LocationHelper helper = new LocationHelper();
    int count = helper.persist(geoLocationRequest);

    logger.info("sortie count:" + count + ":" + geoLocationRequest.getLocationList().size());

//    List<RawGeographicLocation> xxx = helper.selectBySortie(geoLocationRequest.getSortieId());
//    logger.info("sortie count:" + xxx.size());

//    int count = geoLocationRequest.getLocationList().size();

    GeoLocationResponse1 response = new GeoLocationResponse1();
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setReceipt(UUID.randomUUID().toString());
    response.setStatus("OK");
    response.setSortieId(geoLocationRequest.getSortieId());
    response.setRowCount(count);

    GeoLocationResponse1.Self self = new GeoLocationResponse1.Self();
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
  public ObservationResponse1 newObservation(HttpServletRequest request, @RequestBody ObservationRequest1 observationRequest) {
    logger.info("newObservation:" + observationRequest.getInstallationId() + ":" + observationRequest.getSortieId());

    //TODO test for legal installation UUID
    //TODO test for legal message version

    ObservationHelper helper = new ObservationHelper();
    int count = helper.persist(observationRequest);

    logger.info("obs count:" + count + ":" + observationRequest.getObservationList().size());

    ObservationResponse1 response = new ObservationResponse1();
    response.setReceipt(UUID.randomUUID().toString());
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setStatus("OK");
    response.setSortieId(observationRequest.getSortieId());
    response.setRowCount(count);

    ObservationResponse1.Self self = new ObservationResponse1.Self();
    self.setHref(request.getRequestURL().toString());
    response.getLinks().setSelf(self);

    return response;
  }

  /**
   * POST a new sortie
   * @param request
   * @param sortie payload
   * @return
   */
  @RequestMapping(value = "/sortie", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public SortieResponse1 newSortie(HttpServletRequest request, @RequestBody SortieRequest1 sortieRequest) {
    logger.info("newSortie:" + sortieRequest.getInstallationId() + ":" + sortieRequest.getSortieId());

    //TODO test for legal installation UUID
    //TODO test for legal message version

    //ObservationHelper helper = new ObservationHelper();
    //int count = helper.persist(observationRequest);
    int count = 1;

    SortieResponse1 response = new SortieResponse1();
    response.setReceipt(UUID.randomUUID().toString());
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setStatus("OK");
    response.setSortieId(sortieRequest.getSortieId());
    response.setRowCount(count);

    SortieResponse1.Self self = new SortieResponse1.Self();
    self.setHref(request.getRequestURL().toString());
    response.getLinks().setSelf(self);

    return response;
  }
}

/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 17, 2014 by gsc
 */
