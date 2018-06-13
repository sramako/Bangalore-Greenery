#!/bin/bash
cd /usr/local/hadoop
hadoop fs -rm -r -skipTrash /Input
hadoop fs -rm -r -skipTrash Output
hadoop fs -mkdir /Input
