package com.thecodesmith.theforge.cloud

/**
 * Created by Jerry on 9/22/14.
 */
class InputAccepter {

    String flag
    String filename

    InputAccepter() {

        println 'Enter command: (e.g. -u ATestFile.txt or -d AnotherTestFile.txt)'
        println 'Hello from InputAccepter default constructor - lets hardcode in some input'

        //Check out Brian's link
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        //userCommand = br.readLine()

        //code to parse command...we'll hardcode in something for now
        this.flag = '-d'
        this.filename = 'DownloadThis.txt'
    }

}
