/**
 *     Copyright (C) 2010 Julien SMADJA <julien dot smadja at gmail dot com> - Arnaud LEMAIRE <alemaire at norad dot fr>
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package net.awired.visuwall.plugin.jenkins;

import java.util.HashMap;
import java.util.Map;
import net.awired.visuwall.api.domain.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.base.Preconditions;

public class States {

    private static final Logger LOG = LoggerFactory.getLogger(States.class);

    private static final Map<String, State> STATE_MAPPING = new HashMap<String, State>();

    static {
        STATE_MAPPING.put("success", State.SUCCESS);
        STATE_MAPPING.put("aborted", State.ABORTED);
        STATE_MAPPING.put("failure", State.FAILURE);
        STATE_MAPPING.put("unstable", State.UNSTABLE);
    }

    public static final State asVisuwallState(String jenkinsState) {
        Preconditions.checkNotNull(jenkinsState, "jenkinsState is mandatory");
        jenkinsState = jenkinsState.toLowerCase();
        State state = STATE_MAPPING.get(jenkinsState);
        if (state == null) {
            state = State.UNKNOWN;
            LOG.warn(jenkinsState + " is not available in Jenkins plugin. Please report it to Visuwall dev team.");
        }
        return state;
    }
}