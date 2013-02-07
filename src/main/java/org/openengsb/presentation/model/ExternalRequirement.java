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

import java.util.Date;

import org.openengsb.core.api.Constants;
import org.openengsb.core.api.model.annotation.Model;
import org.openengsb.core.api.model.annotation.OpenEngSBModelId;
import org.openengsb.labs.delegation.service.Provide;

@Provide(context = { Constants.DELEGATION_CONTEXT_MODELS })
@Model
public class ExternalRequirement {
    @OpenEngSBModelId
    private String internal_id;
    private String name;
    private String summary;
    private String informalDescription;
    private String technicalDescription;
    private Worker assigned;
    private String priority;
    private String type;
    private Date changed;
    private Worker changedBy;
    private String timeEstimation;
    private String comments;

    public String getInternal_id() {
        return internal_id;
    }

    public void setInternal_id(String internal_id) {
        this.internal_id = internal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInformalDescription() {
        return informalDescription;
    }

    public void setInformalDescription(String informalDescription) {
        this.informalDescription = informalDescription;
    }

    public String getTechnicalDescription() {
        return technicalDescription;
    }

    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getChanged() {
        return changed;
    }

    public void setChanged(Date changed) {
        this.changed = changed;
    }

    public String getTimeEstimation() {
        return timeEstimation;
    }

    public void setTimeEstimation(String timeEstimation) {
        this.timeEstimation = timeEstimation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Worker getAssigned() {
        return assigned;
    }

    public void setAssigned(Worker assigned) {
        this.assigned = assigned;
    }

    public Worker getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Worker changedBy) {
        this.changedBy = changedBy;
    }
}
