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

package net.awired.visuwall.plugin.teamcity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.awired.visuwall.api.domain.ProjectKey;
import net.awired.visuwall.api.domain.SoftwareProjectId;
import net.awired.visuwall.api.domain.State;
import net.awired.visuwall.api.exception.BuildNotFoundException;
import net.awired.visuwall.api.exception.BuildNumberNotFoundException;
import net.awired.visuwall.api.exception.MavenIdNotFoundException;
import net.awired.visuwall.api.exception.ProjectNotFoundException;
import net.awired.visuwall.api.plugin.capability.BuildCapability;
import net.awired.visuwall.teamcityclient.TeamCity;
import net.awired.visuwall.teamcityclient.exception.TeamCityProjectNotFoundException;
import net.awired.visuwall.teamcityclient.exception.TeamCityProjectsNotFoundException;
import net.awired.visuwall.teamcityclient.resource.TeamCityProject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

public class TeamCityConnection implements BuildCapability {

    private static final Logger LOG = LoggerFactory.getLogger(TeamCityConnection.class);

    @VisibleForTesting
    static final String TEAMCITY_ID = "TEAMCITY_ID";

    private boolean connected;

    TeamCity teamCity;

    private String url;

    @Override
    public void connect(String url, String login, String password) {
        connect(url);
    }

    void connect(String url) {
        Preconditions.checkNotNull(url, "url is mandatory");
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("url can't be null.");
        }
        this.url = url;
        teamCity = new TeamCity(url);
        connected = true;
    }

    @Override
    public List<String> findProjectNames() {
        checkConnected();
        try {
            return teamCity.findProjectNames();
        } catch (TeamCityProjectsNotFoundException e) {
            return new ArrayList<String>();
        }
    }

    @Override
    public void close() {
        connected = false;
    }

    @Override
    public String getDescription(SoftwareProjectId softwareProjectId) throws ProjectNotFoundException {
        checkConnected();
        checkSoftwareProjectId(softwareProjectId);
        try {
            String projectId = softwareProjectId.getProjectId();
            TeamCityProject project = teamCity.findProject(projectId);
            return project.getDescription();
        } catch (TeamCityProjectNotFoundException e) {
            throw new ProjectNotFoundException("Can't find description of project with software project id:"
                    + softwareProjectId, e);
        }
    }

    @Override
    public SoftwareProjectId identify(ProjectKey projectKey) throws ProjectNotFoundException {
        checkConnected();
        Preconditions.checkNotNull(projectKey, "projectKey is mandatory");
        try {
            String name = projectKey.getName();
            List<TeamCityProject> projects = teamCity.findAllProjects();
            for (TeamCityProject project : projects) {
                String projectName = project.getName();
                if (projectName.equals(name)) {
                    String projectId = project.getId();
                    SoftwareProjectId softwareProjectId = new SoftwareProjectId(projectId);
                    return softwareProjectId;
                }
            }
        } catch (TeamCityProjectsNotFoundException e) {
            throw new ProjectNotFoundException("Can't identify software project id with project key: " + projectKey, e);
        }
        throw new ProjectNotFoundException("Can't identify software project id with project key: " + projectKey);
    }

    @Override
    public int[] getBuildNumbers(SoftwareProjectId softwareProjectId) throws ProjectNotFoundException {
        checkConnected();
        checkSoftwareProjectId(softwareProjectId);
        return null;
    }

    @Override
    public List<SoftwareProjectId> findAllSoftwareProjectIds() {
        checkConnected();
        List<SoftwareProjectId> projectIds = new ArrayList<SoftwareProjectId>();
        try {
            List<TeamCityProject> projects = teamCity.findAllProjects();
            for (TeamCityProject project : projects) {
                String id = project.getId();
                SoftwareProjectId softwareProjectId = new SoftwareProjectId(id);
                projectIds.add(softwareProjectId);
            }
        } catch (TeamCityProjectsNotFoundException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Can't build list of software project ids.", e);
            }
        }
        return projectIds;
    }

    @Override
    public List<SoftwareProjectId> findSoftwareProjectIdsByNames(List<String> names) {
        checkConnected();
        List<SoftwareProjectId> projectIds = new ArrayList<SoftwareProjectId>();
        try {
            List<TeamCityProject> projects = teamCity.findAllProjects();
            for (TeamCityProject project : projects) {
                String name = project.getName();
                if (names.contains(name)) {
                    String id = project.getId();
                    SoftwareProjectId projectId = new SoftwareProjectId(id);
                    projectIds.add(projectId);
                }
            }
        } catch (TeamCityProjectsNotFoundException e) {
            LOG.warn("Can't find projects by name with this Team City connection," + this.url, e);
        }
        return projectIds;
    }

    @Override
    public State getBuildState(SoftwareProjectId projectId, int buildNumber) throws ProjectNotFoundException,
            BuildNotFoundException {
        checkConnected();
        throw new ProjectNotFoundException("not implemented");
    }

    @Override
    public Date getEstimatedFinishTime(SoftwareProjectId projectId, int buildNumber) throws ProjectNotFoundException,
            BuildNotFoundException {
        checkConnected();
        throw new ProjectNotFoundException("not implemented");
    }

    @Override
    public boolean isBuilding(SoftwareProjectId projectId, int buildNumber) throws ProjectNotFoundException,
            BuildNotFoundException {
        throw new ProjectNotFoundException("not implemented");
    }

    @Override
    public int getLastBuildNumber(SoftwareProjectId projectId) throws ProjectNotFoundException,
            BuildNumberNotFoundException {
        checkConnected();
        throw new ProjectNotFoundException("not implemented");
    }

    @Override
    public String getMavenId(SoftwareProjectId softwareProjectId) throws ProjectNotFoundException,
            MavenIdNotFoundException {
        checkConnected();
        checkSoftwareProjectId(softwareProjectId);
        throw new MavenIdNotFoundException("TeamCity does not implemented this capability");
    }

    @Override
    public String getName(SoftwareProjectId softwareProjectId) throws ProjectNotFoundException {
        checkConnected();
        checkSoftwareProjectId(softwareProjectId);
        try {
            String projectId = softwareProjectId.getProjectId();
            TeamCityProject project = teamCity.findProject(projectId);
            return project.getName();
        } catch (TeamCityProjectNotFoundException e) {
            throw new ProjectNotFoundException("Can't find name of project with software project id:"
                    + softwareProjectId, e);
        }
    }

    private void checkConnected() {
        Preconditions.checkState(connected, "You must connect your plugin");
    }

    private void checkSoftwareProjectId(SoftwareProjectId softwareProjectId) {
        Preconditions.checkNotNull(softwareProjectId, "softwareProjectId is mandatory");
    }

}
