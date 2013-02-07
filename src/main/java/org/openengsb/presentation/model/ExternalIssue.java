/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openengsb.presentation.model;

import org.openengsb.core.api.Constants;
import org.openengsb.core.api.model.annotation.Model;
import org.openengsb.core.api.model.annotation.OpenEngSBModelId;
import org.openengsb.labs.delegation.service.Provide;

import com.google.common.base.Objects;

@Provide(context = { Constants.DELEGATION_CONTEXT_MODELS })
@Model
public class ExternalIssue {
    @OpenEngSBModelId
    private String internal_id;
    private String title;
    private String summary;
    private String assignee;
    private String reporter;
    private IssueMetaInfo metaInfo;
    private String due;
    private String involved;

    public String getInternal_id() {
        return internal_id;
    }

    public void setInternal_id(String internal_id) {
        this.internal_id = internal_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public IssueMetaInfo getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(IssueMetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getInvolved() {
        return involved;
    }

    public void setInvolved(String involved) {
        this.involved = involved;
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("internal_id", internal_id)
                .add("title", title)
                .add("summary", summary)
                .add("assignee", assignee)
                .add("reporter", reporter)
                .add("metaInfo", metaInfo)
                .add("due", due)
                .add("involved", involved).toString();
    }
}
