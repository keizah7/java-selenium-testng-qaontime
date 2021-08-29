![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)
[![Chat](https://img.shields.io/discord/620935790867906561?label=chat)](https://discord.gg/YeJBQrTUT9)
![HitCount](https://views.whatilearened.today/views/github/keizah7/java-selenium-testng-qaontime.svg)
![Forks](https://img.shields.io/github/forks/keizah7/java-selenium-testng-qaontime?style=social)
![Stars](https://img.shields.io/github/stars/keizah7/java-selenium-testng-qaontime?style=social)
![Watchers](https://img.shields.io/github/watchers/keizah7/java-selenium-testng-qaontime?style=social)
![Contributors](https://img.shields.io/github/contributors/keizah7/java-selenium-testng-qaontime)

# Testing qaontime.com with Java TestNG framework

This project is for educational porpuses only. Pull request are welcome! Thank you for your cooperation!

## Requirements (optional)
- IntelliJ IDEA ([Download](https://code.visualstudio.com/Download))
- Eclipse ([Download](https://www.eclipse.org/downloads/))
- Another IDE with Java support

## Setup

Replace ```config/config.xml``` old data with valid login information
```xml
<config>
	<user>
		<url>http://qaontime.com/register/</url>
		<username>yourUsername</username>
		<password>yourPassword</password>
	</user>
</config>
```


In ```test-data/login.xml``` file you can write data which will be filled to login form.
output
**UserName | Password**
```
JohnDoee | john123123
JohnDoee | sdfsdfsdfs
... .... | .......
```


## Dependencies
Dependencies management is available in ```pom.xml```

## Using
Use ```testng.xml``` or ```smoke.xml``` files to run tests. (Run As / TestNG Suite)

### Authors: [Artūras](https://github.com/keizah7) ![Followers](https://img.shields.io/github/followers/keizah7?style=social)
