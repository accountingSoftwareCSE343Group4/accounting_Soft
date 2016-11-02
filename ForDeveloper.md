Arkadaşlar eğer illegal key size içeren bir exception alırsanız kodda hata aramayın, sizin kulllandığınız JDK nın jar dosyalarında problem vardır.

Bunu çözmek için en fazla 2 dakikalık çaba yeterli : 


http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html  adresine gidin.
jce_policy_8.zip dosyasını indirin ve bir klasöre içeriğini çıkarınız.
Bu dosyaları kullandığınız işletim sistemine göre JDK klasörüne atacaksınız.



LINUX İÇİN:
İndirdiğiniz local_policy.jar ve US_export_policy.jar dosyalarını $JAVA_HOME/jre/lib/security directory klasörüne atın.
 ( cd $JAVA_HOME/jre/lib/security directory ).
Varsayılan olarak bu klasör /usr/lib/jvm/java-8-oracle/jre/lib/security dir.



WINDOWS İÇİN:


İndirdiğiniz local_policy.jar ve US_export_policy.jar dosyalarını $JAVA_HOME/jre/lib/security directory klasörüne atın. 

Varsayılan olarak bu klasör C:\Program Files\Java\jdk1.8.0_102\jre\lib\security dir.

*JAVA klasörünün bulunduğu yer kullandığınız sisteme göre değişebilir. Aynı zamanda sisteminizde 2 tane jdk olabilir.
Netbeans hangisini kullanıyorsa onu değiştirmelisiniz!!