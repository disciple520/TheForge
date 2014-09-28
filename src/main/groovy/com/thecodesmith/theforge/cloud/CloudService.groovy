package com.thecodesmith.theforge.cloud

public interface CloudService {

    void authenticate()
    void upload(File file)
    void download(File file)

}