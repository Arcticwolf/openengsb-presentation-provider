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

package org.openengsb.presentation.hook;

import java.util.ArrayList;
import java.util.List;

import org.openengsb.core.api.context.ContextHolder;
import org.openengsb.core.api.model.OpenEngSBModel;
import org.openengsb.core.ekb.api.EKBCommit;
import org.openengsb.core.ekb.api.EKBException;
import org.openengsb.core.ekb.api.QueryInterface;
import org.openengsb.core.ekb.api.hooks.EKBPreCommitHook;
import org.openengsb.core.ekb.api.transformation.TransformationOperationException;
import org.openengsb.presentation.model.Eplan;
import org.openengsb.presentation.model.Logicad;
import org.openengsb.presentation.model.Signal;
import org.openengsb.presentation.model.Zuli;
import org.openengsb.presentation.operation.PrefixChangeOperation;

/**
 * The SignalCreationHook is responsible to check if there exist a Signal engineering object for the models which are
 * committed and creates it if it does not exist yet.
 */
public class SignalCreationHook implements EKBPreCommitHook {
    private QueryInterface queryInterface;

    public SignalCreationHook(QueryInterface queryInterface) {
        this.queryInterface = queryInterface;
    }

    @Override
    public void onPreCommit(EKBCommit commit) throws EKBException {
        List<OpenEngSBModel> models = new ArrayList<OpenEngSBModel>();
        List<String> inserted = new ArrayList<String>();
        for (OpenEngSBModel model : commit.getInserts()) {
            if (needsToBeChecked(model) && !signalExists(model, commit)) {
                OpenEngSBModel temp = createSignal(model);
                if (!inserted.contains(temp.retrieveInternalModelId().toString())) {
                    models.add(temp);
                    inserted.add(temp.retrieveInternalModelId().toString());
                }
            }
        }
        commit.getInserts().addAll(models);
    }

    /**
     * Returns true if the model is an instance of one of the three models involved in the AHy use-case validation
     * besides the 'Signal' model. Returns false otherwise.
     */
    private boolean needsToBeChecked(OpenEngSBModel model) {
        if (model.retrieveModelName().equals(Eplan.class.getName())
                || model.retrieveModelName().equals(Logicad.class.getName())
                || model.retrieveModelName().equals(Zuli.class.getName())) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if the signal which belongs to the given model is already instantiated and is saved in the EDB or in
     * the commit.
     */
    private boolean signalExists(OpenEngSBModel model, EKBCommit commit) {
        String signalId = getSignalId(model);
        try {
            queryInterface.getModel(Signal.class, ContextHolder.get().getCurrentContextId() + "/" + signalId);
            return true;
        } catch (Exception e) {
            for (OpenEngSBModel cmp : commit.getInserts()) {
                if (cmp.retrieveInternalModelId().equals(signalId)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Creates a new signal instance based on the model given as parameter, sets the references accordingly.
     */
    private OpenEngSBModel createSignal(OpenEngSBModel model) {
        String id = model.retrieveInternalModelId().toString();
        String[] parts = id.split("-");
        Signal signal = new Signal();
        signal.setId("signal-" + parts[1]);
        signal.setEplanId("eplan-" + parts[1]);
        signal.setLogicId("logic-" + parts[1]);
        signal.setZuliId("zuli-" + parts[1]);
        return (OpenEngSBModel) signal;
    }

    /**
     * Returns the identifier for the signal which fits to the model given as parameter.
     */
    private String getSignalId(OpenEngSBModel model) {
        String id = model.retrieveInternalModelId().toString();
        try {
            return PrefixChangeOperation.performPrefixChange(id, id.split("-")[0], "signal");
        } catch (TransformationOperationException e) {
            System.out.println("should never come here");
        }
        return null;
    }
}
