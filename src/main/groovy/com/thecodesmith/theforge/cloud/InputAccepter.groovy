package com.thecodesmith.theforge.cloud

/**
 * Created by Jerry on 9/22/14.
 */
class InputAccepter {

    String flag
    String filename

    InputAccepter() {

        println 'Enter command: (e.g. -u test.txt or -d downloadthis.txt)'
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        String[] userCommand = br.readLine().split(" ")
        flag = userCommand[0]
        filename = userCommand[1]
    }

}
