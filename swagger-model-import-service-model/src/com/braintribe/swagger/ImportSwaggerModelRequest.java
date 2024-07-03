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
package com.braintribe.swagger;

import com.braintribe.model.accessapi.AccessDataRequest;
import com.braintribe.model.generic.annotation.Abstract;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.eval.EvalContext;
import com.braintribe.model.generic.eval.Evaluator;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;
import com.braintribe.model.service.api.AuthorizedRequest;
import com.braintribe.model.service.api.ServiceRequest;

@Abstract
public interface ImportSwaggerModelRequest extends AccessDataRequest, AuthorizedRequest {

	EntityType<ImportSwaggerModelRequest> T = EntityTypes.T(ImportSwaggerModelRequest.class);

	@Override
	EvalContext<ImportSwaggerModelResponse> eval(Evaluator<ServiceRequest> evaluator);

	@Initializer("true")
	boolean getImportOnlyDefinitions();
	void setImportOnlyDefinitions(boolean value);

	@Initializer("'tribefire.demo'")
	String getPackageName();
	void setPackageName(String packageName);

	@Initializer("'tribefire.demo'")
	String getGroupId();
	void setGroupId(String groupId);

	@Initializer("'demo-swagger'")
	String getModelBaseName();
	void setModelBaseName(String modelBaseName);

	@Initializer("false")
	boolean getDisableValidation();
	void setDisableValidation(boolean value);

	String getIgnorePathPrefix();
	void setIgnorePathPrefix(String ignorePathPrefix);

	String getModelVersion();
	void setModelVersion(String modelVersion);

}
