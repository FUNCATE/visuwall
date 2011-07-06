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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.21 at 12:25:24 PM CET 
//

package net.awired.visuwall.hudsonclient.generated.hudson.hudsonmodel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for hudson.model.AbstractProject complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hudson.model.AbstractProject">
 *   &lt;complexContent>
 *     &lt;extension base="{}hudson.model.Job">
 *       &lt;sequence>
 *         &lt;element name="concurrentBuild" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="downstreamProject" type="{}hudson.model.AbstractProject" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="scm" type="{}hudson.scm.SCM" minOccurs="0"/>
 *         &lt;element name="upstreamProject" type="{}hudson.model.AbstractProject" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hudson.model.AbstractProject", propOrder = { "concurrentBuild", "downstreamProject", "scm",
        "upstreamProject" })
public class HudsonModelAbstractProject extends HudsonModelJob {

    protected boolean concurrentBuild;
    protected List<HudsonModelAbstractProject> downstreamProject;
    protected HudsonScmSCM scm;
    protected List<HudsonModelAbstractProject> upstreamProject;

    /**
     * Gets the value of the concurrentBuild property.
     * 
     */
    public boolean isConcurrentBuild() {
        return concurrentBuild;
    }

    /**
     * Sets the value of the concurrentBuild property.
     * 
     */
    public void setConcurrentBuild(boolean value) {
        this.concurrentBuild = value;
    }

    /**
     * Gets the value of the downstreamProject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make
     * to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method
     * for the downstreamProject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getDownstreamProject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link HudsonModelAbstractProject }
     * 
     * 
     */
    public List<HudsonModelAbstractProject> getDownstreamProject() {
        if (downstreamProject == null) {
            downstreamProject = new ArrayList<HudsonModelAbstractProject>();
        }
        return this.downstreamProject;
    }

    /**
     * Gets the value of the scm property.
     * 
     * @return possible object is {@link HudsonScmSCM }
     * 
     */
    public HudsonScmSCM getScm() {
        return scm;
    }

    /**
     * Sets the value of the scm property.
     * 
     * @param value
     *            allowed object is {@link HudsonScmSCM }
     * 
     */
    public void setScm(HudsonScmSCM value) {
        this.scm = value;
    }

    /**
     * Gets the value of the upstreamProject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make
     * to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method
     * for the upstreamProject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getUpstreamProject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link HudsonModelAbstractProject }
     * 
     * 
     */
    public List<HudsonModelAbstractProject> getUpstreamProject() {
        if (upstreamProject == null) {
            upstreamProject = new ArrayList<HudsonModelAbstractProject>();
        }
        return this.upstreamProject;
    }

}
