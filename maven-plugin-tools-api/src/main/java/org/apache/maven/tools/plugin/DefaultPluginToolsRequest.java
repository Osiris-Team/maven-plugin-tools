package org.apache.maven.tools.plugin;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.plugin.descriptor.MojoDescriptor;
import org.apache.maven.plugin.descriptor.PluginDescriptor;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.ReaderFactory;
import org.codehaus.plexus.util.StringUtils;

/**
 * Default implementation of {@link PluginToolsRequest}, which is used to pass parameters to components used to extract
 * {@link MojoDescriptor} instances from different types of metadata for a given plugin.
 * 
 * @author jdcasey
 * @since 2.5
 */
public class DefaultPluginToolsRequest
    implements PluginToolsRequest
{
    
    private static final String DEFAULT_ENCODING = ReaderFactory.FILE_ENCODING;

    private PluginDescriptor pluginDescriptor;

    private MavenProject project;

    private String encoding = DEFAULT_ENCODING;

    private boolean skipErrorNoDescriptorsFound;

    public DefaultPluginToolsRequest( MavenProject project, PluginDescriptor pluginDescriptor )
    {
        this.project = project;
        this.pluginDescriptor = pluginDescriptor;
    }

    /**
     * {@inheritDoc}
     */
    public PluginDescriptor getPluginDescriptor()
    {
        return pluginDescriptor;
    }
    
    /**
     * {@inheritDoc}
     */
    public PluginToolsRequest setPluginDescriptor( PluginDescriptor pluginDescriptor )
    {
        this.pluginDescriptor = pluginDescriptor;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public MavenProject getProject()
    {
        return project;
    }
    
    /**
     * {@inheritDoc}
     */
    public PluginToolsRequest setProject( MavenProject project )
    {
        this.project = project;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    public String getEncoding()
    {
        return this.encoding;
    }

    /**
     * {@inheritDoc}
     */
    public PluginToolsRequest setEncoding( String encoding )
    {
        if ( StringUtils.isNotEmpty( encoding ) )
        {
            this.encoding = encoding;
        }
        else
        {
            this.encoding = DEFAULT_ENCODING;
        }

        return this;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isSkipErrorNoDescriptorsFound()
    {
        return skipErrorNoDescriptorsFound;
    }

    /**
     * {@inheritDoc}
     */
    public PluginToolsRequest setSkipErrorNoDescriptorsFound( boolean skipErrorNoDescriptorsFound )
    {
        this.skipErrorNoDescriptorsFound = skipErrorNoDescriptorsFound;
        return this;
    }
}
