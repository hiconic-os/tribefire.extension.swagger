// ============================================================================
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License along with this library; See http://www.gnu.org/licenses/.
// ============================================================================
package tribefire.extension.swagger.model_import_initializer.wire.contract;

import com.braintribe.model.ddra.DdraConfiguration;
import com.braintribe.model.meta.GmMetaModel;
import com.braintribe.wire.api.space.WireSpace;

import tribefire.cortex.initializer.support.impl.lookup.GlobalId;
import tribefire.cortex.initializer.support.impl.lookup.InstanceLookup;

@InstanceLookup(lookupOnly=true)
public interface ExistingInstancesContract extends WireSpace {
	
	String GROUP_ID = "tribefire.extension.swagger";
	String GLOBAL_ID_PREFIX = "model:" + GROUP_ID + ":";
	
	@GlobalId(GLOBAL_ID_PREFIX + "swagger-model-import-data-model")
	GmMetaModel dataModel();
	
	@GlobalId(GLOBAL_ID_PREFIX + "swagger-model-import-deployment-model")
	GmMetaModel deploymentModel();
	
	@GlobalId(GLOBAL_ID_PREFIX + "swagger-model-import-service-model")
	GmMetaModel serviceModel();

	@GlobalId("ddra:config")
	DdraConfiguration ddraConfig();
	
}
