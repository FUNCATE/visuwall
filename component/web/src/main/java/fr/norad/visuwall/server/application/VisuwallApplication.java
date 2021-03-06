/**
 *
 *     Copyright (C) norad.fr
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
package fr.norad.visuwall.server.application;

import java.util.Properties;
import javax.servlet.ServletContext;
import fr.norad.visuwall.core.application.common.ApplicationHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component
public class VisuwallApplication implements ServletContextAware {

    private ServletContext context;
    protected String version;

    // @PostConstruct
    public void init() {
        try {
            ApplicationHelper.getVersion(context.getResourceAsStream("META-INF/MANIFEST.MF"));
            version = ApplicationHelper.getVersion();
        } catch (Exception e) {
            // e.printStackTrace();
        }

    }

    public Properties visuwallProperties() {
        Properties prop = new Properties();
        //        prop.setProperty(ApplicationHelper.HOME_KEY, home);
        return prop;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
        init();
    }
}
