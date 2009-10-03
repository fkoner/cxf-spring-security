/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.security.spring;

import org.w3c.dom.Element;

import org.apache.cxf.configuration.spring.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.security.config.BeanIds;

public class ServerPasswordCallbackHandlerDefinitionParser extends AbstractBeanDefinitionParser {
    public ServerPasswordCallbackHandlerDefinitionParser() {
        setBeanClass(SpringSecurityServerPasswordCallbackHandler.class);
    }

    @Override
    protected void doParse(Element element, ParserContext ctx,
            BeanDefinitionBuilder bean) {
        super.doParse(element, ctx, bean);
        bean.addPropertyReference("authenticationManager", BeanIds.AUTHENTICATION_MANAGER);
    }
}