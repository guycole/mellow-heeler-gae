#!/bin/bash
#
# Title:local_register.sh
#
# Description:write jaded nomad google cloud registration
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Shasta Traction, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"applicationName":"arg1","installationId":"arg2","cloudMessageId":"arg3", "version":1}' http://127.0.0.1:8080/ws/gcmRegister
#