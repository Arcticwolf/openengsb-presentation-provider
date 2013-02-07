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

import com.google.common.base.Objects;

@Provide(context = { Constants.DELEGATION_CONTEXT_MODELS })
@Model
public class SimpleModelD {
    private String identifierD;
    private String elementD;
    private String blubD;
    private String commentPartD1;
    private String commentPartD2;

    public String getIdentifierD() {
        return identifierD;
    }

    public void setIdentifierD(String identifierD) {
        this.identifierD = identifierD;
    }

    public String getElementD() {
        return elementD;
    }

    public void setElementD(String elementD) {
        this.elementD = elementD;
    }

    public String getBlubD() {
        return blubD;
    }

    public void setBlubD(String blubD) {
        this.blubD = blubD;
    }

    public String getCommentPartD1() {
        return commentPartD1;
    }

    public void setCommentPartD1(String commentPartD1) {
        this.commentPartD1 = commentPartD1;
    }

    public String getCommentPartD2() {
        return commentPartD2;
    }

    public void setCommentPartD2(String commentPartD2) {
        this.commentPartD2 = commentPartD2;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("identifierD", identifierD)
            .add("elementD", elementD)
            .add("blubD", blubD)
            .add("commentPartD1", commentPartD1)
            .add("commentPartD2", commentPartD2).toString();
    }

}
