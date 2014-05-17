package com.shastrax.jaded.nomad.dao;

import com.shastrax.jaded.nomad.entity.GameScore;
import com.shastrax.jaded.nomad.entity.GcmRegister;

import java.util.List;

/**
 * DAO implementation
 */
public class GcmRegisterDaoImpl implements GameRegisterDao {

  /**
   * insert fresh login entry
   * @param gameScore
   */
  public void insert(GcmRegister gcmRegister) {
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    try {
      entityManager = EMF.get().createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();
      entityManager.persist(gcmRegister);
      entityTransaction.commit();
    } finally {
      if ((entityTransaction != null) && (entityTransaction.isActive())) {
        entityTransaction.rollback();
      }

      if (entityManager != null) {
        entityManager.close();
      }
    }
  }

  /**
   * return all rows, probably not a good idea in production
   * @return all rows
   */
  public List<GcmRegister> selectAll() {
    List<GcmRegister> candidates = null;

    EntityManager entityManager = EMF.get().createEntityManager();
    candidates = entityManager.createQuery("select row from GcmRegister row").getResultList();
    entityManager.close();

    return(candidates);
  }
}

/*
 * Copyright 2014 Shasta Traction, INC
 * Created on April 28, 2014 by gsc
 */
