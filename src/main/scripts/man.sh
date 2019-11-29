#!/bin/bash

#java -Djava.security.auth.login.config=/etc/hbase/conf/hbase_client_jaas.conf \

#/usr/hdp/current/hadoop-client/hadoop-common.jar:\
#/usr/hdp/current/hadoop-client/hadoop-auth.jar:\

java \
-cp ".:/etc/hadoop/conf/:/etc/hbase/conf/:\
phoenix-demo-1.0-SNAPSHOT-jar-with-dependencies.jar:\
phoenix-demo-1.0-SNAPSHOT.jar" \
com.bdiiot.phoenix.demo.Main