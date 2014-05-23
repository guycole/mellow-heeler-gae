#!/bin/bash
#
# Title:local_authorize.sh
#
# Description:mellow heeler authorization test
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"installationId":"demoInstallation","messageVersion":1}' http://127.0.0.1:8080/ws/v1/authorize
#
