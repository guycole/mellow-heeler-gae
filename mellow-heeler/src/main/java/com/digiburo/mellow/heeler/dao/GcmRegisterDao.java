package com.shastrax.jaded.nomad.dao;

/**
 * DAO
 */

import com.shastrax.jaded.nomad.entity.GcmRegister;

import java.util.List;

public interface GcmRegisterDao {

    /**
     * insert fresh login entry
     * @param userLog
     */
    void insert(GcmRegister gcmRegister);

    /**
     * return all rows, probably not a good idea in production
     * @return all rows
     */
    List<GcmRegister> selectAll();
}

/*
 * Copyright 2014 Shasta Traction, INC
 * Created on April 28, 2014 by gsc
 */