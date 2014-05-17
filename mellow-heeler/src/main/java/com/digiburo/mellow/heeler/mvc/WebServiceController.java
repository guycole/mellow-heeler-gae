package com.shastrax.jaded.nomad.mvc;

import com.shastrax.jaded.nomad.model.GameScoreRequest;
import com.shastrax.jaded.nomad.model.GameScoreResponse;
import com.shastrax.jaded.nomad.model.GcmRegisterRequest;
import com.shastrax.jaded.nomad.model.GcmRegisterResponse;
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
   * POST a new score
   * @param request
   * @param gameScore
   * @return
   */
  @RequestMapping(value = "/gameScore", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public GameScoreResponse newScore(HttpServletRequest request, @RequestBody GameScoreRequest gameScore) {
    logger.info("newScore:" + gameScore.getApplicationName() + ":" + gameScore.getUserName() + ":" + gameScore.getInstallationId());
    System.out.println("appName:" + gameScore.getApplicationName());
    System.out.println("installId:" + gameScore.getInstallationId());
    System.out.println("score:" + gameScore.getScore());
    System.out.println("userName:" + gameScore.getUserName());
    System.out.println("requestAddr:" + request.getRemoteAddr());
    //TODO test legal appName
    System.out.println(request.getRequestURL().toString() + "?" + request.getQueryString());

    GameScoreResponse response = new GameScoreResponse();
    response.setReceipt(new UUID());
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setStatus("OK");

    GameScoreResponse.Self self = new GameScoreResponse.Self();
    self.setHref(request.getRequestURL().toString());
    response.getLinks().setSelf(self);

    return response;
  }

  /**
   * POST a new Google Cloud Message registration
   * @param request
   * @param gcmRequest
   * @return
   */
  @RequestMapping(value = "/gcmRegister", method = RequestMethod.POST, headers = {"content-type=application/json"})
  @ResponseBody
  public GcmRegisterResponse newScore(HttpServletRequest request, @RequestBody GcmRegisterRequest gcmRequest) {
    logger.info("gcmRegister:" + gcmRequest.getApplicationName() + ":" + gcmRequest.getInstallationId());
    System.out.println("appName:" + gcmRequest.getApplicationName());
    System.out.println("installId:" + gcmRequest.getInstallationId());
    System.out.println("gcmId:" + gcmRequest.getCloudMessageId());
    System.out.println("requestAddr:" + request.getRemoteAddr());

    GcmRegisterResponse response = new GcmRegisterResponse();
    response.setReceipt(new UUID());
    response.setRemoteIpAddress(request.getRemoteAddr());
    response.setStatus("OK");

    GcmRegisterResponse.Self self = new GcmRegisterResponse.Self();
    self.setHref(request.getRequestURL().toString());
    response.getLinks().setSelf(self);

    return response;
  }
}