#!/bin/bash

set -e

version=`date +%Y%m%dt%H%M%S`
echo "Version ${version}"
lein clean
rm -rf exploded
lein ring uberwar
mkdir exploded
cd exploded
unzip ../target/*.war
cd WEB-INF
perl -p -i -e "s/<version>1/<version>${version}/" appengine-web.xml
cd ../..
echo 'Run "dev_appserver.sh exploded" to start the server in dev mode'
echo 'Run "appcfg.sh update exploded" to push the changes to GAE.'
