/**
 * Copyright (c) 2017 Contributors to the Eclipse Foundation
 * Copyright 2017 SmartBear Software
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipse.microprofile.openapi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.microprofile.openapi.annotations.extensions.Extension;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirementsSet;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * OpenAPI
 * <p>
 * This is the root document object of the OpenAPI document. It contains required and optional fields.
 * 
 * @see <a href= "https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md#openapi-object">OpenAPI
 *      Specification OpenAPI Object</a>
 */

@Target({ElementType.TYPE, ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface OpenAPIDefinition {
    /**
     * Required: Provides metadata about the API. The metadata MAY be used by tooling as required.
     *
     * @return the metadata about this API
     */
    Info info();

    /**
     * A list of tags used by the specification with additional metadata. The order of the tags can be used to reflect
     * on their order by the parsing tools.
     *
     * @return the tags used by the specification with any additional metadata
     */
    Tag[] tags() default {};

    /**
     * An array of Server Objects, which provide connectivity information to a target server. If the servers property is
     * not provided, or is an empty array, the default value would be a Server Object with a url value of /.
     *
     * @return the servers of this API
     */
    Server[] servers() default {};

    /**
     * A declaration of which security mechanisms can be used across the API.
     * <p>
     * Adding a {@code SecurityRequirement} to this array is equivalent to adding a {@code SecurityRequirementsSet}
     * containing a single {@code SecurityRequirement} to {@link #securitySets()}.
     * 
     * @return the array of security requirements for this API
     */
    SecurityRequirement[] security() default {};

    /**
     * A declaration of which security mechanisms can be used across the API.
     * <p>
     * All of the security requirements within any one of the sets must be satisfied to authorize a request.
     * <p>
     * Including an empty set within this list indicates that the other requirements are optional.
     * 
     * @return the array of security requirement sets for this API
     */
    SecurityRequirementsSet[] securitySets() default {};

    /**
     * Any additional external documentation for the API
     *
     * @return the external documentation for this API.
     */
    ExternalDocumentation externalDocs() default @ExternalDocumentation;

    /**
     * An element to hold a set of reusable objects for different aspects of the OpenAPI Specification (OAS).
     *
     * All objects defined within the components object will have no effect on the API unless they are explicitly
     * referenced from properties outside the components object.
     *
     * @return the element with a set of reusable objects for different aspects of the OAS.
     */
    Components components() default @Components;

    /**
     * List of extensions to be added to the {@link org.eclipse.microprofile.openapi.models.OpenAPI OpenAPI} model
     * corresponding to the containing annotation.
     *
     * @return array of extensions
     * 
     * @since 3.1
     */
    Extension[] extensions() default {};
}
