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
 * The prefix change operation removes the prefix which is given as parameter and adds another prefix which is given as
 * parameter
 */
public class PrefixChangeOperation extends AbstractStandardTransformationOperation {
    private String oldPrefixParam = "oldPrefix";
    private String newPrefixParam = "newPrefix";

    public PrefixChangeOperation(String operationName) {
        super(operationName, PrefixChangeOperation.class);
    }

    @Override
    public String getOperationDescription() {
        return theOperation()
            .does("removes the prefix of the value which is given as parameter and adds another prefix")
            .cnt(" and return the resulting string.").toString();
    }

    @Override
    public Integer getOperationInputCount() {
        return 1;
    }

    @Override
    public Map<String, String> getOperationParameterDescriptions() {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put(oldPrefixParam, "The old string prefix which should be removed. Optional value. "
                + "If no value is set, the empty string is taken instead.");
        parameters.put(newPrefixParam, "The new string prefix which should be used instead. Optional value. "
                + "If no value is set, the empty string is taken instead.");
        return parameters;
    }

    @Override
    public Object performOperation(List<Object> input, Map<String, String> parameters)
        throws TransformationOperationException {
        checkInputSize(input);
        String oldPrefix = getParameterOrDefault(parameters, oldPrefixParam, "");
        String newPrefix = getParameterOrDefault(parameters, newPrefixParam, "");
        return performPrefixChange(input.get(0).toString(), oldPrefix, newPrefix);
    }

    /**
     * Performs the actual prefix change operation. Throws a TransformationOperationException if anything goes wrong
     * during the procedure.
     */
    public static String performPrefixChange(String source, String oldPrefix, String newPrefix)
        throws TransformationOperationException {
        try {
            source = StringUtils.removeStart(source, oldPrefix);
            return StringUtils.join(new Object[]{ newPrefix, source });
        } catch (Exception e) {
            throw new TransformationOperationException("Unable to perform prefix change operation", e);
        }
    }
}
