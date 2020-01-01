package com.praveen.wordcount;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

//This program can be run with any text file as input data
public class WordCount {
    public static void main(String[] args) throws Exception
    {
        Job job = new Job();
        job.setJarByClass(WordCount.class);
        job.setJobName("Word Count");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    public static class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>
    {
        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] arr = value.toString().split(",");
            for(String s : arr)
            {
                context.write(new Text(s), new IntWritable(1));
            }
        }
    }

    public static class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>
    {
        @Override
        public void reduce(Text key, Iterable<IntWritable> values, Context context)  throws IOException, InterruptedException
        {
            int count=0;
            for(IntWritable value : values)
            {
                count++;
            }
            context.write(key, new IntWritable(count));
        }
    }
}