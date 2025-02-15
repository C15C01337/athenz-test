/*
 *  Copyright The Athenz Authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.yahoo.athenz.common.server.notification;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NotificationMetric {

    // Metric attributes as a list of flat arrays
    private final List<String[]> attributes;

    public NotificationMetric(List<String[]> attributes) {
        this.attributes = attributes;
    }

    public List<String[]> getAttributes() {
        return attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NotificationMetric that = (NotificationMetric) o;

        if (attributes.size() != that.attributes.size()) {
            return false;
        }

        for (int i = 0; i < attributes.size(); ++i) {
            if (!Arrays.equals(attributes.get(i), that.attributes.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        if (attributes == null || attributes.size() == 0) {
            return Objects.hash(attributes);
        }

        final int prime = 31;
        int result = 1;

        for (int i = 0; i < attributes.size(); ++i) {
            result = prime * result + Arrays.hashCode(attributes.get(i));
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < attributes.size(); ++i) {
            stringBuilder.append(String.join(",", attributes.get(i))).append(";");
        }

        return "NotificationMetric{" +
                "attributes=" + stringBuilder.toString() +
                '}';
    }
}
