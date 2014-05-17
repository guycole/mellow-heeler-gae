package com.shastrax.jaded.nomad.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity Manager Factory (wrapper)
 *
 * @author gsc
 */
public final class EMF {

  private EMF() {
    //empty
  }

  public static EntityManagerFactory get() {
    return(emf);
  }

  public static String DATA_NUCLEUS_PU = "transactions-optional";

  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(DATA_NUCLEUS_PU);
}

/*
 * Copyright 2014 Shasta Traction, INC
 * Created on April 28, 2014 by gsc
 */
