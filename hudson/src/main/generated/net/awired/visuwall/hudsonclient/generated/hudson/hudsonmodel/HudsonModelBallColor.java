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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for hudson.model.BallColor.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="hudson.model.BallColor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="red"/>
 *     &lt;enumeration value="red_anime"/>
 *     &lt;enumeration value="yellow"/>
 *     &lt;enumeration value="yellow_anime"/>
 *     &lt;enumeration value="blue"/>
 *     &lt;enumeration value="blue_anime"/>
 *     &lt;enumeration value="grey"/>
 *     &lt;enumeration value="grey_anime"/>
 *     &lt;enumeration value="disabled"/>
 *     &lt;enumeration value="disabled_anime"/>
 *     &lt;enumeration value="aborted"/>
 *     &lt;enumeration value="aborted_anime"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "hudson.model.BallColor")
@XmlEnum
public enum HudsonModelBallColor {

    @XmlEnumValue("red")
    RED("red"), @XmlEnumValue("red_anime")
    RED_ANIME("red_anime"), @XmlEnumValue("yellow")
    YELLOW("yellow"), @XmlEnumValue("yellow_anime")
    YELLOW_ANIME("yellow_anime"), @XmlEnumValue("blue")
    BLUE("blue"), @XmlEnumValue("blue_anime")
    BLUE_ANIME("blue_anime"), @XmlEnumValue("grey")
    GREY("grey"), @XmlEnumValue("grey_anime")
    GREY_ANIME("grey_anime"), @XmlEnumValue("disabled")
    DISABLED("disabled"), @XmlEnumValue("disabled_anime")
    DISABLED_ANIME("disabled_anime"), @XmlEnumValue("aborted")
    ABORTED("aborted"), @XmlEnumValue("aborted_anime")
    ABORTED_ANIME("aborted_anime");
    private final String value;

    HudsonModelBallColor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HudsonModelBallColor fromValue(String v) {
        for (HudsonModelBallColor c : HudsonModelBallColor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
