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

##### II. Scanning For Security Vulnerabilities

[Introduction to OWASP ZAP](#zap)  
[Results](#results)

##### III. Security Vulnerability Exploit Attacks   

[Cross Scripting Attack](#xss-attack)  
[SQL Code Injection](#injection-attack)  
[Broken Authentication](#passwords-attack)  
[Broken Access Control](#access-attack)  

##### IV. Security Vulnerability Mitigations  

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

[OWASP Broken Authentication](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A2-Broken_Authentication.html)

<a name="sensitive"/>

### Sensitive Data Exposure

[OWASP Sensitive Data Exposure](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A3-Sensitive_Data_Exposure.html)

<a name="broken-access"/>

### Broken Access Control

[OWASP Broken Access Control](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A5-Broken_Access_Control.html)

<a name="misconfig"/>

### Security Misconfiguration

[OWASP Security Misconfiguration](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A6-Security_Misconfiguration.html)

<a name="xss"/>

### Cross-Site Scripting (XSS)

[OWASP Cross-Site Scripting](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A7-Cross-Site_Scripting_(XSS).html)

<a name="known-vulnerabilities"/>

### Using Components With Known Vulnerabilities

[OWASP Using Components With Known Vulnerabilities](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A9-Using_Components_with_Known_Vulnerabilities.html)

<a name="logging"/>

### Insufficient Logging and Monitoring

[OWASP Insufficient Logging and Monitoring](https://owasp.org/www-project-top-ten/OWASP_Top_Ten_2017/Top_10-2017_A10-Insufficient_Logging%252526Monitoring.html)

## Scanning For Security Vulnerabilities

<a name="zap"/>

### Introduction to OWASP ZAP  

The Open Web Application Security Project (OWASP) is a nonprofit working to advance the security of software through community-driven open source development.  Zed Attack Proxy (ZAP) is a tool created by OWASP to perform security testing in a manner that can be understood by individuals ranging in experience from novice to expert.  ZAP is a penetration testing tool specifically designed for web applications and functions primarily as a "man-in-the-middle proxy" by intercepting and monitoring data transmitted between the browser and web application.  The tool should only be run on sites that you have permission to attack as the simulation functions like a real attack and has the potential to damage the appication's functionality, data, etc.

[About ZAP and Instructions for Use](https://www.zaproxy.org/getting-started/)

<a name="results"/>

### OWASP Zap Scanning Results

## Security Vulnerability Exploit Attacks

<a name="xss-attack"/>

### Cross Scripting Attack  

##### Angular Dom Sanitization   

##### Bypassing Dom Sanitizer   

##### Parameterized XSS Attack  

##### XSS Attack By Updating Customer  

<a name="injection-attack"/>

### SQL Code Injection

<a name="passwords-attack"/>

### Broken Authentication  

<a name="access-attack"/>

### Broken Access Control

## Security Vulnerabilty Mitigations 

<a name="xss-mit"/>

### Cross Scripting Attack  

<a name="injection-mit"/>

### SQL Code Injection

<a name="encryption-mit"/>

### Broken Authentication

<a name="access-mit"/>

### Broken Access Control

<a name="logging-mit"/>

### Logging 

<a name="dataexp-mit"/>

### Sensitive Data Exposure

<a name="misconfig-mit"/>

### Security Misconfiguration  

<a name="outdated-mit"/>

### Using Components with Known Vulnerabilities
