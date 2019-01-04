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
package com.abc.bank.customerinformation;

import java.util.Date;

import com.abc.common.AbstractPojo;

/**
 * Title: InquireAssetsCommondPojo
 * @Description: InquireAssetsCommondPojo
 * @author Bo Liu
 * @date 2018-09-20
*/
public class InquireAssetsCommondPojo extends AbstractPojo {

	private static final long serialVersionUID = 8992883287302022354L;
	private String customer;
	private String party;
	private String deviceNum;
	private Date trDate;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public Date getTrDate() {
		return trDate;
	}

	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}

}
