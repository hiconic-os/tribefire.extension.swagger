// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
//
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
package tribefire.extension.swagger.model_import.wire.space;

import com.braintribe.model.processing.deployment.api.binding.DenotationBindingBuilder;
import com.braintribe.swagger.deployment.ConvertSwaggerModelProcessor;
import com.braintribe.swagger.deployment.ExportSwaggerModelProcessor;
import com.braintribe.swagger.deployment.ImportSwaggerModelProcessor;
import com.braintribe.wire.api.annotation.Import;
import com.braintribe.wire.api.annotation.Managed;

import tribefire.module.wire.contract.TribefireModuleContract;
import tribefire.module.wire.contract.TribefireWebPlatformContract;

@Managed
public class SwaggerModelImportModuleSpace implements TribefireModuleContract {

	@Import
	private TribefireWebPlatformContract tfPlatform;
	
	@Import
	private SwaggerModelImportDeployablesSpace deployables;

	@Override
	public void bindDeployables(DenotationBindingBuilder bindings) {
		// @formatter:off
		bindings.bind(ImportSwaggerModelProcessor.T)
			.component(tfPlatform.binders().accessRequestProcessor())
			.expertSupplier(deployables::importSwaggerModelProcessor);
		
		bindings.bind(ExportSwaggerModelProcessor.T)
			.component(tfPlatform.binders().accessRequestProcessor())
			.expertSupplier(deployables::exportSwaggerModelProcessor);
		
		bindings.bind(ConvertSwaggerModelProcessor.T)
			.component(tfPlatform.binders().accessRequestProcessor())
			.expertSupplier(deployables::convertSwaggerModelProcessor);
		// @formatter:on
	}

}
