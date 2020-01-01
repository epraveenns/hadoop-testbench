package com.praveen.FileSystem;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class Cat
{
    public static void main(String[] args) throws IOException
    {
        Configuration conf = new Configuration();
        String uri = args[0];
        FileSystem fileSystem = FileSystem.get(URI.create(uri), conf);
        try(InputStream in = fileSystem.open(new Path(uri)))
        {
            IOUtils.copyBytes(in, System.out, 4096, false);
        }
    }

}
