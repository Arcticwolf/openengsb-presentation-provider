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

/**
 * The flat list operation takes a list as parameter and concatenates all values in this list into a String using the
 * given parameter as connection string between the elements.
 */
public class FlatListOperation extends AbstractStandardTransformationOperation {
    private String concatString = "concatString";

    public FlatListOperation(String operationName) {
        super(operationName, FlatListOperation.class);
    }

    @Override
    public String getOperationDescription() {
        return theOperation()
            .does("flattens a list of values into a string where the given parameter stands between each element")
            .toString();
    }

    @Override
    public Integer getOperationInputCount() {
        return 1;
    }

    @Override
    public Map<String, String> getOperationParameterDescriptions() {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(concatString, "The string that should be written between the list elements. Optional value. "
                + "If no value is set, the empty string is taken instead.");
        return parameters;
    }

    @Override
    public Object performOperation(List<Object> input, Map<String, String> parameters)
        throws TransformationOperationException {
        checkInputSize(input);
        String concatParameter = getParameterOrDefault(parameters, concatString, "");
        return performListFlattening(input.get(0), concatParameter);
    }

    /**
     * Performs the actual list flattening operation. Throws a TransformationOperationException if the input value is no
     * list.
     */
    private String performListFlattening(Object source, String concatParamter)
        throws TransformationOperationException {
        if (!List.class.isAssignableFrom(source.getClass())) {
            throw new TransformationOperationException("The list flattening works only with list sources.");
        }
        List<?> elements = (List<?>) source;
        return StringUtils.join(elements, concatParamter);
    }
}
