# Hadoop Testbench

This repository is my testbench while learning Big Data using the book [Hadoop: The Definitive Guide, Fourth Edition](http://shop.oreilly.com/product/0636920033448.do) by Tom White (O'Reilly, 2014)

###Content

1) [WordCount](src/main/java/com/praveen/wordcount) contains a map reduce program to count number of times every word is repeated in the given input file. The input file can be any text file 
2) [MaxTemperature](src/main/java/com/praveen/temperature) contains a map reduce program to determine maximum temperature for every year in the input file. A sample input file can be downloaded from the hadoop book's [repository](https://github.com/tomwhite/hadoop-book/tree/master/input/ncdc/all). If you want to run your program on more data, refer to the book's [website](http://www.hadoopbook.com/code.html)  for downloading bigger input data file.
3) [Cat](src/main/java/com/praveen/FileSystem) contains simple FileSystem operation for displaying an input file data on the screen. Example usage `hadoop jar hadoop-testbench-1.0-SNAPSHOT.jar com.praveen.FileSystem.Cat /sample.txt`. Here sample.txt is the location of file on the hdfs
4) [CatSeek](src/main/java/com/praveen/FileSystem) is same as [Cat](src/main/java/com/praveen/FileSystem) but we can skip some number of characters of our choice to be displayed on the screen. Example usage `hadoop jar hadoop-testbench-1.0-SNAPSHOT.jar com.praveen.FileSystem.CatSeek /sample.txt 10`. Here sample.txt is the location of file on the hdfs and the last parameter 10 is the number of characters to skip in the beginning of the file
5) [FileCopy]((src/main/java/com/praveen/FileSystem)) will copy a file from local file system to HDFS. A progressable is passed as lambda function to create method which will print a dot during the progress. Example usage `hadoop jar hadoop-testbench-1.0-SNAPSHOT.jar com.praveen.FileSystem.FileCopy sample.txt /sample.txt`. Here first arg is the location of the local file and second arg is the location of destination in hdfs.
6) [FileStatus](src/main/java/com/praveen/FileSystem/FileStatus.java) uses FileSystem.getFileStatus method to print the information about a file and directory given as input arguments. Example usage `hadoop jar hadoop-testbench-1.0-SNAPSHOT.jar com.praveen.FileSystem.FileStatus /india_weather.csv /testbench`


 