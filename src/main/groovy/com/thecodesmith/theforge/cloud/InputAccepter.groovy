package com.thecodesmith.theforge.cloud

/**
 * Created by Jerry on 9/22/14.
 */
class InputAccepter {

    String flag
    String filename = ""

    InputAccepter() {

        println 'Enter command: (e.g. -u test.txt or -d downloadthis.txt or \'q\' to quit)'
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        String[] userCommand = br.readLine().split(" ")
        flag = userCommand[0]
        if (userCommand.length > 1) {
            filename = userCommand[1]
        }
    }

}
