package com.digiburo.mellow.heeler.ws;

import com.digiburo.mellow.heeler.datastore.dao.ReceiptDao;
import com.digiburo.mellow.heeler.json.AuthorizeRequest1;
import com.digiburo.mellow.heeler.json.AuthorizeResponse1;
import com.digiburo.mellow.heeler.utility.BadGuyException;

import java.util.logging.Logger;

/**
 * Created by gsc on 6/5/14.
 */
public class AuthorizeHelper extends AbstractHelper {
  private final Logger logger = Logger.getLogger(getClass().getName());

  public AuthorizeResponse1 handler(final String ipAddress, final String selfUrl, final AuthorizeRequest1 request) {
    if (!authorizationTest(request.getInstallationId())) {
      logger.info("authorization failure");
      return authorizationFailure(ipAddress, selfUrl, request);
    }

    return successResponse(ipAddress, selfUrl, request);
  }

  private AuthorizeResponse1 authorizationFailure(final String ipAddress, final String selfUrl, final AuthorizeRequest1 request) {
    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(ipAddress, request.getInstallationId(), "authorize", "authorize failure");

    AuthorizeResponse1 response = new AuthorizeResponse1();
    response.setRemoteIpAddress(ipAddress);
    response.setReceipt(receipt);
    response.setStatus(AUTH_FAIL);

    AuthorizeResponse1.Self self = new AuthorizeResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }

  private AuthorizeResponse1 successResponse(final String ipAddress, final String selfUrl, final AuthorizeRequest1 request) {
    ReceiptDao receiptDao = new ReceiptDao();
    String receipt = receiptDao.generateReceipt(ipAddress, request.getInstallationId(), "authorize", "authorize success");

    AuthorizeResponse1 response = new AuthorizeResponse1();
    response.setRemoteIpAddress(ipAddress);
    response.setReceipt(receipt);
    response.setStatus(OK);

    AuthorizeResponse1.Self self = new AuthorizeResponse1.Self();
    self.setHref(selfUrl);
    response.getLinks().setSelf(self);

    return response;
  }
}
