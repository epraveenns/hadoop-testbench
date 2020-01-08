package com.praveen.FileSystem;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class FileCopy
{
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        String localFile = args[0];
        String destination = args[1];

        InputStream in = new BufferedInputStream(new FileInputStream(localFile));
        FileSystem fs = FileSystem.get(URI.create(destination), new Configuration());
        final FSDataOutputStream out = fs.create(new Path(destination), () -> System.out.print("."));
        IOUtils.copyBytes(in, out, 4096, true);
    }
}
