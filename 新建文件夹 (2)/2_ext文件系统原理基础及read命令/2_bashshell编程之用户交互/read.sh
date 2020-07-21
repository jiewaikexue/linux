#!/bin/bash
#查看一个磁盘下的信息
#作者：jie

read -p "请输入一个磁盘设备文件路径i:" diskpath
if [ -z $diskpath ] ;then
  echo "FOOL"
  exit 1 

fi 
if  fdisk -l |  grep "$diskpath" &> /dev/null  ;then
    fdisk -l $diskpath
else
  echo "错误"
  exit 2
fi 

