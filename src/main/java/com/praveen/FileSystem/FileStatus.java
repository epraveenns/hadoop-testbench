package com.praveen.FileSystem;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

public class FileStatus
{
    public static void main(String[] args) throws IOException
    {
        String filePathOnHDFS = args[0];
        String directoryPathOnHDFS = args[1];
        FileSystem fs = FileSystem.get(URI.create(filePathOnHDFS), new Configuration());

        org.apache.hadoop.fs.FileStatus fileStatus = fs.getFileStatus(new Path(filePathOnHDFS));

        System.out.println("Path of the file "+fileStatus.getPath());
        System.out.println("Permission of the file "+fileStatus.getPermission());
        System.out.println("Length of the file "+fileStatus.getLen());

        org.apache.hadoop.fs.FileStatus dirStatus = fs.getFileStatus(new Path(directoryPathOnHDFS));

        System.out.println("Path of the directory "+dirStatus.getPath());
        System.out.println("Permission of the directory "+dirStatus.getPermission());
        System.out.println("Length of the directory "+dirStatus.getLen());
    }
}
