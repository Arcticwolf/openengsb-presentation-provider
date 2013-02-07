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

package org.openengsb.presentation.operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openengsb.core.ekb.api.transformation.TransformationOperationException;

import com.google.common.collect.Lists;

/**
 * The create list operation takes a string, splits it at the string defined by the parameter and adds the resulting
 * elements in a list which is then returned.
 */
public class CreateListOperation extends AbstractStandardTransformationOperation {
    private String splitString = "splitString";

    public CreateListOperation(String operationName) {
        super(operationName, CreateListOperation.class);
    }

    @Override
    public String getOperationDescription() {
        return theOperation()
            .does("takes a string, splits this input at the string given as parameter, adds the resulting elements")
            .cnt(" to a list and returns this list afterwards.")
            .toString();
    }

    @Override
    public Integer getOperationInputCount() {
        return 1;
    }

    @Override
    public Map<String, String> getOperationParameterDescriptions() {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(splitString, "The string that should be used to split the input string. Optional value. "
                + "If no value is set, a string containing one space is taken instead.");
        return parameters;
    }

    @Override
    public Object performOperation(List<Object> input, Map<String, String> parameters)
        throws TransformationOperationException {
        checkInputSize(input);
        String splitParameter = getParameterOrDefault(parameters, splitString, " ");
        return performListCreation(input.get(0).toString(), splitParameter);
    }

    /**
     * Performs the actual list creation operation.
     */
    private List<String> performListCreation(String source, String splitParameter) {
        return Lists.newArrayList(StringUtils.split(source, splitParameter));
    }
}
