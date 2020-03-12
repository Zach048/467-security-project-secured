# <p align="center">HOW-TO: Security Based Research Project</p>
###### <p align="center">Ctrl-Alt-Elite: Zach Earl & Sam Bernstein</p> 

## Table of Contents 

##### I. Defining Security Vulnerabilities

[Injection](#injection)  
[Broken Authentication](#broken-auth)  
[Sensitive Data Exposure](#sensitive)  
[Broken Access Control](#broken-access)  
[Security Misconfiguration](#misconfig)  
[Cross-Site Scripting (XSS)](#xss)  
[Using Components With Known Vulnerabilities](#known-vulnerabilities)  
[Insufficient Logging and Monitoring](#logging)

##### II. Introducing the Bank of Piracy / The Bank Privacy

[The Bank of Piracy](#unsecure)  
[The Bank of Privacy](#secure)

##### III. Scanning For Security Vulnerabilities

[Introduction to OWASP ZAP](#zap)  
[Results: The Bank of Piracy](#unsecureResults)  
[Results: The Bank of Privacy](#secureResults)

##### IV. Security Vulnerability Exploit Attacks   

[Cross Scripting Attack](#xss-attack)  
[SQL Code Injection](#injection-attack)  
[Broken Authentication](#passwords-attack)  
[Broken Access Control](#access-attack)  

##### V. Security Vulnerability Mitigations  

[Cross Scripting Attack](#xss-mit)
[SQL Code Injection](#injection-mit)  
[Broken Authentication](#encryption-mit)  
[Broken Access Control](#access-mit)  
[Logging](#logging-mit)  
[Security Misconfiguration](#misconfig-mit)  
[Sensitive Data Exposure](#dataexp-mit)  
[Using Components with Known Vulnerabilities](#outdated-mit)

## Defining Security Vulnerabilites

<a name="injection"/>

### Injection

An attacker may be able to manipulate a web application such that the submitted commands (to include the request and payload) are altered in order to steal secretive information, change data, or potentially erase traces of activity.

[OWASP Injection](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A1-Injection.html)

<a name="broken-auth"/>

### Broken Authentication

Many applications will require a user to log in with a username and password combination, but attackers can utilize dictionary attacks, brute force, credential stuffing, session hijacking, and more to impersonate a user while the application cannot differentiate the attacker from the victim.

[OWASP Broken Authentication](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A2-Broken_Authentication.html)

<a name="sensitive"/>

### Sensitive Data Exposure

Sensitive data should be protected using encryption or other cryptographic algorithms, but attackers can exploit unencrypted data, custom encryption schemes (opposed to proven algorithms), weak keys, exposed encryption keys, and improperly implemented protocols to steal information such as credit cards, passwords, personal information, and critical business data.

[OWASP Sensitive Data Exposure](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A3-Sensitive_Data_Exposure.html)

<a name="broken-access"/>

### Broken Access Control

Most web applications restrict what a user can see and do, but an attacker may find a way to bypass these controls to reach unauthorized data.

[OWASP Broken Access Control](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A5-Broken_Access_Control.html)

<a name="misconfig"/>

### Security Misconfiguration

The application stack contains many moving components that need to be interconnected with proper configurations, and there is no single setting to protect the application, so all potentially vulnerable settings must be reviewed.

[OWASP Security Misconfiguration](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A6-Security_Misconfiguration.html)

<a name="xss"/>

### Cross-Site Scripting (XSS)

An attacker can alter the the web pages that other users see when using the application, and the vulnerability can occur whenever unverified data is included in a web page response without proper validation and sanitization.

[OWASP Cross-Site Scripting](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A7-Cross-Site_Scripting_(XSS).html)

<a name="known-vulnerabilities"/>

### Using Components With Known Vulnerabilities

Many web applications have multiple software dependencies, and if there are vulnerabilities within the dependencies then the same vulnerabilities also put the web application and its data at risk.

[OWASP Using Components With Known Vulnerabilities](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A9-Using_Components_with_Known_Vulnerabilities.html)

<a name="logging"/>

### Insufficient Logging and Monitoring

Some attacks may penetrate even the best security defenses, but a proper security system will have many layers that provide the organization ample ability to recover against the attack or minimize damage.

[OWASP Insufficient Logging and Monitoring](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A10-Insufficient_Logging%252526Monitoring.html)

## Introducing The Bank of Piracy / The Bank of Privacy

<a name="unsecure"/>

### Bank of Piracy

The Bank of Piracy is the unsecure version of the application.  The front-end of the application uses HTML and CSS in conjunction with Express Framework to deliver the user an interactive online bank account.  The back-end of the application is a Node.js server combined with a MySQL relational database.  There are user accounts stored in the database with user authentication via the login page and the user can input data to pay their credit card bill, update the personal information on their account, or search their list of transactions for a specific vendor.  All data are stored in the database in plaintext with the exception of passwords, which are encrypted for storage in the database using SHA1, a cryptographic hash function that takes a plaintext input and generates a 160-bit hash value that is rendered as a 40-digit hexadecimal number.  Use of SHA1 is no longer recommended due to its associated vulnerabilities, but hash functions can provide a false sense of security simply because they are not supposed to be unhashable.

<a name="secure"/>

### Bank of Privacy

The Bank of Privacy is the secure version of the application.  The front-end of the application is written in TypeScript, HTML, and CSS through Angular, an open-source framework for web applications originally developed and maintained by Google.  The back-end of the application...

## Scanning For Security Vulnerabilities

<a name="zap"/>

## Introduction to OWASP ZAP  

The Open Web Application Security Project (OWASP) is a nonprofit working to advance the security of software through community-driven open source development.  Zed Attack Proxy (ZAP) is a tool created by OWASP to perform security testing in a manner that can be understood by individuals ranging in experience from novice to expert.  ZAP is a penetration testing tool specifically designed for web applications and functions primarily as a "man-in-the-middle proxy" by intercepting and monitoring data transmitted between the browser and web application.  The tool should only be run on sites that you have permission to attack as the simulation functions like a real attack and has the potential to damage the appication's functionality, data, etc.

[About ZAP and Instructions for Use](https://www.zaproxy.org/getting-started/)

<a name="unsecureResults"/>

### OWASP Zap Scanning Results: Bank of Piracy

<a name="secureResults"/>

### OWASP Zap Scanning Results: Bank of Privacy


## Security Vulnerability Exploit Attacks

<a name="injection-attack"/>

### SQL Code Injection

<a name="passwords-attack"/>

### Broken Authentication 

<a name="dataexp-mit"/>

### Sensitive Data Exposure



<a name="access-attack"/>

### Broken Access Control

The Bank of Piracy leaves user data at risk by failing to protect against account access by unauthorized users.  There is no explicit protection for any of the application's routes, which means that all routes associated with the application can be accessed by anyone via URL.  Although there is a login page to verify a username and password combination, it can easily be bypassed by manually changing the route in the URL. 

<a name="misconfig-mit"/>

### Security Misconfiguration  

<a name="xss-attack"/>

### Cross Scripting Attack   

##### Angular Dom Sanitization   

##### Bypassing Dom Sanitizer   

##### Parameterized XSS Attack  

##### XSS Attack By Updating Customer  

## Security Vulnerabilty Mitigations 

<a name="injection-mit"/>

### SQL Code Injection

<a name="encryption-mit"/>

### Broken Authentication

<a name="access-mit"/>

### Broken Access Control

The Bank of Privacy uses sessions in order to prevent accounts from being accessed without authorization.  Additionally, routes in the application do not employ the use of parameters to pass the user id to one another, thereby adding an additional layer of protection against broken access to user data. The login page and new user registration page are accessible without the creation of a session, which occurs after a user enters a correct username and password combination to log into an account.  Once logged into an account, a user can access the dashboard, view their transactions, pay their credit card bill, and update their personal information.  When a user logs out of the account, the session is terminated and the user must present their credentials again in order to regain access to the pages beyond the login screen.  The new user registration page is meant to be accessed from a button on the login page but can also be accessed directly via URL, so when the page is loaded it automatically makes sure that there is no current session in order to prevent the possible contamination of data submitted in the form.

<a name="xss-mit"/>

### Cross Scripting Attack  

<a name="outdated-mit"/>

### Using Components with Known Vulnerabilities

<a name="logging-mit"/>

### Logging 
