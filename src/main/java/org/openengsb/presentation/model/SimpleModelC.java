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
import org.openengsb.labs.delegation.service.Provide;

@Provide(context = { Constants.DELEGATION_CONTEXT_MODELS })
@Model
public class SimpleModelC {
    private String identifierC;
    private String elementC;
    private String blaC;
    private String commentPartC1;
    private String commentPartC2;

    public String getIdentifierC() {
        return identifierC;
    }

    public void setIdentifierC(String identifierC) {
        this.identifierC = identifierC;
    }

    public String getElementC() {
        return elementC;
    }

    public void setElementC(String elementC) {
        this.elementC = elementC;
    }

    public String getBlaC() {
        return blaC;
    }

    public void setBlaC(String blaC) {
        this.blaC = blaC;
    }

    public String getCommentPartC1() {
        return commentPartC1;
    }

    public void setCommentPartC1(String commentPartC1) {
        this.commentPartC1 = commentPartC1;
    }

    public String getCommentPartC2() {
        return commentPartC2;
    }

    public void setCommentPartC2(String commentPartC2) {
        this.commentPartC2 = commentPartC2;
    }

}
