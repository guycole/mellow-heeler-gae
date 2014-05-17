#!/bin/bash
#
# Title:local_observation.sh
#
# Description:write mellow heeler observation datum
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"rawObservationList":[{"ssid":"abcd","bssid":"efgh","capability":"ijkl","frequency":1234,"strength":5678,"timeStampMs":555,"timeStamp":"2014-04-05T03:51:17Z","locationId":"mnop"}],"installationId":"abcd","sortieId":"efgh","messageVersion":1}' http://127.0.0.1:8080/ws/v1/observation
#