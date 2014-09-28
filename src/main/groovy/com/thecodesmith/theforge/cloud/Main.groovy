package com.thecodesmith.theforge.cloud

class Main {

    static void main(args) {

        


        println 'Hello from Main.groovy'
        CloudService cloudService = new DropboxCloudService()
        cloudService.authenticate()
        InputAccepter inputAccepter = new InputAccepter()
        println 'Now were in main at the spot where we start to actually do stuff'
        println 'flag: ' + inputAccepter.flag
        println 'filename:' + inputAccepter.filename
        //File file = cloudService.getFileToUpload()
        //cloudService.upload(file)
    }


}
