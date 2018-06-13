 #!/bin/bash         

echo "Hi Ako"

cd /home/hduser/wc

javac -classpath /usr/local/hadoop/share/hadoop/common/hadoop-common-2.7.2.jar:/usr/local/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.2.jar:/usr/local/hadoop/share/hadoop/common/lib/commons-cli-1.2.jar -d /home/hduser/wc/ *.java

jar -cvf WordCountJ.jar -C /home/hduser/wc .

hadoop fs -put /home/hduser/Desktop/WordCountF/inp1.txt /Input/
hadoop fs -put /home/hduser/Desktop/WordCountF/inp2.txt /Input/

cd /usr/local/hadoop

bin/hadoop jar /home/hduser/wc/WordCountJ.jar WordCount /Input Output
