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

@Provide(context = { Constants.DELEGATION_CONTEXT_MODELS })
@Model
public class Eplan {
    @OpenEngSBModelId
    private String id;
    private Boolean eplan_ok;
    private String eplan_comment;
    private Boolean logic_ok;
    private String logic_comment;
    private Boolean zuli_ok;
    private String zuli_comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getEplan_ok() {
        return eplan_ok;
    }

    public void setEplan_ok(Boolean eplan_ok) {
        this.eplan_ok = eplan_ok;
    }

    public String getEplan_comment() {
        return eplan_comment;
    }

    public void setEplan_comment(String eplan_comment) {
        this.eplan_comment = eplan_comment;
    }

    public Boolean getLogic_ok() {
        return logic_ok;
    }

    public void setLogic_ok(Boolean logic_ok) {
        this.logic_ok = logic_ok;
    }

    public String getLogic_comment() {
        return logic_comment;
    }

    public void setLogic_comment(String logic_comment) {
        this.logic_comment = logic_comment;
    }

    public Boolean getZuli_ok() {
        return zuli_ok;
    }

    public void setZuli_ok(Boolean zuli_ok) {
        this.zuli_ok = zuli_ok;
    }

    public String getZuli_comment() {
        return zuli_comment;
    }

    public void setZuli_comment(String zuli_comment) {
        this.zuli_comment = zuli_comment;
    }

}
