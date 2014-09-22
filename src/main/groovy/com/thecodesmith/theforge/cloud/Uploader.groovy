package com.thecodesmith.theforge.cloud

public interface Uploader {

    void authenticate()
    File getFileToUpload()
    void upload(File file)
}