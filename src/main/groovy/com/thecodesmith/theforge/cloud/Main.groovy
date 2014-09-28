package com.thecodesmith.theforge.cloud

class Main {

    static void main(args) {

            CloudService cloudService = new DropboxCloudService()
            cloudService.authenticate()
            InputAccepter inputAccepter = new InputAccepter()
            println 'flag: ' + inputAccepter.flag
            println 'filename:' + inputAccepter.filename
            def file = new File(inputAccepter.filename)
            switch (inputAccepter.flag) {
                case '-d':
                    cloudService.download(file)
                    break
                case '-u':
                    cloudService.upload(file)
                    break
                default:
                    println 'Invalid command line flag'
            }
        }
    }