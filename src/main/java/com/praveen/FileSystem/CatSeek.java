package com.praveen.FileSystem;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.net.URI;

public class CatSeek
{
    public static void main(String[] args) throws IOException
    {
        Configuration conf = new Configuration();
        String uri = args[0];
        long seekPosition = 0;
        if(args.length >= 2)
        {
            seekPosition = Long.parseLong(args[1]);
        }
        FileSystem fileSystem = FileSystem.get(URI.create(uri), conf);
        try(FSDataInputStream in = fileSystem.open(new Path(uri)))
        {
            in.seek(seekPosition);
            IOUtils.copyBytes(in, System.out, 4096, false);
        }
    }
}
