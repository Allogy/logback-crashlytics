logback-crashlytics
===================

This project provides a logback appender to log to Crashlytics.
You are responsible for setting up Crashlytics and starting it.
After that, log calls via slf4j will go to Crashlytics.


Simple Example
--------------

    <configuration>
        <appender name="Crashlytics" class="com.allogy.android.logback.CrashlyticsAppender">
            <encoder>
                <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
            </encoder>
        </appender>
    
        <root level="DEBUG">
            <appender-ref ref="Crashlytics" />
        </root>
    </configuration>


License
-------

Copyright (c) 2013 Allogy Interactive.

Released under the [Apache License, Version 2.0][apache-license].


[apache-license]: http://www.apache.org/licenses/LICENSE-2.0
