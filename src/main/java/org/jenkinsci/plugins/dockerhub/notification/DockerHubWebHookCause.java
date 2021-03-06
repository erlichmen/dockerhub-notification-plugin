/**
 * The MIT License
 *
 * Copyright (c) 2015, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.dockerhub.notification;


import org.jenkinsci.plugins.dockerhub.notification.webhook.WebHookPayload;
import hudson.model.Cause;

import javax.annotation.Nonnull;

/**
 * The build cause of {@link DockerHubWebHook}.
 */
public class DockerHubWebHookCause extends Cause {

    @Nonnull
    private final WebHookPayload payload;

    public DockerHubWebHookCause(@Nonnull WebHookPayload payload) {
        this.payload = payload;
    }

    @Override
    public String getShortDescription() {
        return String.format("Triggered by push of %s to DockerHub@%s", payload.getRepoName(), payload.getCallbackHost());
    }

    public WebHookPayload getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "DockerHubWebHookCause{" +
                "payload=" + payload +
                '}';
    }
}
