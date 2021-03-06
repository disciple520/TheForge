package com.thecodesmith.theforge.cloud

import com.dropbox.core.*

class DropboxCloudService implements CloudService {

    private static final String SETTINGS_FILE_NAME = 'settings.txt'
    private static final String APP_KEY            = 's566p5mmqlf5o4m'
    private static final String APP_SECRET         = 'ipz5jte5b3bar1i'

    private static def REMOTE_DIR = '/'

    def config
    def client
	def accessToken

    @Override
    void authenticate() {
        accessToken = retrieveAccessToken()
		config = new DbxRequestConfig("JavaTutorial/1.0", Locale.getDefault().toString())
		client = new DbxClient(config, accessToken)

		println "Linked account: ${client.accountInfo.displayName}"


    }

    @Override
    void upload(File file) {
        println 'Uploading ' + file.name
        def remoteFileName = REMOTE_DIR + file.name
        def inputStream = new FileInputStream(file.name)

        try {
			DbxEntry.File uploadedFile = client.uploadFile(remoteFileName, DbxWriteMode.add(), file.length(), inputStream)
			println "Upload Successful"
		} finally {
			inputStream.close()
		}

    }

    @Override
    void download(File file) {
        println 'Downloading ' + file.name
        FileOutputStream outputStream = new FileOutputStream(file.name);
        try {
            DbxEntry.File downloadedFile = client.getFile("/" + file.name, null, outputStream);
            println "Download Successful"
        } finally {
            outputStream.close();
        }
    }

    static void listFiles(){
        println 'Hello from listFiles()!'


    }

    static def retrieveAccessToken() {

        def settingsFile = new File(SETTINGS_FILE_NAME)

        if (!settingsFile.exists()) {
            authorizeAppAndStoreAccessToken()
        }

        settingsFile.text
	}

    static authorizeAppAndStoreAccessToken() {
		DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET)
		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0", Locale.getDefault().toString())
		DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo)

		String authorizeUrl = webAuth.start()
		println "1. Go to: " + authorizeUrl
		println "2. Click \"Allow\" (you might have to log in first)"
        println '3. Paste authorization code below:'

        def authorizationCode
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
		authorizationCode = br.readLine()
		
		DbxAuthFinish authFinish = webAuth.finish(authorizationCode)
		String accessToken = authFinish.accessToken

        def settingsFile = new File(SETTINGS_FILE_NAME)
        settingsFile << (accessToken)
        
	}
}
