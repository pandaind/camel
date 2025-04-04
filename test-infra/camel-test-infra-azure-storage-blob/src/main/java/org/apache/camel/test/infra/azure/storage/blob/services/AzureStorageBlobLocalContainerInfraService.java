/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.camel.test.infra.azure.storage.blob.services;

import org.apache.camel.spi.annotations.InfraService;
import org.apache.camel.test.infra.azure.common.AzureConfigs;
import org.apache.camel.test.infra.azure.common.AzureCredentialsHolder;
import org.apache.camel.test.infra.azure.common.services.AzureInfraService;
import org.apache.camel.test.infra.azure.common.services.AzureServices;
import org.apache.camel.test.infra.azure.common.services.AzureStorageInfraService;

@InfraService(service = AzureInfraService.class,
              description = "Local Azure services with Azurite",
              serviceAlias = "azure", serviceImplementationAlias = "storage-blob")
public class AzureStorageBlobLocalContainerInfraService extends AzureStorageInfraService {

    @Override
    public void registerProperties() {
        super.registerProperties();

        System.setProperty(AzureConfigs.PORT, String.valueOf(getContainer().getMappedPort(AzureServices.BLOB_SERVICE)));
    }

    @Override
    public AzureCredentialsHolder azureCredentials() {
        return getContainer().azureCredentials();
    }
}
