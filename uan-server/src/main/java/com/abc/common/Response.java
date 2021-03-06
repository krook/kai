/*
 * Copyright 2018 Liu Bo
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.abc.common;

import java.net.ResponseCache;

import com.abc.common.bus.RequestBus;
import com.abc.common.bus.ThreadContext;
import com.abc.common.servlet.NodeDeploymentDescriptor;
import com.abc.common.util.BeanFactoryUtils;
import com.abc.common.util.CfgValueHandler;
import com.abc.common.util.ExceptionUtils;
import com.abc.common.util.JsonConvertor;
import com.abc.common.util.LogWriter;

/**
 * @author 011893494
 * 
 * 
 * 
 */
public class Response<T> extends AbstractOutputHeader {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4590654518986452571L;

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	private Response createBase() {
		Response resp = this;
		resp.setAppId(BeanFactoryUtils.getBean(CfgValueHandler.class).getAppId());
		RequestBus requestBus = (RequestBus) ThreadContext.getContext().getAttribute(RequestBus.REQUEST_BUS);
		if (requestBus != null) {
			resp.setUniqueId(requestBus.getUniqueId());
			resp.setId(requestBus.getId());
		}
		return resp;
	}

	public Response createError(Throwable e) {
		Response resp = createBase();
		resp.setStatusCode("500");
		resp.setMessage(e.getMessage());
		resp.setDetail(ExceptionUtils.toString(e));
		resp.setExceptionClassName(e.getClass().getName());
		return resp;
	}

	public Response createError(String msg, Class<?> cls) {
		Response resp = createBase();
		resp.setStatusCode("500");
		resp.setMessage(msg);
		return resp;
	}

	public String createSuccessJson(Object result, AbstractInputHeader inputHeader) {
		// 成功情况下的响应报文处理
		Response response = this;
		response.setData(result);

		response.setAppId(NodeDeploymentDescriptor.getInstance().getApp());
		response.setStatusCode("200");
		response.setMessage("请求成功");
		response.setUniqueId(inputHeader == null ? null : inputHeader.getUniqueId());

		String respJson = new JsonConvertor().toJson(response);
		LogWriter.trace(Response.class, "SuccessResponse: [{}]", respJson);
		return respJson;
	}

}
