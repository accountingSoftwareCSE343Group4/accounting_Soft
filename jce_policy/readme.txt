If you get an exception with illegal key size, do not look for any errors in the code, there is a problem with the JDK's jar files you are using.

It takes at most 2 minutes to resolve this:

These files will be copied to the JDK folder according to the operating system you are using and the JDK version you are using.

FOR LINUX: Discard the files local_policy.jar and US_export_policy.jar in the folder $ JAVA_HOME / jre / lib / security directory. (Cd $ JAVA_HOME / jre / lib / security directory). By default, this folder is / usr / lib / jvm / java8-oracle / jre / lib / security (see equivalent path if you are using JDK 7)

FOR WINDOWS:

In the folder, copy the local_policy.jar and US_export_policy.jar files to the $ JAVA_HOME / jre / lib / security directory folder.

By default this folder is C: \ Program Files \ Java \ jdk1.8.0_102 \ jre \ lib \ security. (See equivalent path if you are using JDK 7)

* The location of the JAVA folder may vary depending on the system you are using. At the same time, you can have 2 jdk on your system. If your Netbeans program is using it, you should change it !!