#!/bin/bash         

x="$(identify -format '%w' $1)"
y="$(identify -format '%h' $1)"

tot=$x*$y

let num=$tot/10

cd Input
split --lines=$num --numeric-suffixes out.txt
rm out.txt
