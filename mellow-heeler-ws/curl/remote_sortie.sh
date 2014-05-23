#!/bin/bash
#
# Title:remote_sortie.sh
#
# Description:write mellow heeler sortie datum
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"installationId":"abcd","sortieId":"efgh","timeStampMs":1400373877000,"messageVersion":1}' https://mellow-heeler.appspot.com/ws/v1/sortie
#
