# 467-security-project

## To Run Back-End Server Locally:

1. Pull code from GitHub
2. Download Eclipse
3. Download Spring Tools from the Eclipse Marketplace
4. Go to File
   - Import
   - Maven
   - Exisiting Maven Projects
   - Browse to your local repo then click Next
5. Go to Help
   - Eclipse Marketplace
   - Search for Spring Tools 4
   - Install, click "Yes" for all agreements
   - Restart Eclipse
6. Right click unsecure 
   - Run As Spring Boot App

## To Run Front-End Angular Project Locally:

1. Make sure you have pulled code from GitHub
2. Download Angular CLI: https://cli.angular.io
3. Open terminal (or another command line interface) and navigate to 'bank' directory
4. Type 'npm install' in the command line to install node modules
5. Type 'ng serve' in the command line to run the server
6. Go to 'http://localhost:4200' in your browser
###### Optional: 
*Follow these instructions to open the project from the command line using Visual Studio Code: https://code.visualstudio.com/docs/setup/mac or https://code.visualstudio.com/docs/editor/command-line*

###### Note: 
*You will likely get errors if you try to submit data without concurrently running the back-end server.
Some of the data is currently referencing files that are temporarily holding the data until back-end is completed.*
