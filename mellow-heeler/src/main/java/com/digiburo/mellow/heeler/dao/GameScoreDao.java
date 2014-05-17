package com.shastrax.jaded.nomad.dao;

/**
 * DAO
 */

import java.util.List;

public interface GameScoreDao {

    /**
     * insert fresh login entry
     * @param userLog
     */
    void insert(GameScore gameScore);

    /**
     * return all rows, probably not a good idea in production
     * @return all rows
     */
    List<GameScore> selectAll();
}

/*
 * Copyright 2014 Shasta Traction, INC
 * Created on April 28, 2014 by gsc
 */