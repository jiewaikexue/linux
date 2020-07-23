#!/bin/bash
#
declare -i estab=0
declare -i listen=0
declare -i other=0
for state in $(netstat -tan | grep "^tcp\>" |awk  '{print $NF}');do 
  if [ "$state" == "ESTABLISHED" ];then
    let estab++
  elif [ "$state" == "LISTEN" ];then
    let listen++
  else 
    let other++
  fi 
done
    echo "estab : $estab"
    echo "listen : $listen"
    echo "other :$other"
