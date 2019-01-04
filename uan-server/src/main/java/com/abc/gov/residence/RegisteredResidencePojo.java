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
package com.abc.gov.residence;

import java.util.List;

import com.abc.common.AbstractPojo;

/**
 * Title: RegisteredResidencePojo
 * @Description: RegisteredResidencePojo
 * @author Bo Liu
 * @date 2018-09-20
 */
public class RegisteredResidencePojo extends AbstractPojo {

	private static final long serialVersionUID = -8170023796410635151L;

	private String id;
	private String residence;
	private String managementAgency;
	private int numberOfMembers;
	private int state;
	private List<RegisteredResidencePagePojo> pages;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getManagementAgency() {
		return managementAgency;
	}

	public void setManagementAgency(String managementAgency) {
		this.managementAgency = managementAgency;
	}

	public int getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(int numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<RegisteredResidencePagePojo> getPages() {
		return pages;
	}

	public void setPages(List<RegisteredResidencePagePojo> pages) {
		this.pages = pages;
	}

}
