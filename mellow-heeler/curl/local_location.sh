#!/bin/bash
#
# Title:local_location.sh
#
# Description:write mellow heeler location datum
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"rawLocationList":[{"accuracy":1.11,"altitude":2.22,"latitude":3.33,"longitude":4.44,"timeStampMs":555,"timeStamp":"2014-04-05T03:51:17Z","locationId":"ijkl"},{"accuracy":1.11,"altitude":2.22,"latitude":3.33,"longitude":4.44,"timeStampMs":555,"timeStamp":"2014-04-05T03:51:17Z","locationId":"ijkl"}],"installationId":"abcd","sortieId":"efgh","messageVersion":1}' http://127.0.0.1:8080/ws/v1/location
#