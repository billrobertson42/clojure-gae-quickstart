#!/bin/bash

set -e

lein clean
rm -rf exploded
lein ring uberwar
mkdir exploded
cd exploded
unzip ../target/*.war
cd ..
echo "Run dev_appserver.sh exploded to start the server in dev mode"
echo "Run appcfg.sh update exploded to push the changes to GAE."
