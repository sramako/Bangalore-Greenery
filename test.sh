 #!/bin/bash         

./clri.sh
echo "Hi Ako"

cd /home/hduser/wc

javac -classpath /usr/local/hadoop/share/hadoop/common/hadoop-common-2.7.2.jar:/usr/local/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.2.jar:/usr/local/hadoop/share/hadoop/common/lib/commons-cli-1.2.jar -d /home/hduser/wc/ *.java

jar -cvf color.jar -C /home/hduser/wc .

hadoop fs -put /home/hduser/wc/Input/* /Input/
#hadoop fs -put /home/hduser/wc/Input/out1.txt /Input/

cd /usr/local/hadoop

bin/hadoop jar /home/hduser/wc/color.jar color /Input Output

rm /home/hduser/wc/Download/part-00000

cd ..
hadoop fs -get Output/part-00000 /home/hduser/wc/Download/

