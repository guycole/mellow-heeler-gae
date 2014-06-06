package com.digiburo.mellow.heeler.datastore.dao;

import com.digiburo.mellow.heeler.datastore.entity.Receipt;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import java.util.UUID;

/**
 *  receipt DAO
 */
public class ReceiptDao extends AbstractDao {

  /**
   * persist a single entity
   * @param arg
   */
  public void save(final Receipt arg) {
    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

    Entity entity = new Entity(Receipt.ENTITY_NAME);

    entity.setProperty(Receipt.PROPERTY_IP_ADDRESS, arg.getIpAddress());
    entity.setProperty(Receipt.PROPERTY_MESSAGE_TYPE, arg.getMessageType());
    entity.setProperty(Receipt.PROPERTY_NOTE, arg.getNote());
    entity.setProperty(Receipt.PROPERTY_TIME_STAMP, arg.getTimeStamp());
    entity.setProperty(Receipt.PROPERTY_INSTALLATION_UUID, arg.getInstallationUuid());
    entity.setProperty(Receipt.PROPERTY_RECEIPT_UUID, arg.getReceiptUuid());

    datastoreService.put(entity);
  }

  /**
   *
   * @param ipAddress
   * @param installationUuid
   * @param messageType
   * @param note
   * @return receipt UUID
   */
  public String generateReceipt(final String ipAddress, final String installationUuid, final String messageType, final String note) {
    Receipt receipt = new Receipt();
    receipt.setReceiptUuid(UUID.randomUUID().toString());

    receipt.setIpAddress(ipAddress);
    receipt.setInstallationUuid(installationUuid);
    receipt.setMessageType(messageType);
    receipt.setNote(note);

    save(receipt);

    return receipt.getReceiptUuid();
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on May 25, 2014 by gsc
 */
