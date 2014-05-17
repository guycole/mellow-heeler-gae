#!/bin/bash
#
# Title:local_score.sh
#
# Description:write game score report
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Shasta Traction, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"applicationName":"arg1","installationId":"arg2","userName":"arg3","version":666, "score":321}' http://127.0.0.1:8080/ws/v1/gameScore
#
