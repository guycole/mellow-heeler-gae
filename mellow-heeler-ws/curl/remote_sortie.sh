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
curl -v -H "Content-Type:application/json" -d '{"installationId":"bff5e368-5052-4c18-9727-6705a5b5d8de","sortieId":"cbc43bbb-1767-4cba-b239-cfd838c0cd1c","timeStampMs":"1401045354000","messageVersion":"1","sortieName":"Default Sortie"}' https://mellow-heeler.appspot.com/ws/v1/sortie
#
