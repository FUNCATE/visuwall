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
package fr.norad.visuwall.plugin.teamcity;

import java.util.Comparator;

class BuildIdComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int comparison = 0;
        try {
            comparison = Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
        } catch (NumberFormatException e) {
        }
        return comparison;
    }
}
