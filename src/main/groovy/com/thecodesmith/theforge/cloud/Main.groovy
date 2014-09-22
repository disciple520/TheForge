package com.thecodesmith.theforge.cloud

class Main {

    static void main(args) {

        println 'Running CloudManager...'

        Uploader uploader = new DropboxUploader()

        uploader.authenticate()
        File file = uploader.getFileToUpload()
        uploader.upload(file)
    }
}
