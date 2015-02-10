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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuildIdComparatorTest {

    BuildIdComparator comparator = new BuildIdComparator();

    @Test
    public void should_compare_asc() {
        assertEquals(-1, comparator.compare("1", "2"));
    }

    @Test
    public void should_compare_desc_with_two_chars() {
        assertEquals(1, comparator.compare("13", "6"));
    }

    @Test
    public void should_compare_equal() {
        assertEquals(0, comparator.compare("1", "1"));
    }

    @Test
    public void should_compare_numeric_with_text() {
        assertEquals(0, comparator.compare("1", "text"));
    }
}
