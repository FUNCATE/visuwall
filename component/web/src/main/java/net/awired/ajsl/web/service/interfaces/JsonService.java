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
package net.awired.ajsl.web.service.interfaces;

import java.io.StringWriter;
import java.io.Writer;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

public interface JsonService {

    Writer serializeFromView(Object object, Class<?> view);

    void serializeFromView(Object object, Writer writer, Class<?> view);

    StringWriter serialize(Object object);

    void serialize(Object object, Writer writer);

    <E> E deserialize(String datas, TypeReference<E> ref);

    <E> E deserialize(String datas, Class<E> clazz);

    <E> E deserialize(String datas, JavaType javaType);
}
