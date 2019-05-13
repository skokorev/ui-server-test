Для запуска тестов понадобится:

* Google Chrome https://www.google.com/chrome/
* Git Client https://git-scm.com/downloads
* JDK https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* ChromeDriver https://chromedriver.storage.googleapis.com/index.html?path=74.0.3729.6/
* Maven https://maven.apache.org/download.cgi
* [Желательно] IDE (IDEA https://www.jetbrains.com/idea/download/, Eclipse https://www.eclipse.org/downloads/)

Настройки:

* Системная переменная WEBDRIVER_PATH, содержащий полный путь до chromedriver. Пример для Windows: `C:\chromedriver\chromedriver.exe`
* Java - в Path
* Maven - в Path

Приложение:

Исходники: https://github.com/skokorev/ui-server

Сборка для docker: `mvn clean install dockerfile:build`

Ссылка на Яндекс-диск: https://yadi.sk/d/sCFeoZ_2JSTW7g

Ссылка на Google Drive: https://drive.google.com/open?id=1ADxkImrT2ouByjrFM6WpKAVG8wfklDLX

Запуск приложения:
```java -jar .\app.jar --server.port=8080```

Тесты:

Запуск тестов:

```mvn clean install -P local```


Презентация:

Ссылка на Яндекс-диск: https://yadi.sk/i/nSjbMdBp9I3mqQ

Ссылка на Google Drive: https://drive.google.com/open?id=1-taGXeuhKtwRtjRkR6gvBwQgUdDqyui7