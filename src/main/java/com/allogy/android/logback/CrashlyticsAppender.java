/*
 * Copyright (c) 2013 Allogy Interactive.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.allogy.android.logback;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.crashlytics.android.Crashlytics;

public class CrashlyticsAppender extends AppenderBase<ILoggingEvent>
{
    private PatternLayoutEncoder encoder;

    @Override
    public void start()
    {
        if (encoder == null || encoder.getLayout() == null)
        {
            addError("No layout set for the appender named [" + name + "].");
            return;
        }

        super.start();
    }

    @Override
    protected void append(ILoggingEvent loggingEvent)
    {
        if (!isStarted())
            return;

        String layoutString = encoder.getLayout().doLayout(loggingEvent);

        Crashlytics.log(layoutString);
    }

    public void setEncoder(PatternLayoutEncoder encoder)
    {
        this.encoder = encoder;
    }
}
