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
curl -v -H "Content-Type:application/json" -d '{"observationList":[{"ssid":"abcd","bssid":"efgh","capability":"ijkl","frequency":1234,"strength":5678,"timeStampMs":555,"locationId":"mnop"}],"installationId":"abcd","sortieId":"efgh","messageVersion":1}' https://mellow-heeler.appspot.com/ws/v1/observation
#
