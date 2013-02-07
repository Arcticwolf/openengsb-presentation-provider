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
public class SimpleModelA {
    private String nameA;
    private String numberA;
    private String descriptionA;
    private String commentA1;
    private String commentA2;

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getNumberA() {
        return numberA;
    }

    public void setNumberA(String numberA) {
        this.numberA = numberA;
    }

    public String getDescriptionA() {
        return descriptionA;
    }

    public void setDescriptionA(String descriptionA) {
        this.descriptionA = descriptionA;
    }

    public String getCommentA1() {
        return commentA1;
    }

    public void setCommentA1(String commentA1) {
        this.commentA1 = commentA1;
    }

    public String getCommentA2() {
        return commentA2;
    }

    public void setCommentA2(String commentA2) {
        this.commentA2 = commentA2;
    }
}
