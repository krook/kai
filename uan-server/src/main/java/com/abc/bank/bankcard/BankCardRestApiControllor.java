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
package com.abc.bank.bankcard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.common.AbstractController;
import com.abc.common.Request;
import com.abc.common.Response;

/**
 * Title: BankCardRestApiControllor
 * @Description: BankCardRestApiControllor
 * @author Bo Liu
 * @date 2018-09-20
*/
@RestController
@RequestMapping(value = AbstractController.REST_API_PREFIX + "/bancar")
public class BankCardRestApiControllor extends AbstractController {

	@Autowired
	private BankCardServiceImpl bankCardService;

	/** 
	 * @Description: findMyCard
	 * @param reqJson
	 * @param req
	 * @return String
	 * @throws 
	 */ 
	@RequestMapping(value = "/findMyCard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String findMyCard(@RequestBody String reqJson, HttpServletRequest req) {
		Request request = Request.create(reqJson, req, null);
		List<BankCardPojo> bankCardPojos = bankCardService.findMyCard();
		Response<List> resp = new Response<List>();
		return resp.createSuccessJson(bankCardPojos, request);
	}

}
